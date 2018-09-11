package client.scenes.sceneMVC;

import javafx.scene.Scene;

public class SceneModel {

    private SceneView sceneView;
    private Scene scene;

    public void register(SceneView sceneView){
        this.sceneView = sceneView;
    }

    public void changeScene(Scene scene){
        this.scene = scene;
        sceneView.update(this);
    }

    public void setFullscreen(){
        sceneView.setFullscreen();
    }

    public Scene getScene(){
        return this.scene;
    }

}
