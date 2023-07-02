import acm.program.*;
public class Module5_5 extends ConsoleProgram {

    private Matrix matrix;

    public void run() {
        int[] sizes = new int[4];
        println("Input no. of rows of 1st matrix:");
        sizes[0] = inputMatrixValue();

        println("\nInput no. of columns of 1st matrix:");
        sizes[1] = inputMatrixValue();

        println("\nInput no. of rows of 2nd matrix:");
        sizes[2] = inputMatrixValue();

        println("\nInput no. of columns of 2nd matrix:");
        sizes[3] = inputMatrixValue();

        matrix = new Matrix(sizes[0], sizes[1], sizes[2], sizes[3]);

        println("\n\n\nThe sizes of the matrices are " + matrix.getCols1() + "x" + matrix.getRows1() + " and " + matrix.getCols2() + "x" + matrix.getRows2());


        while (true) {
            displayMenu();

            int c = readInt();
            if ((c >= 3 && c <= 6) && (matrix.matricesContainValues())) {
                println("\n\n\nError: Please enter values for both matrices first.");
                continue;
            }

            if (c < 1 || c > 7) {
                println("\n\n\nError: Invalid choice");
                continue;
            }

            if (c == 1) {
                getMatrix1Values();
            }

            if (c == 2) {
                getMatrix2Values();
            }

            if (c == 3) {
                if(matrix.isSameSize()) {
                    println("\n\n\nError: Matrices must be the same size");
                    continue;
                }
                addMatrices();
            }

            if (c == 4) {
                if(matrix.isSameSize()) {
                    println("\n\n\nError: Matrices must be the same size");
                    continue;
                }
                subtractMatrices();
            }

            if (c == 5) {
                if(matrix.canBeMultiplied()) {
                    println("\n\n\nError: The matrices cannot be multiplied.");
                    continue;
                }
                multiplyMatrices();
            }

            if (c == 6) {
                transposeMatrices();
            }

            if (c == 7) {
                System.exit(0);
                println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }
    }

    private int inputMatrixValue() {
        int n = readInt();
        if (n < 1 || n > 3) {
            println("\nError: Value must be between 1 and 3.");
            n = inputMatrixValue();
        }
        return n;
    }

    private void displayMenu() {
        println("\nSelect an option: ");
        println("1) Enter values for 1st matrix");
        println("2) Enter values for 2nd matrix");
        println("3) Add matrices");
        println("4) Subtract matrices");
        println("5) Multiply matrices");
        println("6) Transpose matrices");
        println("7) Quit");
    }

    private void getMatrix1Values() {
        matrix.setMatrix1(matrix.getRows1(), matrix.getCols1());
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                println("\nEnter a value for number at row " + (i + 1) + " column " + (j + 1));
                matrix.setMatrix1Value(i, j, readDouble());
            }
        }

        println("\nMATRIX 1:");
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                printf("%12.2f ", matrix.getMatrix1Value(i, j));

            }println("");
        }
    }

    private void getMatrix2Values() {
        matrix.setMatrix2(matrix.getRows2(), matrix.getCols2());
        for (int i = 0; i < matrix.getRows2(); i++) {
            for (int j = 0; j < matrix.getCols2(); j++) {
                println("\nEnter a value for number at row " + (i + 1) + " column " + (j + 1));
                matrix.setMatrix2Value(i, j, readDouble());
            }
        }

        println("\nMATRIX 2:");
        for (int i = 0; i < matrix.getRows2(); i++) {
            for (int j = 0; j < matrix.getCols2(); j++) {
                printf("%12.2f ", matrix.getMatrix2Value(i, j));
            }println("");
        }
    }

    private void addMatrices() {
        matrix.setResult(matrix.getRows1(), matrix.getCols1());
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                matrix.setResultValue(i, j, matrix.getMatrix1Value(i, j) + matrix.getMatrix2Value(i, j));
            }println("");
        }

        println("\nMatrix 1 + Matrix 2:");
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                printf("%12.2f ", matrix.getResultValue(i, j));
            }println("");
        }
    }

    private void subtractMatrices() {
        matrix.setResult(matrix.getRows1(), matrix.getCols1());
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                matrix.setResultValue(i, j, matrix.getMatrix1Value(i, j) - matrix.getMatrix2Value(i, j));
            }println("");
        }

        println("\nMatrix 1 - Matrix 2:");
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                printf("%12.2f ", matrix.getResultValue(i, j));
            }println("");
        }
    }

    private void multiplyMatrices() {
        matrix.setResult(matrix.getRows1(), matrix.getCols2());
        for(int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols2(); j++) {
                for (int k = 0; k < matrix.getCols1(); k++) {
                    matrix.addToResult(i, j, matrix.getMatrix1Value(i, k) * matrix.getMatrix2Value(k, j));
                }
            }
        }

        println("\nMatrix 1 x Matrix 2:");
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols2(); j++) {
                printf("%12.2f ", matrix.getResultValue(i, j));
            }println("");
        }
    }

    private void transposeMatrices() {
        matrix.setResult(matrix.getCols1(), matrix.getRows1());
        for (int i = 0; i < matrix.getRows1(); i++) {
            for (int j = 0; j < matrix.getCols1(); j++) {
                matrix.setResultValue(j, i, matrix.getMatrix1Value(i, j));
            }println("");
        }

        println("\nMatrix 1 T:");
        for (int i = 0; i < matrix.getCols1(); i++) {
            for (int j = 0; j < matrix.getRows1(); j++) {
                printf("%12.2f ", matrix.getResultValue(i, j));
            }println("");
        }

        matrix.setResult(matrix.getCols2(), matrix.getRows2());
        for (int i = 0; i < matrix.getRows2(); i++) {
            for (int j = 0; j < matrix.getCols2(); j++) {
                matrix.setResultValue(j, i, matrix.getMatrix2Value(i, j));
            }println("");
        }

        println("Matrix 2 T:");
        for (int i = 0; i < matrix.getCols2(); i++) {
            for (int j = 0; j < matrix.getRows2(); j++) {
                printf("%12.2f ", matrix.getResultValue(i, j));
            }println("");
        }
    }

    // Solves java.lang.NoClassDefFoundError
    public static void main(String[] args) {
        (new Module5_5()).start(args);
    }
}
