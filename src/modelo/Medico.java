package modelo;

public class Medico extends Empleado {
    private String especialidad;
    private int numeroPacientesAtendidos;
    private double valorConsulta;

    // Utilizamos el Super para indicar que vamos a usar todo el contenido dentro de esta clase
    public Medico(String cedula, String nombre, int edad, String telefono, String correo,
                  String especialidad, int numeroPacientesAtendidos, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad = especialidad;
        this.numeroPacientesAtendidos = numeroPacientesAtendidos;
        this.valorConsulta = valorConsulta;
    }

    // Utilizamos sobreEscritura para realizar los calculos correspondientes
    @Override
    public double calcularPago() {
        return numeroPacientesAtendidos * valorConsulta;
    }
    // Sobreescribimos para que se vaya autoincrementando los datos al imprimir el metodo
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Pacientes atendidos: " + numeroPacientesAtendidos);
        System.out.println("Valor consulta: " + valorConsulta);
        System.out.println("Pago: " + calcularPago());
    }
}

