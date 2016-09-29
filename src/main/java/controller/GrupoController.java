package controller;

import entity.Grupo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.GrupoService;
import service.ServiceException;
import util.StageGroup;

public class GrupoController {

	private Grupo grupo;
	private GrupoService service;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private void initialize() {
		grupo = new Grupo();
		service = new GrupoService();
	}
	
	@FXML
	private void onSalvar() throws ServiceException {
		if (isValid()) {
			grupo.setNome(txtNome.getText().toUpperCase());
			service.salvar(grupo);
			StageGroup.finishStage("Grupo");
		}
	}
	
	@FXML
	private void onCancelar() {
		StageGroup.finishStage("Grupo");
	}
	
	private boolean isValid() {
		return txtNome.getText().isEmpty() ? false : true;
	}
}
