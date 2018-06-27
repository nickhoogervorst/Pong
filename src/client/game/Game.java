package client.game;

import client.scenes.game.GamePane;
import client.scenes.sceneMVC.SceneChanger;

public class Game extends GamePane {

    public Game(SceneChanger sceneChanger){
        this.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case ESCAPE: sceneChanger.createStartScreen();
            }
        });
    }

}
