package entities;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private static int sequencial = 0;
	
	private String nome;
	private int id;

	private Set<Conta> contas;

	public Cliente() {
		sequencial++;
		id = sequencial;
	}

	public Cliente(String nome) {
		sequencial++;
		this.nome = nome;
		id = sequencial;
		this.contas = new HashSet<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", id=" + id + ", " + contas + "]";
	}

	
}
