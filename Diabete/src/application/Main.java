package application;
	
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent event) {
			    	JOptionPane jop1 = new JOptionPane();
				    int result = jop1.showConfirmDialog(null, "Etes vous sûre de vouloir quitter ? ");
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
	
	public static Parent replaceSceneContent(String fxml) {
		Parent page = null;
		try {
			page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.setMaximized(true);
        } else {
            stage.getScene().setRoot(page);
        }
        
        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
