package clases;

public class Repuestos {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double valorTotal;
    private String estado;

    public Repuestos(String codigo, String nombre, double precio, int cantidad, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.valorTotal = precio * cantidad;
        this.estado = estado;
    }

    // Metodos_Get_y_Set
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        setValorTotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        setValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private void setValorTotal() {
        this.valorTotal = this.precio * this.cantidad;
    }

    public Object[] toRow() {
        return new Object[]{codigo, nombre, precio, cantidad, valorTotal, estado};
    }
}