

import java.io.IOException;

import controller.Controller;
import dao.ConnectionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Teste extends Application {



	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/Teste.fxml"));
		
		new Controller().setup();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		ConnectionFactory.initSetup();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		ConnectionFactory.closeFactory();
	}
}


















