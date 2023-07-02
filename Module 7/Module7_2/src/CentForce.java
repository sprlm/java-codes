public class CentForce implements IFormula{
    private final String[] parameterList = {"Mass","Velocity","Radius","Force"};
    private double force; // Centripetal Force
    private double mass;   //  Mass
    private double velocity;   //  Velocity
    private double radius;    //  Radius

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void computeForce() {
        force = mass * velocity * velocity / radius;
    }

    public void computeMass() {
        mass = force * radius / (velocity * velocity);
    }

    public void computeVelocity() {
        velocity = Math.sqrt(force * radius / mass);
    }

    public void computeRadius() {
        radius = mass * velocity * velocity / force;
    }

    @Override
    public double compute(String variable, String[] values) {
        if (variable == null) {
            return 0;
        }
        if (variable.equalsIgnoreCase("Force")) {
            mass = Double.parseDouble(values[0]);
            velocity = Double.parseDouble(values[1]);
            radius = Double.parseDouble(values[2]);
            computeForce();
            return force;

        } else if (variable.equalsIgnoreCase("Mass")) {
            force = Double.parseDouble(values[0]);
            velocity = Double.parseDouble(values[1]);
            radius = Double.parseDouble(values[2]);
            computeMass();
            return mass;

        } else if (variable.equalsIgnoreCase("Velocity")) {
            radius = Double.parseDouble(values[0]);
            force = Double.parseDouble(values[1]);
            mass = Double.parseDouble(values[2]);
            computeVelocity();
            return velocity;

        } else if (variable.equalsIgnoreCase("Radius")) {
            force = Double.parseDouble(values[0]);
            mass = Double.parseDouble(values[1]);
            velocity = Double.parseDouble(values[2]);
            computeRadius();
            return radius;
        }
        return 0;
    }

    @Override
    public String[] getParameterList() {
        return parameterList;
    }
}
