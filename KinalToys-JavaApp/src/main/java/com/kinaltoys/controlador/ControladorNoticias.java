
package com.kinaltoys.controlador;
import com.kinaltoys.dominio.Noticias;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ControladorNoticias {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ NOTICIAS ---");
            System.out.println("1. Agregar noticia");
            System.out.println("2. Listar noticias");
            System.out.println("3. Buscar noticia por ID");
            System.out.println("4. Editar noticia");
            System.out.println("5. Eliminar noticia");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> agregarNoticia();
                case 2 -> listarNoticias();
                case 3 -> buscarNoticia();
                case 4 -> editarNoticia();
                case 5 -> eliminarNoticia();
                case 0 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void agregarNoticia() {
        System.out.print("Ingrese encabezado: ");
        String encabezado = scanner.nextLine();

        System.out.print("Ingrese información: ");
        String informacion = scanner.nextLine();

        System.out.print("Ingrese categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Ingrese fecha (formato yyyy-MM-dd HH:mm:ss): ");
        String fechaTexto = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);

        Noticias noticia = new Noticias();
        noticia.setEncabezado(encabezado);
        noticia.setInformacion(informacion);
        noticia.setCategoria(categoria);
        noticia.setFechaNoticia(fecha);

        em.getTransaction().begin();
        em.persist(noticia);
        em.getTransaction().commit();

        System.out.println("Noticia agregada correctamente.");
    }

    private void listarNoticias() {
        List<Noticias> noticias = em.createQuery("SELECT n FROM Noticias n", Noticias.class).getResultList();
        System.out.println("\n--- Lista de Noticias ---");
        noticias.forEach(System.out::println);
    }

    private void buscarNoticia() {
        System.out.print("Ingrese el ID (código) de la noticia: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Noticias noticia = em.find(Noticias.class, id);
        if (noticia != null) {
            System.out.println("Noticia encontrada:");
            System.out.println(noticia);
        } else {
            System.out.println("Noticia no encontrada.");
        }
    }

    private void editarNoticia() {
        System.out.print("Ingrese ID de la noticia a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Noticias noticia = em.find(Noticias.class, id);
        if (noticia == null) {
            System.out.println("Noticia no encontrada.");
            return;
        }

        System.out.print("Nuevo encabezado (actual: " + noticia.getEncabezado() + "): ");
        String encabezado = scanner.nextLine();

        System.out.print("Nueva información (actual: " + noticia.getInformacion() + "): ");
        String informacion = scanner.nextLine();

        System.out.print("Nueva categoría (actual: " + noticia.getCategoria() + "): ");
        String categoria = scanner.nextLine();

        System.out.print("Nueva fecha (actual: " + noticia.getFechaNoticia().format(formatter) + "): ");
        String fechaTexto = scanner.nextLine();
        LocalDateTime fecha = LocalDateTime.parse(fechaTexto, formatter);

        em.getTransaction().begin();
        noticia.setEncabezado(encabezado);
        noticia.setInformacion(informacion);
        noticia.setCategoria(categoria);
        noticia.setFechaNoticia(fecha);
        em.getTransaction().commit();

        System.out.println("Noticia actualizada.");
    }

    private void eliminarNoticia() {
        System.out.print("Ingrese ID de la noticia a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Noticias noticia = em.find(Noticias.class, id);
        if (noticia == null) {
            System.out.println("Noticia no encontrada.");
            return;
        }

        em.getTransaction().begin();
        em.remove(noticia);
        em.getTransaction().commit();

        System.out.println("Noticia eliminada.");
    }
}
