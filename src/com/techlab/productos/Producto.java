
package com.techlab.productos;

/**
 *
 * @author Veronica Olate
 * 
 * 
 */
public class Producto {

private static int contadorID = 1;
private int ID;
private String nombre;
private double precio;
private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.ID = contadorID++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

     @Override
    public String toString() {
        return "ID: " + ID + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }

}
