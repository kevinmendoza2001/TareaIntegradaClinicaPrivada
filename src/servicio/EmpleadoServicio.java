package servicio;

import modelo.*;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    // CREATE
    public void registrarEmpleado(Empleado e) {
        // Validar duplicados
        for (Empleado emp : empleados) {
            if (emp.getCedula().equals(e.getCedula())) {
                System.out.println("Error: cédula duplicada.");
                return;
            }
        }
        empleados.add(e);
        System.out.println("Empleado registrado correctamente.");
    }

    // READ
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado e : empleados) {
                e.mostrarInformacion();
                System.out.println("-------------------");
            }
        }
    }

    // UPDATE
    public void reemplazarEmpleado(String cedula, Empleado nuevo) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                empleados.set(i, nuevo);
                System.out.println("Información reemplazada.");
                return;
            }
        }
        System.out.println("Registro no encontrado.");
    }

    // DELETE
    public void eliminarEmpleado(String cedula) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                empleados.remove(i);
                System.out.println("Registro eliminado.");
                return;
            }
        }
        System.out.println("Registro no encontrado.");
    }

    // Buscar por cédula
    public void buscarPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                e.mostrarInformacion();
                return;
            }
        }
        System.out.println("Registro no encontrado.");
    }

    // Estadísticas
    public void mostrarEstadisticas() {
        int totalMedicos = 0, totalAdmin = 0;
        double pagoMedicos = 0, pagoAdmin = 0;
        Empleado mayorIngreso = null;

        for (Empleado e : empleados) {
            if (e instanceof Medico) {
                totalMedicos++;
                pagoMedicos += e.calcularPago();
            } else if (e instanceof Administrativo) {
                totalAdmin++;
                pagoAdmin += e.calcularPago();
            }
            if (mayorIngreso == null || e.calcularPago() > mayorIngreso.calcularPago()) {
                mayorIngreso = e;
            }
        }

        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdmin);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total médicos: " + pagoMedicos);
        System.out.println("Pago total administrativos: " + pagoAdmin);
        if (mayorIngreso != null) {
            System.out.println("Empleado con mayor ingreso: " + mayorIngreso.getNombre() +
                    " - Pago: " + mayorIngreso.calcularPago());
        }
    }
}

