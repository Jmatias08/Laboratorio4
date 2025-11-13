import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioContenido {
    private List<Contenido> listaContenidos = new ArrayList<>();

    public void agregar(Contenido c) {
        listaContenidos.add(c);
    }

    public void eliminar(Contenido c) {
        listaContenidos.remove(c);
    }

    public List<Contenido> filtrarPorTipo(String tipo) {
        return listaContenidos.stream()
                .filter(c -> c.getClass().getSimpleName().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Contenido> filtrarPorCategoria(String categoria) {
        return listaContenidos.stream()
                .filter(c -> c.categoria.equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public List<Contenido> buscar(String palabraClave) {
        return listaContenidos.stream()
                .filter(c -> c.titulo.contains(palabraClave))
                .collect(Collectors.toList());
    }
}