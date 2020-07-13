package server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import models.Arquivo;




//Criando a interface (Skeleton) do servidor proxy
public interface InterfaceDoServidor extends Remote{

	public ArrayList<String> receberLista() throws RemoteException;	
	public Arquivo enviarArquivo(String nome) throws RemoteException;
	public void limparCache() throws RemoteException;
	public void receberArquivo(Arquivo arquivo) throws RemoteException;
}
