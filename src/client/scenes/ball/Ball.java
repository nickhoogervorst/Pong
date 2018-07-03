package client.scenes.ball;

import client.scenes.game.GamePane;
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
    private int ballSpeed = 5;
    private double ballXSpeed;
    private double ballYSpeed;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        update();
        ballPosX.setValue(ballPosX.add(ballXSpeed).getValue());
        ballPosY.setValue(ballPosY.add(ballYSpeed).getValue());
    }));
    private Pane pane;

    public Ball(Pane pane){
        this.pane = pane;
        this.radiusProperty().bind(pane.heightProperty().divide(30));
        this.centerXProperty().bind(ballPosX);
        this.centerYProperty().bind(ballPosY);
        this.setFill(Color.WHITE);
        this.ballSpeed = GamePane.getBallSpeed();
        this.ballXSpeed = (Math.random() * (ballSpeed / 4) + ballSpeed);
        this.ballYSpeed = (Math.random() * (ballSpeed / 4) + ballSpeed);
    }

    public void startTimeLine(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    public void update(){
        if(ballPosY.getValue() >= pane.heightProperty().subtract(this.radiusProperty()).getValue() && ballYSpeed > 0){
            changeYDirection();
            System.out.println("south");
        }
        if(ballPosY.getValue() <= this.radiusProperty().getValue() && ballYSpeed < 0){
            changeYDirection();
            System.out.println("north");
        }
        if(ballPosX.getValue() >= pane.widthProperty().subtract(this.radiusProperty()).getValue() && ballXSpeed > 0){
            changeXDirection();
            System.out.println("east");
        }
        if(ballPosX.getValue() <= this.radiusProperty().getValue() && ballXSpeed < 0){
            changeXDirection();
            System.out.println("west");
        }
    }

    public void changeYDirection(){
        ballYSpeed *= -1;
    }

    public void changeXDirection(){
        ballXSpeed *= -1;
    }

    public DoubleProperty getBallPosY(){
        return ballPosY;
    }

    public DoubleProperty getBallPosX(){
        return ballPosX;
    }

    public double getBallXSpeed() { return ballXSpeed; }

    public double getBallYSpeed() { return ballYSpeed; }

    public void reset(){
        ballPosX.setValue(500);
        ballPosY.setValue(300);
        ballXSpeed = (Math.random() * (ballSpeed / 4) + ballSpeed);
        ballYSpeed = (Math.random() * (ballSpeed / 4) + ballSpeed);
    }

}
