package controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class Controller {

	private static ObjectProperty<Node> centerNode = new SimpleObjectProperty<>();
	private static StackPane pane;
	private static HashMap<String, Node> screens = new HashMap<>();
	private static HashMap<String, Object> controllers = new HashMap<>();

	public void setup() {
		loadScreen("Main", "/view/Main.fxml");
		loadScreen("Dashboard", "/view/Dashboard.fxml");
		loadScreen("Produto", "/view/Produto.fxml");
		loadScreen("Novo_Produto", "/view/Novo_Produto.fxml");
		loadScreen("Nova_Marca", "/view/Nova_Marca.fxml");
		loadScreen("Novo_Grupo", "/view/Novo_Grupo.fxml");
		loadScreen("Nova_Un_Medida", "/view/Nova_Un_Medida.fxml");
		loadScreen("Teste", "/view/Teste.fxml");
		
		pane = (StackPane) centerNode.get();
	}


	public ObjectProperty<Node> centerNodeProperty() {
		return centerNode;
	}

	public void goToScreen(String nameScreen) {
		Node node = screens.get(nameScreen);
		setCenterNode(node);
	}

	public Node getCenterNode() {
		return centerNode.get();
	}
	
	public Node getScreen(String nameScreen) {
		Node node = screens.get(nameScreen);
		if (node.getScene() != null) {
			node.getStyleClass().clear();
			node.getScene().setRoot(new Region());
		}
		
		return node;
	}
	
	public Class<?> getController(String nomeController) {
		return controllers.get(nomeController).getClass();
	}

	private void setCenterNode(Node node) {
		if (!pane.getChildren().isEmpty()) {
			
			pane.getChildren().remove(0);
			pane.getChildren().add(node);

		} else {
			pane.getChildren().add(node);
		}
	}

	private void loadScreen(String nome, String resource) {
		FXMLLoader loader = null;
		try {

			loader = new FXMLLoader(getClass().getResource(resource));
			Parent parent = (Parent) loader.load();
			addScreen(nome, parent);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addController(nome, loader.getController());
	}

	private void addScreen(String nome, Node screen) {
		screens.put(nome, screen);
	}
	
	private void addController(String nome, Object controller) {
		controllers.put(nome, controller);
	}
}
