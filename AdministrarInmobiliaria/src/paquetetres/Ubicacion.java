package paquetetres;

public class Ubicacion {

    //Atributos Ubicacion
    private String numeroCasa;
    private String nombreBarrio;
    private String referenciaBarrio;

    // Constructor con parametros
    public Ubicacion(String numero, String nombre, String referencia) {
        numeroCasa = numero;
        nombreBarrio = nombre;
        referenciaBarrio = referencia;
    }

    //Metodos Establecer (SET)
    public void establecerNumeroCasa(String numero) {
        numeroCasa = numero;
    }

    public void establecerNombreBarrio(String barrio) {
        nombreBarrio = barrio;
    }

    public void establecerReferenciaBarrio(String referencia) {
        referenciaBarrio = referencia;
    }

    //Metodos Obtener(GET)
    public String obtenerNumeroCasa() {
        return numeroCasa;
    }

    public String obtenerNombreBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferenciaBarrio() {
        return referenciaBarrio;
    }
}
