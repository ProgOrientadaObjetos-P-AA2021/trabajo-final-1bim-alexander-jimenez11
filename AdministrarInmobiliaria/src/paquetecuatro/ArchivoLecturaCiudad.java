package paquetecuatro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArchivoLecturaCiudad {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Ciudad> lista;

    // Creamos el constructor que recibe 1 parametro que es n y este le asigno 
    // a nombre archivo
    public ArchivoLecturaCiudad(String n) {
        nombreArchivo = n;
        //Creamos la ruta donde se va a guardar 
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // A traves de la clase File de Java nos hace referencia al archivo en
        // la variable rutaArchivo
        File f = new File(rutaArchivo);
        //Creamos el condicional para preguntar si el archivo existe
        if (f.exists()) {
            // Utilizamos un try para prever excepciones en el transcurso de la 
            // ejecución del programa.
            try {
                // La clase Scanner nos permite leer archivos de textos secuenciales
                // Me obtiene los datos del new File
                entrada = new Scanner(new File(rutaArchivo));
            } catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    // Establecer valores de cada línea en la lista de tipo Ubicacion este 
    // metodo carga al ArrayList de tipo Ubicacion todas las lineas que tiene
    // la lista
    public void establecerLista() {
        // Creamos el ArratList<>(); de lista que es de tipo Ubicacion
        lista = new ArrayList<>();
        // A traves de la clase File de Java nos hace referencia al archivo en
        // la variable rutaArchivo
        File f = new File(rutaArchivo);
        //Creamos el condicional para preguntar si el archivo existe
        if (f.exists()) {
            // Mientras exista una linea que leer
            while (entrada.hasNext()) {
                // Vamos a obtener todo lo que tiene la primera linea de texto
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                Ciudad p1 = new Ciudad(linea_partes.get(0),
                        linea_partes.get(1));
                // Utlizamos el metodo add para añadir al ArrayList nomina los 
                // datos del objeto p1 que es de tipo Ubicacion
                lista.add(p1);
            }
        }
    }

    public ArrayList<Ciudad> obtenerLista() {
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // ierra el archivo
    }

    @Override
    public String toString() {
        String cadena = "\nLISTA DE CIUDADES: \n";
        //Ciclo repetitvo epieza en cero hasta que los valores que tengamos 
        // en el ArrayList
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s(%d) %s-%s\n", cadena, i + 1,
                    obtenerLista().get(i).obtenerNombreCiudad(),
                    obtenerLista().get(i).obtenerNombreProvincia());
        }
        return cadena;
    }
}
