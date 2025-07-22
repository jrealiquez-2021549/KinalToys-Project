
package com.kinaltoys.controlador;
import com.kinaltoys.dominio.Juguetes;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ControladorJuguetes {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ JUGUETES ---");
            System.out.println("1. Agregar juguete");
            System.out.println("2. Listar juguetes");
            System.out.println("3. Buscar juguete por ID");
            System.out.println("4. Editar juguete");
            System.out.println("5. Eliminar juguete");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> agregarJuguete();
                case 2 -> listarJuguetes();
                case 3 -> buscarJuguete();
                case 4 -> editarJuguete();
                case 5 -> eliminarJuguete();
                case 0 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void agregarJuguete() {
        System.out.print("Nombre del juguete: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio (ej. 199.99): ");
        BigDecimal precio = scanner.nextBigDecimal();
        scanner.nextLine(); // limpiar buffer

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Stock: ");
        Integer stock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Código de noticia (puede ser null o 0 si no aplica): ");
        Integer codigoNoticia = scanner.nextInt();
        scanner.nextLine();

        Juguetes juguete = new Juguetes();
        juguete.setNombreJuguete(nombre);
        juguete.setPrecio(precio);
        juguete.setCategoria(categoria);
        juguete.setMarca(marca);
        juguete.setStock(stock);
        juguete.setCodigoNoticia(codigoNoticia != 0 ? codigoNoticia : null);

        em.getTransaction().begin();
        em.persist(juguete);
        em.getTransaction().commit();

        System.out.println("Juguete agregado correctamente.");
    }

    private void listarJuguetes() {
        List<Juguetes> juguetes = em.createQuery("SELECT j FROM Juguetes j", Juguetes.class).getResultList();
        System.out.println("\n--- Lista de Juguetes ---");
        juguetes.forEach(System.out::println);
    }

    private void buscarJuguete() {
        System.out.print("Ingrese el ID del juguete: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Juguetes juguete = em.find(Juguetes.class, id);
        if (juguete != null) {
            System.out.println("Juguete encontrado:");
            System.out.println(juguete);
        } else {
            System.out.println("Juguete no encontrado.");
        }
    }

    private void editarJuguete() {
        System.out.print("Ingrese el ID del juguete a editar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Juguetes juguete = em.find(Juguetes.class, id);
        if (juguete == null) {
            System.out.println("Juguete no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + juguete.getNombreJuguete() + "): ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo precio (" + juguete.getPrecio() + "): ");
        BigDecimal precio = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.print("Nueva categoría (" + juguete.getCategoria() + "): ");
        String categoria = scanner.nextLine();

        System.out.print("Nueva marca (" + juguete.getMarca() + "): ");
        String marca = scanner.nextLine();

        System.out.print("Nuevo stock (" + juguete.getStock() + "): ");
        Integer stock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo código de noticia (" + juguete.getCodigoNoticia() + "): ");
        Integer codigoNoticia = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        juguete.setNombreJuguete(nombre);
        juguete.setPrecio(precio);
        juguete.setCategoria(categoria);
        juguete.setMarca(marca);
        juguete.setStock(stock);
        juguete.setCodigoNoticia(codigoNoticia != 0 ? codigoNoticia : null);
        em.getTransaction().commit();

        System.out.println("Juguete actualizado correctamente.");
    }

    private void eliminarJuguete() {
        System.out.print("Ingrese el ID del juguete a eliminar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        Juguetes juguete = em.find(Juguetes.class, id);
        if (juguete == null) {
            System.out.println("Juguete no encontrado.");
            return;
        }

        em.getTransaction().begin();
        em.remove(juguete);
        em.getTransaction().commit();

        System.out.println("Juguete eliminado correctamente.");
    }
}
