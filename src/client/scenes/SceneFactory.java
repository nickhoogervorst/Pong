package client.scenes;

import client.scenes.startScreen.StartScreen;
import javafx.scene.Scene;

public class SceneFactory {

    public SceneFactory(){

    }

    public Scene createStartScreen(){
        StartScreen pane = new StartScreen();
        Scene scene = new Scene(pane);
        return scene;
    }

}
