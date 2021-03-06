package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Servidor.fxml"));			
			Scene scene = new Scene(root,245,162);
			primaryStage.setScene(scene);
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setTitle("Servidor Proxy");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {	
		launch(args);
	}
}
