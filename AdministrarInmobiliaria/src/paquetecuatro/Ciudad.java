package paquetecuatro;

public class Ciudad 
{
    private String nombreCiudad;
    private String nombreProvincia;
    
    //Constructor con parametros
    public Ciudad(String nombre, String provincia) {
        nombreCiudad = nombre;
        nombreProvincia = provincia;
    }
    
    //Metodos Establecer (SET)
    public void establecerNombreCiudad(String n) {
        nombreCiudad = n;
    }

    public void establecerNombreProvincia(String n) {
        nombreProvincia = n;
    }
    
    //Metodos Obtener (GET)
    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
}
