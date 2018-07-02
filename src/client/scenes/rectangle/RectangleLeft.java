package client.scenes.rectangle;

import javafx.scene.layout.Pane;

public class RectangleLeft extends RectangleBase {

    public RectangleLeft(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/100));
        this.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case W:
                    goDown();
                    break;
                case S:
                    goUp();
                    break;
            }
        });
        this.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case W:
                    stopDown();
                    break;
                case S:
                    stopUp();
                    break;
            }
        });
    }
}
