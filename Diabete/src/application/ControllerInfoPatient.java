package application;

import java.util.Date;

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
	       Main.individu.setPrenom(Prenom.getText());
	       Main.individu.setDateNaissance(new Date(DateNaissance.getText()));
	       Main.individu.setNumSecu(Long.parseLong(NumSecu.getText()));
	     //Boîte du message d'information
	       System.out.println("tout :\n"+Main.individu.getId()+"\n"+Main.individu.getNom()+"\n"+Main.individu.getNumSecu()+"\n"+Main.individu.getPrenom()+"\n"+Main.individu.getDateNaissance()+"\n"+Main.individu.getSexe()+"\n"+Main.donnees.getAge()+"\n"+Main.donnees.getId()+"\n"+Main.donnees.getIdIndividu()+"\n"+Main.donnees.getLegumeVert()+"\n"+Main.donnees.getPoids()+"\n"+Main.donnees.getTaille()+"\n"+Main.donnees.getTourDeTaille());
	     Main.replaceSceneContent("designDonneePatient.fxml");
	   }
}
