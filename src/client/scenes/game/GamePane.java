package client.scenes.game;

import client.scenes.BasePane;
import client.scenes.ball.Ball;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;
import client.scenes.sceneMVC.SceneChanger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GamePane extends BasePane {

    private RectangleLeft rectangleLeft = new RectangleLeft(this);
    private RectangleRight rectangleRight = new RectangleRight(this);
    private Ball ball = new Ball(this);
    private Collision collision = new Collision(rectangleLeft, rectangleRight, ball);
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> this.rectangleLeft.requestFocus()));

    public GamePane(SceneChanger sceneChanger){
        this.getChildren().addAll(this.rectangleLeft, this.rectangleRight, this.ball);
        this.ball.startTimeLine();
        this.rectangleLeft.startTimeline();
        this.rectangleRight.startTimeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

}
