package client.scenes.game;

import client.scenes.BasePane;
import client.scenes.ball.Ball;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GamePane extends BasePane {

    private int player1Points = 0;
    private int player2Points = 0;
    private static int rectSpeed = 20;
    private static int ballSpeed = 15;
    private Ball ball = new Ball(this);
    private Label points = new Label(player1Points + " : " + player2Points);
    private RectangleLeft rectangleLeft = new RectangleLeft(this, ball);
    private RectangleRight rectangleRight = new RectangleRight(this, ball);
    private Collision collision = new Collision(this, rectangleLeft, rectangleRight, ball);
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        this.rectangleLeft.requestFocus();
        this.points.setText(player1Points + " : " + player2Points);
        if(player1Points == 5 || player2Points == 5){
            System.out.println("Player 1: " + player1Points);
            System.out.println("Player 2: " + player2Points);
            System.exit(0);
        }
    }));

    public GamePane(){
        this.getChildren().addAll(this.points, this.rectangleLeft, this.rectangleRight, this.ball);
        this.ball.startTimeLine();
        this.rectangleLeft.startTimeline();
        this.rectangleLeft.startTimeline2();
        this.rectangleRight.startTimeline();
        this.rectangleRight.startTimeline2();
        this.collision.startTimeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
        this.points.layoutYProperty().bind(this.heightProperty().divide(30));
        this.points.layoutXProperty().bind(this.widthProperty().divide(2).subtract(this.points.widthProperty()));
        this.points.setTextFill(Color.WHITE);
    }

    public void givePlayer1Point(){
        player1Points++;
    }

    public void givePlayer2Point(){
        player2Points++;
    }

    public static int getBallSpeed(){
        return ballSpeed;
    }

    public static int getRectSpeed(){
        return rectSpeed;
    }

}
