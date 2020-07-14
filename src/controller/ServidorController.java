package controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import server.SkeletonServidorProxy;
import server.StubProxy;

public class ServidorController implements Initializable {
	
	StubProxy stub;
	SkeletonServidorProxy skeleton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stub =new StubProxy();
		skeleton=new SkeletonServidorProxy();
	}	
	
	
	@FXML
	public void pararServidor() throws RemoteException {
		stub.limparCache();
	}
}
