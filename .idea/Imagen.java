import java.util.List;

public class Imagen extends Contenido implements Publicable {
    protected String formato;
    protected String resolucion;

    public Imagen(int id, String titulo, String autor, String categoria, List<String> etiquetas, String formato, String resolucion) {
        super(id, titulo, autor, categoria, etiquetas);
        this.formato = formato;
        this.resolucion = resolucion;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando imagen: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println("Mostrando imagen (" + formato + ", " + resolucion + ")");
    }

    @Override
    public String toString() {
        return "[Imagen] " + getResumen();
    }
}
