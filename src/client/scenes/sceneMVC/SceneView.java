package client.scenes.sceneMVC;

import javafx.stage.Stage;

public class SceneView {

    private SceneController sceneController;
    private Stage stage;

    public SceneView(Stage primaryStage, SceneController sceneController, SceneModel sceneModel){
        this.stage = primaryStage;
        this.sceneController = sceneController;
        sceneModel.register(this);
    }

    public void update(SceneModel sceneModel){
        stage.setScene(sceneModel.getScene());
    }
}
