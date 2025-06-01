
package com.techlab.pedidos;

import java.util.List;
import java.util.ArrayList;


public class Pedido {
     private int id;
    private List<LineaPedido> lineas;

    public Pedido(int id) {
        this.id = id;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    // Opcional: mostrar resumen
    public void mostrarResumen() {
        System.out.println("Pedido #" + id);
        for (LineaPedido linea : lineas) {
            System.out.println("- " + linea);
        }
        System.out.println("Total: $" + calcularTotal());
    }
}


