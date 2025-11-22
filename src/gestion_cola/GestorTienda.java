package gestion_cola;

import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestorTienda {
    
    
    private DefaultListModel<Cliente> modeloCola; 
    private List<Producto> inventarioBase;
    private int contadorTickets = 1;
    private Random random = new Random();

    public GestorTienda() {
        modeloCola = new DefaultListModel<>();
        inicializarInventario();
    }

    private void inicializarInventario() {
        inventarioBase = new ArrayList<>();
        
        inventarioBase.add(new Producto("Harina de Maíz", 1.50));
        inventarioBase.add(new Producto("Arroz 1kg", 1.20));
        inventarioBase.add(new Producto("Aceite 1L", 3.50));
        inventarioBase.add(new Producto("Pasta 500g", 1.10));
        inventarioBase.add(new Producto("Azúcar", 1.30));
        inventarioBase.add(new Producto("Café 250g", 4.00));
        inventarioBase.add(new Producto("Leche en Polvo", 5.50));
        inventarioBase.add(new Producto("Margarina", 2.00));
        inventarioBase.add(new Producto("Atún en lata", 1.80));
        inventarioBase.add(new Producto("Salsa de Tomate", 1.50));
        inventarioBase.add(new Producto("Mayonesa", 2.50));
        inventarioBase.add(new Producto("Jabón de Baño", 0.90));
        inventarioBase.add(new Producto("Detergente", 3.00));
        inventarioBase.add(new Producto("Huevos (12)", 2.50));
        inventarioBase.add(new Producto("Queso 1kg", 6.00));
    }

    public void nuevoCliente(String nombre) {
        Cliente c = new Cliente(nombre, contadorTickets++);
        
        int cantidadProductos = random.nextInt(5) + 1;
        for (int i = 0; i < cantidadProductos; i++) {
            Producto p = inventarioBase.get(random.nextInt(inventarioBase.size()));
            c.agregarProducto(p);
        }
        modeloCola.addElement(c); 
    }

    public void reencolarCliente(Cliente c) {
        
        modeloCola.addElement(c);
    }

    public Cliente sacarSiguiente() {
        if (!modeloCola.isEmpty()) {
            return modeloCola.remove(0); 
        }
        return null;
    }

    public void clienteAbandona(int indice) {
        if (indice >= 0 && indice < modeloCola.getSize()) {
            modeloCola.remove(indice);
        }
    }

    public DefaultListModel<Cliente> getModeloCola() {
        return modeloCola;
    }
    
    public boolean hayClientes() {
        return !modeloCola.isEmpty();
    }
}