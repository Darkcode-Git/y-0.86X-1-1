import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Persona> personas = capturarPersonas();
        
        System.out.println("Nombres y géneros capturados:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " - " + persona.getGenero());
        }
        
        double promedio = calcularPromedioEdades(personas);
        System.out.printf("Promedio de edades: %.2f%n", promedio);
        
        int masculinos = contarMasculinos(personas);
        int femeninos = contarFemeninos(personas);
        System.out.println("Cantidad de género masculino: " + masculinos);
        System.out.println("Cantidad de género femenino: " + femeninos);
    }

    public static List<Persona> capturarPersonas() {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Persona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Género (Masculino/Femenino): ");
            String genero = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            personas.add(new Persona(nombre, apellido, genero, edad));
        }
        return personas;
    }

    public static double calcularPromedioEdades(List<Persona> personas) {
        int suma = 0;
        for (Persona persona : personas) {
            suma += persona.getEdad();
        }
        return (double) suma / personas.size();
    }

    public static int contarMasculinos(List<Persona> personas) {
        return contarGenero(personas, "Masculino");
    }

    public static int contarFemeninos(List<Persona> personas) {
        return contarGenero(personas, "Femenino");
    }

    private static int contarGenero(List<Persona> personas, String genero) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getGenero().equalsIgnoreCase(genero)) {
                contador++;
            }
        }
        return contador;
    }
}
