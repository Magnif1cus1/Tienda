/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

/**
 *
 * @author DAMDU110
 */
public class Tienda {

    private Producto[] productos;
    private String nombre;//nombre tienda
    private String dir;//direccion
    private int libre;
    private static final int MAX = 100;

    public Tienda(Producto[] productos, String nombre, String dir) {
        productos = new Producto[MAX];
        this.nombre = nombre;
        this.dir = dir;
        libre = 0;
    }

    public int getProductosRestantes() {
        return (MAX - libre);
    }

    public boolean hayEspacio() {
        return (!estaLleno());
    }

    public boolean estaLleno() {
        return (libre == MAX);
    }

    /**
     * Comprueba si hay Espacio, e inserta un Objeto Producto en el Array
     * productos.
     *
     * @param producto
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean ExisteProducto(Producto x) {
        boolean ret = false;
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                if (x.getTipo() == productos[i].getTipo()) {
                    ret = true;
                }
            }
        }
        return ret;
    }
    
    public StringBuilder MostrarProductosPorNombre(String nombre){
        StringBuilder Productos= new StringBuilder();
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                if (nombre==productos[i].getNombre()) {
                    Productos.append(productos[i]);
                }
            }
        }
        return Productos;
    }

    
    
    public void insertaProducto(Producto producto) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            if (ExisteProducto(producto)) {
                producto.AumentaCant();
            } else {
                productos[libre] = producto;
                ++libre;
            }

        } else {
            throw new ArrayIndexOutOfBoundsException("Capacidad de contratacion completa.");
        }
    }

    /**
     *
     * @return Devuelve un String de los Productos del Array;
     */
    public StringBuilder getProductos() {
        StringBuilder ret = new StringBuilder();
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                ret.append(productos[i]);
            }
        } else {
            ret.append("No hay Productos en la Tienda actualmente.");
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tienda{");
        sb.append("\n\tProductos=").append(productos);
        sb.append("\n\tNombre=").append(nombre);
        sb.append("\n\tDireccion=").append(dir);
        sb.append('}');
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDir() {
        return dir;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
