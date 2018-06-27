package client.scenes.game;

import client.scenes.BasePane;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;

public class GamePane extends BasePane {

    private RectangleLeft rectangleLeft = new RectangleLeft(this);
    private RectangleRight rectangleRight = new RectangleRight(this);

    public GamePane(){
        this.getChildren().addAll(rectangleLeft, rectangleRight);
    }

}
