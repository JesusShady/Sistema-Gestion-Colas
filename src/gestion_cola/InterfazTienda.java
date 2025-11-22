package gestion_cola;

import javax.swing.*;
import java.awt.*;

public class InterfazTienda extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GestorTienda gestor;
    
   
    private JTextField txtNombre;
    private JList<Cliente> listaVisualCola; 
    private PanelCajero panelCaja1;
    private PanelCajero panelCaja2;

    public InterfazTienda() {
        gestor = new GestorTienda();
        configurarVentana();
        iniciarUI();
    }

    private void configurarVentana() {
        setTitle("SISTEMA DE SIMULACIÓN Y GESTIÓN DE COLAS ");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void iniciarUI() {
        // Panel Superior 
        JPanel panelEntrada = new JPanel(new FlowLayout());
        panelEntrada.setBorder(BorderFactory.createEtchedBorder());
        
        txtNombre = new JTextField(20);
        JButton btnIngresar = new JButton("Nuevo Cliente en la cola ");
        btnIngresar.addActionListener(e -> agregarCliente());
        txtNombre.addActionListener(e -> agregarCliente());

        panelEntrada.add(new JLabel("Nombre Cliente:"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(btnIngresar);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel Central 
        JPanel panelCola = new JPanel(new BorderLayout());
        panelCola.setBorder(BorderFactory.createTitledBorder("Fila Única de Clientes"));
        
        listaVisualCola = new JList<>(gestor.getModeloCola());
        listaVisualCola.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaVisualCola.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        JButton btnAbandonar = new JButton("Cliente Seleccionado Abandona la Fila");
        btnAbandonar.setForeground(Color.RED);
        btnAbandonar.addActionListener(e -> {
            int index = listaVisualCola.getSelectedIndex();
            if (index != -1) {
                gestor.clienteAbandona(index);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente de la lista para retirarlo.");
            }
        });

        panelCola.add(new JScrollPane(listaVisualCola), BorderLayout.CENTER);
        panelCola.add(btnAbandonar, BorderLayout.SOUTH);

        add(panelCola, BorderLayout.CENTER);

        //  Panel Inferior 
        JPanel panelCajas = new JPanel(new GridLayout(1, 2, 20, 0)); 
        panelCajas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCajas.setPreferredSize(new Dimension(0, 250));

        
        panelCaja1 = new PanelCajero(1, gestor);
        panelCaja2 = new PanelCajero(2, gestor);

        panelCajas.add(panelCaja1);
        panelCajas.add(panelCaja2);

        add(panelCajas, BorderLayout.SOUTH);
    }

    private void agregarCliente() {
        String nombre = txtNombre.getText().trim();
        if (!nombre.isEmpty()) {
            gestor.nuevoCliente(nombre);
            txtNombre.setText("");
            txtNombre.requestFocus();
        }
    }
}