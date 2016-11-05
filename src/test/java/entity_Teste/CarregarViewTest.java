package entity_Teste;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarregarViewTest {

	
	public static void carregarView(String nameView) throws IOException {
		Stage stage = new Stage();
		Parent view = FXMLLoader.load(CarregarViewTest.class.getResource("/view/" + nameView));
		Scene scene = new Scene(view);
		stage.setScene(scene);
		stage.show();
	}
}
