package server;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import models.Arquivo;

public class Servidor implements InterfaceDoServidor, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static HashMap<String,Arquivo> listaDeArquivosEmCache =new HashMap<String, Arquivo>();
	static LinkedList<String> acesso =new LinkedList<String>();	
	StubProxy cliente = new StubProxy();
	
	@Override
	public ArrayList<String> receberLista() throws RemoteException {
		System.out.println("Servidor Proxy - Cliente Solicitou lista de arquivos.\n"
				+ " Consultar no servidor de arquivos e retornar para o cliente.\n");
		return cliente.receberLista();
	}
	
	@Override
	public Arquivo enviarArquivo(String nome) throws RemoteException{
		System.out.println("enviar arquivo no proxy");
		if(listaDeArquivosEmCache.get(nome) != null) {
			System.out.println("Enviando arquivo gravado em cache.");
			return listaDeArquivosEmCache.get(nome);
		}else {
			int index = acesso.indexOf(nome);
			if(index == -1) {
				System.out.println("Primeiro acesso ao arquivo. Pegar do servidor");
				acesso.add(nome);
				return cliente.enviarArquivo(nome);
			}else {
				System.out.println("Segundo acesso ao arquivo. Pegar do servidor e guardar na cache");
				acesso.remove(index);
				Arquivo arquivo = cliente.enviarArquivo(nome);
				listaDeArquivosEmCache.put(nome, arquivo);
				return arquivo;
			}
		}
	}
	
	public void limparCache() throws RemoteException{
		acesso.clear();
	}

	@Override
	public void receberArquivo(Arquivo arquivo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
}
