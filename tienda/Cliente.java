package tienda;

public class Cliente {
    // Atributos
    private String nombre;
    private String email;
    private final Producto[] historialCompras;
    private int contadorCompras; 

    // Constructor

    public Cliente(int contadorCompras, String email, Producto[] historialCompras, String nombre) {
        this.contadorCompras = contadorCompras;
        this.email = email;
        this.historialCompras = new Producto[10];
        this.nombre = nombre;
    }

    // Métodos
    public void agregarCompra(Producto producto) {
        if (contadorCompras < historialCompras.length) {
            historialCompras[contadorCompras++] = producto;
        }
    }

    public Producto[] getHistorialCompras() {
        return historialCompras;
    }

    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email;
    }
}
