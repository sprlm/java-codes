import acm.program.*;
import java.lang.Math;

public class Module3_1_B extends ConsoleProgram {

    public void run() {
        int choice = 0;
        while (true) {
            println("Please select a formula: ");
            println("1.) Universal Gravitation Formula");
            println("2.) Centripetal Force Formula");
            println("3.) Exit");
            print(">> ");
            choice = readInt();
            switch (choice) {
                case 1:
                    gravFormula();
                    clearScreen();
                    break;
                case 2:
                    forceFormula();
                    clearScreen();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    println("\nInvalid input");
            }
        }
    }

    private void gravFormula(){
        clearScreen();
        while (true) {
            println("Universal Gravitation Formula: F = G * ((m1 * m2) / (r^2))");
            println("1.  Solve for F");
            println("2.  Solve for m1");
            println("3.  Solve for m2");
            println("4.  Solve for r");
            println("5.  Return to main menu");
            print(">> ");
            int choice = readInt();
            if (choice == 1) {
                println("What is the mass of the first object? (kg)");
                double m1 = readDouble();
                println("What is the mass of the second object? (kg)");
                double m2 = readDouble();
                println("What is the distance between the center of their masses? (m)");
                double r = readDouble();
                if (r == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                double F = 0.00000000006674 * ((m1 * m2) / (r * r));
                println("The gravitational force is " + F + " N");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (choice == 2 || choice == 3) {
                println("What is the gravitational force? (N)");
                double F = readDouble();
                println("What is the mass of the other object? (kg)");
                double m2 = readDouble();
                if (m2 == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the distance between the center of their masses? (m)");
                double r = readDouble();
                double m1 = (F * r * r) / (0.00000000006674 * m2);
                println("The mass is " + m1 + " kg");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (choice == 4) {
                println("What is the gravitational force? (N)");
                double F = readDouble();
                if (F == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the mass of the first object? (kg)");
                double m1 = readDouble();
                println("What is the mass of the second object? (kg)");
                double m2 = readDouble();
                double r = Math.sqrt((0.00000000006674 * m1 * m2) / F);
                println("The distance between the center of masses is " + r + " m");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (choice == 5) {
                return;
            }
            else {
                println("\nInvalid choice");
            }
        }
    }

    private void forceFormula(){
        clearScreen();
        while (true) {
            println("Centripetal Force Formula: F = m * v^2 / r");
            println("1.  Solve for F");
            println("2.  Solve for m");
            println("3.  Solve for v");
            println("4.  Solve for r");
            println("5.  Return to main menu");
            print(">> ");
            int choice = readInt();
            if (choice == 1) {
                println("What is the mass? (kg)");
                double m = readDouble();
                println("What is the velocity? (m/s)");
                double v = readDouble();
                println("What is the radius? (m)");
                double r = readDouble();
                if (r == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                double F = m * v * v / r;
                println("The centripetal force is " + F + " N");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (choice == 2) {
                println("What is the centripetal force? (N)");
                double F = readDouble();
                println("What is the velocity? (m/s)");
                double v = readDouble();
                if (v == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the radius? (m)");
                double r = readDouble();
                double m = F * r / (v * v);
                println("The mass is " + m + " kg");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (choice == 3) {
                println("What is the centripetal force? (N)");
                double F = readDouble();
                println("What is the mass? (kg)");
                double m = readDouble();
                if (m == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the radius? (m)");
                double r = readDouble();
                double v = Math.sqrt(F * r / m);
                println("The velocity is " + v + " m/s");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (choice == 4) {
                println("What is the centripetal force? (N)");
                double F = readDouble();
                if (F == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the mass? (kg)");
                double m = readDouble();
                println("What is the velocity? (m/s)");
                double v = readDouble();
                double r = m * v * v / F;
                println("The radius is " + r + " m");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (choice == 5) {
                return;
            }
            else {
                println("\nInvalid choice");
            }
        }
    }

    public void clearScreen() {
        for (int i = 0; i < 500; i++) {
            println();
        }
    }

    public static void main(String[] args) {
        new Module3_1_B().start(args);
    }
}
