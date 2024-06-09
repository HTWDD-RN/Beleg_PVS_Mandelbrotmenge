import java.awt.image.BufferedImage;

public interface MandelbrotView {
    void displayImage(BufferedImage image);
    void showError(String message);
}
