package client.scenes.rectangle;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleBase extends Rectangle {
    public RectangleBase(Pane pane){
        this.widthProperty().bind(pane.widthProperty().divide(25));
        this.heightProperty().bind(pane.heightProperty().divide(6));
        this.setFill(Color.WHITE);
    }
}
