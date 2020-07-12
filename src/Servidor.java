

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor implements InterfaceDoServidor, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static HashMap<String,String> listaDeArquivosEmCache =new HashMap<String, String>();
	StubProxy cliente = new StubProxy();
	
	@Override
	public ArrayList<String> receberLista() throws RemoteException {
		System.out.println("Servidor Proxy - Cliente Solicitou lista de arquivos.\n"
				+ " Consultar no servidor de arquivos e retornar para o cliente.\n");
		return cliente.receberLista();
	}
	
	@Override
	public ArrayList<String> receberArquivo(String nome) throws RemoteException {
		//ArrayList<String> listaDeArquivos1 = new ArrayList<String>(listaDeArquivos.keySet());
		return cliente.receberLista();
	}
	
	
}
