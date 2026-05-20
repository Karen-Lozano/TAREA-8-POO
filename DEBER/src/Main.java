import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Persona> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        do {

            try {

                System.out.println("\n====== MENU ======");
                System.out.println("1. Registrar persona");
                System.out.println("2. Mostrar registros");
                System.out.println("3. Actualizar registro");
                System.out.println("4. Eliminar registro");
                System.out.println("5. Salir");
                System.out.print("Seleccione: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        registrar();
                        break;

                    case 2:
                        mostrar();
                        break;

                    case 3:
                        actualizar();
                        break;

                    case 4:
                        eliminar();
                        break;

                    case 5:
                        System.out.println("Programa finalizado.");
                        break;

                    default:
                        System.out.println("Error: opcion invalida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar solo numeros.");
            }

        } while (opcion != 5);

    }

    // ================= REGISTRAR =================
    public static void registrar() {

        try {

            System.out.println("\n1. Estudiante");
            System.out.println("2. Docente");
            System.out.print("Seleccione tipo: ");

            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            if (cedula.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            // Validar cedula repetida
            for (Persona p : lista) {
                if (p.getCedula().equals(cedula)) {
                    System.out.println("La cedula ya existe.");
                    return;
                }
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            if (tipo == 1) {

                System.out.print("Carrera: ");
                String carrera = sc.nextLine();

                if (carrera.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                Estudiante e = new Estudiante(
                        cedula,
                        nombre,
                        edad,
                        carrera
                );

                lista.add(e);

            } else if (tipo == 2) {

                System.out.print("Asignatura: ");
                String asignatura = sc.nextLine();

                if (asignatura.isEmpty()) {
                    System.out.println("Campo obligatorio.");
                    return;
                }

                Docente d = new Docente(
                        cedula,
                        nombre,
                        edad,
                        asignatura
                );

                lista.add(d);

            } else {
                System.out.println("Tipo invalido.");
                return;
            }

            System.out.println("Registro agregado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }

    }

    // ================= MOSTRAR =================
    public static void mostrar() {

        if (lista.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        System.out.println("\n===== REGISTROS =====");

        for (int i = 0; i < lista.size(); i++) {

            System.out.println("\nPOSICION: " + i);
            System.out.println(lista.get(i).mostrarDatos());
        }
    }

    // ================= ACTUALIZAR =================
    public static void actualizar() {

        try {

            mostrar();

            System.out.print("\nIngrese posicion a actualizar: ");
            int pos = Integer.parseInt(sc.nextLine());

            if (pos < 0 || pos >= lista.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            Persona p = lista.get(pos);

            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("Campo obligatorio.");
                return;
            }

            System.out.print("Nueva edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            p.setNombre(nombre);
            p.setEdad(edad);

            System.out.println("Registro actualizado.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }

    }

    // ================= ELIMINAR =================
    public static void eliminar() {

        try {

            mostrar();

            System.out.print("\nIngrese posicion a eliminar: ");
            int pos = Integer.parseInt(sc.nextLine());

            if (pos < 0 || pos >= lista.size()) {
                System.out.println("Registro no encontrado.");
                return;
            }

            System.out.print("Seguro que desea eliminar? (s/n): ");
            String confirmacion = sc.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {

                lista.remove(pos);

                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Operacion cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar solo numeros.");
        }

    }
}
