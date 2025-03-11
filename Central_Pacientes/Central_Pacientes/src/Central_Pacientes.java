import java.util.Scanner;

class Paciente {
    private String id;
    private String nombre;
    private String clinica;
    private int edad;

    public Paciente(String id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    @Override
    public String toString() {
        return "Paciente(" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", clinica='" + clinica + '\'' +
                ')';
    }
}

class NodoPaciente {
    Paciente paciente;
    NodoPaciente siguiente;

    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }
}

class ListaPacientes {
    private NodoPaciente cabeza;

    public void agregarPaciente(Paciente paciente) {
        if (existePaciente(paciente.getId())) return;
        NodoPaciente nuevo = new NodoPaciente(paciente);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPaciente aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    public boolean existePaciente(String id) {
        NodoPaciente aux = cabeza;
        while (aux != null) {
            if (aux.paciente.getId().equals(id)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public void mostrarPacientes() {
        NodoPaciente aux = cabeza;
        while (aux != null) {
            System.out.println(aux.paciente);
            aux = aux.siguiente;
        }
    }

    public boolean eliminarPaciente(String id) {
        if (cabeza == null) return false;
        if (cabeza.paciente.getId().equals(id)) {
            cabeza = cabeza.siguiente;
            return true;
        }
        NodoPaciente aux = cabeza;
        while (aux.siguiente != null) {
            if (aux.siguiente.paciente.getId().equals(id)) {
                aux.siguiente = aux.siguiente.siguiente;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public int contarPacientes() {
        int count = 0;
        NodoPaciente aux = cabeza;
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }
}

public class Central_Pacientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaPacientes lista = new ListaPacientes();
        int opcion;
        do {
            System.out.println("\n--- Menú Central de Pacientes ---");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Eliminar paciente");
            System.out.println("4. Contar pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese edad: ");
                    int edad = scanner.nextInt();

                    scanner.nextLine();
                    System.out.print("Ingrese clinica: ");
                    String clinica = scanner.nextLine();

                    lista.agregarPaciente(new Paciente(id, nombre, edad, clinica));
                    System.out.println("Paciente agregado correctamente.");

                    break;
                case 2:

                    System.out.println("\nLista de Pacientes:");
                    lista.mostrarPacientes();

                    break;
                case 3:
                    System.out.print("Ingrese ID del paciente a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    
                    if (lista.eliminarPaciente(idEliminar)) {
                        System.out.println("Paciente eliminado correctamente.");
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Cantidad de pacientes: " + lista.contarPacientes());
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}