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
	       alert.setHeaderText("\t\t\t\t\t\t\t\tNuméro de sécurité sociale :" + Main.individu.getNumSecu()+"\t\t\t\t\t\t\t\t");
	       SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
	       alert.setContentText(Main.donnees.toString(Main.donnees.calculResultat(Main.individu.getSexe()))+"\t\t\t\t\n\n"+"\t\t\t\t\tPatient :\n"+"\t\t\t\tId : "+Main.individu.getId()+"\n"+"\t\t\t\tNom :"+Main.individu.getNom()+"\n\t\t\t\tPrénom : "+Main.individu.getPrenom()+"\n\t\t\t\tNuméro de sécurité sociale : "+Main.individu.getNumSecu()+"\n\t\t\t\tDate de naissance : "+formater.format(Main.individu.getDateNaissance())+"\n\t\t\t\tSexe : "+Main.individu.getSexe()+"\n\t\t\t\tAge : "+Main.donnees.getAge()+"\n\n\t\t\t\t\tDonnées du patient : \n\t\t\t\tId : "+Main.donnees.getId()+"\n\t\t\t\tId Individue : "+Main.donnees.getIdIndividu()+"\n\t\t\t\tPortiont de légume vert : "+Main.donnees.getLegumeVert()+"\n\t\t\t\tPoids : "+Main.donnees.getPoids()+" Taille : "+Main.donnees.getTaille()+" Tour de Taille : "+Main.donnees.getTourDeTaille()+"\n\t\t\t\t30 min 'activitée phyisique : "+Main.donnees.isActPhysique()+"\n\t\t\t\tAntécédent Anti-HTA : "+Main.donnees.isAtcdAntiHTA()+"\n\t\t\t\tAntécédent Familliale : "+Main.donnees.isAtcdFamille()+"\n\t\t\t\tAntécédent Glycémique : "+Main.donnees.isAtcdGlycemie());
		   alert.showAndWait();//d
		   Main.replaceSceneContent("design.fxml");
		}catch (Exception e) {
			System.out.println("ControllerDonnee"+e.getMessage());
		}
	       
	}    
}
