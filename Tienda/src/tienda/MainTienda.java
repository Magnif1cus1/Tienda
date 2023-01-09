/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

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
            System.out.println("2.- Insertar Producto.");
            System.out.println("3.- Eliminar Productos.");
            System.out.println("4.- Buscar por nombre un Producto.");
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
        int op;

        do {
            op = menuPrincipal(scan);

            switch (op) {
                case 1:
//ListarProductos

                    break;
                case 2:

//InsertarProductos
                    break;
                case 3:
//EliminarProductos
                    break;
                case 4:
//buscar por nombre
                    break;
                default:
                    op = 5;

            }

        } while (op != OPCION_SALIR);

    }

}
