public class ClientMain {
    public static void main(String[] args) {
        MandelbrotModel model = new MandelbrotModel();
        MandelbrotView view = new MandelbrotViewImpl();
        MandelbrotService service = (MandelbrotService) Naming.lookup("//localhost/MandelbrotMaster");
        MandelbrotPresenter presenter = new MandelbrotPresenter(view, model, service);

        // Beispiel für die Eingabe eines Zoompunkts
        presenter.onZoomPointEntered(-0.34837308755059104, -0.6065038451823017);
    }
}
