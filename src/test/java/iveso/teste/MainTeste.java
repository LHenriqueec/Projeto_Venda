package iveso.teste;
import controller.Controller;
import dao.ConnectionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainTeste extends Application {
	
	@Override
    public void start(Stage stage) throws Exception {
    	ConnectionFactory.initSetup();
    	
    	Controller controller = new Controller();
    	controller.setup();
    	
    	AnchorPane root = FXMLLoader.load(getClass().getResource("/view/Teste.fxml"));
    	Scene scene = new Scene(root);
    	
    	stage.setTitle("Aplicação");
    	stage.setScene(scene);
    	stage.setMaximized(true);
        stage.show();
    }
	
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		ConnectionFactory.closeFactory();
	}
}


















