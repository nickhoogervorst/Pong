package client.scenes.game;

import client.scenes.ball.Ball;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Collision {

    private RectangleLeft rectangleLeft;
    private RectangleRight rectangleRight;
    private Ball ball;
    private GamePane pane;
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> this.update()));

    public Collision(GamePane pane, RectangleLeft rectangleLeft, RectangleRight rectangleRight, Ball ball){
        this.rectangleLeft = rectangleLeft;
        this.rectangleRight = rectangleRight;
        this.ball = ball;
        this.pane = pane;
    }

    public void startTimeline(){
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void update(){
        if(ball.getBallPosX().getValue() <= rectangleLeft.layoutXProperty().add(rectangleLeft.widthProperty()).add(ball.radiusProperty()).getValue() && ball.getBallPosY().getValue() >= rectangleLeft.layoutYProperty().subtract(ball.radiusProperty()).getValue() && ball.getBallPosY().getValue() <= rectangleLeft.layoutYProperty().add(rectangleLeft.heightProperty()).getValue() && ball.getBallXSpeed() < 0){
            this.ball.changeXDirection();
        }
        if(ball.getBallPosX().getValue() <= ball.radiusProperty().getValue()){
            pane.givePlayer2Point();
            ball.reset();
        }
        if(ball.getBallPosX().getValue() >= pane.widthProperty().subtract(ball.radiusProperty()).getValue()){
            pane.givePlayer1Point();
            ball.reset();
        }
    }

}
