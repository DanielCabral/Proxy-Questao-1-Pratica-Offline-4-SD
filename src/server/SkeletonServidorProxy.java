package server;



import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkeletonServidorProxy {
	// Constantes que indicam onde est´a sendo executado o servi¸co de registro,
	// qual porta e qual o nome do objeto distribu´ıdo
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12345;
	private static final String NOMEOBJDIST = "SistemaDistribuido";
	public SkeletonServidorProxy() {
		try {
			// Criando
			Servidor s = new Servidor();
			
			//Politica de seguran�a
			System.setProperty("java.security.policy", "java.policy");
			if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager());
			}
			
			System.setProperty("java.security.policy","file:java.policy");

			
			// Definindo o hostname do servidor
			System.setProperty("java.rmi.server.hostname", nomeServidor);
			
			InterfaceDoServidor stub = (InterfaceDoServidor)
			UnicastRemoteObject.exportObject(s, 0);
			
			// Criando serviço de registro
			Registry registro = LocateRegistry.createRegistry(porta);
			
			// Registrando objeto distribu´ıdo
			registro.bind(NOMEOBJDIST, stub);
			System.out.println("Servidor proxy pronto!\n");
			System.out.println("Endere�o: "+nomeServidor+"\nPorta: "+porta+"\n");
			System.out.println("Pressione CTRL + C para encerrar...");
		} catch (RemoteException | AlreadyBoundException ex) {
			Logger.getLogger(SkeletonServidorProxy.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void main(String args[]){
		
	}
}