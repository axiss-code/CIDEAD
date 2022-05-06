package Cuentas;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Mantendrá como atributo la estructura que almacena las cuentas.
 * Esta estructura podrá contener un máximo de 100 cuentas bancarias.
 * Para almacenar los objetos de tipo cuenta se deberá utilizar un array.
 * Dispondrá de los siguientes métodos:
 * - Constructor o constructores.
 * - abrirCuenta: recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura.
 *   Devuelve true o false indicando si la operación se realizó con éxito.
 * - listadoCuentas: no recibe parámetro y devuelve un array donde cada elemento es una cadena que
 *   representa la información de una cuenta.
 * - informacionCuenta: recibe un iban por parámetro y devuelve una cadena con la información de la
 *   cuenta o null si la cuenta no existe.
 * - ingresoCuenta: recibe un iban por parámetro y una cantidad e ingresa la cantidad en la cuenta.
 *   Devuelve true o false indicando si la operación se realizó con éxito.
 * - retiradaCuenta: recibe un iban por parámetro y una cantidad y trata de retirar la cantidad de la
 *   cuenta. Devuelve true o false indicando si la operación se realizó con éxito.
 * - obtenerSaldo: Recibe un iban por parámetro y devuelve el saldo de la cuenta si existe. En caso
 *   contrario devuelve -1.
 */
public final class Banco {

    private final ArrayList <CuentaBancaria> cuentas;
    static final String FICHERO = "datoscuentasbancarias.dat";
    static final String LISTADOCCC = "ListadoClientesCCC.txt";
    private ObjectInputStream lector;
    private ObjectOutputStream escritor;

    public Banco() {
        String archivo = Banco.FICHERO;
        if (checkFile(archivo, 'e')) { //si existe el fichero
            if (checkFile(archivo, 'r')) { //si se puede leer
                this.cuentas = cargarDatos(archivo);
            } else {
                System.out.println("El archivo existe, pero no se puede leer.\nNo se cargarán datos. Se crea un ArrayList vacío.");
                this.cuentas = new ArrayList<>();
            }
        } else {
            if (checkFile(archivo, 'c')){
                System.out.println("El nuevo archivo guardará la información al salir.");
            } else {
                System.out.println("Se perderá la información al salir.");
            }
            this.cuentas = new ArrayList<>();
        }
    }
    
    /**
     * Método encargado de recuperar la información en datoscuentasbancarias.dat y que asocia todos los objetos a un ArrayList.
     * En caso de que no exista información o fuese null, devuelve un ArrayList nuevo vacío.
     * 
     * @param fichero donde se encuentra guardada la información a recuperar (binario)
     * @return ArrayList de CuentasBancarias, con la información recuperada o vacío
     */
    public ArrayList <CuentaBancaria> cargarDatos (String fichero){
        File filename = new File(fichero);
        if (filename.exists()){
            System.out.println("Cargando datos...");
            try {
                lector = new ObjectInputStream(new FileInputStream(filename));
                return (ArrayList<CuentaBancaria>)lector.readObject();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            } finally {  // nos aseguramos de que el archivo se cierra
                if (lector !=null) {
                    try {
                        lector.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } 
        return (new ArrayList<>());
    }
    
    //Método encargado de volcar la información, como un flujo de bytes, en el fichero.
    //Si el archivo no existe o no se permite la escritura, notificará al usuario y se perderá la información al salir.
    public void guardarDatos () {
        String archivo = Banco.FICHERO;
        if (checkFile(archivo, 'e')) { //si existe el fichero
            if (checkFile(archivo, 'w')) { //si se puede escribir
                try {
                    escritor = new ObjectOutputStream(new FileOutputStream(archivo));
                    escritor.writeObject(this.cuentas);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } finally {  // nos aseguramos de que el archivo se cierra
                    if (escritor !=null) {
                        try {
                            escritor.close();
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
                System.out.println("Datos guardados en archivo "+archivo);
            } else {
                System.out.println("El archivo existe, pero puede escribirse.\nSe perderán los cambios.");
            }
        }
    }
    
    /**
     * Función que comprobará si un arhcivo existe, si tiene permisos de lectura
     * y/o escritura. También permite crear o borrar un archivo.
     * @param filename archivo que se desea comprobar
     * @param mode r read, w write, e exists, d delete, c create
     * @return true o false
     */
    public static boolean checkFile (String filename, char mode) {
        File comprueba = new File(filename);
        char opcion = mode;
        switch (opcion) {
            case 'r':
                if (comprueba.canRead()) {
                    System.out.println("Acceso de lectura correcto.");
                    return true;
                } else {
                    System.out.println("Sin acceso de lectura.");
                    return false;
                }
            case 'w':
                if (comprueba.canWrite()) {
                    System.out.println("Acceso de escritura correcto.");
                    return true;
                } else {
                    System.out.println("Sin acceso de escritura.");
                    return false;
                }
            case 'e':
                if (comprueba.exists()) {
                    System.out.println("Archivo existente.");
                    return true;
                } else {
                    System.out.println("El archivo no existe.");
                    return false;
                }
            case 'c':
                try {
                    if (comprueba.createNewFile()) {
                        System.out.println("Archivo creado correctamente.");
                        return true;
                    } else {
                        System.out.println("Imposible crear archivo.");
                        return false;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            case 'd':
                if (comprueba.delete()) {
                    System.out.println("Archivo borrado correctamente");
                    return true;
                } else {
                    System.out.println("Imposible borrar archivo.");
                    return false;
                }
        } 
        return false; 
    }
            
    //Método privado que nos servirá para saber si existe una cuenta en nuestro array.
    //Nos devolverá la posición del array en la que se encuentra o -1 en caso negativo.
    private int existeCuenta (String iban) {

        for (CuentaBancaria i:this.cuentas) {
            if (i.getIban().equals(iban)) {
                return cuentas.indexOf(i);
            }
        }
        return -1;
    }
            
    //Recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura.
    //Devuelve true o false indicando si la operación se realizó con éxito.
    public boolean abrirCuenta(CuentaBancaria cta) {
        
        if (existeCuenta(cta.getIban()) != -1){
            System.out.print("Ya existe una cuenta con el IBAN introducido");
            return false;
        } else {
            this.cuentas.add(cta);
            //instanceof CuentaCorrienteEmpresa
            if (cta instanceof CuentaCorrienteEmpresa) {
                System.out.print("Cuenta corriente de empresa creada.");
            } else if (cta instanceof CuentaCorrientePersonal) {
                System.out.print("Cuenta corriente personal creada.");
            } else if (cta instanceof CuentaAhorro){
                System.out.print("Cuenta de ahorro creada.");
            }
            return true;   
        }
    }
    
    //No recibe parámetro y devuelve un array donde cada elemento es una cadena que representa la información de una cuenta.
    public String[] listadoCuentas() {
        
        String [] respuesta;
        if (this.cuentas.isEmpty()) {
            respuesta = new String[] {"Aún no existen cuentas creadas."};
            return respuesta;
        } else {
            respuesta = new String [this.cuentas.size()];
            for (int i = 0; i < respuesta.length; i++) {
                respuesta[i] = "------------\n"+this.cuentas.get(i).devolverInfoString();
            }
            return respuesta;
        }
    }
    
    //Recibe un iban por parámetro y devuelve una cadena con la información de la cuenta o null si la cuenta no existe.
    //Utilizo un método similar a devolverInfoString, pero devuelve toda la info detallada de la cuenta correspondiente.
    public String informacionCuenta(String iban) {

        if (existeCuenta(iban) == -1){
            return null;
        } else {
            if (this.cuentas.get(existeCuenta(iban)) instanceof CuentaCorrienteEmpresa) {
                return "------------\n"+((CuentaCorrienteEmpresa)this.cuentas.get(existeCuenta(iban))).devolverStringInfo()+"\n------------"; 
            } else if (this.cuentas.get(existeCuenta(iban)) instanceof CuentaCorrientePersonal) {
                return "------------\n"+((CuentaCorrientePersonal)this.cuentas.get(existeCuenta(iban))).devolverStringInfo()+"\n------------"; 
            } else if (this.cuentas.get(existeCuenta(iban)) instanceof CuentaAhorro){
                return "------------\n"+((CuentaAhorro)this.cuentas.get(existeCuenta(iban))).devolverStringInfo()+"\n------------"; 
            } else {
                return "------------\n"+this.cuentas.get(existeCuenta(iban)).devolverInfoString()+"\n------------";
            }
        }
    }
    
    //Recibe un iban por parámetro y una cantidad e ingresa la cantidad en la cuenta.
    //Devuelve true o false indicando si la operación se realizó con éxito.
    public boolean ingresoCuenta (String iban, double cantidad) {
        
        if (existeCuenta(iban) == -1){
            System.out.println("No existe una cuenta con el IBAN introducido.");
            return false;
        } else {
            System.out.println("Saldo anterior= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
            this.cuentas.get(existeCuenta(iban)).setSaldo(this.cuentas.get(existeCuenta(iban)).getSaldo()+cantidad);
            System.out.println("Saldo actual= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
            return true;
        }
    }
    
    //Recibe un iban por parámetro y una cantidad y trata de retirar la cantidad de la cuenta.
    //Devuelve true o false indicando si la operación se realizó con éxito.
    public boolean retiradaCuenta(String iban, double cantidad) {
        
        if (existeCuenta(iban) == -1){
            System.out.println("No existe una cuenta con el IBAN introducido.");
            return false;
        }
        
        if (this.cuentas.get(existeCuenta(iban)).getSaldo() - cantidad >= 0) {
            System.out.println("Saldo anterior= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
            this.cuentas.get(existeCuenta(iban)).setSaldo(this.cuentas.get(existeCuenta(iban)).getSaldo() - cantidad);
            System.out.println("Saldo actual= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
            return true;
        } else if (this.cuentas.get(existeCuenta(iban)) instanceof CuentaCorrienteEmpresa) {
            double limite = ((CuentaCorrienteEmpresa)this.cuentas.get(existeCuenta(iban))).getMaximoDescubiertoPermitido();
            double comision = ((CuentaCorrienteEmpresa)this.cuentas.get(existeCuenta(iban))).getComisionFijaDescubierto();
            double descubierto = this.cuentas.get(existeCuenta(iban)).getSaldo();
            if (limite + descubierto - comision - cantidad >= 0){
                System.out.println("Saldo anterior= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
                this.cuentas.get(existeCuenta(iban)).setSaldo(descubierto - cantidad - comision);
                System.out.println("Saldo actual= "+this.cuentas.get(existeCuenta(iban)).getSaldo());
                return true;
            } else {
                System.out.println("Saldo ("+this.cuentas.get(existeCuenta(iban)).getSaldo()+") insuficiente.");
                return false;
            }
        } else {
            System.out.println("Saldo ("+this.cuentas.get(existeCuenta(iban)).getSaldo()+") insuficiente.");
            return false;
        }
    }
    
    //Recibe un iban por parámetro y devuelve el saldo de la cuenta si existe. En caso contrario devuelve -1.
    public double obtenerSaldo (String iban) {
        
        if (existeCuenta(iban) == -1){
            return -1;
        } else {
            return this.cuentas.get(existeCuenta(iban)).getSaldo();
        }
    }
    
    //Se eliminará de la estructura siempre que exista y su saldo sea 0. No se podrán eliminar cuentas con saldo superior a 0.
    public void eliminarCuenta(String iban){
        
        if (existeCuenta(iban) == -1){
            System.out.println("No existe una cuenta con el IBAN introducido.");
        } else {
            if (this.cuentas.get(existeCuenta(iban)).getSaldo() > 0) {
                System.out.println("No es posible eliminar cuentas con Saldo > 0.");
            } else {
                this.cuentas.remove(existeCuenta(iban));
                System.out.println("Cuenta borrada con éxito.");
            }
        }        
    }
    
    //Genera un archivo txt con el nombre y apellido del titular de cada cuenta,
    //junto con el tipo de cuenta (Corriente Personal o de Empresa o de Ahorro) y su iban.
    //Y al final el total de cuentas que contiene la lista
    public void listarClientesTxt(){
        String archivo=Banco.LISTADOCCC;
        if ((checkFile(archivo, 'e') && checkFile(archivo, 'w')) || checkFile(archivo, 'c')) { //si existe el fichero y se puede escribir, o si se puede crear
            Path ruta=Paths.get(archivo);
            ruta=ruta.toAbsolutePath();
            try (BufferedWriter in = new BufferedWriter (new FileWriter(archivo))) {
                for (CuentaBancaria i:this.cuentas) {
                    String aux ="";
                    if (i instanceof CuentaCorrienteEmpresa) {
                        aux="Cuenta Corriente de Empresa ";
                    } else if (i instanceof CuentaCorrientePersonal) {
                        aux="Cuenta Corriente Personal ";
                    } else if (i instanceof CuentaAhorro){
                        aux="Cuenta de Ahorro ";
                    }
                    in.write(i.getNombreApellido()+" "+aux+"("+i.getIban()+")");
                    in.newLine();
                }
                in.write("Total de cuentas: "+this.cuentas.size());
            } catch (EOFException ex) {
                System.out.println("Error de fichero.");
            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no encontrado.");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Fichero generado correctamente en "+ruta);
        } 
    }

}
