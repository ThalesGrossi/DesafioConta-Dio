package entities;

import java.util.HashSet;
import java.util.Set;

import entities.enums.TipoDeConta;

public class Banco {

	private String nome;

	private Set<ContaCorrente> listaCC;
	private Set<ContaPoupanca> listaPoupanca;
	private Set<Cliente> listaCliente;

	public Banco() {
	}

	public Banco(String nome) {
		this.nome = nome;
		listaCC = new HashSet<>();
		listaPoupanca = new HashSet<>();
		listaCliente = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ContaCorrente> getListaCCorrente() {
		return listaCC;
	}

	public Set<ContaPoupanca> getListaCPoupanca() {
		return listaPoupanca;
	}

	public Set<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void novoCliente(Cliente cliente) {
		try {
			if (listaCliente.contains(cliente)) {
				throw new RuntimeException("Erro ao criar cliente. Já existe um cliente com este id.");
			} else {
				listaCliente.add(cliente);
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	public void abrirConta(Conta conta, TipoDeConta tipo) {
		try {
			switch(tipo) {
				case CORRENTE:
					abrirCC(conta);
					break;
				case POUPANCA:
					abrirCP(conta);
					break;
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void abrirCP(Conta conta) {
		if (listaPoupanca.contains(conta)) {
			throw new RuntimeException("Erro ao abrir conta corrente. Já existe uma conta corrente com esse id.");
		} else {
			conta.getCliente().getContas().add(conta);
			listaPoupanca.add((ContaPoupanca)conta);
		}
	}

	private void abrirCC(Conta conta) {
		if (listaCC.contains(conta)) {
			throw new RuntimeException("Erro ao abrir conta corrente. Já existe uma conta corrente com esse id.");
		} else {
			conta.getCliente().getContas().add(conta);
			listaCC.add((ContaCorrente)conta);
		}
	}

	public void abrirContaPoupanca(ContaPoupanca poupanca) {
		try {
			if (listaPoupanca.contains(poupanca)) {
				throw new RuntimeException("Erro ao abrir conta poupança. Já existe uma conta poupança com esse id.");
			} else {
				poupanca.getCliente().getContas().add(poupanca);
				listaPoupanca.add(poupanca);
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
		for (ContaCorrente cc : listaCC) {
			if (cc.getId() == id) {
				return cc;
			}
		}
		return null;
	}

	public ContaPoupanca obterCPoupancaPeloId(int id) {
		for (ContaPoupanca cp : listaPoupanca) {
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
