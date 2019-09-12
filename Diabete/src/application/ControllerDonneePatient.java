package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

public class ControllerDonneePatient {
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
	       System.out.println("Button Clicked!");
	       JOptionPane jop1;
	       
	     //Boîte du message d'information
	     Main.replaceSceneContent("designResultatPatient.fxml");
	   }
}
