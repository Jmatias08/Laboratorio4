import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        RepositorioContenido repo = new RepositorioContenido();
        ControladorContenido controlador = new ControladorContenido(repo);
        Administrador admin = new Administrador("Luis", "admin@cms.com");

        SwingUtilities.invokeLater(() -> new VistaPrincipal(controlador, admin));
    }
}
