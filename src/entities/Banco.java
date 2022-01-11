package entities;

import java.util.HashSet;
import java.util.Set;

import entities.enums.TipoDeConta;

public class Banco {

	private String nome;

	private Set<ContaCorrente> contasC;
	private Set<ContaPoupanca> contasP;
	private Set<Cliente> listaCliente;

	public Banco() {
	}

	public Banco(String nome) {
		this.nome = nome;
		contasC = new HashSet<>();
		contasP = new HashSet<>();
		listaCliente = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ContaCorrente> getContasC() {
		return contasC;
	}

	public Set<ContaPoupanca> getContasP() {
		return contasP;
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
		if (contasP.contains(conta)) {
			throw new RuntimeException("Erro ao abrir conta poupanca. Já existe uma conta corrente com esse id.");
		} else {
			conta.getCliente().getContas().add(conta);
			contasP.add((ContaPoupanca)conta);
		}
	}

	private void abrirCC(Conta conta) {
		if (contasC.contains(conta)) {
			throw new RuntimeException("Erro ao abrir conta corrente. Já existe uma conta corrente com esse id.");
		} else {
			conta.getCliente().getContas().add(conta);
			contasC.add((ContaCorrente)conta);
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

	public Conta obterContaPeloId(int id) {
		Conta conta = obterContaCorrentePeloId(id);
		if(conta == null) {
			return obterContaPoupancaPeloId(id);
		}
		return conta;
	}
	
	public Conta obterContaCorrentePeloId(int id) {
		for (Conta c : contasC) {
			if (c.getId() == id){
				return c;
			}
		}
		return null;
	}
	
	public Conta obterContaPoupancaPeloId(int id) {
		for (Conta p : contasP) {
			if (p.getId() == id){
				return p;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Banco [nome=" + nome + ", Clientes=" + listaCliente + "]";
	}

}
