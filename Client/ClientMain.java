import java.rmi.Naming;

public class ClientMain {
    public static void main(String[] args) {
        try {
            MandelbrotModel model = new MandelbrotModel();
            model.setWidth(1024);
            model.setHeight(768);
            model.setMaxIterations(1000);

            MandelbrotView view = new MandelbrotViewImpl();
            MandelbrotService service = (MandelbrotService) Naming.lookup("//localhost/MandelbrotMaster");
            MandelbrotPresenter presenter = new MandelbrotPresenter(view, model, service);

            // Beispiel für die Eingabe eines Zoompunkts
            presenter.onZoomPointEntered(-0.34837308755059104, -0.6065038451823017);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
