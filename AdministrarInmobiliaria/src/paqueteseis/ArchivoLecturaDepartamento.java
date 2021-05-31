package paqueteseis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArchivoLecturaDepartamento {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Departamento> lista;

    public ArchivoLecturaDepartamento(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s", obtenerNombreArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
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

    // Establecer valores de cada línea en la lista de tipo Departamento
    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);
        if (f.exists()) {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                Departamento d = new Departamento(linea_partes.get(0), linea_partes.get(1), linea_partes.get(2), linea_partes.get(3), linea_partes.get(4),
                        linea_partes.get(5), linea_partes.get(6), linea_partes.get(7), linea_partes.get(8), linea_partes.get(9), linea_partes.get(10),
                        linea_partes.get(11), Double.parseDouble(linea_partes.get(12).replace(",", ".")),
                        Double.parseDouble(linea_partes.get(13).replace(",", ".")), Double.parseDouble(linea_partes.get(14).replace(",", ".")),
                        Double.parseDouble(linea_partes.get(15).replace(",", ".")));
                lista.add(d);
            }
        }
    }

    public ArrayList<Departamento> obtenerLista() {
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // Cierra el archivo

    }

    @Override
    public String toString() {
        String cadena = "\nLISTA DE DEPARTAMENTOS: \n";
        // Ciclo repetitvo epieza en cero hasta que los valores que tengamos 
        // en el ArrayList
        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%s \n\t   REGISTRO Nº%d\n\t   ------------"
                    + "\nNombre                   : %s"
                    + "\nApellido                 : %s"
                    + "\nIdentificación           : %s"
                    + "\nNombre del edificio      : %s"
                    + "\nNúmero de casa           : %s"
                    + "\nNombre del barrio        : %s"
                    + "\nReferencia del barrio    : %s"
                    + "\nCiudad                   : %s"
                    + "\nProvincia                : %s"
                    + "\nUbicación dentro edificio: %s"
                    + "\nNombre de la onstructora : %s"
                    + "\nID de la empresa         : %s"
                    + "\nValor alícuota           : $ %.2f"
                    + "\nMetros cuadrados         : %.2f"
                    + "\nPrecio metro cuadrado    : $ %.2f"
                    + "\nCosto final              : $ %.2f\n",
                    cadena, (i + 1),
                    obtenerLista().get(i).ObtenerNombrePropietario(),
                    obtenerLista().get(i).ObtenerApellidoPropietario(),
                    obtenerLista().get(i).ObtenerIdentificacionPropietario(),
                    obtenerLista().get(i).ObtenerNombreEdificio(),
                    obtenerLista().get(i).ObtenerNumeroCasa(),
                    obtenerLista().get(i).ObtenerBarrioPropietario(),
                    obtenerLista().get(i).ObtenerReferenciaBarrio(),
                    obtenerLista().get(i).ObtenerCiudadPropietario(),
                    obtenerLista().get(i).ObtenerProvinciaPropietario(),
                    obtenerLista().get(i).ObtenerUbicacionDentroEdificio(),
                    obtenerLista().get(i).ObtenerNombreConstructora(),
                    obtenerLista().get(i).ObtenerIdEmpresa(),
                    obtenerLista().get(i).ObtenerValorAlicuotaMensual(),
                    obtenerLista().get(i).ObtenerMetrosCuadrados(),
                    obtenerLista().get(i).ObtenerPrecioMetroCuadrado(),
                    obtenerLista().get(i).ObtenerCostoFinal());
        }
        return cadena;
    }
}
