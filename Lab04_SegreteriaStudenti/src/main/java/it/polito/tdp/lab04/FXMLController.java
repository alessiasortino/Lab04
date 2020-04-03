
 package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Corso> cboxCorsi;

    @FXML
    private Button btnCercaIscrittti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnSpuntaVerde;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCgnome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void CercaCorsi(ActionEvent event) {
    	int matricola= Integer.parseInt(txtMatricola.getText());
    	Studente s=model.getStudente(matricola);
    	if(s==null) {
    		txtRisultato.appendText("La matricola non corrisponde a nessuno studente");
    		return;
    	}
    	
    	txtRisultato.appendText(model.getCorsiStudente(matricola));

    }

    @FXML
    void CercaIscritti(ActionEvent event) {
    	Corso c= cboxCorsi.getValue();
    	String codCorso= c.getCodins();
    	if(codCorso.compareTo("") ==0){
    		txtRisultato.appendText("Inserire un corso\n");
    		}
    	txtRisultato.appendText(model.getStudentiPerCorso(codCorso));

    }

    @FXML
    void Iscrivi(ActionEvent event) {
    	

    }

    @FXML
    void Reset(ActionEvent event) {

    }

    @FXML
    void SpuntaVerde(ActionEvent event) {
    	try {
    	int matricola= Integer.parseInt(txtMatricola.getText());
    	Studente s=model.getStudente(matricola);
    	if(s==null) {
    		txtRisultato.appendText("La matricola non corrisponde a nessuno studente");
    		return;
    	}
    	txtNome.setText(s.getNome());
    	txtCgnome.setText(s.getCognome());
    	
    	}catch (NumberFormatException e) {
    		txtRisultato.appendText("Inserire una matricola valida");
    	}
    	

    }

    @FXML
    void initialize() {
        assert cboxCorsi != null : "fx:id=\"cboxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittti != null : "fx:id=\"btnCercaIscrittti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpuntaVerde != null : "fx:id=\"btnSpuntaVerde\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCgnome != null : "fx:id=\"txtCgnome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
       
       
    }


    public void setModel(Model model) {
    	this.model=model;
    	cboxCorsi.getItems().add(new Corso("",-1,"",-1));
    	cboxCorsi.getItems().addAll(model.getTuttiICorsi());
    	

    }
}
