public class Main {
    public static void main(String[] args) {
        RepositorioContenido repo = new RepositorioContenido();
        ControladorContenido controlador = new ControladorContenido(repo);

        // Crear usuarios
        Administrador admin = new Administrador("Luis", "admin@cms.com");
        Editor editor = new Editor("Maria", "editor@cms.com");

        // Crear GUI con Swing (ejemplo con admin)
        new VistaPrincipal(controlador, admin);
    }
}