import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaSeleccionRol extends JFrame {
    public VistaSeleccionRol() {
        setTitle("Seleccionar Rol");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JLabel lbl = new JLabel("Seleccione su rol:", SwingConstants.CENTER);
        JButton btnAdmin = new JButton("Administrador");
        JButton btnEditor = new JButton("Editor");

        add(lbl);
        add(btnAdmin);
        add(btnEditor);

        btnAdmin.addActionListener(e -> abrirVistaPrincipal(new Administrador("Luis", "admin@cms.com")));
        btnEditor.addActionListener(e -> abrirVistaPrincipal(new Editor("María", "editor@cms.com")));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirVistaPrincipal(Usuario usuario) {
        RepositorioContenido repo = new RepositorioContenido();
        ControladorContenido controlador = new ControladorContenido(repo);
        dispose();
        new VistaPrincipal(controlador, usuario);
    }
}
