package entities;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banco {

	private String nome;

	private Set<ContaCorrente> listaCCorrente;
	private Set<ContaPoupanca> listaCPoupanca;
	private Set<Cliente> listaCliente;

	public Banco() {
	}

	public Banco(String nome) {
		this.nome = nome;
		listaCCorrente = new HashSet<>();
		listaCPoupanca = new HashSet<>();
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

	public Set<ContaPoupanca> getListaCPoupanca() {
		return listaCPoupanca;
	}

	public Set<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void novoCliente(Cliente cliente) {
		try {
			if (listaCliente.contains(cliente)){
				throw new RuntimeException("Erro ao criar cliente. Já existe um cliente com este id.");
			} else {
				listaCliente.add(cliente);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void abrirContaCorrente(ContaCorrente contaCorrente) {
		try {
			if (listaCCorrente.contains(contaCorrente)) {
				throw new RuntimeException("Erro ao abrir conta corrente. Já existe uma conta corrente com esse id.");
			} else {
				contaCorrente.getCliente().setContaCorrente(contaCorrente);
				listaCCorrente.add(contaCorrente);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void abrirContaPoupanca(ContaPoupanca contaPoupanca) {
		try {
			if (listaCPoupanca.contains(contaPoupanca)) {
				throw new RuntimeException("Erro ao abrir conta poupança. Já existe uma conta poupança com esse id.");
			} else {
				contaPoupanca.getCliente().setContaPoupanca(contaPoupanca);
				listaCPoupanca.add(contaPoupanca);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public Cliente obterClientePeloId(int id) {
		for (Cliente client : listaCliente) {
			if (client.getId() == id) {
				return client;
			}
		}
		return null;
	}
	
	public ContaCorrente obterCCorrentePeloId(int id) {
		for (ContaCorrente cc : listaCCorrente) {
			if (cc.getId() == id) {
				return cc;
			}
		}
		return null;
	}
	
	public ContaPoupanca obterCPoupancaPeloId(int id) {
		for (ContaPoupanca cp : listaCPoupanca) {
			if (cp.getId() == id) {
				return cp;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Banco [nome=" + nome + ", Clientes=" + listaCliente + "]";
	}

}
