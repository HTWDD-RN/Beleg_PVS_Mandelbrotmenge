import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MandelbrotMaster extends UnicastRemoteObject implements MandelbrotService {
    private List<Worker> workers;

    public MandelbrotMaster() throws RemoteException {
        workers = new ArrayList<>();
    }

    public void registerWorker(Worker worker) throws RemoteException {
        workers.add(worker);
    }

    @Override
    public BufferedImage calculateMandelbrot(MandelbrotModel model, double x, double y) throws RemoteException {
        // Verteilte Berechnung der Mandelbrotmenge
        BufferedImage image = new BufferedImage(model.getWidth(), model.getHeight(), BufferedImage.TYPE_INT_RGB);
        // Verteilungslogik hier einfügen
        return image;
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
