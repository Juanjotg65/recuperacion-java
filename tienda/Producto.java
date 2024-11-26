package tienda;

public class Producto {
    // Atributos
    private int id;
    private String titulo;
    private String tipo; 
    private double precio;
    private int stock;

    // Constructor
    public Producto(int id, String titulo, String tipo, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Tipo: " + tipo +
               ", Precio: " + precio + ", Stock: " + stock;
    }
}
