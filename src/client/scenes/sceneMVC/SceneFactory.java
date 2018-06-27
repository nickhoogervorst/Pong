package client.scenes.sceneMVC;

import client.scenes.game.GamePane;
import client.scenes.startScreen.StartScreen;
import javafx.scene.Scene;

public class SceneFactory {

    public SceneFactory(){

    }

    public Scene createStartScreen(SceneChanger sceneChanger){
        StartScreen pane = new StartScreen(sceneChanger);
        Scene scene = new Scene(pane);
        return scene;
    }

    public Scene startGame(SceneChanger sceneChanger){
        GamePane game = new GamePane(sceneChanger);
        Scene scene = new Scene(game);
        scene.getRoot().requestFocus();
        return  scene;
    }

}
