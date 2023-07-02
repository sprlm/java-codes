import stanford.karel.Karel;

public class CheckerboardKarel extends Karel {

    public void run() {
        while (true) {
            putBeeper();
            fillRow();
            if (facingEast()) {
                turnLeft();
                if (frontIsBlocked()) {break;}
                if (beepersPresent()) {
                    if (frontIsClear()) {move();}
                    turnLeft();
                    if (frontIsClear()) {move();}
                    else {
                        turnRight();
                        if (frontIsClear()) {move();}
                        else {break;}
                        turnRight();
                    }
                }
                else {
                    if (frontIsClear()) {move();}
                    turnLeft();
                }
            }
            else {
                turnRight();
                if (frontIsBlocked()) {break;}
                if (beepersPresent()) {
                    if (frontIsClear()) {move();}
                    turnRight();
                    if (frontIsClear()) {move();}
                    else {
                        turnLeft();
                        if (frontIsClear()) {move();}
                        else {break;}
                        turnLeft();
                    }
                }
                else {
                    if (frontIsClear()) {move();}
                    turnRight();
                }
            }
        }
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void fillRow() {
        while (true) {
            if (frontIsClear()) {
                move();
            }
            else {break;}
            if (frontIsClear()) {
                move();
            }
            else {break;}
            putBeeper();
        }
    }
}
