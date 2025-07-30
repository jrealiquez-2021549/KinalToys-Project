
package controller;
import dao.Cuentas;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ControladorCuentas {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ CUENTAS ---");
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Listar cuentas");
            System.out.println("3. Buscar cuenta por ID");
            System.out.println("4. Editar cuenta");
            System.out.println("5. Eliminar cuenta");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: agregarCuenta();
                    break;
                case 2: listarCuentas();
                    break;
                case 3: buscarCuenta();
                    break;
                case 4: editarCuenta();
                    break;
                case 5: eliminarCuenta();
                    break;
                case 0: System.out.println("Saliendo del menú...");
                    break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    private void agregarCuenta() {
        System.out.print("Ingrese nombre de la cuenta: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Ingrese código del usuario asociado: ");
        int codigoUsuario = scanner.nextInt();
        scanner.nextLine();

        Cuentas cuenta = new Cuentas();
        cuenta.setNombreCuenta(nombre);
        cuenta.setCorreoCuenta(correo);
        cuenta.setContrasenaCuenta(contrasena);
        cuenta.setCodigoUsuario(codigoUsuario);

        em.getTransaction().begin();
        em.persist(cuenta);
        em.getTransaction().commit();

        System.out.println("Cuenta agregada correctamente.");
    }

    private void listarCuentas() {
        List<Cuentas> cuentas = em.createQuery("SELECT c FROM Cuentas c", Cuentas.class).getResultList();
        System.out.println("\n--- Lista de Cuentas ---");
        cuentas.forEach(System.out::println);
    }

    private void buscarCuenta() {
        System.out.print("Ingrese el ID (código) de la cuenta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Cuentas cuenta = em.find(Cuentas.class, id);
        if (cuenta != null) {
            System.out.println("Cuenta encontrada:");
            System.out.println(cuenta);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private void editarCuenta() {
        System.out.print("Ingrese ID de la cuenta a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cuentas cuenta = em.find(Cuentas.class, id);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + cuenta.getNombreCuenta() + "): ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo correo (actual: " + cuenta.getCorreoCuenta() + "): ");
        String correo = scanner.nextLine();

        System.out.print("Nueva contraseña (actual: " + cuenta.getContrasenaCuenta() + "): ");
        String contrasena = scanner.nextLine();

        System.out.print("Nuevo código de usuario (actual: " + cuenta.getCodigoUsuario() + "): ");
        int codigoUsuario = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        cuenta.setNombreCuenta(nombre);
        cuenta.setCorreoCuenta(correo);
        cuenta.setContrasenaCuenta(contrasena);
        cuenta.setCodigoUsuario(codigoUsuario);
        em.getTransaction().commit();

        System.out.println("Cuenta actualizada.");
    }

    private void eliminarCuenta() {
        System.out.print("Ingrese ID de la cuenta a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cuentas cuenta = em.find(Cuentas.class, id);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        em.getTransaction().begin();
        em.remove(cuenta);
        em.getTransaction().commit();

        System.out.println("Cuenta eliminada.");
    }
}
