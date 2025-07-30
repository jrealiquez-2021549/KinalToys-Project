
package controller;
import dao.Facturas;
import enums.MetodoPago;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ControladorFacturas {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ FACTURAS ---");
            System.out.println("1. Agregar factura");
            System.out.println("2. Listar facturas");
            System.out.println("3. Buscar factura por ID");
            System.out.println("4. Editar factura");
            System.out.println("5. Eliminar factura");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: agregarFactura();
                    break;
                case 2: listarFacturas();
                    break;
                case 3: buscarFactura();
                    break;
                case 4: editarFactura();
                    break;
                case 5: eliminarFactura();
                    break;
                case 0: System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void agregarFactura() {
        try {
            System.out.print("Ingrese fecha de emisión (yyyy-MM-dd HH:mm:ss): ");
            String fechaTexto = scanner.nextLine();
            LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);

            System.out.print("Ingrese método de pago (Efectivo/Credito): ");
            String metodoTexto = scanner.nextLine();
            MetodoPago metodoPago = MetodoPago.valueOf(metodoTexto);

            System.out.print("Ingrese total: ");
            BigDecimal total = new BigDecimal(scanner.nextLine());

            System.out.print("Ingrese código de usuario: ");
            int codigoUsuario = scanner.nextInt();
            scanner.nextLine();

            Facturas factura = new Facturas();
            factura.setFechaEmision(fecha);
            factura.setMetodoPago(metodoPago);
            factura.setTotal(total);
            factura.setCodigoUsuario(codigoUsuario);

            em.getTransaction().begin();
            em.persist(factura);
            em.getTransaction().commit();

            System.out.println("Factura agregada correctamente.");

        } catch (Exception e) {
            System.out.println("Error al agregar factura: " + e.getMessage());
        }
    }

    private void listarFacturas() {
        List<Facturas> facturas = em.createQuery("SELECT f FROM Facturas f", Facturas.class).getResultList();
        System.out.println("\n--- Lista de Facturas ---");
        facturas.forEach(System.out::println);
    }

    private void buscarFactura() {
        System.out.print("Ingrese el ID de la factura: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Facturas factura = em.find(Facturas.class, id);
        if (factura != null) {
            System.out.println("Factura encontrada:");
            System.out.println(factura);
        } else {
            System.out.println("Factura no encontrada.");
        }
    }

    private void editarFactura() {
        System.out.print("Ingrese ID de la factura a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Facturas factura = em.find(Facturas.class, id);
        if (factura == null) {
            System.out.println("Factura no encontrada.");
            return;
        }

        System.out.print("Nueva fecha (actual: " + factura.getFechaEmision().format(formatter) + "): ");
        LocalDateTime fecha = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Nuevo método de pago (actual: " + factura.getMetodoPago() + "): ");
        MetodoPago metodoPago = MetodoPago.valueOf(scanner.nextLine());

        System.out.print("Nuevo total (actual: " + factura.getTotal() + "): ");
        BigDecimal total = new BigDecimal(scanner.nextLine());

        System.out.print("Nuevo código de usuario (actual: " + factura.getCodigoUsuario() + "): ");
        int codigoUsuario = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        factura.setFechaEmision(fecha);
        factura.setMetodoPago(metodoPago);
        factura.setTotal(total);
        factura.setCodigoUsuario(codigoUsuario);
        em.getTransaction().commit();

        System.out.println("Factura actualizada.");
    }

    private void eliminarFactura() {
        System.out.print("Ingrese ID de la factura a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Facturas factura = em.find(Facturas.class, id);
        if (factura == null) {
            System.out.println("Factura no encontrada.");
            return;
        }

        em.getTransaction().begin();
        em.remove(factura);
        em.getTransaction().commit();

        System.out.println("Factura eliminada.");
    }
}
