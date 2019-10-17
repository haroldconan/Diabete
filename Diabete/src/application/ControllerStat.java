package application;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import bd.Connexion;
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

		XYChart.Series set1 = GetStatHomme("");
		set1.setName("Pourcentage de patients Homme");

		XYChart.Series set2 = GetStatFemme("");
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
	 * Récupère les données de la base en fonction de la requete qui lui est passée
	 * 
	 * @param requete
	 * @return la liste d'élément à mettre dans un axe
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private XYChart.Series GetStatHomme(String requete) {

		XYChart.Series serieBDD = new XYChart.Series<>();
		serieBDD.getData().add(new XYChart.Data("Risque de 1%", Connexion.getStat1AccueilH()));
		serieBDD.getData().add(new XYChart.Data("Risque de 4%", Connexion.getStat4AccueilH()));
		serieBDD.getData().add(new XYChart.Data("Risque de 17%", Connexion.getStat17AccueilH()));
		serieBDD.getData().add(new XYChart.Data("Risque de 33%", Connexion.getStat33AccueilH()));
		serieBDD.getData().add(new XYChart.Data("Risque de 50%", Connexion.getStat50AccueilH()));

		return serieBDD;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private XYChart.Series GetStatFemme(String requete) {

		XYChart.Series serieBDD = new XYChart.Series<>();
		serieBDD.getData().add(new XYChart.Data("Risque de 1%", Connexion.getStat1AccueilF()));
		serieBDD.getData().add(new XYChart.Data("Risque de 4%", Connexion.getStat4AccueilF()));
		serieBDD.getData().add(new XYChart.Data("Risque de 17%", Connexion.getStat17AccueilF()));
		serieBDD.getData().add(new XYChart.Data("Risque de 33%", Connexion.getStat33AccueilF()));
		serieBDD.getData().add(new XYChart.Data("Risque de 50%", Connexion.getStat50AccueilF()));

		return serieBDD;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private XYChart.Series GetStatGene(String requete) {

		XYChart.Series serieBDD = new XYChart.Series<>();
		serieBDD.getData().add(new XYChart.Data("Risque de 1%", Connexion.getStat1Accueil()));
		serieBDD.getData().add(new XYChart.Data("Risque de 4%", Connexion.getStat4Accueil()));
		serieBDD.getData().add(new XYChart.Data("Risque de 17%", Connexion.getStat17Accueil()));
		serieBDD.getData().add(new XYChart.Data("Risque de 33%", Connexion.getStat33Accueil()));
		serieBDD.getData().add(new XYChart.Data("Risque de 50%", Connexion.getStat50Accueil()));

		return serieBDD;
	}

	private ObservableList<Individu> getIndividuList() {
		
		ObservableList<Individu> list = FXCollections.observableArrayList();
		try {
			list.addAll(Connexion.getListIndividues());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
