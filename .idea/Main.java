/*
 * Programacion orientada a objetos
 * Grupo 12
 * Laboratorio 4
 * José David Matías Morales 251170
 * Jordi Javier Cardona Ochoa 251142
 */

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        RepositorioContenido repo = new RepositorioContenido();
        ControladorContenido controlador = new ControladorContenido(repo);
        Administrador admin = new Administrador("Luis", "admin@cms.com");

        SwingUtilities.invokeLater(() -> new VistaPrincipal(controlador, admin));
    }
}
