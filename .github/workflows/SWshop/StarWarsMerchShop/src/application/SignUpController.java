package application;

import java.net.URL;
import java.util.ResourceBundle;



import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dao.ServiceClient;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.stage.Stage;


public class SignUpController implements Initializable{
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfPassword;
	@FXML
	private Label currentStageLabel;
	@FXML 
	private Button buttonCreateAccount;
	@FXML
	private Button buttonLogin;
	
	@Override
	public void initialize(URL url, ResourceBundle rbl) {
		onButtonCreateAccount();
		onLoginButton();
		
	}
	
	private void onButtonCreateAccount() {
		buttonCreateAccount.setOnAction(e->{
		
		if(tfName.getText().isEmpty() || tfPassword.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText("You must complete all fields for registration!");
		alert.show();
		System.out.println("Empty fields");
		}
		else if (retrieveUsername(tfName.getText())) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Username already exists!");
			alert.show();
			System.out.println("User already exists");
		}
        else {
			createUser();
		}
		
		});
	}
	
	private void createUser() {
		// TODO Auto-generated method stub
		ServiceClient serviceClient = new ServiceClient();
		model.Client client = new model.Client();
		client.setName(tfName.getText());
		client.setPassword(tfPassword.getText());
		System.out.println(client.getName() + " " + client.getPassword());
		serviceClient.addClient(client);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText("User succesfully created.");
		alert.show();
	}
	private boolean retrieveUsername(String name) {
		// TODO Auto-generated method stub
		ServiceClient serviceClient = new ServiceClient();
		for(model.Client client : serviceClient.getAllClients())
			if(name.equals(client.getName()))
				return true;
		return false;
	}
	private void onLoginButton() {
		buttonLogin.setOnAction(e-> {
			//create a new stage, scene and open the home window
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("sample.fxml"));
			Scene scene;
			try {
				scene = new Scene(fxmlLoader.load(), 625, 407);
				Stage stage = new Stage();
				stage.setTitle("Login");
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
