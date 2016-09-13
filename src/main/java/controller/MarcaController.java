package controller;

import entity.Marca;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.MarcaService;
import service.ServiceException;
import util.StageGroup;

public class MarcaController extends Controller {
	
	private MarcaService service;
	private Marca marca;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private void initialize() {
		service = new MarcaService();
		marca = new Marca();
	}

	@FXML
	private void onSalvar() throws ServiceException {
		if (isValid()) {
			marca.setNome(txtNome.getText().toUpperCase());
			service.salvar(marca);
			StageGroup.finishStage("Marca");
		}
		
		//TODO: Criar um dialog avisando que a informação é inválida!
	}
	
	@FXML
	private void onCancelar() {
		StageGroup.finishStage("Marca");
	}
	
	private boolean isValid() {
		return txtNome.getText().isEmpty() ? false : true;
	}
}
