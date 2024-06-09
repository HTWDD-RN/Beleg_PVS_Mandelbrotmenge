import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MandelbrotMaster extends UnicastRemoteObject implements MandelbrotService {
    private List<Worker> workers;

    public MandelbrotMaster() throws RemoteException {
        super();
        workers = new ArrayList<>();
    }

    public void registerWorker(Worker worker) throws RemoteException {
        workers.add(worker);
    }

    @Override
    public BufferedImage computeMandelbrot(MandelbrotModel model) throws RemoteException {
        // Aufteilung der Berechnungen
        int width = model.getWidth();
        int height = model.getHeight();
        int partWidth = width / workers.size();
        List<BufferedImage> parts = new ArrayList<>();

        for (int i = 0; i < workers.size(); i++) {
            int startX = i * partWidth;
            int endX = (i == workers.size() - 1) ? width : startX + partWidth;
            parts.add(workers.get(i).computeMandelbrotPart(startX, endX, model));
        }

        // Zusammenführung der Ergebnisse
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < workers.size(); i++) {
            int startX = i * partWidth;
            result.getGraphics().drawImage(parts.get(i), startX, 0, null);
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            MandelbrotMaster master = new MandelbrotMaster();
            Naming.rebind("MandelbrotMaster", master);
            System.out.println("Master ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
