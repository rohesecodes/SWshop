package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.ServiceClient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

import javafx.stage.Stage;
public class SampleController implements Initializable {
	@FXML
	private Button buttonLoggin;
	@FXML
	private Button buttonSignUp;
	@FXML
	private Button buttonPrefill;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfPassword;
	@FXML
	private Label currentStageLabel;
	
	@Override
	public void initialize(URL url, ResourceBundle rbl) {
		
		onLogInButton();
		onButtonPrefill();
		onButtonSignUp();
	}
	
	
	private void onLogInButton() {
		buttonLoggin.setOnAction(e-> {
			checkLogin();
	});
	}
	
	private void checkLogin() {
		ServiceClient serviceClient = new ServiceClient();
		try {
			if((serviceClient.findClient(tfName.getText(), tfPassword.getText()).getName() +
					serviceClient.findClient(tfName.getText(), tfPassword.getText()).getPassword())
					.equals(tfName.getText() + tfPassword.getText())) {
				System.out.print("User loggedin successfully");
				//create a new stage, scene and open the home window
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("logged-in.fxml"));
				Scene scene = new Scene(fxmlLoader.load(), 658, 589);
				Stage stage = new Stage();
				stage.setTitle("Star Wars shop");
				stage.setScene(scene);
				stage.show();
				
				//close the last scene
				Stage currentStage = (Stage) currentStageLabel.getScene().getWindow();
				currentStage.close();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	private void onButtonPrefill() {
		buttonPrefill.setOnAction(e-> {
			tfName.setText("diana");
			tfPassword.setText("12");
	});
	}
	private void onButtonSignUp() {
		buttonSignUp.setOnAction(e-> {
			//create a new stage, scene and open the home window
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("sign_up.fxml"));
			Scene scene;
			try {
				scene = new Scene(fxmlLoader.load(), 562, 318);
				Stage stage = new Stage();
				stage.setTitle("Register");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//close the last scene
			Stage currentStage = (Stage) currentStageLabel.getScene().getWindow();
			currentStage.close();
	});
	}
	
}
