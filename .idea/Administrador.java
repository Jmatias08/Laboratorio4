public class Administrador extends Usuario implements Reportable {
    public Administrador(String nombre, String email) {
        super(nombre, email, 1);
    }

    @Override
    public void crearContenido(Contenido c) {
        System.out.println("Administrador creó contenido: " + c.getResumen());
    }

    @Override
    public void editarContenido(Contenido c) {
        System.out.println("Administrador editó contenido: " + c.getResumen());
    }

    public void eliminarContenido(Contenido c) {
        System.out.println("Administrador eliminó contenido: " + c.getResumen());
    }

    @Override
    public String generarReporte() {
        return "Reporte generado por administrador " + nombre;
    }
}