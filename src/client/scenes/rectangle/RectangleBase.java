package client.scenes.rectangle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RectangleBase extends Rectangle {

    private Pane pane;
    private Boolean rectangleDown = false;
    private Boolean rectangleUp = false;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        if(rectangleUp){
            rectangleHeightUp();
        }
        if(rectangleDown){
            rectangleHeightDown();
        }
    }));

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

    public void startTimeline(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    public void goUp(){
        rectangleUp = true;
    }

    public void goDown(){
        rectangleDown = true;
    }

    public void stopUp(){
        rectangleUp = false;
    }

    public void stopDown(){
        rectangleDown = false;
    }
}
