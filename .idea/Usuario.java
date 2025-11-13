public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected int rol; // 1 = Admin, 2 = Editor

    public Usuario(String nombre, String email, int rol) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public abstract void crearContenido(Contenido c);
    public abstract void editarContenido(Contenido c);

    public int getRol() { return rol; }
    public String getNombre() { return nombre; }
}
