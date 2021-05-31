package paquetecinco;

public class Constructora {

    //Atributos Constructora
    private String nombreConstructora;
    private String identificacionConstructora;

    //Constructor Con Parametros
    public Constructora(String nombre, String id) {
        nombreConstructora = nombre;
        identificacionConstructora = id;
    }

    //Metodos Establecer (SET)
    public void establecerNombreConstructora(String nombre) {
        nombreConstructora = nombre;
    }

    public void establecerIdentificacionConstructora(String ideconstr) {
        identificacionConstructora = ideconstr;
    }

    //Metodos Obtener (GET)
    public String obtenerNombreConstructora() {
        return nombreConstructora;
    }

    public String obtenerIdentificacionConstructora() {
        return identificacionConstructora;
    }
}
