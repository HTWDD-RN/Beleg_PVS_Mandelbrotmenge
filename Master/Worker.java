import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Worker extends Remote {
    BufferedImage computeMandelbrotPart(int startX, int endX, MandelbrotModel model) throws RemoteException;
}
