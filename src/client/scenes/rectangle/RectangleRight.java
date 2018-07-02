package client.scenes.rectangle;

import client.scenes.ball.Ball;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RectangleRight extends RectangleBase {

    private Ball ball;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60), event -> {
        if(ball.getBallPosY().getValue() > this.layoutYProperty().getValue()){
            goUp();
            System.out.println("up");
        }
        if(ball.getBallPosY().getValue() < this.layoutYProperty().getValue()){
            goDown();
            System.out.println("down");
        }
    }));

    public RectangleRight(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(99.0/100).subtract(this.widthProperty()));
    }


    public RectangleRight(Pane pane, Ball ball){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(99.0/100).subtract(this.widthProperty()));
        this.ball = ball;
        this.layoutYProperty().bind(ball.getBallPosY().subtract(this.heightProperty().divide(2)));
    }
}
