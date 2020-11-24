import java.util.Scanner;
import java.util.ArrayList;

/*
Hola buenas tardes alguien me ayuda con este ejercicio en java ? 
Los vendedores de una empresa reciben una comisión de acuerdo a sus ventas mensuales de acuerdo a la siguiente tabla:
Monto de las ventas         | Porcentaje de Comisión
Menos de $1,000.00          | 0.0%
$1,000.00 a $4,999.99       | 2.5%
$5,000.00 a $9,999.99       | 5.0%
$10,000.00 a 49,999.00      | 7.5%
$50,000.00 o más            | 10.0%
Lea la venta mensual de un vendedor de la empresa y escriba su comisión.
Como hago para que el programa me muestre una sola vez al final todo el total de ventas ? 
*/

public class ComisionVendedores {

    private ArrayList<Double> venta;
    private Scanner scanner;

    public ComisionVendedores() {
        scanner = new Scanner(System.in);
        this.venta = new ArrayList<Double>();
        this.printStart();
        this.printMenu();
        this.loop();
    }

    public int getOpcion() {
        boolean flag = false;
        String input = "";
        int entero = 0;
        while(!flag) { 
            System.out.print("Ingrese una opcion : ");
            input = scanner.nextLine();
            try {
                entero = Integer.parseInt(input);
                if(entero >= 0 && entero <= 3) {
                    flag = true;
                } else {
                    this.println("Elija una opcion entre 0 y 2.");
                }
            } catch (NumberFormatException nfe) {
                this.println("Ingrese una opcion valida.");
                flag = false;
            }
        }
        return entero;
    }

    public void printMenu() {
        this.println("Elija una opcion.");
        this.println("1- Ingresar nueva venta.");
        this.println("2- Mostrar Comision.");
        this.println("3- Historial de Ventas.");
        this.println("0- Cerrar programa.");
        this.printSeparador();
    }
    
    public void printStart() {
        this.printSeparador();
        this.println("\tBienvenido.");
        this.printSeparador();
    }

    public void printEnd() {
        this.printSeparador();
        this.println("\tPrograma Finalizado.");
        this.printSeparador();

    }

    public void printSeparador() {
        this.println("-------------------------------");
    }

    public void cls() {
        this.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void pause() {
        System.out.print("Presione enter para continuar...");
        scanner.nextLine();
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    public void loop() {
        OUTER:
        while(true) {
            int opcion = this.getOpcion();
            switch (opcion) {
                case 0:
                    this.printEnd();
                    break OUTER;
                case 1:
                    this.inVenta();
                    this.printSeparador();
                    this.printMenu();
                    break;
                case 2:
                    this.printComision();
                    this.printSeparador();
                    this.printMenu();
                    break;
                default:
                    this.printHistorialVentas();
                    this.printSeparador();
                    this.printMenu();

            }
        }
    }

    public void printComision() {
        this.cls();
        double total_venta_mensual = this.totalVentaMensual();
        double total_comision = this.getComision(total_venta_mensual);
        this.printSeparador();
        this.println("Total Venta Mensual : " + total_venta_mensual);
        this.println("Total Comision : " + total_comision);
        this.printSeparador();
        this.pause();
        this.cls();
    }

    public double totalVentaMensual() {
        double total_venta = 0.0;
        for(double value : this.venta) {
            total_venta += value;
        }
        return total_venta;
    }

    public void printHistorialVentas() {
        this.cls();
        this.println("Historial de venta : ");
        for(double value : this.venta) {
            this.println("" + value);
        }
        this.pause();
    }

    public void inVenta() {
        this.cls();
        boolean flag = false;
        String input = "";
        double venta = 0;
        while(!flag) { 
            System.out.print("Ingrese Venta : ");
            input = scanner.nextLine();
            try {
                venta = Double.parseDouble(input);
                if(venta>=0.0) {
                    flag = true;
                } else {
                    this.println("El monto no puede ser negativo.");
                }
            } catch (NumberFormatException nfe) {
                this.println("Ingrese un monto valido.");
                flag = false;
            }
        }
        this.venta.add(venta);
        this.cls();
        this.println("Monto de la venta : " + venta);
    }

    public double getComision(double venta_mensual) {
        double comision_venta = 0;
        if(venta_mensual < 1000.00) {
            comision_venta = venta_mensual;
        } else if (venta_mensual >= 1000.00 && venta_mensual < 5000.00) {
            comision_venta = venta_mensual * 2.5 / 100;
        } else if (venta_mensual >= 5000.00 && venta_mensual < 10000.00) {
            comision_venta = venta_mensual * 5.0 / 100;
        } else if (venta_mensual >= 10000.00 && venta_mensual < 50000.00) {
            comision_venta = venta_mensual * 7.5 / 100;
        } else {
            comision_venta = venta_mensual * 10.0 / 100;
        }
        return comision_venta;
    }

    public static void main(String ...args) {
        ComisionVendedores cv = new ComisionVendedores();
    }
}