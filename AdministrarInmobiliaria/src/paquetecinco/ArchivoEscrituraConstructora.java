package paquetecinco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscrituraConstructora {

    private String nombreArchivo;
    private String rutaArchivo;
    private Constructora registro;
    private Formatter salidaArchivo;

    // Constructor con Parametro
    public ArchivoEscrituraConstructora(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // Sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
    }

    // Creo un objeto lectura de tipo ArchLecCons
    public void establecerInformacionAnterior() {
        ArchivoLecturaConstructora lectura = new ArchivoLecturaConstructora(nombreArchivo);
        lectura.establecerLista();
        //Lista a la cual le pasamos la lista de constructoras
        ArrayList<Constructora> lista = lectura.obtenerLista();
        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {// Condicional para saber si la lista trae valores
                if (lista.size() > 0) {// Si la nomina es mayor a cero hara el ciclo repetitvo
                    // Este ciclo repetitivo se va ir hasta las lineas del archivo
                    // y luego llamo a establecerRegistro y le enviamos Constructores
                    // en la posi
                    for (int i = 0; i < lista.size(); i++) {
                        Constructora p1 = lista.get(i);
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

    // Recibe un argumento que es de tipo Constructora y lo que recibe lo asigna 
    // a la variable registro y esta es de tipo COnstructora
    public void establecerRegistro(Constructora n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Constructora obtenerRegistro() {
        return registro;
    }

    // Este metodo no recibe ningun parámetro
    public void establecerSalida() {
        // Utilizamos un try para prever excepciones en el transcurso de la 
        // ejecución del programa.
        try {
            // Creamos una variable p de tipo de dato Constructora que es igual 
            // al metodo obtenerRegistro que este me devuelve registro que a su
            // vez es un tipo de dato Constructora. 
            // Es decir ahora el registro estará en la variable p
            Constructora p = obtenerRegistro();
            // Creamos una variable cadenaRegsitro que es de tipo String, luego
            // creamos una cadena que es igual a String.format que le estoy 
            // generando %s separados por un ;
            String cadenaRegistro = String.format("%s;%s",
                    p.obtenerNombreConstructora(), p.obtenerIdentificacionConstructora());
            // SalidaArchivo me va a permitir escribir en el archivo
            // nos guarda una cadena y le envio cadenaRegistro que es donde
            // pasamos la info de la varible p
            salidaArchivo.format("%s\n", cadenaRegistro);
            // Especifica la excepción que puede ocurrir
        } catch (Exception e) {
            System.err.println("ERROR AL CREAR ARCHIVO.");
            System.err.println(e);

        }
    }

    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } // Cierra el archivo
    }
}
