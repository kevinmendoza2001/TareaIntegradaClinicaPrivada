package util;

// Lo usamos para evitar edades fuera del alcance como negativas o mayores a 150
public class Validador {
    public static boolean validarEdad(int edad) {
        return edad > 0 && edad < 150;
    }

// El correo ingresado debe tener "@" y "." para ser considerado correcto
    public static boolean validarCorreo(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

// (\\d+) esto significa “uno o más dígitos”, asi procuramos que solo se usen datos numericos.
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("\\d+"); // solo números
    }

// Se usa para validar horas trabajadas, pacientes atendidos, valor consulta, etc.
    public static boolean validarMayorCero(double valor) {
        return valor > 0;
    }
}

