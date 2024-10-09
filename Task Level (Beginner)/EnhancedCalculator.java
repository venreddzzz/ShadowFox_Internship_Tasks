import java.util.Scanner;

public class EnhancedCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEnhanced Console-based Calculator");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic();
                    break;
                case 2:
                    scientificCalculations();
                    break;
                case 3:
                    unitConversions();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void basicArithmetic() {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        int operation = scanner.nextInt();
        double result = 0;

        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
                return;
        }
        System.out.println("Result: " + result);
    }

    private static void scientificCalculations() {
        System.out.println("Select operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (a^b)");

        int operation = scanner.nextInt();
        double result = 0;

        switch (operation) {
            case 1:
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num >= 0) {
                    result = Math.sqrt(num);
                } else {
                    System.out.println("Error: Cannot calculate square root of a negative number.");
                    return;
                }
                break;
            case 2:
                System.out.print("Enter base (a): ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent (b): ");
                double exponent = scanner.nextDouble();
                result = Math.pow(base, exponent);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
                return;
        }
        System.out.println("Result: " + result);
    }

    private static void unitConversions() {
        System.out.println("Select conversion type:");
        System.out.println("1. Temperature (Celsius to Fahrenheit)");
        System.out.println("2. Currency (USD to EUR)");

        int conversionType = scanner.nextInt();
        double result = 0;

        switch (conversionType) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                result = (celsius * 9 / 5) + 32; // Convert to Fahrenheit
                System.out.println("Temperature in Fahrenheit: " + result);
                break;
            case 2:
                System.out.print("Enter amount in USD: ");
                double usd = scanner.nextDouble();
                result = usd * 0.85; // Example conversion rate to EUR
                System.out.println("Amount in EUR: " + result);
                break;
            default:
                System.out.println("Invalid conversion type. Please try again.");
        }
    }
}