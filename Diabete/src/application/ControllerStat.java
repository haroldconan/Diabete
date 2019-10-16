package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private BarChart<Number,String> GraphStat;
	@FXML
	private TableView<Individu> TableauIndividu;
	@FXML
	private TableColumn<Individu, Long> ColSecu;
	@FXML
	private TableColumn<Individu, String> ColNom;

	@FXML
	private TableColumn<Individu, String> ColPrenom;
	
    @FXML
    private TableColumn<Individu, Date> ColNaissance;

    @FXML
    private TableColumn<Individu, Integer> ColSexe;

	public void NouvelleEntree(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Bo�te du message d'information
		Main.replaceSceneContent("designInfoPatient.fxml");
	}

	public void Statistiques(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Bo�te du message d'information
		Main.replaceSceneContent("designStat.fxml");

	}

	public void Accueil(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Bo�te du message d'information
		Main.replaceSceneContent("design.fxml");

	}

	public void Deconnexion(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Bo�te du message d'information
		Main.replaceSceneContent("designLog.fxml");
	}

	public void Valider(ActionEvent event) {
		System.out.println("Button Clicked!");

		// Bo�te du message d'information
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
		GraphStat.getData().addAll(set1);
		GraphStat.getData().addAll(set2);
		// FIN PARTIE GRAPH
		GraphStat.setVisible(true);
		TableauIndividu.setVisible(false);
	}

	@FXML
	void BTlistIndiviue(ActionEvent event) {
		GraphStat.setVisible(false);
		TableauIndividu.setVisible(true);
		ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		ColPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		ColSecu.setCellValueFactory(new PropertyValueFactory<>("numSecu"));
		ColNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
		ColSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
		ObservableList<Individu> listIndi = getIndividuList();
		for(int indi = 0; indi < listIndi.size();indi++) {
			if(listIndi.get(indi).getSexe()) {
				ColSexe.getCellData(indi);
			}
		}
		TableauIndividu.setItems(listIndi);
	}

	@FXML
	void BTGraphSexe(ActionEvent event) {
		GraphStat.setVisible(true);
		TableauIndividu.setVisible(false);
	}

	@FXML
	void BTGraphAge(ActionEvent event) {

	}

	/**
	 * R�cup�re les donn�es de la base en fonction de la requete qui lui est pass�e
	 * 
	 * @param requete
	 * @return la liste d'�l�ment � mettre dans un axe
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

	private ObservableList<Individu> getIndividuList() {
		long secu = Long.parseLong("8888888888888");
		Individu indi1 = new Individu("CONAN", "Harold", new Date("04/28/1999"), true, secu);
		Individu indi2 = new Individu("CONAN", "Harold", new Date("04/28/1999"), true, secu);
		Individu indi3 = new Individu("CONAN", "Harold", new Date("04/28/1999"), true, secu);
		Individu indi4 = new Individu("CONAN", "Harold", new Date("04/28/1999"), true, secu);
		ObservableList<Individu> list = FXCollections.observableArrayList(indi1, indi2, indi3, indi4);
		return list;
	}
}
