package sample;

import dao.ConnectionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import controller.Controller;

public class Main extends Application {
	

    @Override
    public void start(Stage stage) throws Exception {
    	ConnectionFactory.initSetup();
    	BorderPane root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
    	
    	Controller controller = new Controller();
    	controller.centerNodeProperty().bind(root.centerProperty());
    	controller.setup();
    	controller.goToScreen("Dashboard");
    	
    	Scene scene = new Scene(root);
    	
    	stage.setTitle("Aplicação");
    	stage.setScene(scene);
    	stage.setMaximized(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop() throws Exception {
    	super.stop();
    	ConnectionFactory.closeFactory();
    }
    
    
    
}
