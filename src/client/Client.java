package client;

import client.scenes.SceneChanger;
import client.scenes.SceneController;
import client.scenes.SceneModel;
import client.scenes.SceneView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

    public void run(){launch();}

    @Override
    public void start(Stage primaryStage) {
        SceneModel sceneModel = new SceneModel();
        SceneController sceneController = new SceneController(sceneModel);
        SceneView sceneView = new SceneView(primaryStage, sceneController, sceneModel);
        SceneChanger sceneChanger = new SceneChanger(sceneController);
        sceneChanger.createStartScreen();
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Pong");
    }
}
