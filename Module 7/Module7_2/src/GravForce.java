public class GravForce implements IFormula {
    private final String[] parameterList = {"M1","M2","Distance","Force"};
    private double force; // Gravitational Force
    private double m1;   //  Mass of object 1
    private double m2;   //  Mass of object 2
    private double distance;    //  Distance between center of two masses
    private final double G = 0.00000000006674;  // Gravitational constant

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getM1() {
        return m1;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void computeForce() {
        force = G * ((m1 * m2) / (distance * distance));
    }

    public void computeM1() {
        m1 = (force * distance * distance) / (0.00000000006674 * m2);
    }

    public void computeM2() {
        m2 = (force * distance * distance) / (0.00000000006674 * m1);
    }

    public void computeDistance() {
        distance = Math.sqrt((G * m1 * m2) / force);
    }

    @Override
    public double compute(String variable, String[] values) {
        if (variable == null) {
            return 0;
        }
        if (variable.equalsIgnoreCase("Force")) {
            m1 = Double.parseDouble(values[0]);
            m2 = Double.parseDouble(values[1]);
            distance = Double.parseDouble(values[2]);
            computeForce();
            return force;

        } else if (variable.equalsIgnoreCase("M1")) {
            m2 = Double.parseDouble(values[0]);
            distance = Double.parseDouble(values[1]);
            force = Double.parseDouble(values[2]);
            computeM1();
            return m1;

        } else if (variable.equalsIgnoreCase("M2")) {
            distance = Double.parseDouble(values[0]);
            force = Double.parseDouble(values[1]);
            m1 = Double.parseDouble(values[2]);
            computeM2();
            return m2;

        } else if (variable.equalsIgnoreCase("distance")) {
            force = Double.parseDouble(values[0]);
            m1 = Double.parseDouble(values[1]);
            m2 = Double.parseDouble(values[2]);
            computeDistance();
            return distance;
        }
        return 0;
    }

    @Override
    public String[] getParameterList() {
        return parameterList;
    }
}
