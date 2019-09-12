package application;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerInfoPatient {
	@FXML
	private TextField Nom;
	@FXML
	private TextField DateNaissance;
	@FXML
	private TextField Prenom;
	@FXML
	private TextField NumSecu;
	
	public void NouvelleEntree(ActionEvent event) {
		System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	     jop1 = new JOptionPane();
	     jop1.showMessageDialog(null, "nouvelle entree ", "C'est le titre", JOptionPane.CLOSED_OPTION);
	}
	public void Statistiques(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	       Main.replaceSceneContent("designStat.fxml");
	      
	   }
	
	public void Accueil(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	       Main.replaceSceneContent("design.fxml");
	      
	   }
	public void Deconnexion(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	     Main.replaceSceneContent("designLog.fxml");
	   }
	public void Valider(ActionEvent event) {
	       System.out.println(Nom.getText()+" "+Prenom.getText()+" "+DateNaissance.getText()+" "+NumSecu.getText());
	       JOptionPane jop1;
	       Main.individu.setNom(Nom.getText());
	       Main.individu.setNom(Prenom.getText());
	       Main.individu.setNom(DateNaissance.getText());
	       Main.individu.setNom(NumSecu.getText());
	     //Boîte du message d'information
	     Main.replaceSceneContent("designDonneePatient.fxml");
	   }
}
