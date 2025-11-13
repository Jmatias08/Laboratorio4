public class Editor extends Usuario {
    public Editor(String nombre, String email) {
        super(nombre, email, 2);
    }

    @Override
    public void crearContenido(Contenido c) {
        System.out.println("Editor creó: " + c.getResumen());
    }

    @Override
    public void editarContenido(Contenido c) {
        System.out.println("Editor editó: " + c.getResumen());
    }
}
