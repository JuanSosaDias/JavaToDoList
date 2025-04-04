import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            String input = scanner.nextLine(); // Siempre leer como línea
            try {
                opcion = Integer.parseInt(input); // Intentar convertir
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, debe ser un número.");
                opcion = -1; // Evita que salga del bucle
            }

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    mostrarTareas();
                    break;
                case 3:
                    eliminarTarea();
                    break;
                case 0:
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\nGESTOR DE TAREAS");
        System.out.println("1- Agregar tarea");
        System.out.println("2- Ver tareas");
        System.out.println("3- Eliminar tarea");
        System.out.println("0- Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarTarea() {
        System.out.print("Escribe la nueva tarea: ");
        String tarea = scanner.nextLine();
        tareas.add(tarea);
        System.out.println("Tarea agregada.");
    }

    private static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("Tus tareas:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    private static void eliminarTarea() {
        mostrarTareas();
        if (!tareas.isEmpty()) {
            System.out.print("Número de la tarea a eliminar: ");
            String input = scanner.nextLine();
            try {
                int indice = Integer.parseInt(input);
                if (indice > 0 && indice <= tareas.size()) {
                    tareas.remove(indice - 1);
                    System.out.println("Tarea eliminada.");
                } else {
                    System.out.println("Indice no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, debe ser un número.");
            }
        }
    }
}
