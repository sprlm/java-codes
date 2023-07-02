package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        canvas.setPrefSize(800, 400);

        Rectangle blue = new Rectangle(800,200, Color.rgb(0, 56, 168));

        Rectangle red = new Rectangle(800,200,Color.rgb(206, 17, 38));
        red.relocate(0, 200);

        Polygon white = new Polygon();
        white.getPoints().addAll(
                0.0, 0.0,
                0.0, 400.0,
                346.41, 200.0
        );
        white.setFill(Color.WHITE);

        Path star1 = createStar(10, 30, 0);
        Path star2 = createStar(10, 330, 36);
        Path star3 = createStar(275, 179, 198);

        Circle circle = new Circle(130,200,40, Color.rgb(252, 209, 22));

        canvas.getChildren().addAll(blue, red, white, star1, star2, star3, circle);

        for (int i = 0; i < 4; i++) {
            Polygon ray = new Polygon();
            ray.getPoints().addAll(
                    130.0, 200.0,
                    120.0, 130.0,
                    130.0, 110.0,
                    140.0, 130.0,
                    130.0, 200.0,
                    140.0, 270.0,
                    130.0, 290.0,
                    120.0, 270.0

            );
            ray.setRotate(i * 45);
            ray.setFill(Color.rgb(252, 209, 22));
            canvas.getChildren().add(ray);
        }

        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Philippine Flag");
        primaryStage.show();
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
