import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MandelbrotService extends Remote {
    BufferedImage calculateMandelbrot(MandelbrotModel model, double x, double y) throws RemoteException;
}
