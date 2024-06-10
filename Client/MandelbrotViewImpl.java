import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotViewImpl extends JPanel implements MandelbrotView {
    private MandelbrotPresenter presenter;
    private BufferedImage image;

    @Override
    public void displayImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    public void setPresenter(MandelbrotPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Viewer");
        MandelbrotViewImpl view = new MandelbrotViewImpl();
        frame.getContentPane().add(view);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
