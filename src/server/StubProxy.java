package server;



import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Arquivo;

public class StubProxy {
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12344;
	private static final String NOMEOBJDIST = "ServidorDeArquivos";
	Registry registro;
	InterfaceDoServidor stub;
	
	public StubProxy() {
		try {
			
			//Politica de seguran�a
			System.setProperty("java.security.policy", "java.policy");
			if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager());
			}
			
			System.setProperty("java.security.policy","file:java.policy");
			
			
			// Obtendo refer^encia do servi¸co de registro
			registro = LocateRegistry.getRegistry(nomeServidor, porta);
			System.out.println("Conectado com servidor");
			// Procurando pelo objeto distribu´ıdo registrado previamente com o NOMEOBJDIST
			stub = (InterfaceDoServidor) registro.lookup(NOMEOBJDIST);
		} catch (RemoteException | NotBoundException ex) {
			Logger.getLogger(StubProxy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	public ArrayList<String> receberLista() throws RemoteException {
		System.out.println("Receber lista "+stub);
		return stub.receberLista();
	}
	
	public Arquivo enviarArquivo(String nome) throws RemoteException{
		return stub.enviarArquivo(nome);
	}
	
	public void limparCache() throws RemoteException{
		stub.limparCache();
	}
	
	public void receberArquivo(Arquivo arquivo) throws RemoteException, ParseException {
		stub.receberArquivo(arquivo);
	}
	
	public static void main(String [] args) {
	
	}
	
}
