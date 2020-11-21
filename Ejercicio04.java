import java.util.Scanner;

public class Ejercicio04 {
    
    private String [][]puntuaciones_peliculas = {
            {"E.T.","Sharknado","Godzilla"},
            {"8", "3", "9"},
            {"5", "8", "7"},
            {"10", "9", "6"},
            {"4", "7", "8"}
        };
    
    public Ejercicio04() {
        this.printStart();
        this.printMenu();
        OUTER:
        while (true) {
            int input = this.getInput("Ingrese una opcion", 1, 4, 0);
            switch (input) {
                case 0:
                    this.printEnd();
                    break OUTER;
                case 1:
                    this.opcion1();
                    break;
                case 2:
                    this.opcion2();
                    break;
                case 3:
                    this.opcion3();
                    break;
                case 4:
                    this.opcion4();
                    break;
                default:
                    System.out.println("Ingresa una opcion valida.");
                    break;
            }
        }
    }
    
    private void opcion1() {
        this.cls();
        this.printTable();
        this.printMenu();
    }
    
    private void opcion2() {
        this.cls();
        this.printNombresPeliculas();
        this.cls();
        this.printMenu();
    }
    
    private void opcion3() {
        this.cls();
        this.printModificarDatoPelicula();
        this.cls();
        this.printMenu();
    }
    
    private void opcion4() {
        this.cls();
        this.printPuntuacionPelicula();
        this.printMenu();
    }
    
    private void printLineaDivisoria() {
        System.out.println("------------------------------------------------------------");
    }
    
    private void printStart() {
        System.out.println("============================================================");
        System.out.println("\t\t\t*Bienvenido*");
        System.out.println("\t\tPractica de Array Bidimensional");
        System.out.println("============================================================");
        this.printTable();
    }
    
    private void printEnd() {
        this.cls();
        System.out.println("============================================================");
        System.out.println("\t\tPrograma Finalizado");
        System.out.println("============================================================");
    }
    
    private void printMenu() {
        System.out.println("Seleccione una opcion :");
        this.printLineaDivisoria();
        System.out.println("1- Mostrar nombre y puntucaciones de todas las peliculas.");
        System.out.println("2- Modificar el nombre de una pelicula.");
        System.out.println("3- Modificar puntuacion de una pelicula.");
        System.out.println("4- Mostrar todas las puntuaciones de una pelicula.");
        System.out.println("0- Terminar Programa.");
        this.printLineaDivisoria();
    }
    
    private int getInput(String msg, int min, int max, int close) {
        Scanner scanner = new Scanner(System.in);
        int r = -1;
        do { 
            System.out.println("Ingrese un numero entre " + min + " y " + max);
            System.out.println("Para cerrar el programa ingrese " + close);
            System.out.print(msg + " : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor ingrese un numero entre " + min + " y " + max + " : ");
                scanner.next();
            }
            r = scanner.nextInt();
        } while(!((r>=min && r<=max) || r==close));
        this.cls();
        return r;
    }
    
    private void cls() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        /*
        // investigar como ejecutar linea de comandos con java
        System.out.println("Clear exec here...");
        try {
            final String os = System.getProperty("os.name");
            System.out.println("Es Windows : " + os.startsWith("Windows"));
            if(os.startsWith("Windows") == "true") {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e){}
        */
    }
    
    private void printTable() {
        int l_i = this.puntuaciones_peliculas.length;
        String lh = "_________________________________________________";
        System.out.println(lh);
        for(int i=0; i<l_i; i++) {
            int l_j = this.puntuaciones_peliculas[i].length;
            for(int j=0; j<l_j; j++) {
                if(this.puntuaciones_peliculas[i][j].length()>4) {
                    System.out.print("    " + this.puntuaciones_peliculas[i][j] + "   ");
                } else {
                    System.out.print("\t" + this.puntuaciones_peliculas[i][j] + "\t");
                }
            }
            System.out.println("\n" + lh);
        }
    }
    
    private void printNombresPeliculas() {
        System.out.println("Seleccione un indice para modificar el nombre : ");
        int l_i = this.puntuaciones_peliculas[0].length;
        for(int i=0; i<l_i; i++) {
            System.out.println((i+1) + "- " + this.puntuaciones_peliculas[0][i] + ".");
        }
        this.printLineaDivisoria();
        OUTER:
        while(true) {
            int input = this.getInput("Seleccione el indice", 1, l_i, 0);
            switch (input) {
                case 0:
                    this.printEnd();
                    break OUTER;
                default:
                    this.cambiarNombrePelicula(input);
                    break OUTER;
            }
        }
    }
    
    private void cambiarNombrePelicula(int indice_pelicula) {
        System.out.print("Ingrese nuevo nombre : ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        this.puntuaciones_peliculas[0][indice_pelicula-1] = nombre;
    }
    
    private void printPuntuacionPelicula() {
        System.out.println("Seleccione un indice para mostrar las puntuaciones de la pelicula : ");
        int l_i = this.puntuaciones_peliculas[0].length;
        for(int i=0; i<l_i; i++) {
            System.out.println((i+1) + "- " + this.puntuaciones_peliculas[0][i] + ".");
        }
        this.printLineaDivisoria();
        OUTER:
        while(true) {
            int input = this.getInput("Seleccione el indice", 1, l_i, 0);
            switch (input) {
                case 0:
                    this.printEnd();
                    break OUTER;
                default:
                    this.mostrarPuntuacionPelicula(input);
                    break OUTER;
            }
        }
    }
    
    private void mostrarPuntuacionPelicula(int indice_pelicula) {
        int l_i = this.puntuaciones_peliculas.length;
        System.out.println(this.puntuaciones_peliculas[0][indice_pelicula-1]);
        for(int i=1; i<l_i; i++) {
            System.out.println(this.puntuaciones_peliculas[i][indice_pelicula-1]);
        }
    }
    
    private void printModificarDatoPelicula() {
        System.out.println("Seleccione un indice para modificar las puntuaciones de la pelicula : ");
        int l_i = this.puntuaciones_peliculas[0].length;
        for(int i=0; i<l_i; i++) {
            System.out.println((i+1) + "- " + this.puntuaciones_peliculas[0][i] + ".");
        }
        this.printLineaDivisoria();
        OUTER:
        while(true) {
            int input = this.getInput("Seleccione el indice", 1, l_i, 0);
            switch (input) {
                case 0:
                    this.printEnd();
                    break OUTER;
                default:
                    this.modificarDatoPelicula(input);
                    break OUTER;
            }
        }
    }
    
    private void modificarDatoPelicula(int indice_pelicula) {
        int l_i = this.puntuaciones_peliculas[0][0].length();
        System.out.println(this.puntuaciones_peliculas[0][indice_pelicula-1]);
        Scanner scanner = new Scanner(System.in);
        int r;
        for(int i=1; i<=l_i; i++) {
            System.out.print("Ingrese nueva puntuacion : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un numero valido : ");
                scanner.next();
            }
            r = scanner.nextInt();
            System.out.println(i + " : valor de " + r);
            this.puntuaciones_peliculas[i][indice_pelicula-1] = String.valueOf(r);
        }
    }
    
    public static void main(String[] args) {
        new Ejercicio04();
    }    
}
