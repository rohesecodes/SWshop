package dao;
import java.util.List;
import javax.persistence.Persistence;

import model.Client;

public class ServiceClient {
	private ClientDao clientdao;
	public ServiceClient() {
		try {
		 clientdao = new ClientDao(Persistence.createEntityManagerFactory("default"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addClient(Client newClient) {
		clientdao.create(newClient);
	}

	public void updateClient(Client updatedClient) {
		clientdao.update(updatedClient);
	}

	public List<Client> getAllClients() {
		return clientdao.findAll();
	}

	/// for login
	public Client findClient(String Client, String pass) throws Exception {
		List<Client> Clients = clientdao.find(Client);
		if (Clients.size() == 0) {
			throw new Exception("Client not found!");
		}
		Client u = Clients.get(0);

		if (pass.compareTo(u.getPassword()) != 0) {
			throw new Exception("Password does not match");
		}
		return u;
	}

}
