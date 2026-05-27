Sistema de Gestión de Personal – Clínica Privada

* Herencia
Medico y Administrativo heredan de Empleado. Así se comparten atributos comunes y cada uno agrega lo suyo.

* Encapsulamiento
Los atributos son privados y se accede con getters/setters. Esto protege la información.

* Polimorfismo
Se usa un ArrayList<Empleado> para guardar todo tipo de empleados. Cada uno calcula su pago de forma distinta.

* Excepciones
Se usan try-catch para evitar que el programa se caiga si el usuario ingresa datos inválidos, un claro ejemplo de ello son numeros en lugar de letras o al reves

* Conversiones
Se aplican Integer.parseInt() y Double.parseDouble() para transformar texto en números.

* Validaciones: Se revisa que: Edad esté en rango correcto.
* Correo tenga @ y el Teléfono solo números.
* Valores (horas, pacientes, etc.) sean mayores a cero.
* No haya cédulas duplicadas ni campos vacíos.
