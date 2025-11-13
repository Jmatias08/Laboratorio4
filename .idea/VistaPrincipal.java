import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaPrincipal extends JFrame {
    protected ControladorContenido controlador;
    protected Usuario usuario;
    private DefaultListModel<String> modeloLista;
    private JList<String> lista;
    private JButton btnAgregar, btnEliminar, btnEditar;
    private JComboBox<String> selectorUsuario;

    private Administrador admin = new Administrador("Luis", "admin@cms.com");
    private Editor editor = new Editor("María", "editor@cms.com");

    public VistaPrincipal(ControladorContenido controlador, Usuario usuarioInicial) {
        this.controlador = controlador;
        this.usuario = usuarioInicial;

        setTitle("CMS - Panel Principal (" + usuario.getNombre() + ")");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnEditar = new JButton("Editar");
        selectorUsuario = new JComboBox<>(new String[] { "Administrador", "Editor" });

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(new JLabel("Rol actual:"));
        panelBotones.add(selectorUsuario);

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarContenido());
        btnEliminar.addActionListener(e -> eliminarSeleccionado());
        btnEditar.addActionListener(e -> editarSeleccionado());
        selectorUsuario.addActionListener(e -> cambiarUsuario());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarContenido() {
        String[] tipos = { "Artículo", "Video", "Imagen" };
        String tipo = (String) JOptionPane.showInputDialog(
                this, "Seleccione tipo de contenido:",
                "Nuevo Contenido", JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);

        if (tipo == null)
            return; // Si canceló la selección, no hacemos nada

        String titulo = JOptionPane.showInputDialog(this, "Título del contenido:");
        if (titulo == null)
            return; // Canceló
        titulo = titulo.trim();
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ El título no puede estar vacío.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String descripcion = JOptionPane.showInputDialog(this, "Descripción o texto:");
        if (descripcion == null)
            return; // Canceló
        descripcion = descripcion.trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ La descripción no puede estar vacía.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contenido c = null;

        switch (tipo) {
            case "Video":
                c = new Video(
                        modeloLista.size() + 1,
                        titulo,
                        usuario.getNombre(),
                        "Multimedia",
                        java.util.Arrays.asList("CMS"),
                        descripcion, // url o texto corto
                        5.0);
                break;

            case "Imagen":
                c = new Imagen(
                        modeloLista.size() + 1,
                        titulo,
                        usuario.getNombre(),
                        "Fotografía",
                        java.util.Arrays.asList("CMS"),
                        "jpg",
                        "1080p");
                break;

            default: // Artículo
                c = new Articulo(
                        modeloLista.size() + 1,
                        titulo,
                        usuario.getNombre(),
                        "Texto",
                        java.util.Arrays.asList("CMS"),
                        descripcion);
                break;
        }

        if (c != null) {
            controlador.crearContenido(usuario, c);
            actualizarLista();
            JOptionPane.showMessageDialog(this, "✅ Contenido agregado correctamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void eliminarSeleccionado() {
        int index = lista.getSelectedIndex();
        if (index >= 0) {
            List<Contenido> contenidos = controlador.listarContenidos();
            controlador.eliminarContenido(usuario, contenidos.get(index));
            actualizarLista();
        }
    }

    private void editarSeleccionado() {
        int index = lista.getSelectedIndex();

        if (index < 0) {
            JOptionPane.showMessageDialog(this, "⚠️ Debe seleccionar un contenido para editar.", "Atención",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Contenido> contenidos = controlador.listarContenidos();
        Contenido c = contenidos.get(index);

        String nuevoTitulo = JOptionPane.showInputDialog(this, "Nuevo título:", c.getTitulo());
        if (nuevoTitulo == null)
            return; // canceló
        nuevoTitulo = nuevoTitulo.trim();
        if (nuevoTitulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ El título no puede estar vacío.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nuevaCategoria = JOptionPane.showInputDialog(this, "Nueva categoría:", c.getCategoria());
        if (nuevaCategoria == null)
            return; // canceló
        nuevaCategoria = nuevaCategoria.trim();
        if (nuevaCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ La categoría no puede estar vacía.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        controlador.editarContenido(usuario, c, nuevoTitulo, nuevaCategoria);
        actualizarLista();
        JOptionPane.showMessageDialog(this, "✅ Contenido editado correctamente.", "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void cambiarUsuario() {
        String seleccionado = (String) selectorUsuario.getSelectedItem();
        if (seleccionado.equals("Administrador"))
            usuario = admin;
        else
            usuario = editor;
        setTitle("CMS - Panel Principal (" + usuario.getNombre() + ")");
    }

    private void actualizarLista() {
        modeloLista.clear();
        for (Contenido c : controlador.listarContenidos()) {
            modeloLista.addElement(c.getResumen());
        }
    }
}
