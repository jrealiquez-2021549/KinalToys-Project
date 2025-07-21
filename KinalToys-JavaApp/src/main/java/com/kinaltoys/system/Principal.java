
package com.kinaltoys.system;
import com.kinaltoys.controlador.ControladorUsuarios;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Facturas");
            System.out.println("3. Gestión de Noticias");
            System.out.println("0. Salir de aplicación");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    ControladorUsuarios controladorUsuarios = new ControladorUsuarios();
                    controladorUsuarios.menu(); // Llama al menú de usuarios
                    break;
                case 2:
                    System.out.println("Funcionalidad de Facturas aún no implementada.");
                    // ControladorProductos controladorProductos = new ControladorProductos();
                    // controladorProductos.menu();
                    break;
                case 3:
                    System.out.println("Funcionalidad de Noticias aún no implementada.");
                    // ControladorClientes controladorClientes = new ControladorClientes();
                    // controladorClientes.menu();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}