package client;

import client.scenes.sceneMVC.SceneChanger;
import client.scenes.sceneMVC.SceneController;
import client.scenes.sceneMVC.SceneModel;
import client.scenes.sceneMVC.SceneView;
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
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.setTitle("Pong");
    }
}
