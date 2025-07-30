
package controller;
import dao.Usuarios;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class ControladorUsuarios {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominio");
    private final EntityManager em = emf.createEntityManager();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Editar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Salir del menú");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: agregarUsuario();
                    break;
                case 2: listarUsuarios();
                    break;
                case 3: buscarUsuario();
                    break;
                case 4: editarUsuario();
                    break;
                case 5: eliminarUsuario();
                    break;
                case 0: System.out.println("Saliendo del menú...");
                    break;
                default: System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    private void agregarUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese teléfono (9 dígitos): ");
        String telefono = scanner.nextLine();

        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(nombre);
        usuario.setApellidoUsuario(apellido);
        usuario.setDireccionUsuario(direccion);
        usuario.setTelefonoUsuario(telefono);

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        System.out.println("Usuario agregado correctamente.");
    }

    private void listarUsuarios() {
        List<Usuarios> usuarios = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class).getResultList();
        System.out.println("\n--- Lista de Usuarios ---");
        usuarios.forEach(System.out::println);
    }

    private void buscarUsuario() {
        System.out.print("Ingrese el ID (código) del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Usuarios usuario = em.find(Usuarios.class, id);
        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void editarUsuario() {
        System.out.print("Ingrese ID del usuario a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuarios usuario = em.find(Usuarios.class, id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + usuario.getNombreUsuario() + "): ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo apellido (actual: " + usuario.getApellidoUsuario() + "): ");
        String apellido = scanner.nextLine();

        System.out.print("Nueva dirección (actual: " + usuario.getDireccionUsuario() + "): ");
        String direccion = scanner.nextLine();

        System.out.print("Nuevo teléfono (actual: " + usuario.getTelefonoUsuario() + "): ");
        String telefono = scanner.nextLine();

        em.getTransaction().begin();
        usuario.setNombreUsuario(nombre);
        usuario.setApellidoUsuario(apellido);
        usuario.setDireccionUsuario(direccion);
        usuario.setTelefonoUsuario(telefono);
        em.getTransaction().commit();

        System.out.println("Usuario actualizado.");
    }

    private void eliminarUsuario() {
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuarios usuario = em.find(Usuarios.class, id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();

        System.out.println("Usuario eliminado.");
    }
}