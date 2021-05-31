package paquetedos;

public class Propietario {

    //Atributos Propietario
    private String nombrePropietario;
    private String apellidoPropietario;
    private String identificacionPropietario;

    //Cosntructor con parametros
    public Propietario(String nombre, String apellido, String identificacion) {
        nombrePropietario = nombre;
        apellidoPropietario = apellido;
        identificacionPropietario = identificacion;
    }

    //Metodos Establecer (SET)
    public void establecerNombrePropietario(String nombre) {
        nombrePropietario = nombre;
    }

    public void establecerApellidoPropietario(String apellido) {
        apellidoPropietario = apellido;
    }

    public void establecerIdentificacionPropietario(String identificacion) {
        identificacionPropietario = identificacion;
    }

    //Metodos Obtener (GET)
    public String obtenerNombrePropietario() {
        return nombrePropietario;
    }

    public String obtenerApellidoPropietario() {
        return apellidoPropietario;
    }

    public String obtenerIdentificacionPropietario() {
        return identificacionPropietario;
    }
}
