package util;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.stage.Stage;

public abstract class StageGroup {

	private static Map<String, Stage> stages = new LinkedHashMap<>();
	
	
	public static void addStage(String nameStage, Stage stage) {
		stages.put(nameStage, stage);
	}
	
	public static Stage getStage(String nameStage) {
		return stages.get(nameStage);
	}
	
	public static void finishStage(String nameStage) {
		stages.get(nameStage).close();
		stages.remove(nameStage);
	}
}
