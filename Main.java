import java.util.Scanner;

class Televisor {
    public void encender() { System.out.println("  [TV] Encendiendo Televisor..."); }
    public void apagar() { System.out.println("  [TV] Apagando Televisor..."); }
    public void setInput() { System.out.println("  [TV] Configurando entrada a HDMI 1..."); }
}

class Proyector {
    public void encender() { System.out.println("  [Proyector] Encendiendo Proyector..."); }
    public void apagar() { System.out.println("  [Proyector] Apagando Proyector..."); }
    public void modoAncho() { System.out.println("  [Proyector] Configurando a formato panorámico 16:9..."); }
}

class SistemaDeSonido {
    public void encender() { System.out.println("  [Sonido] Encendiendo Sistema de Sonido..."); }
    public void apagar() { System.out.println("  [Sonido] Apagando Sistema de Sonido..."); }
    public void setVolumen(int nivel) { System.out.println("  [Sonido] Configurando volumen a " + nivel + "..."); }
}

class Luces {
    public void encender() { System.out.println("  [Luces] Encendiendo luces al 100%..."); }
    public void apagar() { System.out.println("  [Luces] Apagando luces..."); }
    public void atenuar(int nivel) { System.out.println("  [Luces] Atenuando luces al " + nivel + "%..."); }
}

class CineEnCasaFacade {
    private Televisor televisor;
    private Proyector proyector;
    private SistemaDeSonido sonido;
    private Luces luces;

    public CineEnCasaFacade() {
        this.televisor = new Televisor();
        this.proyector = new Proyector();
        this.sonido = new SistemaDeSonido();
        this.luces = new Luces();
    }

    public void verPelicula() {
        System.out.println("\nPreparando el cine en casa...");
        luces.atenuar(20);
        proyector.encender();
        proyector.modoAncho();
        televisor.encender();
        televisor.setInput();
        sonido.encender();
        sonido.setVolumen(15);
        System.out.println("¡Disfruta la película!\n");
    }

    public void apagarTodo() {
        System.out.println("\nApagando el cine en casa...");
        sonido.apagar();
        televisor.apagar();
        proyector.apagar();
        luces.encender(); // Volvemos a poner las luces al 100%
        System.out.println("Sistema apagado. ¡Hasta luego!\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CineEnCasaFacade cine = new CineEnCasaFacade(); 
        
        int opcion = 0;
        
        System.out.println("=================================");
        System.out.println("  SISTEMA DE CONTROL DEL HOGAR   ");
        System.out.println("=================================");

        while (opcion != 3) {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Ver una película (Modo Cine)");
            System.out.println("2. Apagar todo el sistema");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción (1-3): ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    cine.verPelicula();
                    break;
                case 2:
                    cine.apagarTodo();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.\n");
                    break;
            }
        }
        scanner.close();
    }
}