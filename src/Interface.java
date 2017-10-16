
import java.util.Scanner;

public class Interface {
    private static Scanner teclado = new Scanner(System.in);
    
    public static String pedeRua() {
        System.out.print("Insira o nome da rua: ");
        return teclado.nextLine();
    }
    
    public static String pedeCidade() {
        System.out.print("Insira o nome da cidade: ");
        return teclado.nextLine();
    }
    
}
