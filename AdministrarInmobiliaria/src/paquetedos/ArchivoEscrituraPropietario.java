package paquetedos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscrituraPropietario {

    //Atributos de ArchivoEscritura
    private String nombreArchivo;
    private String rutaArchivo;
    private Propietario registro;
    private Formatter salidaArchivo;

    //Constructor con Parametro
    public ArchivoEscrituraPropietario(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // Sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
    }

    // Creo un objeto lectura de tipo ArchLecProp
    public void establecerInformacionAnterior() {
        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nombreArchivo);
        lectura.establecerLista();
        //Lista a la cual le pasamos la lista de propietarios
        ArrayList<Propietario> lista = lectura.obtenerLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {//Condicional para saber si la lista trae valores
                if (lista.size() > 0) {//Si la lista es mayor a cero hara el ciclo repetitvo
                    // este ciclo repetitivo se va ir hasta las lineas del archivo
                    // y luego llamo a establecerRegistro y le enviamos Propietarios
                    // en la posi
                    for (int i = 0; i < lista.size(); i++) {
                        Propietario p1 = lista.get(i);
                        establecerRegistro(p1);
                        establecerSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);
        }
    }

    public void establecerNombreArchivo(String nomb_Arch) {
        nombreArchivo = nomb_Arch;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());
    }
    // Recibe un argumento que es de tipo Propietario y lo que recibe lo asigna 
    // a la variable registro y esta es de tipo Propietario

    public void establecerRegistro(Propietario n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Propietario obtenerRegistro() {
        return registro;
    }

    // Este metodo no recibe ningun parámetro
    public void establecerSalida() {
        // Utilizamos un try para prever excepciones en el transcurso de la 
        // ejecución del programa.
        try {
            // Creamos una variable p de tipo de dato Propietario que es igual 
            // al metodo obtenerRegistro que este me devuelve registro que a su
            // vez es un tipo de dato Propietario. 
            // Es decir ahora el registro estará en la variable p
            Propietario p = obtenerRegistro();
            // Creamos una variable cadenaRegsitro que es de tipo String, luego
            // creamos una cadena que es igual a String.format que le estoy 
            // generando %s separados por un ;
            String cadenaRegistro = String.format("%s;%s;%s",
                    p.obtenerNombrePropietario(), p.obtenerApellidoPropietario(),
                    p.obtenerIdentificacionPropietario());
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
        } // cierra el archivo
    }
}
