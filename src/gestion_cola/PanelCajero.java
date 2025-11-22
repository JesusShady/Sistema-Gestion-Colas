package gestion_cola;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class PanelCajero extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroCaja;
    private GestorTienda gestor;
    private Cliente clienteEnAtencion;
    private boolean cajaAbierta;

   
    private JLabel lblEstado;
    private JTextArea txtInfoCliente;
    private JButton btnLlamar;
    private JButton btnCobrar;
    private JButton btnTiempoAgotado;
    private JButton btnAbrirCerrar;

    public PanelCajero(int numeroCaja, GestorTienda gestor) {
        this.numeroCaja = numeroCaja;
        this.gestor = gestor;
        this.cajaAbierta = true; 

        configurarPanel();
    }

    private void configurarPanel() {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), 
                "Caja #" + numeroCaja, 
                TitledBorder.CENTER, 
                TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14)
        ));

        // Estado y Control
        JPanel panelTop = new JPanel(new BorderLayout());
        lblEstado = new JLabel("DISPONIBLE", SwingConstants.CENTER);
        lblEstado.setOpaque(true);
        lblEstado.setBackground(new Color(144, 238, 144)); // Verde claro
        
        btnAbrirCerrar = new JButton("Cerrar Caja");
        btnAbrirCerrar.setFont(new Font("Arial", Font.PLAIN, 10));
        
        panelTop.add(lblEstado, BorderLayout.CENTER);
        panelTop.add(btnAbrirCerrar, BorderLayout.EAST);

        // Info Cliente
        txtInfoCliente = new JTextArea(6, 20);
        txtInfoCliente.setEditable(false);
        txtInfoCliente.setText("Esperando cliente...");
        txtInfoCliente.setLineWrap(true);
        txtInfoCliente.setWrapStyleWord(true);

        // Acciones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 2, 2));
        btnLlamar = new JButton("Llamar Cliente");
        btnCobrar = new JButton("Cobrar ");
        btnTiempoAgotado = new JButton("Tiempo Agotado");
        
      
        btnCobrar.setBackground(new Color(173, 216, 230)); 
        btnTiempoAgotado.setBackground(new Color(255, 182, 193));

        btnCobrar.setEnabled(false);
        btnTiempoAgotado.setEnabled(false);

        panelBotones.add(btnLlamar);
        panelBotones.add(btnCobrar);
        panelBotones.add(btnTiempoAgotado);

        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(txtInfoCliente), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        asignarEventos();
    }

    private void asignarEventos() {
       
        btnAbrirCerrar.addActionListener(e -> {
            cajaAbierta = !cajaAbierta;
            if (cajaAbierta) {
                lblEstado.setText("DISPONIBLE");
                lblEstado.setBackground(new Color(144, 238, 144));
                btnAbrirCerrar.setText("Cerrar Caja");
                btnLlamar.setEnabled(true);
            } else {
                lblEstado.setText("CERRADA");
                lblEstado.setBackground(Color.LIGHT_GRAY);
                btnAbrirCerrar.setText("Abrir Caja");
                btnLlamar.setEnabled(false);
                btnCobrar.setEnabled(false);
                btnTiempoAgotado.setEnabled(false);
                if (clienteEnAtencion != null) {
                   
                    gestor.reencolarCliente(clienteEnAtencion);
                    clienteEnAtencion = null;
                    txtInfoCliente.setText("Caja Cerrada.");
                }
            }
        });

        //  Llamar Cliente
        btnLlamar.addActionListener(e -> {
            if (!gestor.hayClientes()) {
                JOptionPane.showMessageDialog(this, "No hay clientes en la cola.");
                return;
            }
            
            clienteEnAtencion = gestor.sacarSiguiente();
            mostrarInfoCliente();
            
            lblEstado.setText("OCUPADO");
            lblEstado.setBackground(new Color(255, 255, 224)); 
            btnLlamar.setEnabled(false);
            btnCobrar.setEnabled(true);
            btnTiempoAgotado.setEnabled(true);
        });

       
        btnCobrar.addActionListener(e -> procesarPago());

       
        btnTiempoAgotado.addActionListener(e -> {
            if (clienteEnAtencion != null) {
                JOptionPane.showMessageDialog(this, "Tiempo excedido (7 min). El cliente vuelve a la cola.");
                gestor.reencolarCliente(clienteEnAtencion);
                limpiarCaja();
            }
        });
    }

    private void mostrarInfoCliente() {
        txtInfoCliente.setText("");
        txtInfoCliente.append("Cliente: " + clienteEnAtencion.getNombre() + "\n");
        txtInfoCliente.append("-----------------\n");
        txtInfoCliente.append(clienteEnAtencion.getDetalleCompra() + "\n");
        txtInfoCliente.append("-----------------\n");
        txtInfoCliente.append(String.format("TOTAL A PAGAR: $%.2f", clienteEnAtencion.calcularTotal()));
    }

    private void procesarPago() {
        String[] opciones = {"Efectivo", "Pago Móvil", "Punto de Venta"};
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione Método de Pago para pagar $" + String.format("%.2f", clienteEnAtencion.calcularTotal()),
                "Procesar Pago",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != -1) {
            JOptionPane.showMessageDialog(this, "Pago procesado con " + opciones[seleccion] + ".\nGracias por su compra.");
            limpiarCaja();
        }
    }

    private void limpiarCaja() {
        clienteEnAtencion = null;
        txtInfoCliente.setText("Esperando cliente...");
        lblEstado.setText("DISPONIBLE");
        lblEstado.setBackground(new Color(144, 238, 144));
        btnLlamar.setEnabled(true);
        btnCobrar.setEnabled(false);
        btnTiempoAgotado.setEnabled(false);
    }
}