package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private TextArea txtWrongWords;

    @FXML
    private URL location;
    
    @FXML
    private TextArea txtTesto;

    @FXML
    private ComboBox<String> boxLingua;
  
    private Dictionary model = new Dictionary();

    @FXML
    private Label txtErrors;

    @FXML
    private Label txtTime;
    
    public void setModel(Dictionary model) {
    	this.model=model;
    	String languages[] = {"English","Italian"};
    	boxLingua.getItems().addAll(languages);
    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtErrors.setText("");
    	txtTime.setText("");
    	txtTesto.setText("");
    	txtWrongWords.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	model.loadDictionary(boxLingua.getValue());
    	String testo = txtTesto.getText();
    	testo = testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "").toLowerCase();
    	String testoCampi[] =testo.split(" ");
    	ArrayList<String> testoi =new ArrayList<String>();
    	for(String s:testoCampi) {
    		testoi.add(s);
    	}
    	long start=System.nanoTime();
    	ArrayList<RichWord> paroleVerificate=new ArrayList<RichWord>(model.spellCheckText(testoi));
    	
    	
    	int cont =0;
    	String tot="";
    	for(RichWord r:paroleVerificate) {
    		if(r.isPresente()) {
    		tot += r.getParola() +"\n";
    		cont++;
    		}
    	}
    	long stop =System.nanoTime();
    	txtWrongWords.setText(tot);
    	txtTime.setText("Spell Check completed in "+(stop-start)+" nanoseconds");
    	
    	txtErrors.setText("The Text contains "+cont+" errors");
    	
    	
    }

    @FXML
    void initialize() {
        assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrongWords != null : "fx:id=\"txtWrongWords\" was not injected: check your FXML file 'Scene.fxml'.";


    }
}
