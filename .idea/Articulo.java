import java.util.List;

public class Articulo extends Contenido implements Publicable {
    protected String texto;

    public Articulo(int id, String titulo, String autor, String categoria, List<String> etiquetas, String texto) {
        super(id, titulo, autor, categoria, etiquetas);
        this.texto = texto;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando artículo: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println("Artículo: " + texto);
    }
}