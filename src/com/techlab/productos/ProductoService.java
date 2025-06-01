
package com.techlab.productos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Veronica Olate
 * Esta clase contiene los metodos relacionados con la gestión de los productos
 * 
 */




public class ProductoService {
    private List<Producto> productos;

    public ProductoService() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, double precio, int stock) {
        Producto p = new Producto(nombre, precio, stock);
        productos.add(p);
        System.out.println("producto agregado");
    }

    public List<Producto> listarProductos() {
        return productos;}

    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    }

    public Producto buscarPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(int id) {
        Producto p = buscarPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
    
    public void actualizarProducto(Producto producto, double nuevoPrecio, int nuevoStock) {
    producto.setPrecio(nuevoPrecio);
    producto.setStock(nuevoStock);
}
   
}

