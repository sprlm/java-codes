package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private Pane canvas;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Pane();
        canvas.setPrefSize(800, 400);

        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                createFlag(row * 800 - 3600, col * 400 - 1800);
                canvas.setScaleX(.1);
                canvas.setScaleY(.1);
            }
        }

        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flag Array");
        primaryStage.show();
    }

    private void createFlag(double x, double y) {
        Rectangle blue = new Rectangle(800,200, Color.rgb(0, 56, 168));
        blue.relocate(x, y);

        Rectangle red = new Rectangle(800,200,Color.rgb(206, 17, 38));
        red.relocate(x, y + 200);

        Polygon white = new Polygon();
        white.getPoints().addAll(
                x, y,
                x, y + 400.0,
                x + 346.41, y + 200.0
        );
        white.setFill(Color.WHITE);

        Path star1 = createStar(x + 10, y + 30, 0);
        Path star2 = createStar(x + 10, y + 330, 36);
        Path star3 = createStar(x + 275, y + 179, 198);

        Circle circle = new Circle(x + 130,y + 200,40, Color.rgb(252, 209, 22));

        canvas.getChildren().addAll(blue, red, white, star1, star2, star3, circle);

        for (int i = 0; i < 4; i++) {
            Polygon ray = new Polygon();
            ray.getPoints().addAll(
                    x + 130.0, y + 200.0,
                    x + 120.0, y + 130.0,
                    x + 130.0, y + 110.0,
                    x + 140.0, y + 130.0,
                    x + 130.0, y + 200.0,
                    x + 140.0, y + 270.0,
                    x + 130.0, y + 290.0,
                    x + 120.0, y + 270.0

            );
            ray.setRotate(i * 45);
            ray.setFill(Color.rgb(252, 209, 22));
            canvas.getChildren().add(ray);
        }
    }

    private Path createStar(double x, double y, double r) {
        Path star = new Path();
        star.getElements().addAll(new MoveTo(0, 18),
                new LineTo(4, 4),
                new LineTo(18, 4),
                new LineTo(7, -5),
                new LineTo(11, -19),
                new LineTo(0, -10),
                new LineTo(-11, -19),
                new LineTo(0, -10),
                new LineTo(-11, -19),
                new LineTo(-7, -5),
                new LineTo(-19, 4),
                new LineTo(-4, 4),
                new ClosePath());
        star.relocate(x,y);
        star.setRotate(r);
        star.setFill(Color.rgb(252, 209, 22));
        star.setStroke(Color.rgb(252, 209, 22));
        return star;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
