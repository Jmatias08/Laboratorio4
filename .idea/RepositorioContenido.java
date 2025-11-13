import java.util.*;
import java.util.stream.Collectors;

public class RepositorioContenido {
    private List<Contenido> lista = new ArrayList<>();

    public void agregar(Contenido c) { lista.add(c); }
    public void eliminar(Contenido c) { lista.remove(c); }
    public List<Contenido> listar() { return lista; }

    public List<Contenido> buscar(String palabra) {
        return lista.stream()
                .filter(c -> c.getTitulo().toLowerCase().contains(palabra.toLowerCase()))
                .collect(Collectors.toList());
    }
}
