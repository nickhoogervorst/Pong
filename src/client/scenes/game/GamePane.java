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
    private Boolean rectangleLeftUp = false;
    private Boolean rectangleLeftDown = false;
    private Boolean rectangleRightUp = false;
    private Boolean rectangleRightDown = false;
    private Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        if(rectangleLeftUp){
            rectangleLeft.rectangleHeightUp();
        }
        if(rectangleLeftDown){
            rectangleLeft.rectangleHeightDown();
        }
        if(rectangleRightUp){
            rectangleRight.rectangleHeightUp();
        }
        if(rectangleRightDown){
            rectangleRight.rectangleHeightDown();
        }
    }));

    public GamePane(SceneChanger sceneChanger){
        this.getChildren().addAll(rectangleLeft, rectangleRight, ball);
        ball.startTimeLine();
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
        this.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case ESCAPE:
                    sceneChanger.createStartScreen();
                    break;
                case W:
                    rectangleLeftDown = true;
                    break;
                case S:
                    rectangleLeftUp = true;
                    break;
                case UP:
                    rectangleRightDown = true;
                    break;
                case DOWN:
                    rectangleRightUp = true;
                    break;
            }
        });
        this.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case W:
                    rectangleLeftDown = false;
                    break;
                case S:
                    rectangleLeftUp = false;
                    break;
                case UP:
                    rectangleRightDown = false;
                    break;
                case DOWN:
                    rectangleRightUp = false;
                    break;
            }
        });
    }

}
