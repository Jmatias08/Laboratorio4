import java.util.List;

public class Video extends Contenido implements Publicable {
    protected String urlVideo;
    protected double duracion;

    public Video(int id, String titulo, String autor, String categoria, List<String> etiquetas, String urlVideo, double duracion) {
        super(id, titulo, autor, categoria, etiquetas);
        this.urlVideo = urlVideo;
        this.duracion = duracion;
    }

    @Override
    public void publicar() {
        System.out.println("Publicando video: " + titulo);
    }

    @Override
    public void visualizar() {
        System.out.println("Reproduciendo video en: " + urlVideo);
    }
}