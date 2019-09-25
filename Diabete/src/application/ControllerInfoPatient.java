package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	       if(Nom.getText().equals(null)) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Erreur !");
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'Nom' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }
	       else {
		    	System.out.println("\tRésultat match : "+Nom.getText().matches("[a-zA-Z]"));
	    	   if(!Nom.getText().matches("[a-zA-Z]*")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Erreur !");
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'Nom' ne doit contenir que des lettres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       if(Prenom.getText().equals(null)) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Erreur !");
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'Prenom' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }
	       else {
	    	   if(!Prenom.getText().matches("[a-zA-Z]*")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Erreur !");
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'Prenom' ne doit contenir que des lettres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       if(DateNaissance.getText().equals(null)) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'Nom' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }else {
	    	   if(!DateNaissance.getText().matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Erreur !");
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'Date de naissance' doit être au format jj/mm/aaaa");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       if(NumSecu.getText().equals(null)) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'Numérau de sécurité sociale' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }else {
	    	   if(!NumSecu.getText().matches("[0-9]{13}")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'Numérau de sécurité sociale' ne doit contenir que les 13 chiffres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }//
	       Main.individu.setNom(Nom.getText());
	       Main.individu.setPrenom(Prenom.getText());
	       Main.individu.setDateNaissance(new Date(DateNaissance.getText()));
	       Main.individu.setNumSecu(Long.parseLong(NumSecu.getText()));
	     //Boîte du message d'information
	       System.out.println("tout :\n"+Main.individu.getId()+"\n"+Main.individu.getNom()+"\n"+Main.individu.getNumSecu()+"\n"+Main.individu.getPrenom()+"\n"+Main.individu.getDateNaissance()+"\n"+Main.individu.getSexe()+"\n"+Main.donnees.getAge()+"\n"+Main.donnees.getId()+"\n"+Main.donnees.getIdIndividu()+"\n"+Main.donnees.getLegumeVert()+"\n"+Main.donnees.getPoids()+"\n"+Main.donnees.getTaille()+"\n"+Main.donnees.getTourDeTaille());
	     Main.replaceSceneContent("designDonneePatient.fxml");
	   }
}
