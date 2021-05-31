package paquetedos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArchivoLecturaPropietario {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Propietario> lista;

    // Creamos el constructor que recibe 1 parametro que es n y este le asigno 
    // a nombre archivo
    public ArchivoLecturaPropietario(String n) {
        nombreArchivo = n;
        //creamos la ruta donde se va a guardar 
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // A traves de la clase File de Java nos hace referencia al archivo en
        // la variable rutaArchivo
        File f = new File(rutaArchivo);
        //creamos el condicional para preguntar si el archivo existe
        if (f.exists()) {
            // Utilizamos un try para prever excepciones en el transcurso de la 
            // ejecución del programa.
            try {
                // La clase Scanner nos permite leer archivos de textos secuenciales
                // Me obtiene los datos del new File
                entrada = new Scanner(new File(rutaArchivo));
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);
            } // fin de catch
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

    // Establecer valores de cada línea
    // en nomina de tipo Propietario
    // este metodo carga al ArrayList de tipo Propietario todas las lineas que 
    // tiene la lista
    public void establecerLista() {
        // Creamos el ArratList<>(); de la lista que es de tipo Propietario
        lista = new ArrayList<>();
        // a traves de la clase File de Java nos hace referencia al archivo en
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
                Propietario p1 = new Propietario(linea_partes.get(0),
                        linea_partes.get(1), linea_partes.get(2));
                // Utlizamos el metodo add para añadir al ArrayList nomina los 
                // datos del objeto p1 que es de tipo Propietario
                lista.add(p1);
            }
        }
    }

    public ArrayList<Propietario> obtenerLista() {
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo
    }

    @Override
    public String toString() {
        String cadena = "\nLISTA DE PROPIETARIOS: \n";
        //ciclo repetitvo epieza en cero hasta que los valores que tengamos 
        // en el ArrayList
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s(%d) %s-%s-%s\n", cadena, i + 1,
                    obtenerLista().get(i).obtenerNombrePropietario(),
                    obtenerLista().get(i).obtenerApellidoPropietario(),
                    obtenerLista().get(i).obtenerIdentificacionPropietario());
        }
        return cadena;

    }
}
