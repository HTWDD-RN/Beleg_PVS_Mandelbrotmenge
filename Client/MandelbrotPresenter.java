import java.awt.image.BufferedImage;

public class MandelbrotPresenter {
    private MandelbrotView view;
    private MandelbrotModel model;
    private MandelbrotService service;

    public MandelbrotPresenter(MandelbrotView view, MandelbrotModel model, MandelbrotService service) {
        this.view = view;
        this.model = model;
        this.service = service;
        view.setPresenter(this);
    }

    public void onZoomPointEntered(double x, double y) {
        // Starten der Berechnung in einem separaten Thread
        new Thread(() -> {
            try {
                BufferedImage image = service.calculateMandelbrot(model, x, y);
                view.displayImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
