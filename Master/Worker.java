import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Worker extends Remote {
    BufferedImage calculateMandelbrotPart(MandelbrotModel model, int startX, int endX) throws RemoteException;
}
