class ForceFormula {

    private double f, m, v, r;
    private int choice;

    double solveF() {
        return m * v * v / r;
    }

    double solveM() {
        return f * r / (v * v);
    }

    double solveV() {
        return Math.sqrt(f * r / m);
    }

    double solveR() {
        return  m * v * v / f;
    }

    double getF() {
        return f;
    }

    void setF(double f) {
        this.f = f;
    }

    double getM() {
        return m;
    }

    void setM(double m) {
        this.m = m;
    }

    double getV() {
        return v;
    }

    void setV(double v) {
        this.v = v;
    }

    void setR(double r) {
        this.r = r;
    }

    int getChoice() {
        return choice;
    }

    void setChoice(int choice) {
        this.choice = choice;
    }
}
