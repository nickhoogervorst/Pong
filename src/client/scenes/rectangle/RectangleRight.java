package client.scenes.rectangle;

import client.scenes.ball.Ball;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RectangleRight extends RectangleBase {

    private Ball ball;
    private Pane pane;
    private Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1.0/60), event -> {
        if(ball.getBallPosX().getValue() > 800 && ball.getBallXSpeed() > 0) {
            this.setRectangleHeight(ball.centerYProperty().add(ball.getBallYSpeed() * (pane.widthProperty().getValue() - ball.centerXProperty().add(ball.radiusProperty()).getValue() - (pane.widthProperty().subtract(this.layoutXProperty().add(this.widthProperty())).getValue())) / ball.getBallXSpeed()).subtract(this.heightProperty().divide(2)).getValue());
        } else {
            setRectangleHeight(pane.heightProperty().divide(2).getValue());
        }
    }));

    public RectangleRight(Pane pane){
        super(pane);
        this.pane = pane;
        this.layoutXProperty().bind(pane.widthProperty().multiply(99.0/100).subtract(this.widthProperty()));
    }

    public RectangleRight(Pane pane, Ball ball){
        super(pane);
        this.ball = ball;
        this.pane = pane;
        this.layoutXProperty().bind(pane.widthProperty().multiply(99.0/100).subtract(this.widthProperty()));
    }

    public void startTimeline2(){
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();
    }
}
