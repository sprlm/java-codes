class GravityFormula {

    private double f, m1, m2, r;
    private int choice;

    double solveF() {
        return (0.00000000006674 * ((m1 * m2) / (r * r)));
    }

    double solveM() {
        return((f * r * r) / (0.00000000006674 * m2));
    }

    double solveR() {
        return(Math.sqrt((0.00000000006674 * m1 * m2) / f));
    }

    void setF(double f) {
        this.f = f;
    }

    void setM1(double m1) {
        this.m1 = m1;
    }

    void setM2(double m2) {
        this.m2 = m2;
    }

    void setR(double r) {
        this.r = r;
    }

    void setChoice(int choice) {
        this.choice = choice;
    }

    double getF() {
        return f;
    }

    double getM2() {
        return m2;
    }

    double getR() {
        return r;
    }

    int getChoice() {
        return choice;
    }
}
