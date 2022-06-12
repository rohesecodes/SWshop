package dao;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Client;


public class ClientController {
	@FXML
	public ListView<Client> ClientListView;

	@FXML
	void initialize() {
		ServiceClient ClientService = new ServiceClient();
		List<Client> allClients = ClientService.getAllClients();

		System.out.println(allClients);
		ClientListView.setItems(FXCollections.observableArrayList(new ArrayList<Client>(allClients)));

		// test login
		try {
			System.out.println(ClientService.findClient("test", "1234").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
