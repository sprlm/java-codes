import stanford.karel.Karel;

public class StoneKarel extends Karel {

    public void run() {
        while (frontIsClear()) {
            fillColumn();
            if (frontIsClear()) {
                moveFourSpaces();
            }
        }
        fillColumn();
    }

    public void moveFourSpaces() {
        move();
        move();
        move();
        move();
    }

    public void turnAround() {
        turnLeft();
        turnLeft();
    }

    public void moveForward() {
        if (noBeepersPresent()) {
            putBeeper();
        }
        while (frontIsClear()) {
            if (noBeepersPresent()) {
                putBeeper();
            }
            move();
        }
    }

    public void fillColumn() {
        turnLeft();
        moveForward();
        turnAround();
        moveForward();
        turnLeft();
    }
}