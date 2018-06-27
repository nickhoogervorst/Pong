package client.scenes.rectangle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleBase extends Rectangle {

    private Pane pane;

    public RectangleBase(Pane pane){
        this.pane = pane;
        this.layoutYProperty().setValue(250);
        this.widthProperty().setValue(30);
        this.heightProperty().setValue(100);
        this.setFill(Color.WHITE);
    }

    public void rectangleHeightUp(){
        if(this.layoutYProperty().getValue() <= pane.heightProperty().subtract(this.heightProperty()).getValue()) {
            this.layoutYProperty().setValue(this.layoutYProperty().add(5).getValue());
        }
    }

    public void rectangleHeightDown(){
        if(this.layoutYProperty().getValue() >= 0) {
            this.layoutYProperty().setValue(this.layoutYProperty().subtract(5).getValue());
        }
    }
}
