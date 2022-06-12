package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class LoggedInController implements Initializable {
	@FXML
	Button buttonLogout;
	@FXML
	Button buttonBuy;
	@FXML
	RadioButton rb_item1;
	@FXML
	RadioButton rb_item2;
	@FXML
	RadioButton rb_item3;
	@FXML
	RadioButton rb_item4;
	@FXML
	RadioButton rb_item5;
	@FXML
	RadioButton rb_item6;
	@FXML
	RadioButton rb_item7;
	@FXML
	RadioButton rb_item8;
	@FXML
	RadioButton rb_item9;
	@FXML
	Label currentStageLabel;
	@FXML 
	MenuButton menuButton1;
	
	@FXML
	MenuItem size1;
	@FXML
	MenuItem size2;
	@FXML
	MenuItem size3;
	@FXML
	MenuItem size4;
	@FXML
	MenuItem size5;
	@FXML
	MenuItem size6;
	@FXML
	MenuItem size7;
	Size sizeItem1;
	int total =0;
	boolean item1;
	boolean item2;
	boolean item3;
	boolean item4;
	boolean item5;
	boolean item6;
	boolean item7;
	boolean item8;
	boolean item9;


	@Override
	public void initialize(URL url, ResourceBundle rbl) {
		onButtonBuy();
		onLogoutButton();
		onSize1();
		onSize2();
		onSize3();
		onSize4();
		onSize5();
		onSize6();
		onSize7();
		onrb_item1();
		onrb_item2();
		onrb_item3();
		onrb_item4();
		onrb_item5();
		onrb_item6();
		onrb_item7();
		onrb_item8();
		onrb_item9();
	}
	
	
	private void onrb_item9() {
		// TODO Auto-generated method stub
		rb_item9.setOnAction(e->{
			item9 =true;
			total += 10;
			System.out.println("click!");
		});
	}


	private void onrb_item8() {
		// TODO Auto-generated method stub
		rb_item8.setOnAction(e->{
			item8 = true;
			total += 10;
		});
	}


	private void onrb_item7() {
		// TODO Auto-generated method stub
		rb_item7.setOnAction(e->{
			item7 = true;
			total += 10;
		});
	}


	private void onrb_item6() {
		// TODO Auto-generated method stub
		rb_item6.setOnAction(e->{
			item6 = true;
			total += 12;
		});
	}


	private void onrb_item5() {
		// TODO Auto-generated method stub
		rb_item5.setOnAction(e->{
			item5 = true;
			total += 25;
		});
	}


	private void onrb_item4() {
		// TODO Auto-generated method stub
		rb_item4.setOnAction(e->{
			item4 = true;
			total += 15;
		});
	}


	private void onrb_item3() {
		// TODO Auto-generated method stub
		rb_item3.setOnAction(e->{
			item3 = true;
			total += 20;
		});
	}


	private void onrb_item2() {
		// TODO Auto-generated method stub
		rb_item2.setOnAction(e->{
			item2 = true;
			total += 20;
		});
	}


	private void onrb_item1() {
		// TODO Auto-generated method stub
		rb_item1.setOnAction(e->{
			item1 = true;
			total += 20;
		});
	}


	private void onSize7() {
		// TODO Auto-generated method stub
		size7.setOnAction(e->{
			sizeItem1 = Size.XXL;
		});
	}


	private void onSize6() {
		// TODO Auto-generated method stub
		size6.setOnAction(e->{
			sizeItem1 = Size.XXL;
		});
	}


	private void onSize5() {
		// TODO Auto-generated method stub
		size5.setOnAction(e->{
			sizeItem1 = Size.XL;
		});
	}


	private void onSize4() {
		// TODO Auto-generated method stub
		size4.setOnAction(e->{
			sizeItem1 = Size.L;
		});
	}


	private void onSize3() {
		// TODO Auto-generated method stub
		size3.setOnAction(e->{
			sizeItem1 = Size.M;
		});
	}


	private void onSize2() {
		// TODO Auto-generated method stub
		size2.setOnAction(e->{
			sizeItem1 = Size.S;
		});
	}


	private void onSize1() {
		// TODO Auto-generated method stub
		size1.setOnAction(e->{
			sizeItem1 = Size.XS;
			System.out.println("Size chosen!");
		});
	}
	
	private void onButtonBuy() {
	buttonBuy.setOnAction(e->{
		StringBuilder message = new StringBuilder();
		if(item1) 
			message.append("You have perchased item1 in size " + sizeItem1 + '\n');
		if(item2)
			message.append("You have perchased item2." + '\n');
		if(item3)
			message.append("You have perchased item3." + '\n');
		if(item4)
			message.append("You have perchased item4." + '\n');
		if(item5)
			message.append("You have perchased item5." + '\n');
		if(item6)
			message.append("You have perchased item6." + '\n');
		if(item7)
			message.append("You have perchased item7." + '\n');
		if(item8)
			message.append("You have perchased item8." + '\n');
		if(item9)
			message.append("You have perchased item9." +'\n');
		message.append("Total:"+ '\t' + total + "$");
		AlertBox.display("Items purchased successfully", message.toString());
		System.out.println(message);
	});
	}
	private void onLogoutButton() {
		buttonLogout.setOnAction(e-> {
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
