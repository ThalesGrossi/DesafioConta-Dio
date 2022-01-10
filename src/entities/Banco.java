package entities;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banco {

	private String nome;
	
	private Set<ContaCorrente> listaCCorrente = null;
	private Set<ContaPoupanca> listaCPoupan�a = null;
	private Set<Cliente> listaCliente = null;
	
	public Banco() {
	}
	
	public Banco(String nome) {
		this.nome = nome;
		listaCCorrente = new HashSet<>();
		listaCPoupan�a = new HashSet<>();
		listaCliente = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ContaCorrente> getListaCCorrente() {
		return listaCCorrente;
	}

	public Set<ContaPoupanca> getListaCPoupan�a() {
		return listaCPoupan�a;
	}

	public Set<Cliente> getListaCliente() {
		return listaCliente;
	}
}
