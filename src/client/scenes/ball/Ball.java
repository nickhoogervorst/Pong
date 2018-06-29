package client.scenes.ball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {

    private DoubleProperty ballPosX = new SimpleDoubleProperty(500);
    private DoubleProperty ballPosY = new SimpleDoubleProperty(300);
    private int speed = 5;
    private int ballXSpeed = speed;
    private int ballYSpeed = speed;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        ballPosX.setValue(ballPosX.add(ballXSpeed).getValue());
        ballPosY.setValue(ballPosY.add(ballYSpeed).getValue());
        update();
    }));
    private Pane pane;

    public Ball(Pane pane){
        this.pane = pane;
        this.radiusProperty().bind(pane.heightProperty().divide(30));
        this.centerXProperty().bind(ballPosX);
        this.centerYProperty().bind(ballPosY);
        this.setFill(Color.WHITE);
    }

    public void startTimeLine(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    public void update(){
        if(ballPosY.getValue() >= pane.heightProperty().subtract(this.radiusProperty()).getValue() && ballYSpeed > 0){
            changeYDirection();
        }
        if(ballPosY.getValue() <= this.radiusProperty().getValue() && ballYSpeed < 0){
            changeYDirection();
        }
        if(ballPosX.getValue() >= pane.widthProperty().subtract(this.radiusProperty()).getValue() && ballXSpeed > 0){
            changeXDirection();
        }
        if(ballPosX.getValue() <= this.radiusProperty().getValue() && ballXSpeed < 0){
            changeXDirection();
        }
    }

    public void changeYDirection(){
        ballYSpeed *= -1;
    }

    public void changeXDirection(){
        ballXSpeed *= -1;
    }

}
