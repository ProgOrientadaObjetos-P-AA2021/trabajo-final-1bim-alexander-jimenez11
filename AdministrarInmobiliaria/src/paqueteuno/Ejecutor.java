package paqueteuno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import paquetedos.Propietario;
import paquetedos.ArchivoEscrituraPropietario;
import paquetedos.ArchivoLecturaPropietario;
import paquetetres.Ubicacion;
import paquetetres.ArchivoEscrituraUbicacion;
import paquetetres.ArchivoLecturaUbicacion;
import paquetecuatro.Ciudad;
import paquetecuatro.ArchivoEscrituraCiudad;
import paquetecuatro.ArchivoLecturaCiudad;
import paquetecinco.Constructora;
import paquetecinco.ArchivoEscrituraConstructora;
import paquetecinco.ArchivoLecturaConstructora;
import paqueteseis.Casa;
import paqueteseis.ArchivoEscrituraCasa;
import paqueteseis.ArchivoLecturaCasa;
import paqueteseis.Departamento;
import paqueteseis.ArchivoEscrituraDepartamento;
import paqueteseis.ArchivoLecturaDepartamento;

public class Ejecutor {

    public static void main(String[] args) {
        //Creamos los nombres de los archivos con los que se guardar previamente
        String nombreArchivo = ("propietarios.txt");
        String nombreArchivo2 = ("ubicaciones.txt");
        String nombreArchivo3 = ("ciudades.txt");
        String nombreArchivo4 = ("constructoras.txt");
        String nombreArchivo5 = ("casas.txt");
        String nombreArchivo6 = ("departamentos.txt");
        // Permite ingresar datos por teclado
        Scanner entrada = new Scanner(System.in);
        int opcion = 8;
        System.out.println("\t<< SISTEMA DE GESTIÓN DE INMOBILIARIA >>");
        System.out.println("\t========================================");
        while (opcion != 7) {//Ciclo while que permitira repetir el menu mientras la opcion seleccionada sea distinta de 0
            //Lista  de cada una de las clases a leer (propietario, ubicacion, ciudad y constructora)
            ArrayList<Propietario> ListaPro;
            ArrayList<Ubicacion> ListaUbi;
            ArrayList<Ciudad> ListaCiud;
            ArrayList<Constructora> ListaCons;
            System.out.println("\n***  MENÚ INMOBILIARIA  ***");
            System.out.println("PROPIETARIOS            (1)");
            System.out.println("UBICACIONES             (2)");
            System.out.println("CIUDADES                (3)");
            System.out.println("CONSTRUCTORAS           (4)");
            System.out.println("CASAS                   (5)");
            System.out.println("DEPARTAMENTOS           (6)");
            System.out.println("SALIR                   (7)");
            System.out.print("\nSELECCIONE UNA OPCIÓN: ");
            opcion = entrada.nextInt();
            // Utilizamos la estructura swith para trabajar con un menu de seleccion
            // multiple
            switch (opcion) {
                case 1: //Cuando la opcion es 1 permitirá registrar Propietarios
                    System.out.println("\n\tREGISTRO DE PROPIETARIOS");
                    System.out.println("\t------------------------");
                    System.out.print("INGRESE LA CANTIDAD DE PROPIETARIOS: ");
                    int lim = entrada.nextInt();
                    while (lim <= 0) {
                        System.out.print("INGRESE LA CANTIDAD DE PROPIETARIOS: ");
                        lim = entrada.nextInt();
                    }
                    entrada.nextLine();
                    for (int i = 0; i < lim; i++) {
                        System.out.println("\n\tREGISTRO Nº" + (i + 1));
                        // Se piden los datos del propietario
                        System.out.print("NOMBRE DEL PROPIETARIO: ");
                        String nombreP = entrada.nextLine();
                        System.out.print("APELLIDO DEL PROPIETARIO: ");
                        String apellidoP = entrada.nextLine();
                        System.out.print("IDENTIFICACIÓN DEL PROPIETARIO: ");
                        String idP = entrada.nextLine();
                        // Con los datos ingresados ​​se crea el objeto de tipo Propietario
                        Propietario pro = new Propietario(nombreP, apellidoP, idP);
                        //Creamos el objeto escritura que es de tipo ArchivoEscrituraPropietario
                        // y le envio el nombre del archivo
                        ArchivoEscrituraPropietario escritura = new ArchivoEscrituraPropietario(nombreArchivo);
                        // A traves de mi objeto escritura llamo al metodo establecerRegistro
                        // y le envio un tipo de dato que es Proietario
                        escritura.establecerRegistro(pro);
                        // A traves del objeto escritura llamo al metodo establecerSalida
                        // que no recibe ningún parámetro pero que guarda una cadena 
                        // para ponerlo en el archivo
                        escritura.establecerSalida();
                        // A traves del objeto escritura llamo al cerrarArchivo
                        // es importante cerrar cuando se abre un archivo ya que
                        // puede ocasionar problema en la maquina por la cantidad
                        // de recursos que puedan quedar abiertos
                        escritura.cerrarArchivo();
                    }
                    // Creamos el objeto lec que es de tipo ArchivoLecturaProp y le envio 1
                    // parametro que es nombreArchivo
                    // a traves del objeto lec llamo al metodo establecerLista 
                    // que no recibe ningún parámetro pero que carga el ArrayList
                    // de tipo Propietario
                    ArchivoLecturaPropietario lec = new ArchivoLecturaPropietario(nombreArchivo);
                    lec.establecerLista();
                    System.out.println(lec); // Llamamos al metdo ToString
                    lec.cerrarArchivo(); // Cerramos  el archivo
                    break;
                case 2://Cuando la opcion es 2 permitirá registrar Ubicaciones
                    System.out.println("\n\tREGISTRO DE UBICACIONES");
                    System.out.println("\t-----------------------");
                    System.out.print("INGRESE LA CANTIDAD DE UBICACIONES: ");
                    int cant = entrada.nextInt();
                    while (cant <= 0) {
                        System.out.print("INGRESE LA CANTIDAD DE UBICACIONES: ");
                        cant = entrada.nextInt();
                    }
                    entrada.nextLine();
                    for (int i = 0; i < cant; i++) {
                        System.out.println("\n\tREGISTRO Nº" + (i + 1));
                        // Se piden los datos de la ubicacion
                        System.out.print("INGRESE NÚMERO DE CASA: ");
                        String nro = entrada.nextLine();
                        System.out.print("NOMBRE DEL BARRIO: ");
                        String barrio = entrada.nextLine();
                        System.out.print("REFERENCIA DEL BARRIO: ");
                        String referencia = entrada.nextLine();
                        // Con los datos ingresados ​​se crea el objeto de tipo Ubicacion
                        Ubicacion ubi = new Ubicacion(nro, barrio, referencia);
                        //Creamos el objeto escritura que es de tipo ArchivoEscrituraUbicacion
                        // y le envio el nombre del archivo
                        ArchivoEscrituraUbicacion escritura2 = new ArchivoEscrituraUbicacion(nombreArchivo2);
                        // A traves de mi objeto escritura llamo al metodo establecerRegistro
                        // y le envio un tipo de dato que es Ubicacion
                        escritura2.establecerRegistro(ubi);
                        // A traves del objeto escritura llamo al metodo establecerSalida
                        // que no recibe ningún parámetro pero que guarda una cadena 
                        // para ponerlo en el archivo
                        escritura2.establecerSalida();
                        // A traves del objeto escritura llamo al cerrarArchivo
                        // es importante cerrar cuando se abre un archivo ya que
                        // puede ocasionar problema en la maquina por la cantidad
                        // de recursos que puedan quedar abiertos
                        escritura2.cerrarArchivo();
                    }
                    // Creamos el objeto lec que es de tipo ArchivoLecturaUbi 
                    // y le envio un parametro que es nombreArchivo
                    // a traves del objeto lec llamo al metodo establecerLista 
                    // que no recibe ningún parámetro pero que carga el ArrayList
                    // de tipo Ubicacion
                    ArchivoLecturaUbicacion lec2 = new ArchivoLecturaUbicacion(nombreArchivo2);
                    lec2.establecerLista();
                    System.out.println(lec2); // Llamamos al metodo ToString
                    lec2.cerrarArchivo();// Cerramos  el archivo
                    break;
                case 3://Cuando la opcion es 3 permitirá registrar Ciudades
                    System.out.println("\n\tREGISTRO DE CIUDADES");
                    System.out.println("\t--------------------");
                    System.out.print("INGRESE LA CANTIDAD DE CIUDADES: ");
                    int lim2 = entrada.nextInt();
                    while (lim2 <= 0) {
                        System.out.print("INGRESE LA CANTIDAD DE CIUDADES: ");
                        lim2 = entrada.nextInt();
                    }
                    entrada.nextLine();
                    for (int i = 0; i < lim2; i++) {
                        System.out.println("\n\tREGISTRO Nº" + (i + 1));
                        //Se piden los datos de la ciudad
                        System.out.print("NOMBRE DE LA CIUDAD: ");
                        String nombreCiudad = entrada.nextLine();
                        System.out.print("NOMBRE DE LA PROVINCIA: ");
                        String nombreProvincia = entrada.nextLine();
                        // Con los datos ingresados ​​se crea el objeto de tipo Ciudad
                        Ciudad c = new Ciudad(nombreCiudad, nombreProvincia);
                        //Creamos el objeto escritura que es de tipo ArchivoEscrituraCiudad
                        // y le envio el nombre del archivo2
                        ArchivoEscrituraCiudad escritura3 = new ArchivoEscrituraCiudad(nombreArchivo3);
                        // A traves de mi objeto escritura2 llamo al metodo establecerLista
                        // y le envio un tipo de dato que es Ciudad
                        escritura3.establecerRegistro(c);
                        // A traves del objeto escritura llamo al metodo establecerSalida
                        // que no recibe ningún parámetro pero que guarda una cadena 
                        // para ponerlo en el archivo
                        escritura3.establecerSalida();
                        escritura3.cerrarArchivo();
                    }
                    ArchivoLecturaCiudad lec3 = new ArchivoLecturaCiudad(nombreArchivo3);
                    lec3.establecerLista();
                    System.out.println(lec3);// Llamamos al metodo ToString
                    lec3.cerrarArchivo();// Cerramos  el archivo
                    break;
                case 4://Cuando la opcion es 4 permitirá registrar Constructoras
                    System.out.println("\n\tREGISTRO DE CONSTRUCTORAS");
                    System.out.println("\t-------------------------");
                    System.out.print("INGRESE LA CANTIDAD DE CONSTRUCTORAS: ");
                    int lim3 = entrada.nextInt();
                    while (lim3 <= 0) {
                        System.out.print("INGRESE LA CANTIDAD DE CONSTRUCTORAS: ");
                        lim3 = entrada.nextInt();
                    }
                    entrada.nextLine();
                    for (int i = 0; i < lim3; i++) {
                        System.out.println("\n\tREGISTRO Nº" + (i + 1));
                        // Se piden los datos de la constructora
                        System.out.print("NOMBRE DE LA CONSTRUCTORA: ");
                        String nomC = entrada.nextLine();
                        System.out.print("IDENTIFICACIÓN DE LA EMPRESA: ");
                        String idenC = entrada.nextLine();
                        // Con los datos ingresados ​​se crea el objeto de tipo Constructora
                        Constructora ct = new Constructora(nomC, idenC);
                        //Creamos el objeto escritura que es de tipo ArchivoEscrituraConstructora
                        // y le envio el nombre del archivo3
                        ArchivoEscrituraConstructora escritura4 = new ArchivoEscrituraConstructora(nombreArchivo4);
                        // A traves de mi objeto escritura3 llamo al metodo establecerRegistro
                        // y le envio un tipo de dato que es Constructora
                        escritura4.establecerRegistro(ct);
                        // A traves del objeto escritura llamo al metodo establecerSalida
                        // que no recibe ningún parámetro pero que guarda una cadena 
                        // para ponerlo en el archivo
                        escritura4.establecerSalida();
                        escritura4.cerrarArchivo();
                    }
                    ArchivoLecturaConstructora lec4 = new ArchivoLecturaConstructora(nombreArchivo4);
                    lec4.establecerLista();
                    System.out.println(lec4);// Llamamos al metodo ToString
                    lec4.cerrarArchivo();// Cerramos  el archivo
                    break;
                case 5:// Cuando la opcion es 5 permitirá buscar y agregar datos de la casa
                    //Variables para cada atributo de propietario, ciudad, ubicacion, constructora
                    ArchivoLecturaPropietario lect1 = new ArchivoLecturaPropietario(nombreArchivo);
                    ArchivoLecturaUbicacion lect2 = new ArchivoLecturaUbicacion(nombreArchivo2);
                    ArchivoLecturaCiudad lect3 = new ArchivoLecturaCiudad(nombreArchivo3);
                    ArchivoLecturaConstructora lect4 = new ArchivoLecturaConstructora(nombreArchivo4);
                    String nombpropcasa = " ",
                     apepropcasa = "",
                     ciudP = " ",
                     provP = "",
                     nrocasap = "",
                     barrioP = " ",
                     referenciaB = "",
                     nombCtr = " ";
                    double cf_casa = 0; // Variable para almacenar el costofinal de la casa
                    // Se realiza la lectura de los archivos
                    lect1.establecerLista();
                    lect1.cerrarArchivo();
                    lect2.establecerLista();
                    lect2.cerrarArchivo();
                    lect3.establecerLista();
                    lect3.cerrarArchivo();
                    lect4.establecerLista();
                    lect4.cerrarArchivo();
                    //A cada lista se le asigna la lista de registros correspondientes
                    ListaPro = lect1.obtenerLista();
                    ListaUbi = lect2.obtenerLista();
                    ListaCiud = lect3.obtenerLista();
                    ListaCons = lect4.obtenerLista();
                    //Si los archivos propietario, ubicacion, ciudad y constructora al menos tienen un registro
                    //permitirá registrar una casa
                    if (ListaPro.size() > 0 && ListaUbi.size() > 0 && ListaCiud.size() > 0 && ListaCons.size() > 0) {
                        System.out.println("\n\tREGISTRO DE CASAS");
                        System.out.println("\t-----------------");
                        System.out.print("INGRESE LA CANTIDAD DE CASAS: ");
                        int lim4 = entrada.nextInt();
                        while (lim4 <= 0) {
                            System.out.print("INGRESE LA CANTIDAD DE CASAS: ");
                            lim4 = entrada.nextInt();
                        }
                        for (int i = 0; i < lim4; i++) {
                            entrada.nextLine();
                            System.out.println("\n\tREGISTRO Nº" + (i + 1));
                            //Se realiza la busqueda de un propietario
                            System.out.print("IDENTIFICACIÓN DEL PROPIETARIO A BUSCAR: ");
                            String identpropbusc = entrada.nextLine();
                            //Creamos una variable del objeto propietario a la 
                            //cual le asignamos el metodo de busqueda con sus 
                            // parametros correspondientes
                            Propietario prop = Casa.BuscarPropietario(ListaPro, identpropbusc);
                            // Si la prop es distinto de null, significa que se ha encontrado un propietario
                            while (prop == null) {
                                // A la variable _nombprop le asignamos el nombre del propietario encontrado, lo asignamos
                                // a travez del objeto creado anteriormente
                                System.out.println("PROPIETARIO CON IDENTIFICACIÓN " + identpropbusc + ", NO REGISTRADO!!");
                                System.out.print("IDENTIFICACIÓN DEL PROPIETARIO A BUSCAR: ");
                                identpropbusc = entrada.nextLine();
                                prop = Casa.BuscarPropietario(ListaPro, identpropbusc);
                            }
                            nombpropcasa = prop.obtenerNombrePropietario();
                            apepropcasa = prop.obtenerApellidoPropietario();
                            //Se realiza la busqueda de una ubicacion a traves del nro de casa
                            System.out.print("NÚMERO DE CASA A BUSCAR: ");
                            String numcasa = entrada.nextLine();
                            // Creamos un objeto de Ubicacion al cual le asignamos 
                            // el metodo buscarubicacion, con sus parametros
                            Ubicacion ubi = Casa.BuscarUbicacion(ListaUbi, numcasa);
                            // Si el objeto es distinto de null, significa que se ha encontrado una ubicacion
                            while (ubi == null) {
                                System.out.println("CASA CON EL NÚMERO " + numcasa + ", NO REGISTRADO!!");
                                System.out.print("NÚMERO DE CASA A BUSCAR: ");
                                numcasa = entrada.nextLine();
                                ubi = Casa.BuscarUbicacion(ListaUbi, numcasa);
                            }
                            nrocasap = ubi.obtenerNumeroCasa();
                            barrioP = ubi.obtenerNombreBarrio();
                            referenciaB = ubi.obtenerReferenciaBarrio();
                            //Obtener por busqueda de nombre ciudad
                            System.out.print("CIUDAD DE RESIDENCIA DEL PROPIETARIO: ");
                            String ciudadbusc = entrada.nextLine();
                            // Se crea un objeto de ciudad al cual se le asigna el metodo buscar ciudad, con sus atributos
                            Ciudad ciud = Casa.BuscarCiudad(ListaCiud, ciudadbusc);
                            // Si el objeto es distinto de nul significa que hemos encontrado una ciudad
                            while (ciud == null) {
                                System.out.println("CIUDAD " + ciudadbusc + ", NO REGISTRADO!!");
                                System.out.print("CIUDAD DE RESIDENCIA DEL PROPIETARIO: ");
                                ciudadbusc = entrada.nextLine();
                                ciud = Casa.BuscarCiudad(ListaCiud, ciudadbusc);
                            }
                            ciudP = ciud.obtenerNombreCiudad();
                            provP = ciud.obtenerNombreProvincia();
                            // Obtener por busqueda de Id Empresa
                            System.out.print("IDENTIFICACIÓN DE EMPRESA A BUSCAR: ");
                            String idconstrbusc = entrada.nextLine();
                            // Se crea un objeto de constructora, el cual se le 
                            // asigna el metodo buscar, con sus respectivos atributos
                            Constructora constr = Casa.BuscarConstructora(ListaCons, idconstrbusc);
                            //Si el objeto es distinto a null, es porque se ha encontrado una constructora
                            while (constr == null) {
                                System.out.println("CONSTRUCTORA CON IDENTIFICACIÓN " + idconstrbusc + ", NO REGISTRADO!!");
                                System.out.print("IDENTIFICACIÓN DE EMPRESA A BUSCAR: ");
                                idconstrbusc = entrada.nextLine();
                                constr = Casa.BuscarConstructora(ListaCons, idconstrbusc);
                            }
                            // La variable _constructora le asiganamos el nombre 
                            // de la constructora a traves del objeto creado anteriormente
                            nombCtr = constr.obtenerNombreConstructora();
                            // Se piden los demas datos de la casa
                            System.out.print("NÚMERO DE HABITACIONES: ");
                            int num_cuartos = entrada.nextInt();
                            while (num_cuartos <= 0) {
                                System.out.print("NÚMERO DE HABITACIONES: ");
                                num_cuartos = entrada.nextInt();
                            }
                            System.out.print("METROS CUADRADOS DE LA CASA: ");
                            double mtrs_cua = entrada.nextDouble();
                            while (mtrs_cua <= 0) {
                                System.out.print("METROS CUADRADOS DE LA CASA: ");
                                mtrs_cua = entrada.nextDouble();
                            }
                            System.out.print("PRECIO POR METRO CUADRADO: ");
                            double precioMc = entrada.nextDouble();
                            while (precioMc <= 0) {
                                System.out.print("PRECIO POR METRO CUADRADO: ");
                                precioMc = entrada.nextDouble();
                            }
                            // Instanciamos el constructor de casa, y a los atributos strings les asignamos "" y a los atributos numericos el 0
                            Casa c = new Casa(nombpropcasa, apepropcasa, identpropbusc, nrocasap, barrioP, referenciaB, ciudP, provP, nombCtr, idconstrbusc, num_cuartos, mtrs_cua, precioMc, cf_casa);
                            // Llamamos el metodo calcular costoFinal
                            c.CalcularCostoFinal();
                            // En cf_casa asignamos el valor a traves del metodo Obtenercostofinal
                            cf_casa = c.ObtenerCostoFinal();
                            // Instanciamos el archivo de escritura
                            ArchivoEscrituraCasa escritura5 = new ArchivoEscrituraCasa(nombreArchivo5);
                            Casa cs = new Casa(nombpropcasa, apepropcasa, identpropbusc, nrocasap, barrioP, referenciaB, ciudadbusc, provP, nombCtr, idconstrbusc, num_cuartos, mtrs_cua, precioMc, cf_casa);
                            escritura5.establecerRegistro(cs);
                            escritura5.establecerSalida();
                            escritura5.cerrarArchivo();
                        }
                        // Se realiza la lectura y presentacion en pantalla del archivo casas
                        ArchivoLecturaCasa lec5 = new ArchivoLecturaCasa(nombreArchivo5);
                        lec5.establecerLista();
                        System.out.println(lec5);
                        lec5.cerrarArchivo();
                    } // Si uno de los archivos propietario, ubicacion, ciudad o constructora no tiene registros
                    //No permitirá registrar casa e indicará que archivos son los que estan sin registros
                    else {
                        System.out.println("\n\tNO SE PUEDE REALIZAR REGISTRO PORQUE:");
                        if (ListaPro.size() == 0) {
                            System.out.println("NO HAY PROPIETARIOS REGISTRADOS!!");
                        }
                        if (ListaUbi.size() == 0) {
                            System.out.println("NO HAY UBICACIONES REGISTRADAS!!");
                        }
                        if (ListaCiud.size() == 0) {
                            System.out.println("NO HAY CIUDADES REGISTRADAS!!");
                        }
                        if (ListaCons.size() == 0) {
                            System.out.println("NO HAY CONSTRUCTORAS REGISTRADAS!!");
                        }
                    }
                    break;
                case 6:// Cuando la opcion es 6 permitirá buscar y agregar datos del departamento
                    //Variables para cada atributo de propietario, ciudad, ubicacion, constructora
                    ArchivoLecturaPropietario lectProp = new ArchivoLecturaPropietario(nombreArchivo);
                    ArchivoLecturaUbicacion lectUbi = new ArchivoLecturaUbicacion(nombreArchivo2);
                    ArchivoLecturaCiudad lectCiud = new ArchivoLecturaCiudad(nombreArchivo3);
                    ArchivoLecturaConstructora lectConstr = new ArchivoLecturaConstructora(nombreArchivo4);
                    String nombprodep = " ",
                     apepropdep = "",
                     ciuddepP = " ",
                     provdepP = "",
                     nrocasadep = " ",
                     barriodep = " ",
                     referenciaBdep = "",
                     constructoradep = " ";
                    double cfdep = 0;// Variable para almacenar el costo final
                    // Se realiza la lectura de los archivos
                    lectProp.establecerLista();
                    lectProp.cerrarArchivo();
                    lectUbi.establecerLista();
                    lectUbi.cerrarArchivo();
                    lectCiud.establecerLista();
                    lectCiud.cerrarArchivo();
                    lectConstr.establecerLista();
                    lectConstr.cerrarArchivo();
                    // A cada lista se le asigna la lista de registros correspondientes
                    ListaPro = lectProp.obtenerLista();
                    ListaUbi = lectUbi.obtenerLista();
                    ListaCiud = lectCiud.obtenerLista();
                    ListaCons = lectConstr.obtenerLista();
                    //Si los archivos propietario, ubicacion, ciudad y constructora al menos tienen un registro
                    //permitirá registrar un departamento
                    if (ListaPro.size() > 0 && ListaUbi.size() > 0 && ListaCiud.size() > 0 && ListaCons.size() > 0) {
                        System.out.println("\n\tREGISTRO DE DEPARTAMENTOS");
                        System.out.println("\t-------------------------");
                        System.out.print("INGRESE LA CANTIDAD DE DEPARTAMENTOS: ");
                        int lim5 = entrada.nextInt();
                        while (lim5 <= 0) {
                            System.out.print("INGRESE LA CANTIDAD DE DEPARTAMENTOS: ");
                            lim5 = entrada.nextInt();
                        }
                        entrada.nextLine();
                        for (int i = 0; i < lim5; i++) {
                            System.out.println("\n\t   REGISTRO Nº" + (i + 1));
                            System.out.print("IDENTIFICACIÓN DEL PROPIETARIO A BUSCAR: ");
                            String ide_busc = entrada.nextLine();
                            //Creamos una variable del objeto propietario a la 
                            // cual le asignamos el metodo de busqueda con sus
                            //parametros correspondientes
                            Propietario prop = Departamento.BuscarPropietario(ListaPro, ide_busc);
                            // Si la prop es distinto de null, significa que se ha encontrado un propietario
                            while (prop == null) {
                                System.out.println("PROPIETARIO CON IDENTIFICACIÓN " + ide_busc + ", NO REGISTRADO!!");
                                System.out.print("IDENTIFICACIÓN DEL PROPIETARIO A BUSCAR: ");
                                ide_busc = entrada.nextLine();
                                // Creamos una variable del objeto propietario a 
                                // la cual le asignamos el metodo de busqueda con 
                                // sus parametros correspondientes
                                prop = Departamento.BuscarPropietario(ListaPro, ide_busc);
                                //A la variable _nombprodep le asignamos el 
                                // nombre del propietario encontrado, lo asignamos
                                //a travez del objeto creado anteriormente
                            }
                            nombprodep = prop.obtenerNombrePropietario();
                            apepropdep = prop.obtenerApellidoPropietario();
                            // Se realiza la busqueda de una ubicacion a traves del nro de casa
                            System.out.print("NÚMERO DE CASA A BUSCAR: ");
                            String nc_busc = entrada.nextLine();
                            // Creamos un objeto de Ubicacion al cual le asignamos
                            //el metodo buscarubicacion, con sus parametros
                            Ubicacion ubi = Departamento.BuscarUbicacion(ListaUbi, nc_busc);
                            // Si el objeto es distinto de null, significa que se ha encontrado una ubicacion
                            while (ubi == null) {
                                System.out.println("CASA CON EL NÚMERO " + nc_busc + ", NO REGISTRADO!!");
                                System.out.print("NÚMERO DE CASA A BUSCAR: ");
                                nc_busc = entrada.nextLine();
                                // Creamos un objeto de Ubicacion al cual le asignamos el metodo buscarubicacion, con sus parametros
                                ubi = Departamento.BuscarUbicacion(ListaUbi, nc_busc);
                            }
                            nrocasadep = ubi.obtenerNumeroCasa();
                            barriodep = ubi.obtenerNombreBarrio();
                            referenciaBdep = ubi.obtenerReferenciaBarrio();
                            // Obtener por busqueda de nombre ciudad
                            System.out.print("CIUDAD DE RESIDENCIA DEL PROPIETARIO: ");
                            String ciudad_busc = entrada.nextLine();
                            // S crea un objeto de ciudad al cual se le asigna el metodo buscar ciudad, con sus atributos
                            Ciudad ciud = Departamento.BuscarCiudad(ListaCiud, ciudad_busc);
                            // Si el objeto es distinto de nul significa que hemos encontrado una ciudad
                            while (ciud == null) {
                                System.out.println("CIUDAD " + ciudad_busc + ", NO REGISTRADO");
                                System.out.print("CIUDAD DE RESIDENCIA DEL PROPIETARIO: ");
                                ciudad_busc = entrada.nextLine();
                                // Se crea un objeto de ciudad al cual se le asigna el metodo buscar ciudad, con sus atributos
                                ciud = Departamento.BuscarCiudad(ListaCiud, ciudad_busc);
                                // A la variable _ciudaddep le asignamos el nombre de la ciudad a traves del objeto creado anterioemente
                            }
                            ciuddepP = ciud.obtenerNombreCiudad();
                            provdepP = ciud.obtenerNombreProvincia();
                            //Obtener por busqueda de Id Empresa
                            System.out.print("IDENTIFICACIÓN DE LA EMPRESA A BUSCAR: ");
                            String idcons_busc = entrada.nextLine();
                            // Se crea un objeto de constructora, el cual se le asigna el metodo buscar, con sus respectivos atributos
                            Constructora constr = Departamento.BuscarConstructora(ListaCons, idcons_busc);
                            // Si el objeto es distinto a null, es porque se ha encontrado una constructora
                            while (constr == null) {
                                System.out.println("CONSTRUCTORA CON IDENTIFICACIÓN " + idcons_busc + ", NO REGISTRADO!!");
                                System.out.print("IDENTIFICACIÓN DE LA EMPRESA A BUSCAR: ");
                                idcons_busc = entrada.nextLine();
                                constr = Departamento.BuscarConstructora(ListaCons, idcons_busc);
                            }
                            constructoradep = constr.obtenerNombreConstructora();
                            // Se piden los demas datos del departamento
                            System.out.print("NOMBRE DEL EDIFICIO: ");
                            String nom_edif = entrada.nextLine();
                            System.out.print("METROS CUADRADOS DEL DEPARTAMENTO: ");
                            double metr_cuad_dep = entrada.nextDouble();
                            while (metr_cuad_dep <= 0) {
                                System.out.print("METROS CUADRADOS DEPARTAMENTO: ");
                                metr_cuad_dep = entrada.nextDouble();
                            }
                            System.out.print("VALOR ALICUOTA: ");
                            double valor = entrada.nextDouble();
                            while (valor <= 0) {
                                System.out.print("VALOR ALICUOTA: ");
                                valor = entrada.nextDouble();
                            }
                            System.out.print("PRECIO METRO CUADRADO: ");
                            double precioMc = entrada.nextDouble();
                            while (precioMc <= 0) {
                                System.out.print("PRECIO METRO CUADRADO: ");
                                precioMc = entrada.nextDouble();
                            }
                            entrada.nextLine();
                            System.out.print("UBICACIÓN DENTRO DEL EDIFICIO: ");
                            String ubidep = entrada.nextLine();
                            // Instanciamos el constructor de casa, y a los atributos strings les asignamos "" y a los atributos numericos el 0
                            Departamento d = new Departamento(nombprodep, apepropdep, ide_busc, nom_edif, nrocasadep, barriodep, referenciaBdep, ciuddepP, provdepP, ubidep, constructoradep, idcons_busc, valor, metr_cuad_dep, precioMc, cfdep);
                            //Lllamamos el metodo calcular costofinal 
                            d.CalcularCostoFinal();
                            // En cfdep asignamos el valor a traves del metodo ObtenercostoFinalDepartamento
                            cfdep = d.ObtenerCostoFinal();
                            // Instanciamos el archivo de escritura
                            ArchivoEscrituraDepartamento escritura6 = new ArchivoEscrituraDepartamento(nombreArchivo6);
                            Departamento dp = new Departamento(nombprodep, apepropdep, ide_busc, nom_edif, nrocasadep, barriodep, referenciaBdep, ciuddepP, provdepP, ubidep, constructoradep, idcons_busc, valor, metr_cuad_dep, precioMc, cfdep);
                            escritura6.establecerRegistro(dp);
                            escritura6.establecerSalida();
                            escritura6.cerrarArchivo();
                        }
                        // Se realiza la lectura y presentacion en pantalla del archivo departamentos
                        ArchivoLecturaDepartamento lec6 = new ArchivoLecturaDepartamento(nombreArchivo6);
                        lec6.establecerLista();
                        System.out.println(lec6);
                        lec6.cerrarArchivo();
                    } // Si uno de los archivos propietario, ubicacion, ciudad o constructora no tiene registros
                    // No permitirá registrar casa e indicará que archivos son los que estan sin registros
                    else {
                        System.out.println("\n\tNO SE PUEDE REALIZAR REGISTRO PORQUE:");
                        if (ListaPro.size() == 0) {
                            System.out.println("NO HAY PROPIETARIOS REGISTRADOS!!");
                        }
                        if (ListaUbi.size() == 0) {
                            System.out.println("NO HAY UBICACIONES REGISTRADAS!!");
                        }
                        if (ListaCiud.size() == 0) {
                            System.out.println("NO HAY CIUDADES REGISTRADAS!!");
                        }
                        if (ListaCons.size() == 0) {
                            System.out.println("NO HAY CONSTRUCTORAS REGISTRADAS!!");
                        }
                    }
                    break;
                case 7:
                    System.out.println("GRACIAS POR USAR EL PROGRAMA!!!");
                    break;
                default:
                    System.out.println("OPCIÓN INGRESADA INCORRECTA, INGRESE OTRO!!!");
                    break;
            }

        }
    }
}
