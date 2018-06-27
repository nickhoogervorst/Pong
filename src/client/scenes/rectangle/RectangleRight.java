package client.scenes.rectangle;

import javafx.scene.layout.Pane;

public class RectangleRight extends RectangleBase {

    public RectangleRight(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(49.0/50).subtract(this.widthProperty()));
    }

}
