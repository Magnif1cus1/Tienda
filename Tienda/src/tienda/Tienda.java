/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import java.util.Scanner;

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

    public Tienda(String nombre, String dir) {
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
        public boolean hayProductos() {
        return (libre > 0);
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
    
    public StringBuilder BuscarProductosPorNombre(String nombre){
        StringBuilder Productos= new StringBuilder();
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                if (nombre==productos[i].getNombre()) {
                    Productos.append(productos[i]);
                }
            }
        }
        else{
        Productos.append("No existe el producto en la base de datos.");
        }
        return Productos;
    }
  public static Producto leeProducto(Scanner scan) {
        String nombre;
        String descripcion;
        Producto.TipoProducto tipo;
        int codigo;
        int cantidad;
        codigo= leeNumero(scan, "Introduce codigo: ");
        scan.nextLine();
        cantidad= leeNumero(scan, "Introduce cantidad: ");
        scan.nextLine();
        nombre = leeCadena(scan, "Nombre: ");
        descripcion = leeCadena(scan, "Descripcion: ");
        tipo = leeTipo(scan);
          return new Producto(codigo,cantidad,nombre,descripcion,tipo);
    }
    
      public static Producto.TipoProducto leeTipo(Scanner scan) {
        int op;
        do {
            System.out.println("Seleccione el tipo: ");
            for (int i = 0; i < Producto.TipoProducto.values().length; i++) {
                System.out.println((i + 1) + ".- " + Producto.TipoProducto.values()[i].toString());
            }
            op = scan.nextInt();
        } while (op < 1 || op > Producto.TipoProducto.values().length);
        scan.nextLine();
        return Producto.TipoProducto.values()[op - 1];
    }
  
  
      public static String leeCadena(Scanner scan, String mensaje) {
        System.out.println(mensaje);
        return (scan.nextLine());
    }
      
      public static int leeNumero (Scanner scan,String mensaje){
          System.out.println(mensaje);
          return (scan.nextInt());
      }
    
   public void insertaProducto(Producto producto) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            productos[libre] = producto;
            ++libre;
        } else {
            throw new ArrayIndexOutOfBoundsException("Capacidad de contratacion completa.");
        }
    }

         public void borraProductoPorCodigo(int codigo) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                if (codigo==productos[i].getCodigo()) {
             productos[i] =null;
            --libre;  
                }
            }

        } else {
            throw new ArrayIndexOutOfBoundsException("Capacidad de contratacion completa.");
        }
    }
   
   
   
      public void borraProducto(Producto producto) throws ArrayIndexOutOfBoundsException {
        if (hayEspacio()) {
            for (int i = 0; i < libre; i++) {
                if (producto.getCodigo()==productos[i].getCodigo()) {
             productos[i] = productos[libre-i];
            --libre;  
                }
            }

        } else {
            throw new ArrayIndexOutOfBoundsException("Capacidad de contratacion completa.");
        }
    }
    /**
     *
     * @return Devuelve un String de los Productos del Array;
     */
    public String getProductos() {
        StringBuilder ret = new StringBuilder();
        if (hayProductos()) {

            for (int i = 0; i < libre; i++) {
                ret.append(productos[i]);
            }

        } else {
            ret.append("No hay ningún producto en " + this.getNom());
        }
        return ret.toString();
    }
    
        public String getNom() {
        return nombre;
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
