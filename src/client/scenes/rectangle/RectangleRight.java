package client.scenes.rectangle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RectangleRight extends RectangleBase {

    private Boolean rectangleDown = false;
    private Boolean rectangleUp = false;
    private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.0/60.0), event -> {
        if(rectangleUp){
            rectangleHeightUp();
        }
        if(rectangleDown){
            rectangleHeightDown();
        }
    }));

    public RectangleRight(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(49.0/50).subtract(this.widthProperty()));
        this.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case UP:
                    rectangleDown = true;
                    break;
                case DOWN:
                    rectangleUp = true;
                    break;
            }
        });
        this.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case UP:
                    rectangleDown = false;
                    break;
                case DOWN:
                    rectangleUp = false;
                    break;
            }
        });
    }

    public void startTimeline(){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

}
