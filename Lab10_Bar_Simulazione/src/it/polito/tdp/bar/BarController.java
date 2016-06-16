package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

	Model model = new Model();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimula(ActionEvent event) {
    	model.clear();
    	model.simula();
    	txtResult.setText("Numero clienti totali arrivati: "+model.getClientiTotali());
    	txtResult.appendText("\nNumero clienti soddisfatti: "+model.getClientiSoddisfatti());
    	txtResult.appendText("\nNumero clienti insoddisfatti: "+model.getClientiInsoddisfatti());
    }

    public void setModel(Model model){
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    
}
