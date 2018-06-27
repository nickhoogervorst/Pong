package client.scenes.rectangle;

import javafx.scene.layout.Pane;

public class RectangleLeft extends RectangleBase {

    public RectangleLeft(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/50));
    }

}
