import java.util.List;

public class ControladorContenido {
    protected RepositorioContenido repo;

    public ControladorContenido(RepositorioContenido repo) {
        this.repo = repo;
    }

    public void crearContenido(Usuario u, Contenido c) {
        repo.agregar(c);
        u.crearContenido(c);
    }

    public void editarContenido(Usuario u, Contenido c, String nuevoTitulo, String nuevaCategoria) {
        c.editar(nuevoTitulo, nuevaCategoria, List.of("Editado"));
        u.editarContenido(c);
    }

    public void eliminarContenido(Usuario u, Contenido c) {
        if (u.getRol() == 1) {
            repo.eliminar(c);
            System.out.println("Eliminado por admin");
        } else {
            System.out.println("Solo los administradores pueden eliminar contenido");
        }
    }

    public List<Contenido> listarContenidos() {
        return repo.listar();
    }
}
