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

    private static int codTotal = 0;
    public static enum TipoProducto {
        MONITORES, LAVADORAS, TELEVISORES, ORDENADORES
    };
    private int codigo; //identificador
    private int cantidad;
    private String nombre;
    private String descripcion;
    private TipoProducto tipo;
    private boolean borrado;

    public Producto() {

    }

    public void aumentaCant(){
    this.cantidad++;
    }

    public boolean getBorrado() {
        return borrado;
    }
            
    public void borrarProducto(){
    this.borrado=true;}
    
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

    public Producto(int cantidad, String nombre, String descripcion, TipoProducto tipo) {
        this.codigo = ++codTotal;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.borrado=false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCodigo = ").append(codigo);
        sb.append("\nCantidad = ").append(cantidad);
        sb.append("\nNombre = ").append(nombre);
        sb.append("\nDescripcion = ").append(descripcion);
        sb.append("\nTipo = ").append(tipo);
        sb.append("\nBorrado = ").append(borrado);
        sb.append("\n");
        return sb.toString();
    }
}
