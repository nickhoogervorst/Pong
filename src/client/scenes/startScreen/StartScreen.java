package client.scenes.startScreen;

import client.scenes.InGameButton;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class StartScreen extends Pane {

    private Label title = new Label("Pong");
    private Rectangle rectangle1 = new Rectangle();
    private Rectangle rectangle2 = new Rectangle();
    private VBox vbox = new VBox();


    public StartScreen(){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, new Insets(0))));
        this.setPrefSize(800, 600);

        title.setStyle("-fx-font-size: 4em;");
        title.setTextFill(Color.WHITE);
        title.layoutXProperty().bind(this.widthProperty().divide(2).subtract(title.widthProperty().divide(2)));
        title.layoutYProperty().bind(this.heightProperty().divide(20));

        rectangle1.widthProperty().bind(this.widthProperty().divide(25));
        rectangle1.heightProperty().bind(this.heightProperty().divide(6));
        rectangle1.setFill(Color.WHITE);
        rectangle1.layoutYProperty().bind(this.heightProperty().divide(2).subtract(rectangle1.heightProperty().divide(2)));
        rectangle1.layoutXProperty().bind(this.widthProperty().multiply(1.0/50));
        rectangle2.widthProperty().bind(this.widthProperty().divide(25));
        rectangle2.heightProperty().bind(this.heightProperty().divide(6));
        rectangle2.setFill(Color.WHITE);
        rectangle2.layoutYProperty().bind(this.heightProperty().divide(2).subtract(rectangle2.heightProperty().divide(2)));
        rectangle2.layoutXProperty().bind(this.widthProperty().multiply(49.0/50).subtract(rectangle2.widthProperty()));

        InGameButton start = new InGameButton("Start", this, 3);
        InGameButton exit = new InGameButton("Exit", this, 3);

        exit.setOnAction(event -> System.exit(0));

        vbox.getChildren().addAll(start, exit);
        vbox.layoutXProperty().bind(this.widthProperty().divide(2).subtract(vbox.widthProperty().divide(2)));
        vbox.layoutYProperty().bind(this.heightProperty().divide(2).subtract(vbox.heightProperty().divide(2)));
        vbox.setSpacing(20);

        this.getChildren().addAll(title, rectangle1, rectangle2, vbox);

    }

}
