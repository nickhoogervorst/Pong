package client.scenes.rectangle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class RectangleLeft extends RectangleBase {

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

    public RectangleLeft(Pane pane){
        super(pane);
        this.layoutXProperty().bind(pane.widthProperty().multiply(1.0/50));
        this.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case W:
                    rectangleDown = true;
                    break;
                case S:
                    rectangleUp = true;
                    break;
            }
        });
        this.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case W:
                    rectangleDown = false;
                    break;
                case S:
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
