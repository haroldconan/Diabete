package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ControllerDonneePatient {
	
	@FXML
	private TextField taille;
	@FXML
	private TextField poids;
	@FXML
	private TextField tourTaille;
	
	public void NouvelleEntree(ActionEvent event) {
		
		System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	     jop1 = new JOptionPane();
	     jop1.showMessageDialog(null, "nouvelle entree ", "C'est le titre", JOptionPane.CLOSED_OPTION);
	}
	public void Statistiques(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       
	     //Boîte du message d'information
	       Main.replaceSceneContent("designStat.fxml");
	      
	   }
	
	public void Accueil(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       
	     //Boîte du message d'information
	       Main.replaceSceneContent("design.fxml");
	      
	   }
	public void Deconnexion(ActionEvent event) {
	       System.out.println("Button Clicked!");
	       
	     //Boîte du message d'information
	     Main.replaceSceneContent("designLog.fxml");
	   }
	public void Valider(ActionEvent event) {
		try {
	       System.out.println(taille.getText() +" "+poids.getText());
	       Main.donnees.setTaille(Double.parseDouble(taille.getText()));
	       Main.donnees.setPoids(Double.parseDouble(poids.getText()));
	       Main.donnees.setAge(Main.donnees.calculAge(Main.individu.getDateNaissance()));
	       Main.donnees.setTourDeTaille(Double.parseDouble(tourTaille.getText()));
	       
	       System.out.println("tout :\n"+Main.individu.getId()+"\n"+Main.individu.getNom()+"\n"+Main.individu.getNumSecu()+"\n"+Main.individu.getPrenom()+"\n"+Main.individu.getDateNaissance()+"\n"+Main.individu.getSexe()+"\n"+Main.donnees.getAge()+"\n"+Main.donnees.getId()+"\n"+Main.donnees.getIdIndividu()+"\n"+Main.donnees.getLegumeVert()+"\n"+Main.donnees.getPoids()+"\n"+Main.donnees.getTaille()+"\n"+Main.donnees.getTourDeTaille());
	     //Boîte du message d'information
	       System.out.println(Main.donnees.toString(Main.donnees.calculResultat(Main.individu.getSexe())));
	       Alert alert = new Alert(AlertType.INFORMATION);
	       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
	       alert.setHeaderText("Numéro de sécurité sociale :" + Main.individu.getNumSecu());
	       alert.setContentText(Main.donnees.toString(Main.donnees.calculResultat(Main.individu.getSexe()))+"\n"+"tout :\n"+"Id : "+Main.individu.getId()+"\n"+"Nom :"+Main.individu.getNom()+"\n"+Main.individu.getNumSecu()+"\n"+Main.individu.getPrenom()+"\n"+Main.individu.getDateNaissance()+"\n"+Main.individu.getSexe()+"\n"+Main.donnees.getAge()+"\n"+Main.donnees.getId()+"\n"+Main.donnees.getIdIndividu()+"\n"+Main.donnees.getLegumeVert()+"\n"+Main.donnees.getPoids()+"\n"+Main.donnees.getTaille()+"\n"+Main.donnees.getTourDeTaille());
		   alert.showAndWait();
		   Main.replaceSceneContent("design.fxml");
		}catch (Exception e) {
			System.out.println("ControllerDonnee"+e.getMessage());
		}
	   }
	
}
