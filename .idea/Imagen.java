import java.util.List;

public class Imagen extends Contenido implements Publicable {
    protected String resolucion;
    protected String formato;

    public Imagen(int id, String titulo, String autor, String categoria, List<String> etiquetas, String resolucion, String formato) {
        super(id, titulo, autor, categoria, etiquetas);
        this.resolucion = resolucion;
        this.formato = formato;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando imagen: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println("Mostrando imagen en formato " + formato + " (" + resolucion + ")");
    }
}