package paquetecuatro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscrituraCiudad {

    private String nombreArchivo;
    private String rutaArchivo;
    private Ciudad registro;
    private Formatter salidaArchivo;

    //Constructor con Parametro
    public ArchivoEscrituraCiudad(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // Sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
    }

    // Creo un objeto lectura de tipo ArchLecProp
    public void establecerInformacionAnterior() {
        ArchivoLecturaCiudad lectura = new ArchivoLecturaCiudad(nombreArchivo);
        lectura.establecerLista();
        //Lista a la cual le pasamos la lista de propietarios
        ArrayList<Ciudad> lista = lectura.obtenerLista();
        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {//Condicional para saber si la lista trae valores
                if (lista.size() > 0) {//Si la LISTA es mayor a cero hara el ciclo repetitvo
                    // Este ciclo repetitivo se va ir hasta las lineas del archivo
                    // y luego llamo a establecerRegistro y le enviamos Ubicaciones
                    // en la posi
                    for (int i = 0; i < lista.size(); i++) {
                        Ciudad p1 = lista.get(i);
                        establecerRegistro(p1);
                        establecerSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    // Recibe un argumento que es de tipo Propietario y lo que recibe lo asigna 
    // a la variable registro y esta es de tipo Ubicacion
    public void establecerRegistro(Ciudad n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Ciudad obtenerRegistro() {
        return registro;
    }

    // Este metodo no recibe ningun parámetro
    public void establecerSalida() {
        // Utilizamos un try para prever excepciones en el transcurso de la 
        // ejecución del programa.
        try {
            // Creamos una variable p de tipo de dato Ubicacion que es igual 
            // al metodo obtenerRegistro que este me devuelve registro que a su
            // vez es un tipo de dato Ubicacion. 
            // Es decir ahora el registro estará en la variable p
            Ciudad p = obtenerRegistro();
            // Creamos una variable cadenaRegsitro que es de tipo String, luego
            // creamos una cadena que es igual a String.format que le estoy 
            // generando %s separados por un ;
            String cadenaRegistro = String.format("%s;%s",
                    p.obtenerNombreCiudad(), p.obtenerNombreProvincia());
            // SalidaArchivo me va a permitir escribir en el archivo
            // nos guarda una cadena y le envio cadenaRegistro que es donde
            // pasamos la info de la varible p
            salidaArchivo.format("%s\n", cadenaRegistro);
            //Especifica la excepción que puede ocurrir
        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);
        }
    }

    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } // Cierra el archivo
    }
}
