/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author DAMDU110
 */
public class Producto {

    public static enum TipoProducto {
        MONITORES, LAVADORAS, TELEVISORES, ORDENADORES
    };
    private int codigo; //identificador
    private int cantidad;
    private String nombre;
    private String descripcion;
    private TipoProducto tipo;

    public Producto() {

    }

    public void AumentaCant(){
    this.cantidad++;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Producto(int codigo, int cantidad, String nombre, String descripcion, TipoProducto tipo) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\ncodigo=").append(codigo);
        sb.append("\ncantidad=").append(cantidad);
        sb.append("\nnombre=").append(nombre);
        sb.append("\ndescripción=").append(descripcion);
        sb.append("\ntipo=").append(tipo);
        return sb.toString();
    }
}
