package Principal;

import Cuentas.*;
import java.util.Scanner;

public class Principal {
   
    static Scanner sc = new Scanner(System.in);
    
    //Muestra el menú en pantalla.
    //Devuelve la opción
    public static int mostrarMenu() {
        
        System.out.println("\n== GESTION DE CUENTAS BANCARIAS ==");
        System.out.println("1.Abrir una nueva cuenta");
        System.out.println("2.Ver un listado de las cuentas disponibles");
        System.out.println("3.Obtener los datos de una cuenta concreta");
        System.out.println("4.Realizar un ingreso en una cuenta");
        System.out.println("5.Retirar efectivo de una cuenta");
        System.out.println("6.Consultar el saldo actual de una cuenta");
        System.out.println("7.Eliminar una cuenta");
        System.out.println("8.Salir");
        System.out.print("Elija una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public static void main(String args[]) {
        
        Banco bank = new Banco();
        int opcion;
        do {
            opcion = mostrarMenu();
            try {
                switch (opcion) {
                
                    case 1: //Crear nueva cuenta
                        System.out.println(cuentaNueva(bank));
                        break;

                    case 2: //Ver un listado de las cuentas disponibles
                        String [] c = bank.listadoCuentas();
                        for (String listado : c) {
                            System.out.println(listado);
                        }
                        break;

                    case 3: //Obtener los datos de una cuenta concreta
                        String iban1 = validarIban();
                        System.out.println(bank.informacionCuenta(iban1) == null ? "No existe una cuenta con el IBAN introducido" : bank.informacionCuenta(iban1));
                        break;

                    case 4: //Realizar un ingreso en una cuenta
                        String iban2 = validarIban();
                        System.out.print("Cantidad a ingresar: ");
                        double cantidad2 = Double.parseDouble(sc.nextLine());
                        System.out.println(bank.ingresoCuenta(iban2, cantidad2) ? "Operación realizada con éxito." : "No se ha podido realizar la operación.");
                        break;

                    case 5: //Retirar efectivo de una cuenta
                        String iban3 = validarIban();
                        System.out.print("Cantidad a retirar: ");
                        double cantidad3 = Double.parseDouble(sc.nextLine());
                        System.out.println(bank.retiradaCuenta(iban3, cantidad3) ? "Operación realizada con éxito." : "No se ha podido realizar la operación.");
                        break;

                    case 6: //Consultar el saldo actual de una cuenta
                        String iban4 = validarIban();
                        double verSaldo = bank.obtenerSaldo(iban4);
                        System.out.println(verSaldo != -1 ? "Saldo: "+verSaldo : "No se ha podido encontrar una cuenta con ese IBAN.");
                        break;
                    
                    case 7: //Eliminar cuenta
                        String iban5 = validarIban();
                        bank.eliminarCuenta(iban5);
                        break;

                    case 8:  //Salir
                        System.out.println("Programa finalizado.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opción no válida.\n");
            } 
        } while (opcion !=8);
    }
    /**
     * Al abrir una nueva cuenta bancaria, se tendrá que solicitar al cliente:
     * - Datos personales: nombre, apellidos y DNI.
     * - Tipo de cuenta que desea abrir: cuenta de ahorro, cuenta corriente personal o cuenta corriente de empresa.
     * - Saldo inicial.
     * Además se debe introducir:
     * - Número de cuenta (IBAN)
     * - Tipo de interés de remuneración, si es cuenta de ahorro.
     * - Comisión de mantenimiento, si es cuenta corriente personal.
     * - Máximo descubierto permitido, si es cuenta corriente de empresa.
     * - Tipo de interés por descubierto, si es cuenta corriente de empresa.
     * - Comisión fija por cada descubierto, si es cuenta corriente de empresa.
     */
    static String cuentaNueva (Banco bco) {
        
        String nombre, apellidos, dni, iban, entidadesAutorizadas;
        int tipo;
        double saldoInicial;
        entidadesAutorizadas = "Caixabank, Santander, BBVA";
        boolean continuar;
        
        try {
            System.out.println("\nAbrir cuenta nueva");
            System.out.print("Nombre del cliente: ");
            nombre = sc.nextLine();
            System.out.print("Apellidos del cliente: ");
            apellidos = sc.nextLine();
            System.out.print("DNI del cliente: ");
            dni = sc.nextLine();
            iban = validarIban();
            continuar=false;
            do {
                System.out.print("Saldo inical: ");
                saldoInicial = Double.parseDouble(sc.nextLine());
                if (saldoInicial < 0) {
                    System.out.println("Valor fuera de rango");                                                        
                } else {
                    continuar=true;
                }
            } while (!continuar);
            System.out.println("Tipo de cuenta:");
            System.out.println("1 - Cuenta de ahorro");
            System.out.println("2 - Cuenta corriente personal");
            System.out.println("3 - Cuenta corriente de empresa");
            System.out.print(">> ");
            tipo = Integer.parseInt(sc.nextLine());
            Persona titular = new Persona (nombre, apellidos, dni);
            switch (tipo) {
                case 1:
                    double interesRemuneracion;
                    continuar=false;
                    do {
                        System.out.print("Tipo de interés de remuneración (0-100): ");
                        interesRemuneracion = Double.parseDouble(sc.nextLine());
                        if (interesRemuneracion < 0 || interesRemuneracion > 100) {
                            System.out.println("Valor fuera de rango");                                                        
                        } else {
                            continuar=true;
                        }
                    } while (!continuar);
                    CuentaAhorro ctaA = new CuentaAhorro (titular, saldoInicial, iban, interesRemuneracion);
                    bco.abrirCuenta(ctaA);
                    break;
                case 2:
                    double comisionMantenimiento;
                    continuar=false;
                    do {
                        System.out.print("Comisión de mantenimiento: ");
                        comisionMantenimiento = Double.parseDouble(sc.nextLine());
                        if (comisionMantenimiento < 0) {
                            System.out.println("Valor fuera de rango");                                                        
                        } else {
                            continuar=true;
                        }
                    } while (!continuar);
                    System.out.println("(Entidades autorizadas por defecto)");
                    CuentaCorrientePersonal ctaB = new CuentaCorrientePersonal (titular, saldoInicial, iban, entidadesAutorizadas , comisionMantenimiento);
                    bco.abrirCuenta(ctaB);
                    break;
                case 3:
                    double maximoDescubierto;
                    continuar=false;
                    do {
                        System.out.print("Máximo descubierto permitido: ");
                        maximoDescubierto = Double.parseDouble(sc.nextLine());
                        if (maximoDescubierto < 0) {
                            System.out.println("Valor fuera de rango");                                                        
                        } else {
                            continuar=true;
                        }
                    } while (!continuar);
                    continuar=false;
                    double interesDescubierto;
                    do {
                        System.out.print("Tipo de interés por descubierto: ");
                        interesDescubierto = Double.parseDouble(sc.nextLine());
                        if (interesDescubierto < 0 || interesDescubierto > 100) {
                            System.out.println("Valor fuera de rango");                                                        
                        } else {
                            continuar=true;
                        }
                    } while (!continuar);
                    continuar=false;
                    double comisionDescubierto;
                    do {
                        System.out.print("Comisión fija por cada descubierto: ");
                        comisionDescubierto = Double.parseDouble(sc.nextLine());
                        if (comisionDescubierto >= maximoDescubierto) {
                            System.out.println("Valor fuera de rango");                                                        
                        } else {
                            continuar=true;
                        }
                    } while (!continuar);
                    System.out.println("(Entidades autorizadas por defecto)");
                    CuentaCorrienteEmpresa ctaC = new CuentaCorrienteEmpresa (titular, saldoInicial, iban, entidadesAutorizadas, interesDescubierto, maximoDescubierto, comisionDescubierto);
                    bco.abrirCuenta(ctaC);
                    break;
                default:
                    throw new Exception ("Valor no válido.");
            }
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Opción no válida.");
            return "Creación de cuenta cancelada.";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Creación de cuenta cancelada.";
        }
        return "";   
    }
    
    //Valida IBAN mediante expresion regular ESn... (ES en mayúsculas y al menos un número)
    private static String validarIban () {
        boolean ibanOk = false;
        String ib;
        do {
            System.out.print("IBAN (ESn...): ");
            ib = sc.nextLine();
            if (ib.matches("ES[0-9]*")) {
                ibanOk=true;
            } else {
                System.out.println("Formato de IBAN inválido. ESn...");
            }
        } while (!ibanOk);
        return ib;
    }
}

