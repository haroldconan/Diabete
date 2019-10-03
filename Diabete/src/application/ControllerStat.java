package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerStat implements Initializable {

	@FXML
	private NumberAxis AxeY;

	@FXML
	private CategoryAxis AxeX;

	@FXML
	private BarChart<?, ?> GraphStat;
	@FXML
	private TableView<?> TableauIndividue;
	@FXML
	private TableColumn<?, ?> ColSecu;
	@FXML
	private TableColumn<?, ?> ColNom;

	@FXML
	private TableColumn<?, ?> ColPrenom;

	public void NouvelleEntree(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Boîte du message d'information
		Main.replaceSceneContent("designInfoPatient.fxml");
	}

	public void Statistiques(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Boîte du message d'information
		Main.replaceSceneContent("designStat.fxml");

	}

	public void Accueil(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Boîte du message d'information
		Main.replaceSceneContent("design.fxml");

	}

	public void Deconnexion(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Boîte du message d'information
		Main.replaceSceneContent("designLog.fxml");
	}

	public void Valider(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Boîte du message d'information
		Main.replaceSceneContent("designResultatPatient.fxml");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// PARTIE GRAPH
		System.out.println("passe dans initialise");

		XYChart.Series set1 = GetStat("");
		set1.setName("Pourcentage de patients Homme");

		XYChart.Series set2 = GetStat("");
		set2.setName("Pourcentage de patients Femme");
		GraphStat.setVisible(true);
		TableauIndividue.setVisible(false);
		GraphStat.getData().addAll(set1);
		GraphStat.getData().addAll(set2);
		// FIN PARTIE GRAPH

	}

	@FXML
	void BTlistIndiviue(ActionEvent event) {
		GraphStat.setVisible(false);
		TableauIndividue.setVisible(true);
		ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		ColPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		ColSecu.setCellValueFactory(new PropertyValueFactory<>("numSecu"));
		long secu = Long.parseLong("88888888888888");
		Item indi1 = new Item(new Individu("CONAN", "Harold", new Date("28/04/1999"), true, secu));
		Item indi2 = new Item(new Individu("CONAN", "Harold", new Date("28/04/1999"), true, secu));
		Item indi3 = new Item(new Individu("CONAN", "Harold", new Date("28/04/1999"), true, secu));
		Item indi4 = new Item(new Individu("CONAN", "Harold", new Date("28/04/1999"), true, secu));
		
		 TableauIndividue.setRoot(indi1);
	}

	@FXML
	void BTGraphSexe(ActionEvent event) {

	}

	@FXML
	void BTGraphAge(ActionEvent event) {

	}

	/**
	 * Récupère les données de la base en fonction de la requete qui lui est passée
	 * 
	 * @param requete
	 * @return la liste d'élément à mettre dans un axe
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private XYChart.Series GetStat(String requete) {

		XYChart.Series serieBDD = new XYChart.Series<>();
		serieBDD.getData().add(new XYChart.Data("Risque de 1%", 50));
		serieBDD.getData().add(new XYChart.Data("Risque de 4%", 20));
		serieBDD.getData().add(new XYChart.Data("Risque de 17%", 5));
		serieBDD.getData().add(new XYChart.Data("Risque de 33%", 10));
		serieBDD.getData().add(new XYChart.Data("Risque de 50%", 15));

		return serieBDD;
	}
}
