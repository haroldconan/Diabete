package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import bd.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class ControllerMain implements Initializable {

	@FXML
	private PieChart StatRounded;

	public void NouvelleEntree(ActionEvent event) {
		System.out.println("Button Clicked!");
		JOptionPane jop1;

		// Boîte du message d'information
		Main.replaceSceneContent("designInfoPatient.fxml");
	}

	public void Statistiques(ActionEvent event) {
		System.out.println("Button Clicked!");
		JOptionPane jop1;

		// Boîte du message d'information
		Main.replaceSceneContent("designStat.fxml");

	}

	public void Accueil(ActionEvent event) {
		System.out.println("Button Clicked!");
		JOptionPane jop1;

		// Boîte du message d'information
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "accueil ", "C'est le titre", JOptionPane.CLOSED_OPTION);

	}

	public void Deconnexion(ActionEvent event) {
		System.out.println("Button Clicked!");
		JOptionPane jop1;

		// Boîte du message d'information
		Main.replaceSceneContent("designLog.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
///////////Stat acceuil
		StatRounded.setTitle("Statistique Générale");
		StatRounded.getData().setAll(GetStatAccueil());
		////////// Fin STAT Accueil
	}

	private List<PieChart.Data> GetStatAccueil() {
		List<PieChart.Data> listAccueil = new ArrayList<PieChart.Data>();
		listAccueil.add(new PieChart.Data("Risque de 1%", Connexion.getStat1Accueil()));
		listAccueil.add(new PieChart.Data("Risque de 4%", Connexion.getStat4Accueil()));
		listAccueil.add(new PieChart.Data("Risque de 17%", Connexion.getStat17Accueil()));
		listAccueil.add(new PieChart.Data("Risque de 33%", Connexion.getStat33Accueil()));
		listAccueil.add(new PieChart.Data("Risque de 50%", Connexion.getStat50Accueil()));
		return listAccueil;
	}

}
