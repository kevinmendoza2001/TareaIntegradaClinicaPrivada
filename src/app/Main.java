package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoServicio servicio = new EmpleadoServicio();

        int opcion = 0;
        do {
            System.out.println("===== CLÍNICA SALUD TOTAL =====");
            System.out.println("1. Registrar médico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cédula");
            System.out.println("5. Reemplazar información");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadísticas");
            System.out.println("9. Salir");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1: // Registrar médico
                    try {
                        System.out.print("Cédula: ");
                        String cedulaM = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombreM = sc.nextLine();
                        System.out.print("Edad: ");
                        int edadM = Integer.parseInt(sc.nextLine());
                        System.out.print("Teléfono: ");
                        String telM = sc.nextLine();
                        System.out.print("Correo: ");
                        String correoM = sc.nextLine();
                        System.out.print("Especialidad: ");
                        String esp = sc.nextLine();
                        System.out.print("Pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());
                        System.out.print("Valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());

                        // Validaciones
                        if (!Validador.validarEdad(edadM) ||
                                !Validador.validarCorreo(correoM) ||
                                !Validador.validarTelefono(telM) ||
                                !Validador.validarMayorCero(pacientes) ||
                                !Validador.validarMayorCero(valorConsulta)) {
                            System.out.println("Error en los datos ingresados.");
                            break;
                        }

                        Medico m = new Medico(cedulaM, nombreM, edadM, telM, correoM, esp, pacientes, valorConsulta);
                        servicio.registrarEmpleado(m);
                    } catch (Exception e) {
                        System.out.println("Error: datos inválidos.");
                    }
                    break;

                case 2: // Registrar administrativo
                    try {
                        System.out.print("Cédula: ");
                        String cedulaA = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombreA = sc.nextLine();
                        System.out.print("Edad: ");
                        int edadA = Integer.parseInt(sc.nextLine());
                        System.out.print("Teléfono: ");
                        String telA = sc.nextLine();
                        System.out.print("Correo: ");
                        String correoA = sc.nextLine();
                        System.out.print("Departamento: ");
                        String dep = sc.nextLine();
                        System.out.print("Horas trabajadas: ");
                        int horas = Integer.parseInt(sc.nextLine());
                        System.out.print("Valor hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());

                        // Validaciones
                        if (!Validador.validarEdad(edadA) ||
                                !Validador.validarCorreo(correoA) ||
                                !Validador.validarTelefono(telA) ||
                                !Validador.validarMayorCero(horas) ||
                                !Validador.validarMayorCero(valorHora)) {
                            System.out.println("Error en los datos ingresados.");
                            break;
                        }

                        Administrativo a = new Administrativo(cedulaA, nombreA, edadA, telA, correoA, dep, horas, valorHora);
                        servicio.registrarEmpleado(a);
                    } catch (Exception e) {
                        System.out.println("Error: datos inválidos.");
                    }
                    break;

                case 3: // Mostrar empleados
                    servicio.mostrarEmpleados();
                    break;

                case 4: // Buscar por cédula
                    System.out.print("Ingrese cédula: ");
                    String cedulaBuscar = sc.nextLine();
                    servicio.buscarPorCedula(cedulaBuscar);
                    break;

                case 5: // Reemplazar información
                    System.out.print("Ingrese cédula a reemplazar: ");
                    String cedulaReemplazar = sc.nextLine();
                    System.out.println("Ingrese nuevo registro como médico (1) o administrativo (2): ");
                    int tipo = Integer.parseInt(sc.nextLine());
                    if (tipo == 1) {
                        // Se podría reutilizar el bloque de registrar médico
                        System.out.println("Ingrese datos del nuevo médico:");
                        // (Por simplicidad, se puede copiar el bloque de case 1 aquí)
                    } else if (tipo == 2) {
                        System.out.println("Ingrese datos del nuevo administrativo:");
                        // (Por simplicidad, se puede copiar el bloque de case 2 aquí)
                    }
                    break;

                case 6: // Eliminar registro
                    System.out.print("Ingrese cédula a eliminar: ");
                    String cedulaEliminar = sc.nextLine();
                    servicio.eliminarEmpleado(cedulaEliminar);
                    break;

                case 7: // Calcular pagos
                    servicio.mostrarEmpleados(); // ya muestra el pago calculado
                    break;

                case 8: // Mostrar estadísticas
                    servicio.mostrarEstadisticas();
                    break;

                case 9: // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Error: opción inválida.");
            }
        } while (opcion != 9);
    }
}
