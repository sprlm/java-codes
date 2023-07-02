import stanford.karel.Karel;

public class MyKarel extends Karel {

    public void run() {
        goToNewspaper();
        pickBeeper();
        goToStart();
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void goToNewspaper() {
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
    }

    public void goToStart() {
        turnLeft();
        turnLeft();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
    }
}

