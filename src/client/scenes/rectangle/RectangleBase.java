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

    RectangleBase(Pane pane){
        this.pane = pane;
        this.layoutYProperty().setValue(250);
        this.widthProperty().setValue(30);
        this.heightProperty().setValue(100);
        this.setFill(Color.WHITE);
    }

    private void rectangleHeightUp(){
        if(this.layoutYProperty().getValue() <= pane.heightProperty().subtract(this.heightProperty()).getValue()) {
            this.layoutYProperty().setValue(this.layoutYProperty().add(5).getValue());
        }
    }

    private void rectangleHeightDown(){
        if(this.layoutYProperty().getValue() >= 0) {
            this.layoutYProperty().setValue(this.layoutYProperty().subtract(5).getValue());
        }
    }

    public void startTimeline(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
        System.out.println("timeline started");
    }

    void goUp(){
        rectangleUp = true;
    }

    void goDown(){
        rectangleDown = true;
    }

    void stopUp(){
        rectangleUp = false;
    }

    void stopDown(){
        rectangleDown = false;
    }
}
