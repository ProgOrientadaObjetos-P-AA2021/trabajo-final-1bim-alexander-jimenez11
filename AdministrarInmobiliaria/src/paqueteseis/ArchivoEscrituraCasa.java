package paqueteseis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscrituraCasa {

    private String nombreArchivo;
    private String rutaArchivo;
    private Casa registro;
    private Formatter salidaArchivo;

    // Constructor con Parametro
    public ArchivoEscrituraCasa(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // Sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
    }

    // Creo un objeto lectura de tipo ArchLecUbi
    public void establecerInformacionAnterior() {
        ArchivoLecturaCasa lectura = new ArchivoLecturaCasa(nombreArchivo);
        lectura.establecerLista();
        //Lista a la cual le pasamos la lista de casas
        ArrayList<Casa> lista = lectura.obtenerLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {// Condicional para saber si la lista trae valores
                if (lista.size() > 0) {// Si la lista es mayor a cero hara el ciclo repetitvo
                    // Este ciclo repetitivo se va ir hasta las lineas del archivo
                    // y luego llamo a establecerRegistro y le enviamos Casa
                    // en la posi
                    for (int i = 0; i < lista.size(); i++) {
                        Casa p1 = lista.get(i);
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

    // Recibe un argumento que es de tipo Casa y lo que recibe lo asigna a la 
    // variable registro y esta es de tipo Casa
    public void establecerRegistro(Casa n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Casa obtenerRegistro() {
        return registro;
    }

    // Este metodo no recibe ningun parámetro
    public void establecerSalida() {
        try {
            Casa c = obtenerRegistro();
            String cadenaRegistro = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;"
                    + "%s;%d;%.2f;%.2f;%.2f",c.ObtenerNombrePropietario(),
                    c.ObtenerApellidoPropietario(),
                    c.ObtenerIdentificacionPropietario(),
                    c.ObtenerNumeroCasa(),c.ObtenerBarrioPropietario(),
                    c.ObtenerReferenciaBarrio(),c.ObtenerCiudadPropietario(),
                    c.ObtenerProvinciaPropietario(),c.ObtenerNombreConstructora(),
                    c.ObtenerIdEmpresa(),c.ObtenerNumeroCuartos(),
                    c.ObtenerMetrosCuadrados(), c.ObtenerPrecioMetroCuadrado(),
                    c.ObtenerCostoFinal());
            salidaArchivo.format("%s\n", cadenaRegistro);
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
