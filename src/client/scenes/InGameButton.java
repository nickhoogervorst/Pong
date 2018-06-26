package client.scenes;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class InGameButton extends Button {

    public InGameButton(String naam, Pane pane, double width) {
        super(naam);
        prefWidthProperty().bind(pane.widthProperty().divide((width)));
        prefHeightProperty().bind(pane.heightProperty().divide(10));
        setTextFill(Color.WHITE);
        setStyle("-fx-background-color: rgb(0,0,0); -fx-font-size: 1.8em;");
        setOnMouseEntered(event -> {
            setStyle("-fx-background-color: rgb(25,25,25); -fx-font-size: 1.8em;");
            setCursor(Cursor.HAND);
        });
        setOnMouseExited(event -> {
            setStyle("-fx-background-color: rgb(0,0,0); -fx-font-size: 1.8em;");
            setCursor(Cursor.DEFAULT);
        });
        this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

}
