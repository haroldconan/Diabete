package application;
	
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;


public class Main extends Application {
	private static Stage stage;
	private static ComboBox<String> comboSexe;
	private static ComboBox<String> comboTourTaille;
	private static ComboBox<String> comboActiviteePhysique;
	private static ComboBox<String> comboAntiHTA;
	private static ComboBox<String> comboLegumes;
	private static ComboBox<String> comboGlyce;
	private static ComboBox<String> comboFamille;
	
	
	static ObservableList<String> listTourTaille = FXCollections.observableArrayList("<94", "94-102",">102");
	static ObservableList<String> listSexe = FXCollections.observableArrayList("Homme", "Femme");
	static ObservableList<String> listActiviteePhysique = FXCollections.observableArrayList("Oui","Non");
	static ObservableList<String> listAntiHTA = FXCollections.observableArrayList("Non","Oui");
	static ObservableList<String> listLegumes = FXCollections.observableArrayList("Non", "Tous les jours","Pas tous les jours");
	static ObservableList<String> listGlycee = FXCollections.observableArrayList("Non","Oui");
	static ObservableList<String> listFamille = FXCollections.observableArrayList("Non","Oui (grands parents, tante, oncle, cousins)");
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setTitle("Diabete 2");
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent event) {
			    	int result = JOptionPane.showConfirmDialog(null, "Etes vous sûre de vouloir quitter ? ");
				    if(result == 1 || result == 2) {
				    	event.consume();
				    }
			    }
			});
			replaceSceneContent("designLog.fxml");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Parent replaceSceneContent(String fxml) {
		Parent page = null;
		try {System.out.println(fxml);
			page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.setMaximized(true);
            
        } else {
            stage.getScene().setRoot(page);
            if(fxml.equals("designInfoPatient.fxml")) {
            	
            	
            	comboSexe = (ComboBox<String>) scene.lookup("#sexe");
            	comboSexe.setItems(listSexe);
            	EventHandler<ActionEvent> event = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboSexe.getValue()); 
                      switch(comboSexe.getValue()) {
	                      case "Homme":{
	                    	  
	                      }break;
	                      case "Femme":{
	                    	  
	                      }break;
                      }
                  } 
            	};
            	comboSexe.setOnAction(event);
            	
            }
            if(fxml.equals("designDonneePatient.fxml")) {
            	comboTourTaille = (ComboBox<String>) scene.lookup("#tourTaille");
            	comboTourTaille.setItems(listTourTaille);
            	EventHandler<ActionEvent> eventTourTaille = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboTourTaille.getValue()); 
                      switch(comboTourTaille.getValue()) {
                      case "<94":{
                    	  
                      }break;
                      case "94-102":{
                    	  
                      }break;
                      case ">102":{
                    	  
                      }
                  }
                  } 
            	};
            	comboSexe.setOnAction(eventTourTaille);
            	
            	
            	comboActiviteePhysique = (ComboBox<String>) scene.lookup("#actiPhysique");
            	comboActiviteePhysique.setItems(listActiviteePhysique);
            	EventHandler<ActionEvent> eventActi = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboActiviteePhysique.getValue());
                      switch(comboActiviteePhysique.getValue()) {
                      case "Oui":{
                    	  
                      }break;
                      case "Non":{
                    	  
                      }break;
                  }
                  } 
            	};
            	comboActiviteePhysique.setOnAction(eventActi);
            	
            	comboAntiHTA = (ComboBox<String>) scene.lookup("#antiHTA");
            	comboAntiHTA.setItems(listAntiHTA);
            	EventHandler<ActionEvent> eventAntiHTA = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboAntiHTA.getValue()); 
                      switch(comboAntiHTA.getValue()) {
                      case "Oui":{
                    	  
                      }break;
                      case "Non":{
                    	  
                      }break;
                  }
                  } 
            	};
            	comboAntiHTA.setOnAction(eventAntiHTA);
            	
            	comboFamille = (ComboBox<String>) scene.lookup("#famille");
            	comboFamille.setItems(listFamille);
            	EventHandler<ActionEvent> eventFamille = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboFamille.getValue()); 
                      switch(comboFamille.getValue()) {
                      case "Oui (grands parents, tante, oncle, cousins)":{
                    	  
                      }break;
                      case "Non":{
                    	  
                      }break;
                  }
                      
                  } 
            	};
            	comboFamille.setOnAction(eventFamille);
            	
            	comboGlyce = (ComboBox<String>) scene.lookup("#glycemi");
            	comboGlyce.setItems(listGlycee);
            	EventHandler<ActionEvent> eventGlyce = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboGlyce.getValue()); 
                      switch(comboGlyce.getValue()) {
                      case "Oui":{
                    	  
                      }break;
                      case "Non":{
                    	  
                      }break;
                  }
                  } 
            	};
            	comboGlyce.setOnAction(eventGlyce);

            	comboLegumes = (ComboBox<String>) scene.lookup("#legumes");
            	comboLegumes.setItems(listLegumes);
            	EventHandler<ActionEvent> eventLegumes = 
                        new EventHandler<ActionEvent>() { 
                  public void handle(ActionEvent e) 
                  { 
                      System.out.println(comboLegumes.getValue()); 
                      switch(comboLegumes.getValue()) {
                      case "Non":{
                    	  
                      }break;
                      case "tous les jours":{
                    	  
                      }break;
                      case "Pas tous les jours":{
                    	  
                      }break;
                  }
                  } 
            	};
            	comboLegumes.setOnAction(eventLegumes);
            	
            	
            }
        }
        
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return page;
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
