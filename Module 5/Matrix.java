class Matrix {

    private int rows1;
    private int cols1;
    private int rows2;
    private int cols2;

    private double[][] matrix1;
    private double[][] matrix2;
    private double[][] result;

    Matrix(int rows1, int cols1, int rows2, int cols2) {
        this.rows1 = rows1;
        this.cols1 = cols1;
        this.rows2 = rows2;
        this.cols2 = cols2;
    }

    boolean matricesContainValues() {
        return (matrix1 == null || matrix2 == null);
    }

    void setMatrix1(int x, int y) {
        this.matrix1 = new double[x][y];
    }

    double getMatrix1Value(int i, int j) {
        return this.matrix1[i][j];
    }

    void setMatrix1Value(int i, int j, double value) {
        this.matrix1[i][j] = value;
    }

    void setMatrix2(int x, int y) {
        this.matrix2 = new double[x][y];
    }

    double getMatrix2Value(int i, int j) {
        return this.matrix2[i][j];
    }

    void setMatrix2Value(int i, int j, double value) {
        this.matrix2[i][j] = value;
    }

    void setResult(int x, int y) {
        this.result = new double[x][y];
    }

    double getResultValue(int i, int j) {
        return this.result[i][j];
    }

    void addToResult(int i, int j, double value) {
        this.result[i][j] += value;
    }

    void setResultValue(int i, int j, double value) {
        this.result[i][j] = value;
    }

    int getRows1() {
        return rows1;
    }

    int getCols1() {
        return cols1;
    }

    int getRows2() {
        return rows2;
    }

    int getCols2() {
        return cols2;
    }

    boolean isSameSize() {
        return (rows1 != rows2 || cols1 != cols2);
    }

    boolean canBeMultiplied() {
        return cols1 != rows2;
    }
}
