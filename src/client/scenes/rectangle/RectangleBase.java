package client.scenes.rectangle;

import client.scenes.game.GamePane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RectangleBase extends Rectangle {

    private Pane pane;
    private Boolean rectangleDown = false;
    private Boolean rectangleUp = false;
    private DoubleProperty rectangleHeight;
    private int rectSpeed = 10;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        if(rectangleUp){
            rectangleHeightUp();
        }
        if(rectangleDown){
            rectangleHeightDown();
        }
        if(this.layoutYProperty().getValue() > rectangleHeight.getValue() && this.layoutYProperty().getValue() > 0){
            this.layoutYProperty().setValue(this.layoutYProperty().getValue() - rectSpeed);
        }
        if(this.layoutYProperty().getValue() < rectangleHeight.getValue() && this.layoutYProperty().getValue() < 500){
            this.layoutYProperty().setValue(this.layoutYProperty().getValue() + rectSpeed);
        }
    }));

    RectangleBase(Pane pane){
        this.pane = pane;
        this.layoutYProperty().setValue(250);
        this.rectangleHeight = new SimpleDoubleProperty(250);
        this.widthProperty().setValue(30);
        this.heightProperty().setValue(100);
        this.setFill(Color.WHITE);
        this.rectSpeed = GamePane.getRectSpeed();
        System.out.println(rectSpeed);
    }

    void rectangleHeightUp(){
        if(rectangleHeight.getValue() < 500) {
            rectangleHeight.setValue(rectangleHeight.getValue() + rectSpeed);
        }
    }

    void rectangleHeightDown(){
        if(rectangleHeight.getValue() > 0) {
            rectangleHeight.setValue(rectangleHeight.getValue() - rectSpeed);
        }
    }

    public void startTimeline(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    public void setRectangleHeight(double i){
        this.rectangleHeight.setValue(i);
    }

    DoubleProperty getRectangleHeight(){
        return  rectangleHeight;
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
