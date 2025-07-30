
package system;
import controller.ControladorJuguetes;
import controller.ControladorUsuarios;
import controller.ControladorNoticias;
import controller.ControladorProveedores;
import controller.ControladorFacturas;
import controller.ControladorCuentas;
import controller.ControladorCarritos;
import controller.ControladorDetallesCarritos;
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
            System.out.println("4. Gestion de Proveedores");
            System.out.println("5. Gestion de Juguetes");
            System.out.println("6. Gestion de Cuentas");
            System.out.println("7. Gestion de Carritos");
            System.out.println("8. Gestion de Detalles Carritos");
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
                    ControladorFacturas ControladorFacturas = new ControladorFacturas();
                    ControladorFacturas.menu();
                    break;
                case 3:
                    ControladorNoticias controladorNoticias = new ControladorNoticias();
                    controladorNoticias.menu();
                    break;
                case 4:
                    ControladorProveedores controladorProveedores = new ControladorProveedores();
                    controladorProveedores.menu();
                    break;
                case 5:
                    ControladorJuguetes controladorJuguetes = new ControladorJuguetes();
                    controladorJuguetes.menu();
                    break;
                case 6:
                    ControladorCuentas controladorCuentas = new ControladorCuentas();
                    controladorCuentas.menu();
                    break;
                case 7:
                    ControladorCarritos controladorCarritos = new ControladorCarritos();
                    controladorCarritos.menu();
                    break;
                case 8:
                    ControladorDetallesCarritos controladorDetallesCarritos = new ControladorDetallesCarritos();
                    controladorDetallesCarritos.menu();
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