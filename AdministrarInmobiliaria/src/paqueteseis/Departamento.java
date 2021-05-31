package paqueteseis;

import java.util.ArrayList;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

public class Departamento {

    //Atributos Departamento
    private String nombrePropietario;
    private String apellidoPropietario;
    private String identificacionPropietario;
    private String nombreEdificio;
    private String numeroCasa;
    private String barrioPropietario;
    private String referenciaBarrio;
    private String ciudadPropietario;
    private String provinciaPropietario;
    private String ubicacionDentroEdificio;
    private String nombreConstructora;
    private String idEmpresa;
    private double valorAlicuotaMensual;
    private double metrosCuadrados;
    private double precioMetroCuadrado;
    private double costoFinal;

    //Constructor con parametos
    public Departamento(String nombProp, String apellidoPropie, String idPropie,
            String nombEdificio, String nro, String barrioP, String referenciaB, String ciudPro, String provPro,
            String ubiDentroEdif, String nombConstr, String idE, double valCuota, double mCuadr,
            double precMetr, double cf) {
        nombrePropietario = nombProp;
        apellidoPropietario = apellidoPropie;
        identificacionPropietario = idPropie;
        nombreEdificio = nombEdificio;
        numeroCasa = nro;
        barrioPropietario = barrioP;
        referenciaBarrio = referenciaB;
        ciudadPropietario = ciudPro;
        provinciaPropietario = provPro;
        ubicacionDentroEdificio = ubiDentroEdif;
        nombreConstructora = nombConstr;
        idEmpresa = idE;
        valorAlicuotaMensual = valCuota;
        metrosCuadrados = mCuadr;
        precioMetroCuadrado = precMetr;
        costoFinal = cf;
    }

    //Metodos Establecer (SET)
    public void EstablecerNombrePropietario(String nombre) {
        nombrePropietario = nombre;
    }

    public void EstablecerApellidoPropietario(String apellido) {
        apellidoPropietario = apellido;
    }

    public void EstablecerIdentificacionPropietario(String identificacion) {
        identificacionPropietario = identificacion;
    }

    public void EstablecerNumeroCasa(String numero) {
        numeroCasa = numero;
    }

    public void EstablecerNombreEdificio(String nombreF) {
        nombreEdificio = nombreF;
    }

    public void EstablecerBarrioPropietario(String barrio) {
        barrioPropietario = barrio;
    }

    public void EstablecerReferenciaBarrio(String referencia) {
        referenciaBarrio = referencia;
    }

    public void EstablecerCiudadPropietario(String ciudad) {
        ciudadPropietario = ciudad;
    }

    public void EstablecerProvinciaPropietario(String provincia) {
        provinciaPropietario = provincia;
    }

    public void EstablecerUbicacionDentroEdificio(String ubicacion) {
        ubicacionDentroEdificio = ubicacion;
    }

    public void EstablecerNombreConstructora(String constructora) {
        nombreConstructora = constructora;
    }

    public void EstablecerIdEmpresa(String id) {
        idEmpresa = id;
    }

    public void EstablecerValorAlicuotaMensual(double alicuota) {
        valorAlicuotaMensual = alicuota;
    }

    public void EstablecerMetrosCuadrados(double metros) {
        metrosCuadrados = metros;
    }

    public void EstablecerPrecioMetroCuadrado(double n) {
        precioMetroCuadrado = n;
    }

    // Metodo CalcularCostoFinal
    public void CalcularCostoFinal() {
        costoFinal = (metrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12);
    }

    // Metodos Obtener (GET)
    public String ObtenerNombrePropietario() {
        return nombrePropietario;
    }

    public String ObtenerApellidoPropietario() {
        return apellidoPropietario;
    }

    public String ObtenerIdentificacionPropietario() {
        return identificacionPropietario;
    }

    public String ObtenerNumeroCasa() {
        return numeroCasa;
    }

    public String ObtenerNombreEdificio() {
        return nombreEdificio;
    }

    public String ObtenerBarrioPropietario() {
        return barrioPropietario;
    }

    public String ObtenerReferenciaBarrio() {
        return referenciaBarrio;
    }

    public String ObtenerCiudadPropietario() {
        return ciudadPropietario;
    }

    public String ObtenerProvinciaPropietario() {
        return provinciaPropietario;
    }

    public String ObtenerUbicacionDentroEdificio() {
        return ubicacionDentroEdificio;
    }

    public String ObtenerNombreConstructora() {
        return nombreConstructora;
    }

    public String ObtenerIdEmpresa() {
        return idEmpresa;
    }

    public double ObtenerValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public double ObtenerMetrosCuadrados() {
        return metrosCuadrados;
    }

    public double ObtenerPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double ObtenerCostoFinal() {
        return costoFinal;
    }

    // Metodos de busqueda
    // Buscar Propietario recibe como parametro la lista y la identificacion a buscar
    public static Propietario BuscarPropietario(ArrayList<Propietario> ListaPro, String id) {
        try {
            int pos = -1;// Variable para obtener la posicion del propietario encontrado
            for (int i = 0; i < ListaPro.size(); i++) {
                // Si la identificacion es igual a una de las identificaciones de la lista entonces 
                if (id.equals(ListaPro.get(i).obtenerIdentificacionPropietario())) {
                    pos = i;// A pos le asignamos esa posicion
                }
            }
            // Creamos un objeto de propietario llamado pro, al cual le asignaremos
            // sus respectivos atributos pero en la posicion que se está el 
            // propietario que se encontró 
            Propietario pro = new Propietario(ListaPro.get(pos).obtenerNombrePropietario(), ListaPro.get(pos).obtenerApellidoPropietario(), ListaPro.get(pos).obtenerIdentificacionPropietario());
            // Se retorna el propietario
            return pro;
        } catch (Exception ex) {
        }
        // Se retorna nul
        return null;
    }

    // Metodo para buscar Ubicacion con el atributo de busqueda numero de casa
    public static Ubicacion BuscarUbicacion(ArrayList<Ubicacion> ListaUbi, String nro) {
        try {
            int pos = -1;
            for (int i = 0; i < ListaUbi.size(); i++) {
                if (nro.equals(ListaUbi.get(i).obtenerNumeroCasa())) {
                    pos = i;
                }
            }
            Ubicacion ubi = new Ubicacion(ListaUbi.get(pos).obtenerNumeroCasa(), ListaUbi.get(pos).obtenerNombreBarrio(), ListaUbi.get(pos).obtenerReferenciaBarrio());
            return ubi;
        } catch (Exception ex) {
        }
        return null;
    }

    // Metodo para buscar Ciudad con el atributo de busqueda de nombre de la ciudad
    public static Ciudad BuscarCiudad(ArrayList<Ciudad> ListaCiud, String nombciud) {
        try {
            int pos = -1;
            for (int i = 0; i < ListaCiud.size(); i++) {
                if (nombciud.equals(ListaCiud.get(i).obtenerNombreCiudad())) {
                    pos = i;
                }
            }
            Ciudad ciud = new Ciudad(ListaCiud.get(pos).obtenerNombreCiudad(), ListaCiud.get(pos).obtenerNombreProvincia());
            return ciud;
        } catch (Exception ex) {
        }
        return null;
    }

    // Metodo para buscar Constructora con el atributo de busqueda de Id de la empresa
    public static Constructora BuscarConstructora(ArrayList<Constructora> ListaCons, String id) {
        try {
            int pos = -1;
            for (int i = 0; i < ListaCons.size(); i++) {
                if (id.equals(ListaCons.get(i).obtenerIdentificacionConstructora())) {
                    pos = i;
                }
            }
            Constructora cons = new Constructora(ListaCons.get(pos).obtenerNombreConstructora(), ListaCons.get(pos).obtenerIdentificacionConstructora());
            return cons;
        } catch (Exception ex) {
        }
        return null;
    }
}
