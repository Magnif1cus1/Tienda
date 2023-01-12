/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

import static tienda.Tienda.*;
/**
 *
 * @author DAMDU110
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAMDU101
 */
public class MainTienda {
    
    public static final int OPCION_SALIR = 5;
    
    public static int menuPrincipal(Scanner scan) {
        int op;
        System.out.println("********************TIENDA DE ELECTRODOMESTICOS*************************");
        
        do {
            System.out.println("1.- Listar Productos.");
            System.out.println("2.- Insertar Productos.");
            System.out.println("3.- Eliminar Productos.");
            System.out.println("4.- Buscar Productos.");
            System.out.println("5.- Salir.");
            System.out.println("************************************************************************");
            op = leerEntero("Insertar Opcion:");
        } while (op < 1 || op > OPCION_SALIR);
        return op;
    }
    
    public static int menuBuscar(Scanner scan) {
        int op;
        System.out.println("********************TIENDA DE ELECTRODOMESTICOS*************************");
        
        do {
            System.out.println("1.- Buscar por nombre de producto.");
            System.out.println("2.- Buscar por Código.");
            System.out.println("3.- Buscar por palabra.");
            System.out.println("4.- Atras.");
            System.out.println("5.- Salir.");
            System.out.println("************************************************************************");
            op = leerEntero("Insertar Opcion:");
        } while (op < 1 || op > OPCION_SALIR);
        return op;
    }
    
    public static String leeCadena(Scanner scan, String mensaje) {
        System.out.println(mensaje);
        return (scan.nextLine());
    }
    
    public static Producto leeProductos(Scanner scan) {
        return new Producto();
    }
    
    public static int leerEntero(String men) {
        int ret = 0;
        boolean error;
        Scanner sc = new Scanner(System.in);
        System.out.print(men);
        
        do {
            try {
                ret = sc.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                error = true;
                System.out.println("""
Error: Solo se adminten numeros
Introduzca un numero: """);
                sc.nextLine();
                
            }
            
        } while (error);
        
        return ret;
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tienda ventaElectronica = new Tienda("appInformatica", "Ourense");
        int op;
        final int OPCION_SALIR = 5;
        do {
            op = menuPrincipal(scan);
            
            switch (op) {
                case 1://ListarProductos
                    System.out.println(ventaElectronica.getProductos().toString());
                    break;
                case 2://InsertarProductos
                    if (ventaElectronica.hayEspacio()) {
                        ventaElectronica.insertaProducto(leeProducto(scan));
                    } else {
                        System.out.println("No podemos contratar más médicos, cuadro completo.");
                    }
                    break;
                case 3://EliminarProductos
                    System.out.println("Introduce el codigo del producto a borrar: ");
                    ventaElectronica.borraProductoPorCodigo(leerEntero("codigo:"));
                    break;
                case 4:
                    do {
                        op = menuBuscar(scan);
                        switch (op) {
                            case 1:
                                System.out.println("Introduce nombre del producto a buscar: ");
                                System.out.println(ventaElectronica.BuscarProductosPorNombre(scan.nextLine()));
                                break;
                            default:
                                throw new AssertionError();
                        }
                        
                        System.out.println("Pulse una tecla para continuar: ");
                        scan.nextLine();
                    } while (op != 5);
                    
                    System.out.println("Pulse una tecla para continuar: ");
                    scan.nextLine();
            }
        } while (op != OPCION_SALIR);
        
    }
    
}
