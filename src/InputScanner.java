import java.util.Scanner;

public class InputScanner {
    private Scanner scanner;

    public InputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public String readStringInput(String outputPrompt) {
        String inputString = "";
        System.out.print(outputPrompt + ":");
        inputString = this.scanner.nextLine();
        return inputString;
    }

    public int readIntegerInput(String outputPrompt) {
        int inputString = 0;
        System.out.print(outputPrompt + ":");
        inputString = this.scanner.nextInt();
        return inputString;
    }

}
