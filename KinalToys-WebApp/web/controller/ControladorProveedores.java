
package controller;
import dao.Proveedores;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ControladorProveedores {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ PROVEEDORES ---");
            System.out.println("1. Agregar proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Buscar proveedor por ID");
            System.out.println("4. Editar proveedor");
            System.out.println("5. Eliminar proveedor");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: agregarProveedor();
                    break;
                case 2: listarProveedores();
                    break;
                case 3: buscarProveedor();
                    break;
                case 4: editarProveedor();
                    break;
                case 5: eliminarProveedor();
                    break;
                case 0: System.out.println("Saliendo del menú...");
                    break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    private void agregarProveedor() {
        System.out.print("Ingrese nombre del proveedor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese teléfono (9 dígitos): ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();

        Proveedores proveedor = new Proveedores();
        proveedor.setNombreProveedor(nombre);
        proveedor.setTelefonoProveedor(telefono);
        proveedor.setCorreoProveedor(correo);
        proveedor.setDireccionProveedor(direccion);

        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

        System.out.println("Proveedor agregado correctamente.");
    }

    private void listarProveedores() {
        List<Proveedores> proveedores = em.createQuery("SELECT p FROM Proveedores p", Proveedores.class).getResultList();
        System.out.println("\n--- Lista de Proveedores ---");
        proveedores.forEach(System.out::println);
    }

    private void buscarProveedor() {
        System.out.print("Ingrese el ID (código) del proveedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Proveedores proveedor = em.find(Proveedores.class, id);
        if (proveedor != null) {
            System.out.println("Proveedor encontrado:");
            System.out.println(proveedor);
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    private void editarProveedor() {
        System.out.print("Ingrese ID del proveedor a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Proveedores proveedor = em.find(Proveedores.class, id);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + proveedor.getNombreProveedor() + "): ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo teléfono (actual: " + proveedor.getTelefonoProveedor() + "): ");
        String telefono = scanner.nextLine();

        System.out.print("Nuevo correo (actual: " + proveedor.getCorreoProveedor() + "): ");
        String correo = scanner.nextLine();

        System.out.print("Nueva dirección (actual: " + proveedor.getDireccionProveedor() + "): ");
        String direccion = scanner.nextLine();

        em.getTransaction().begin();
        proveedor.setNombreProveedor(nombre);
        proveedor.setTelefonoProveedor(telefono);
        proveedor.setCorreoProveedor(correo);
        proveedor.setDireccionProveedor(direccion);
        em.getTransaction().commit();

        System.out.println("Proveedor actualizado.");
    }

    private void eliminarProveedor() {
        System.out.print("Ingrese ID del proveedor a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Proveedores proveedor = em.find(Proveedores.class, id);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado.");
            return;
        }

        em.getTransaction().begin();
        em.remove(proveedor);
        em.getTransaction().commit();

        System.out.println("Proveedor eliminado.");
    }
}
