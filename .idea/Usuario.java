public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected int rol; // 1 = admin, 2 = editor

    public Usuario(String nombre, String email, int rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public abstract void crearContenido(Contenido c);
    public abstract void editarContenido(Contenido c);
}