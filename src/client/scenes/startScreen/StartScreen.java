package client.scenes.startScreen;

import client.scenes.BasePane;
import client.scenes.InGameButton;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;
import client.scenes.sceneMVC.SceneChanger;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class StartScreen extends BasePane {

    private Label title = new Label("Pong");
    private RectangleLeft rectangleLeft = new RectangleLeft(this);
    private RectangleRight rectangleRight = new RectangleRight(this);
    private VBox vbox = new VBox();

    public StartScreen(SceneChanger sceneChanger){

        title.setStyle("-fx-font-size: 4em;");
        title.setTextFill(Color.WHITE);
        title.layoutXProperty().bind(this.widthProperty().divide(2).subtract(title.widthProperty().divide(2)));
        title.layoutYProperty().bind(this.heightProperty().divide(20));

        InGameButton start = new InGameButton("Start", this, 3);
        InGameButton exit = new InGameButton("Exit", this, 3);

        start.setOnAction(event -> sceneChanger.startGame());
        exit.setOnAction(event -> System.exit(0));

        vbox.getChildren().addAll(start, exit);
        vbox.layoutXProperty().bind(this.widthProperty().divide(2).subtract(vbox.widthProperty().divide(2)));
        vbox.layoutYProperty().bind(this.heightProperty().divide(2).subtract(vbox.heightProperty().divide(2)));
        vbox.setSpacing(20);

        this.getChildren().addAll(title, rectangleLeft, rectangleRight, vbox);

    }

}
