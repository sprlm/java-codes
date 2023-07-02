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

        createFlag(0, 0);

        Arc arc = new Arc(100, 100, 40, 40, 45, 270);
        arc.relocate(90, 160);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.YELLOW);
        arc.setStroke(Color.BLACK);
        canvas.getChildren().add(arc);

        SVGPath strawberry = new SVGPath();
        strawberry.setContent("M 250 200 Q 150 200 150 300 Q 250 550 350 300 Q 350 200 250 200");
        strawberry.setFill(Color.RED);
        strawberry.setStroke(Color.BLACK);
        strawberry.setScaleX(.5);
        strawberry.setScaleY(.5);
        strawberry.relocate(500, 200);
        canvas.getChildren().add(strawberry);

        Polyline stem = new Polyline();
        stem.getPoints().addAll(0.0, 0.0,
                10.0, 0.0,
                10.0, 20.0,
                0.0, 20.0,
                0.0, 0.0);
        stem.setFill(Color.BROWN);
        stem.setStroke(Color.BLACK);
        stem.relocate(595, 238);
        canvas.getChildren().add(stem);

        QuadCurve curve = new QuadCurve(0, 0, 50, 40, 100, 0);
        curve.relocate(400, 100);
        curve.setFill(Color.WHITESMOKE);
        canvas.getChildren().add(curve);

        Ellipse leftEye = new Ellipse(10, 20);
        leftEye.setFill(Color.BLUE);
        leftEye.relocate(420, 25);
        canvas.getChildren().add(leftEye);

        Ellipse rightEye = new Ellipse(10, 20);
        rightEye.setFill(Color.GREEN);
        rightEye.relocate(460, 25);
        canvas.getChildren().add(rightEye);

        Text text = new Text(650, 380, "created by Matthew Toro");
        text.setFill(Color.LIGHTGRAY);
        canvas.getChildren().add(text);

        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Artistry");
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
