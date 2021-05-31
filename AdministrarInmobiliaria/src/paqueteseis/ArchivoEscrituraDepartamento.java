package paqueteseis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscrituraDepartamento {

    private String nombreArchivo;
    private String rutaArchivo;
    private Departamento registro;
    private Formatter salidaArchivo;

    //Constructor con Parametro
    public ArchivoEscrituraDepartamento(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        // Sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
    }

    // Creo un objeto lectura de tipo ArchLecUbi
    public void establecerInformacionAnterior() {
        ArchivoLecturaDepartamento lectura = new ArchivoLecturaDepartamento(nombreArchivo);
        lectura.establecerLista();
        //Lista a la cual le pasamos la lista de departamento
        ArrayList<Departamento> lista = lectura.obtenerLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {//Condicional para saber si la lista trae valores
                if (lista.size() > 0) {//Si la nomina es mayor a cero hara el ciclo repetitvo
                    // Este ciclo repetitivo se va ir hasta las lineas del archivo
                    // y luego llamo a establecerRegistro y le enviamos Propietarios
                    // en la posi
                    for (int i = 0; i < lista.size(); i++) {
                        Departamento p1 = lista.get(i);
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
    // a la variable registro y esta es de tipo Departamento
    public void establecerRegistro(Departamento n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Departamento obtenerRegistro() {
        return registro;
    }

    // Este metodo no recibe ningun parámetro
    public void establecerSalida() {
        try {
            Departamento d = obtenerRegistro();
            String cadenaRegistro = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;"
                    + "%s;%s;%s;%.2f;%.2f;%.2f;%.2f",
                    d.ObtenerNombrePropietario(), d.ObtenerApellidoPropietario(),
                    d.ObtenerIdentificacionPropietario(), d.ObtenerNombreEdificio(),
                    d.ObtenerNumeroCasa(), d.ObtenerBarrioPropietario(),
                    d.ObtenerReferenciaBarrio(), d.ObtenerCiudadPropietario(),
                    d.ObtenerProvinciaPropietario(), d.ObtenerUbicacionDentroEdificio(),
                    d.ObtenerNombreConstructora(), d.ObtenerIdEmpresa(),
                    d.ObtenerValorAlicuotaMensual(), d.ObtenerMetrosCuadrados(),
                    d.ObtenerPrecioMetroCuadrado(), d.ObtenerCostoFinal());
            salidaArchivo.format("%s\n", cadenaRegistro);
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
