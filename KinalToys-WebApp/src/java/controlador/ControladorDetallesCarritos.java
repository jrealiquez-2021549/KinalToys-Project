
package controller;
import dao.DetallesCarritos;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ControladorDetallesCarritos {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DETALLES CARRITOS ---");
            System.out.println("1. Agregar detalle");
            System.out.println("2. Listar detalles");
            System.out.println("3. Buscar detalle por ID");
            System.out.println("4. Editar detalle");
            System.out.println("5. Eliminar detalle");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: agregarDetalle();
                    break;
                case 2: listarDetalles();
                    break;
                case 3: buscarDetalle();
                    break;
                case 4: editarDetalle();
                    break;
                case 5: eliminarDetalle();
                    break;
                case 0: System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarDetalle() {
        try {
            System.out.print("Ingrese cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese subTotal: ");
            BigDecimal subTotal = new BigDecimal(scanner.nextLine());

            System.out.print("Ingrese descuento aplicado: ");
            BigDecimal descuentoAplicado = new BigDecimal(scanner.nextLine());

            System.out.print("Ingrese código de carrito: ");
            int codigoCarrito = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese código de juguete: ");
            int codigoJuguete = scanner.nextInt();
            scanner.nextLine();

            DetallesCarritos detalle = new DetallesCarritos();
            detalle.setCantidad(cantidad);
            detalle.setSubTotal(subTotal);
            detalle.setDescuentoAplicado(descuentoAplicado);
            detalle.setCodigoCarrito(codigoCarrito);
            detalle.setCodigoJuguete(codigoJuguete);

            em.getTransaction().begin();
            em.persist(detalle);
            em.getTransaction().commit();

            System.out.println("Detalle agregado correctamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al agregar detalle: " + e.getMessage());
        }
    }

    private void listarDetalles() {
        List<DetallesCarritos> detalles = em.createQuery("SELECT d FROM DetallesCarritos d", DetallesCarritos.class).getResultList();
        System.out.println("\n--- Lista de Detalles ---");
        detalles.forEach(System.out::println);
    }

    private void buscarDetalle() {
        System.out.print("Ingrese el ID del detalle: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DetallesCarritos detalle = em.find(DetallesCarritos.class, id);
        if (detalle != null) {
            System.out.println("Detalle encontrado:");
            System.out.println(detalle);
        } else {
            System.out.println("Detalle no encontrado.");
        }
    }

    private void editarDetalle() {
        System.out.print("Ingrese ID del detalle a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DetallesCarritos detalle = em.find(DetallesCarritos.class, id);
        if (detalle == null) {
            System.out.println("Detalle no encontrado.");
            return;
        }

        System.out.print("Nueva cantidad (actual: " + detalle.getCantidad() + "): ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo subTotal (actual: " + detalle.getSubTotal() + "): ");
        BigDecimal subTotal = new BigDecimal(scanner.nextLine());

        System.out.print("Nuevo descuento aplicado (actual: " + detalle.getDescuentoAplicado() + "): ");
        BigDecimal descuento = new BigDecimal(scanner.nextLine());

        System.out.print("Nuevo código de carrito (actual: " + detalle.getCodigoCarrito() + "): ");
        int codigoCarrito = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo código de juguete (actual: " + detalle.getCodigoJuguete() + "): ");
        int codigoJuguete = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        detalle.setCantidad(cantidad);
        detalle.setSubTotal(subTotal);
        detalle.setDescuentoAplicado(descuento);
        detalle.setCodigoCarrito(codigoCarrito);
        detalle.setCodigoJuguete(codigoJuguete);
        em.getTransaction().commit();

        System.out.println("Detalle actualizado.");
    }

    private void eliminarDetalle() {
        System.out.print("Ingrese ID del detalle a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DetallesCarritos detalle = em.find(DetallesCarritos.class, id);
        if (detalle == null) {
            System.out.println("Detalle no encontrado.");
            return;
        }

        em.getTransaction().begin();
        em.remove(detalle);
        em.getTransaction().commit();

        System.out.println("Detalle eliminado.");
    }
}
