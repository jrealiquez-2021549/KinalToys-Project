
package controller;
import dao.Carritos;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ControladorCarritos {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ CARRITOS ---");
            System.out.println("1. Agregar carrito");
            System.out.println("2. Listar carritos");
            System.out.println("3. Buscar carrito por ID");
            System.out.println("4. Editar carrito");
            System.out.println("5. Eliminar carrito");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: agregarCarrito();
                    break;
                case 2: listarCarritos();
                    break;
                case 3: buscarCarrito();
                    break;
                case 4: editarCarrito();
                    break;
                case 5: eliminarCarrito();
                    break;
                case 0: System.out.println("Saliendo del menú...");
                    break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    private void agregarCarrito() {
        System.out.print("Ingrese fecha de creación (formato yyyy-MM-dd HH:mm:ss): ");
        String fechaTexto = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);

        System.out.print("Ingrese estado (Activo o Comprado): ");
        String estado = scanner.nextLine();

        System.out.print("Ingrese total del carrito: ");
        String total = scanner.nextLine();

        System.out.print("Ingrese código del usuario: ");
        int codigoUsuario = scanner.nextInt();
        scanner.nextLine();

        Carritos carrito = new Carritos();
        carrito.setFechaCreacion(fecha);
        carrito.setEstado(estado);
        carrito.setTotal(total);
        carrito.setCodigoUsuario(codigoUsuario);

        em.getTransaction().begin();
        em.persist(carrito);
        em.getTransaction().commit();

        System.out.println("Carrito agregado correctamente.");
    }

    private void listarCarritos() {
        List<Carritos> carritos = em.createQuery("SELECT c FROM Carritos c", Carritos.class).getResultList();
        System.out.println("\n--- Lista de Carritos ---");
        carritos.forEach(System.out::println);
    }

    private void buscarCarrito() {
        System.out.print("Ingrese el ID del carrito: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carritos carrito = em.find(Carritos.class, id);
        if (carrito != null) {
            System.out.println("Carrito encontrado:");
            System.out.println(carrito);
        } else {
            System.out.println("Carrito no encontrado.");
        }
    }

    private void editarCarrito() {
        System.out.print("Ingrese ID del carrito a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carritos carrito = em.find(Carritos.class, id);
        if (carrito == null) {
            System.out.println("Carrito no encontrado.");
            return;
        }

        System.out.print("Nueva fecha de creación (actual: " + carrito.getFechaCreacion().format(formatter) + "): ");
        String fechaTexto = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);

        System.out.print("Nuevo estado (actual: " + carrito.getEstado() + "): ");
        String estado = scanner.nextLine();

        System.out.print("Nuevo total (actual: " + carrito.getTotal() + "): ");
        String total = scanner.nextLine();

        System.out.print("Nuevo código de usuario (actual: " + carrito.getCodigoUsuario() + "): ");
        int codigoUsuario = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        carrito.setFechaCreacion(fecha);
        carrito.setEstado(estado);
        carrito.setTotal(total);
        carrito.setCodigoUsuario(codigoUsuario);
        em.getTransaction().commit();

        System.out.println("Carrito actualizado correctamente.");
    }

    private void eliminarCarrito() {
        System.out.print("Ingrese ID del carrito a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Carritos carrito = em.find(Carritos.class, id);
        if (carrito == null) {
            System.out.println("Carrito no encontrado.");
            return;
        }

        em.getTransaction().begin();
        em.remove(carrito);
        em.getTransaction().commit();

        System.out.println("Carrito eliminado correctamente.");
    }
}