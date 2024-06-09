import javax.swing.*;
import java.awt.image.BufferedImage;

public class MandelbrotViewImpl implements MandelbrotView {
    private JFrame frame;
    private JLabel label;

    public MandelbrotViewImpl() {
        frame = new JFrame("Mandelbrot Viewer");
        label = new JLabel();
        frame.add(label);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void displayImage(BufferedImage image) {
        label.setIcon(new ImageIcon(image));
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

