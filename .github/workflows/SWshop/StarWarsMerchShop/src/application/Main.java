package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
			primaryStage.setTitle("Star Wars Shop");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
