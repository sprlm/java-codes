import acm.program.*;

public class Module5_4 extends ConsoleProgram {

    public void run() {
        int choice;
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
        GravityFormula f1 = new GravityFormula();
        clearScreen();
        while (true) {
            println("Universal Gravitation Formula: F = G * ((m1 * m2) / (r^2))");
            println("1.  Solve for F");
            println("2.  Solve for m1");
            println("3.  Solve for m2");
            println("4.  Solve for r");
            println("5.  Return to main menu");
            print(">> ");
            f1.setChoice(readInt());
            if (f1.getChoice() == 1) {
                println("What is the mass of the first object? (kg)");
                f1.setM1(readDouble());
                println("What is the mass of the second object? (kg)");
                f1.setM2(readDouble());
                println("What is the distance between the center of their masses? (m)");
                f1.setR(readDouble());
                if (f1.getR() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("The gravitational force is " + f1.solveF() + " N");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (f1.getChoice() == 2 || f1.getChoice() == 3) {
                println("What is the gravitational force? (N)");
                f1.setF(readDouble());
                println("What is the mass of the other object? (kg)");
                f1.setM2(readDouble());
                if (f1.getM2() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the distance between the center of their masses? (m)");
                f1.setR(readDouble());
                println("The mass is " + f1.solveM() + " kg");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (f1.getChoice() == 4) {
                println("What is the gravitational force? (N)");
                f1.setF(readDouble());
                if (f1.getF() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the mass of the first object? (kg)");
                f1.setM1(readDouble());
                println("What is the mass of the second object? (kg)");
                f1.setM2(readDouble());
                println("The distance between the center of masses is " + f1.solveR() + " m");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (f1.getChoice() == 5) {
                return;
            }
            else {
                println("\nInvalid choice");
            }
        }
    }

    private void forceFormula(){
        ForceFormula f2 = new ForceFormula();
        clearScreen();
        while (true) {
            println("Centripetal Force Formula: F = m * v^2 / r");
            println("1.  Solve for F");
            println("2.  Solve for m");
            println("3.  Solve for v");
            println("4.  Solve for r");
            println("5.  Return to main menu");
            print(">> ");
            f2.setChoice(readInt());
            if (f2.getChoice() == 1) {
                println("What is the mass? (kg)");
                f2.setM(readDouble());
                println("What is the velocity? (m/s)");
                f2.setV(readDouble());
                println("What is the radius? (m)");
                f2.setR(readDouble());
                if (f2.getM() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("The centripetal force is " + f2.solveF() + " N");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (f2.getChoice() == 2) {
                println("What is the centripetal force? (N)");
                f2.setF(readDouble());
                println("What is the velocity? (m/s)");
                f2.setV(readDouble());
                if (f2.getV() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the radius? (m)");
                f2.setR(readDouble());
                println("The mass is " + f2.solveM() + " kg");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (f2.getChoice() == 3) {
                println("What is the centripetal force? (N)");
                f2.setF(readDouble());
                println("What is the mass? (kg)");
                f2.setM(readDouble());
                if (f2.getM() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the radius? (m)");
                f2.setR(readDouble());
                println("The velocity is " + f2.solveV() + " m/s");
                readLine("Enter any key to continue");
                clearScreen();
            }
            if (f2.getChoice() == 4) {
                println("What is the centripetal force? (N)");
                f2.setF(readDouble());
                if (f2.getF() == 0) {
                    println("\nERROR: The value cannot be 0\n");
                    continue;
                }
                println("What is the mass? (kg)");
                f2.setM(readDouble());
                println("What is the velocity? (m/s)");
                f2.setV(readDouble());
                println("The radius is " + f2.solveR() + " m");
                readLine("Enter any key to continue");
                clearScreen();
            }
            else if (f2.getChoice() == 5) {
                return;
            }
            else {
                println("\nInvalid choice");
            }
        }
    }

    private void clearScreen() {
        for (int i = 0; i < 500; i++) {
            println();
        }
    }

    public static void main(String[] args) {
        new Module5_4().start(args);
    }
}
