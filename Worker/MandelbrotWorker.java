import java.awt.image.BufferedImage;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MandelbrotWorker extends UnicastRemoteObject implements Worker {
    public MandelbrotWorker() throws RemoteException {
        super();
    }

    @Override
    public BufferedImage computeMandelbrotPart(int startX, int endX, MandelbrotModel model) throws RemoteException {
        int width = endX - startX;
        int height = model.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Berechnung der Mandelbrotmenge
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double zx = (x + startX) * (3.0 / model.getWidth()) - 2;
                double zy = y * (2.0 / model.getHeight()) - 1;
                float i = model.getMaxIterations();
                while (zx * zx + zy * zy < 4 && i > 0) {
                    double tmp = zx * zx - zy * zy + model.getZoomX();
                    zy = 2.0 * zx * zy + model.getZoomY();
                    zx = tmp;
                    i--;
                }
                int c = Color.HSBtoRGB((model.getMaxIterations() / i) % 1, 1, i > 0 ? 1 : 0);
                image.setRGB(x, y, c);
            }
        }

        return image;
    }

    public static void main(String[] args) {
        try {
            Worker worker = new MandelbrotWorker();
            Naming.rebind("Worker", worker);
            System.out.println("Worker ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
