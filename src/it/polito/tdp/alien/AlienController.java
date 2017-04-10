package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	private AlienDictionary alienDict;

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
		alienDict = new AlienDictionary();

	}

	@FXML
	void doTranslate(ActionEvent event) {
		txtResult.clear();

		String inserita = txtWord.getText();
		if (inserita.length() == 0) {
			txtResult.appendText("Campo AlienWord Vuoto!!!!");
			return;
		}
		StringTokenizer st = new StringTokenizer(inserita, " ");
		String alienWord = st.nextToken();
		String translation=null;
		if (!st.hasMoreTokens()) {
			 translation  = alienDict.translateWord(alienWord);
			if (translation != null) {
				txtResult.appendText(String.format("La traduzione alla parola aliena inserita è %s :", translation));
			} else {
				txtResult.appendText("Parola Aliena Non esistente!!");
				return;
			}
		} else {
			translation = st.nextToken();
			alienDict.addWord(alienWord, translation);
			txtResult.appendText("Word aggiunto correttamente!!");
			return;
		}

	}

	@FXML
	void doReset(ActionEvent event) {
	txtWord.clear();
	txtResult.clear();
	

	}

}
