package tienda;

import java.util.Scanner;

public class Main {

    private static Producto[] productos = new Producto[10];
    private static Cliente[] clientes = new Cliente[5];
    private static int contadorProductos = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();
        mostrarMenuPrincipal();
    }

    private static void inicializarDatos() {
        productos[0] = new Producto(1, "One Piece", "manga", 8.99, 10);
        productos[1] = new Producto(2, "Batman", "cómic", 12.50, 5);
        productos[2] = new Producto(3, "Naruto", "manga", 7.99, 8);
        productos[3] = new Producto(4, "Spider-Man", "cómic", 15.99, 6);
        productos[4] = new Producto(5, "Dragon Ball", "manga", 9.99, 4);
        contadorProductos = 5;

        clientes[0] = new Cliente(1, "Juan", new Producto[0], "juan@gmail.com");
        clientes[1] = new Cliente(2, "María", new Producto[0], "maria@gmail.com");
        clientes[2] = new Cliente(3, "Pedro", new Producto[0], "pedro@gmail.com");
        clientes[3] = new Cliente(4, "Ana", new Producto[0], "ana@gmail.com");
        clientes[4] = new Cliente(5, "Luis", new Producto[0], "luis@gmail.com");
    }

    // Menú principal
    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestión de Productos");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarProductos();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);
    }

    // Gestión de productos
    private static void gestionarProductos() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Productos ===");
            System.out.println("1. Añadir nuevo producto");
            System.out.println("2. Mostrar lista de productos");
            System.out.println("3. Buscar productos por título");
            System.out.println("4. Actualizar stock");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductoPorTitulo();
                    break;
                case 4:
                    actualizarStock();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void añadirProducto() {
        if (contadorProductos < productos.length) {
            int id = -1;
            while (true) {
                System.out.print("ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    scanner.nextLine(); 
                    break; 
                } else {
                    System.out.println("Por favor, ingresa un número válido para el ID.");
                    scanner.nextLine(); 
                }
            }
    
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
    
            String tipo;
            while (true) {
                System.out.print("Tipo (cómic/manga): ");
                tipo = scanner.nextLine().toLowerCase(); 
                if (tipo.equals("cómic") || tipo.equals("manga")) {
                    break; 
                } else {
                    System.out.println("Por favor, ingresa 'cómic' o 'manga' como tipo de producto.");
                }
            }
    
            double precio = 0;
            while (true) {
                System.out.print("Precio: ");
                if (scanner.hasNextDouble()) {
                    precio = scanner.nextDouble();
                    scanner.nextLine(); 
                    break; 
                } else {
                    System.out.println("Por favor, ingresa un número válido para el precio.");
                    scanner.nextLine(); 
                }
            }
    
            int stock = -1;
            while (true) {
                System.out.print("Stock: ");
                if (scanner.hasNextInt()) {
                    stock = scanner.nextInt();
                    break; 
                } else {
                    System.out.println("Por favor, ingresa un número válido para el stock.");
                    scanner.nextLine(); 
                }
            }
    
            productos[contadorProductos++] = new Producto(id, titulo, tipo, precio, stock);
            System.out.println("Producto añadido exitosamente.");
        } else {
            System.out.println("No se pueden añadir más productos.");
        }
    }
    

    private static void mostrarProductos() {
        for (int i = 0; i < contadorProductos; i++) {
            System.out.println(productos[i]);
        }
    }

    private static void buscarProductoPorTitulo() {
        System.out.print("Ingrese el título a buscar: ");
        scanner.nextLine(); 
        String titulo = scanner.nextLine();

        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(productos[i]);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    private static void actualizarStock() {
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getId() == id) {
                System.out.print("Nuevo stock: ");
                int nuevoStock = scanner.nextInt();
                productos[i].setStock(nuevoStock);
                System.out.println("Stock actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }


private static void realizarVenta() {
    int opcion;
    Cliente clienteSeleccionado = null;
    Producto productoSeleccionado = null;

    do {
        System.out.println("\n=== Realizar Venta ===");
        System.out.println("1. Seleccionar producto");
        System.out.println("2. Seleccionar cliente");
        System.out.println("3. Confirmar venta");
        System.out.println("4. Aplicar descuento aleatorio");
        System.out.println("5. Ver historial de compras");
        System.out.println("6. Ver productos más vendidos");
        System.out.println("7. Volver al menú principal");
        System.out.print("Selecciona una opción: ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                productoSeleccionado = seleccionarProducto();
                break;
            case 2:
                clienteSeleccionado = seleccionarCliente();
                break;
            case 3:
                confirmarVenta(productoSeleccionado, clienteSeleccionado);
                break;
            case 4:
                aplicarDescuentoAleatorio(productoSeleccionado);
                break;
            case 5:
                verHistorialDeCompras(clienteSeleccionado);
                break;
            case 6:
                verProductosMasVendidos();
                break;
            case 7:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    } while (opcion != 7);
}

private static Producto seleccionarProducto() {
    System.out.println("\n=== Seleccionar Producto ===");
    mostrarProductos();
    System.out.print("Ingresa el ID del producto: ");
    int id = scanner.nextInt();
    for (int i = 0; i < contadorProductos; i++) {
        if (productos[i].getId() == id) {
            if (productos[i].getStock() > 0) {
                System.out.println("Producto seleccionado: " + productos[i]);
                return productos[i];
            } else {
                System.out.println("El producto seleccionado no tiene stock.");
                return null;
            }
        }
    }
    System.out.println("Producto no encontrado.");
    return null;
}

private static Cliente seleccionarCliente() {
    System.out.println("\n=== Seleccionar Cliente ===");
    for (int i = 0; i < clientes.length; i++) {
        System.out.println((i + 1) + ". " + clientes[i]);
    }
    System.out.print("Selecciona un cliente (por número): ");
    int indice = scanner.nextInt() - 1;
    if (indice >= 0 && indice < clientes.length) {
        System.out.println("Cliente seleccionado: " + clientes[indice]);
        return clientes[indice];
    }
    System.out.println("Cliente no válido.");
    return null;
}

private static void confirmarVenta(Producto producto, Cliente cliente) {
    if (producto == null || cliente == null) {
        System.out.println("Debes seleccionar un producto y un cliente primero.");
        return;
    }
    if (producto.getStock() <= 0) {
        System.out.println("No se puede realizar la venta porque no hay stock disponible.");
        return;
    }
    producto.setStock(producto.getStock() - 1); 
    cliente.agregarCompra(producto); 
    System.out.println("Venta realizada con éxito: " + producto.getTitulo() + " a " + cliente);
}

private static void aplicarDescuentoAleatorio(Producto producto) {
    if (producto == null) {
        System.out.println("Debes seleccionar un producto antes de aplicar un descuento.");
        return;
    }
    double descuento = Math.random() * 0.3; 
    double precioConDescuento = producto.getPrecio() * (1 - descuento);
    System.out.printf("Se aplicó un descuento del %.2f%%. Nuevo precio: %.2f%n", descuento * 100, precioConDescuento);
}

private static void verHistorialDeCompras(Cliente cliente) {
    if (cliente == null) {
        System.out.println("Debes seleccionar un cliente para ver su historial de compras.");
        return;
    }

    System.out.println("\n=== Historial de Compras de " + cliente + " ===");
    
    Producto[] historial = cliente.getHistorialCompras();
    
    boolean tieneCompras = false;
    for (Producto producto : historial) {
        if (producto != null) {
            tieneCompras = true;
            break;
        }
    }

    if (!tieneCompras) {
        System.out.println("El cliente no tiene historial de compras.");
        return;
    }

    for (Producto producto : historial) {
        if (producto != null) {
            System.out.println(producto);
        }
    }
}


private static void verProductosMasVendidos() {
    System.out.println("\n=== Productos Más Vendidos ===");

    int[] ventas = new int[contadorProductos];

    for (Cliente cliente : clientes) {
        Producto[] historial = cliente.getHistorialCompras();
        for (Producto producto : historial) {
            if (producto != null) {
                for (int i = 0; i < contadorProductos; i++) {
                    if (productos[i].getId() == producto.getId()) {
                        ventas[i]++;
                    }
                }
            }
        }
    }

    for (int i = 0; i < contadorProductos; i++) {
        if (ventas[i] > 0) {
            System.out.println(productos[i] + " - Ventas: " + ventas[i]);
        }
    }
}

}


