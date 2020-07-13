package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import server.StubProxy;

public class ServidorController implements Initializable {
	@FXML
	ImageView imagem;
	
	@FXML
	javafx.scene.control.ListView listaDeArquivos;
	
	StubProxy stub;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stub =new StubProxy();
	}	
	
	
	@FXML
	public void pararServidor() throws RemoteException {
		stub.limparCache();
	}
}
