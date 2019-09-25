package application;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

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
	 //test git
			//test git//test git
	       if(taille.getText().equals("")) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'Taille' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }else {
	    	   if(!taille.getText().matches("[0-9]*")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'Taille' ne doit contenir que des chiffres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       Main.donnees.setTaille(Double.parseDouble(taille.getText()));
	       
	       if(poids.getText().equals("")) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'poids' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }else {
	    	   if(!poids.getText().matches("[0-9]*")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'poids' ne doit contenir que des chiffres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       Main.donnees.setPoids(Double.parseDouble(poids.getText()));
	       
	       if(tourTaille.getText().equals("")) {
	    	   Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
		       alert.setHeaderText("Erreur de complétion de texte :");
		       alert.setContentText("Le champs 'tourTaille' est incomplet");
			   alert.showAndWait();
	    	   return;
	       }else {
	    	   if(!tourTaille.getText().matches("[0-9]*")) {
	    		   Alert alert = new Alert(AlertType.ERROR);
			       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
			       alert.setHeaderText("Erreur de complétion de texte :");
			       alert.setContentText("Le champs 'tourTaille' ne doit contenir que des chiffres");
				   alert.showAndWait();
		    	   return;
	    	   }
	       }
	       Main.donnees.setAge(Main.donnees.calculAge(Main.individu.getDateNaissance()));
	       Main.donnees.setTourDeTaille(Double.parseDouble(tourTaille.getText()));
	       
	       System.out.println("tout :\n"+Main.individu.getId()+"\n"+Main.individu.getNom()+"\n"+Main.individu.getNumSecu()+"\n"+Main.individu.getPrenom()+"\n"+Main.individu.getDateNaissance()+"\n"+Main.individu.getSexe()+"\n"+Main.donnees.getAge()+"\n"+Main.donnees.getId()+"\n"+Main.donnees.getIdIndividu()+"\n"+Main.donnees.getLegumeVert()+"\n"+Main.donnees.getPoids()+"\n"+Main.donnees.getTaille()+"\n"+Main.donnees.getTourDeTaille());
	     //Boîte du message d'information
	       System.out.println(Main.donnees.toString(Main.donnees.calculResultat(Main.individu.getSexe())));
	       Alert alert = new Alert(AlertType.INFORMATION);
	       alert.setTitle("Resulat pour : "+Main.individu.getNom()+" "+Main.individu.getPrenom());
	       alert.setHeaderText("Numéro de sécurité sociale :" + Main.individu.getNumSecu());
	       SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
	       alert.setContentText(Main.donnees.toString(Main.donnees.calculResultat(Main.individu.getSexe()))+"\n"+"tout sur :\n"+"Id : "+Main.individu.getId()+"\n"+"Nom :"+Main.individu.getNom()+" Prénom : "+Main.individu.getPrenom()+"\nNuméro de sécurité sociale : "+Main.individu.getNumSecu()+"\nDate de naissance : "+formater.format(Main.individu.getDateNaissance())+"\nSexe : "+Main.individu.getSexe()+"\nAge : "+Main.donnees.getAge()+"\n\n\tDonnées du patient : \nId : "+Main.donnees.getId()+"Id Individue : "+Main.donnees.getIdIndividu()+"\nPortiont de légume vert : "+Main.donnees.getLegumeVert()+"\nPoids : "+Main.donnees.getPoids()+" Taille : "+Main.donnees.getTaille()+" Tour de Taille : "+Main.donnees.getTourDeTaille()+"\n30 min 'activitée phyisique : "+Main.donnees.isActPhysique()+"\nAntécédent Anti-HTA : "+Main.donnees.isAtcdAntiHTA()+"\nAntécédent Familliale : "+Main.donnees.isAtcdFamille()+"\nAntécédent Glycémique : "+Main.donnees.isAtcdGlycemie());
		   alert.showAndWait();//d
		   Main.replaceSceneContent("design.fxml");
		}catch (Exception e) {
			System.out.println("ControllerDonnee"+e.getMessage());
		}
	       
	}    
}
