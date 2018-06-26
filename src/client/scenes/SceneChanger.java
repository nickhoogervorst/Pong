package client.scenes;

import javafx.scene.Scene;

public class SceneChanger {

    private SceneFactory sceneFactory;
    private SceneController sceneController;

    public SceneChanger(SceneController sceneController){
        this.sceneFactory = new SceneFactory();
        this.sceneController = sceneController;
    }

    public void createStartScreen(){
        Scene scene = sceneFactory.createStartScreen();
        this.sceneController.changeScene(scene);
    }

}
