import java.time.LocalDate;
import java.util.List;

public abstract class Contenido {
    protected int id;
    protected String titulo;
    protected String autor;
    protected LocalDate fechaPublicacion;
    protected String categoria;
    protected List<String> etiquetas;

    public Contenido(int id, String titulo, String autor, String categoria, List<String> etiquetas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = LocalDate.now();
        this.categoria = categoria;
        this.etiquetas = etiquetas;
    }

    public abstract void publicar();
    public abstract void visualizar();

    public void editar(String nuevoTitulo, String nuevaCategoria, List<String> nuevasEtiquetas) {
        this.titulo = nuevoTitulo;
        this.categoria = nuevaCategoria;
        this.etiquetas = nuevasEtiquetas;
    }

    public String getResumen() {
        return titulo + " - " + autor + " (" + categoria + ")";
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
}
