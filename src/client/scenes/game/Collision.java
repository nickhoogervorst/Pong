package client.scenes.game;

import client.scenes.ball.Ball;
import client.scenes.rectangle.RectangleLeft;
import client.scenes.rectangle.RectangleRight;

public class Collision {

    private RectangleLeft rectangleLeft;
    private RectangleRight rectangleRight;
    private Ball ball;

    public Collision(RectangleLeft rectangleLeft, RectangleRight rectangleRight, Ball ball){
        this.rectangleLeft = rectangleLeft;
        this.rectangleRight = rectangleRight;
        this.ball = ball;
    }

}
