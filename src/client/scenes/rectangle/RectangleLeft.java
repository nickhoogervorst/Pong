package client.scenes.rectangle;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RectangleLeft extends RectangleBase {

    public RectangleLeft(Pane pane){
        super(pane);
        this.layoutYProperty().bind(pane.heightProperty().divide(2).subtract(this.heightProperty().divide(2)));
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/50));
    }

}
