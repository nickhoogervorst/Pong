package client.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneFactory {

    public SceneFactory(){

    }

    public Scene createStartScreen(){
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        return scene;
    }

}
