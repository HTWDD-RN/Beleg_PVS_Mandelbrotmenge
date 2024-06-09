public class MandelbrotPresenter {
    private MandelbrotView view;
    private MandelbrotModel model;
    private MandelbrotService service;

    public MandelbrotPresenter(MandelbrotView view, MandelbrotModel model, MandelbrotService service) {
        this.view = view;
        this.model = model;
        this.service = service;
    }

    public void onZoomPointEntered(double x, double y) {
        model.setZoomX(x);
        model.setZoomY(y);
        try {
            BufferedImage image = service.computeMandelbrot(model);
            view.displayImage(image);
        } catch (RemoteException e) {
            view.showError(e.getMessage());
        }
    }
}
