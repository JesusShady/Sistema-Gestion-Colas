package gestion_cola;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int numeroTicket;
    private List<Producto> carrito;

    public Cliente(String nombre, int numeroTicket) {
        this.nombre = nombre;
        this.numeroTicket = numeroTicket;
        this.carrito = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        carrito.add(p);
    }

    public double calcularTotal() {
        return carrito.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public String getDetalleCompra() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos (").append(carrito.size()).append("): ");
        for (Producto p : carrito) {
            sb.append(p.getNombre()).append(", ");
        }
        return sb.toString();
    }

    public String getNombre() { return nombre; }
    public int getNumeroTicket() { return numeroTicket; }

    @Override
    public String toString() {
        
        return String.format("T-%03d | %s | Total: $%.2f", numeroTicket, nombre, calcularTotal());
    }
}