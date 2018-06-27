package client.scenes.rectangle;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RectangleRight extends RectangleBase {

    public RectangleRight(Pane pane){
        super(pane);
        this.layoutYProperty().bind(pane.heightProperty().divide(2).subtract(this.heightProperty().divide(2)));
        this.layoutXProperty().bind(pane.widthProperty().multiply(49.0/50).subtract(this.widthProperty()));
    }

}
