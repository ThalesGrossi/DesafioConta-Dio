package entities;

public class Cliente {

	private String nome;
	private int id;

	private ContaCorrente cc;
	private ContaPoupanca cp;

	public Cliente() {
	}

	public Cliente(String nome, int id) {
		this.nome = nome;
		this.id = id;
		this.cc = null;
		this.cp = null;
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

	public ContaPoupanca getContaPoupanca() {
		return this.cp;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		if (cp != null) {
			throw new RuntimeException("Erro ao criar conta poupança. Esse cliente já possui uma conta poupança.");
		} else {
			cp = contaPoupanca;
		}
	}

	public ContaCorrente getContaCorrente() {
		return this.cc;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		if (cc != null) {
			throw new RuntimeException("Erro ao criar conta corrente. Esse cliente já possui uma conta corrente.");
		} else {
			cc = contaCorrente;
		}
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
		return "Cliente [nome=" + nome + ", id=" + id + ", Conta corrente=" + cc + ", Conta poupança=" + cp + "]";
	}

	
}
