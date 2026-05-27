package modelo;

public abstract class Empleado {
    // Encapsulamiento de atributos privados
    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;

    // Aplicamos un constructor para cada uno de los atributos dentro del encapsulamiento
    public Empleado(String cedula, String nombre, int edad, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Usamos getters
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }

    // Usamos un metodo void para imprimir la información
    public void mostrarInformacion() {
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
    }
    // Usamos un metodo abstracto, el cual indica que es necesario su uso
    public abstract double calcularPago();
}

