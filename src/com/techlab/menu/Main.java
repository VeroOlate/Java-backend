package com.techlab.menu;

import com.techlab.productos.ProductoService;
import com.techlab.productos.Producto;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("---- Menu Principal ----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar productos");
            System.out.println("4. Eliminar productos");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.println("=== Agregar Producto ===");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio (ingrese los centavos seguidos de una coma): ");
                    double precio = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    productoService.agregarProducto(nombre, precio, stock);
                    break;
                case 2:
                    System.out.println("=== Listar Productos ===");
                    List<Producto> lista = productoService.listarProductos();
                    if (lista.isEmpty()) {
                        System.out.println("No hay productos cargados");
                    } else {
                        for (Producto p : lista) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3: 
                    System.out.println("=== Buscar Producto por Nombre ===");
                    System.out.print("Ingresá el nombre del producto: ");
                    String nombreBuscar = scanner.nextLine();

                    Producto productoEncontrado = productoService.buscarPorNombre(nombreBuscar);

                    if (productoEncontrado != null) {
                        System.out.println("Producto: ");
                        System.out.println(productoEncontrado);

                        System.out.print("¿Deseás actualizar precio y stock? (S/N): ");
                        String actualizar = scanner.nextLine();

                        if (actualizar.equalsIgnoreCase("S")) {
                            try {
                                System.out.println("===Actualizar Producto ===");
                                System.out.print("precio nuevo : ");
                                double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                                System.out.print("stock nuevo : ");
                                int nuevoStock = Integer.parseInt(scanner.nextLine());

                                if (nuevoPrecio < 0 || nuevoStock < 0) {
                                    System.out.println("Ingresa un valor mayor a 0");
                                } else {
                                    productoService.actualizarProducto(productoEncontrado, nuevoPrecio, nuevoStock);
                                    System.out.println("Se actualizo el producto");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Error: Ingresá valores numéricos válidos.");
                            }
                        }

                    } else {
                        System.out.println("No se encuentra un producto con ese nombre");
                    }
                    break;
                case 4:
                    System.out.println("=== Eliminar Producto ===");
                    System.out.print("Ingrese el nombre del producto que desea eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    Producto productoAEliminar = productoService.buscarPorNombre(nombreEliminar);

                    if (productoAEliminar != null) {
                        System.out.println("Producto encontrado: " + productoAEliminar);
                        System.out.print("Confirma que desea eliminarlo? (S/N): ");
                        String confirmacion = scanner.nextLine();

                        if (confirmacion.equalsIgnoreCase("S")) {
                            boolean eliminado = productoService.eliminarProducto(productoAEliminar.getID());
                            if (eliminado) {
                                System.out.println("Producto eliminado");
                            } else {
                                System.out.println("Ocurrió un error al intentar eliminar.");
                            }
                        } else {
                            System.out.println("Eliminación cancelada.");
                        }
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestro servicio. Hasta pronto!2");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}
