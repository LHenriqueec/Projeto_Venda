package util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateViewUtil {

	public static void createView(Stage stage, String pathView, String title) {
		try {
			Parent parent = FXMLLoader.load(CreateViewUtil.class.getResource(pathView));
			Scene scene = new Scene(parent);

			stage.setTitle(title);
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createViewByNode(Node node, String title, String nameStage) {
		Stage stage = new Stage();
		StageGroup.addStage(nameStage, stage);
		Parent parent = (Parent) node;
		Scene scene = new Scene(parent);
		
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
