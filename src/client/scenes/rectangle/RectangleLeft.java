package client.scenes.rectangle;

import client.scenes.ball.Ball;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RectangleLeft extends RectangleBase {

    private Ball ball;
    private Pane pane;
    private Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1.0/60), event -> {
        if(ball.getBallPosX().getValue() <  200 && ball.getBallXSpeed() < 0) {
            this.setRectangleHeight(ball.centerYProperty().add((-1 * ball.getBallYSpeed()) * (ball.centerXProperty().subtract(ball.radiusProperty()).getValue()) / ball.getBallXSpeed()).subtract(this.heightProperty().divide(2)).getValue());
        } else {
            setRectangleHeight(250);
        }
        this.setOnKeyPressed(event2 -> {
            switch (event2.getCode()){
                case W:
                    goDown();
                    System.out.println("up");
                    break;
                case S:
                    goUp();
                    System.out.println("down");
                    break;
            }
        });
        this.setOnKeyReleased(event2 -> {
            switch (event2.getCode()){
                case W:
                    stopDown();
                    break;
                case S:
                    stopUp();
                    break;
            }
        });
    }));

    public RectangleLeft(Pane pane){
        super(pane);
        this.pane = pane;
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/100));
    }

    public RectangleLeft(Pane pane, Ball ball){
        super(pane);
        this.ball = ball;
        this.pane = pane;
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/100));
    }

    public void startTimeline2(){
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }
}
