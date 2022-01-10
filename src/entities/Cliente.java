package entities;

public class Cliente {

	private String nome;
	private int id;
	
	ContaCorrente cc;
	ContaPoupanca cp;
	
	public Cliente() {
	}

	public Cliente(String nome, int id) {
		this.nome = nome;
		this.id = id;
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
		this.cp = contaPoupanca;
	}
	
	public ContaCorrente getContaCorrente() {
		return this.cc;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.cc = contaCorrente;
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
	
	public void abrirContaCorrente(int id, double saldo) {
		cc = new ContaCorrente(id, saldo, this);
	}
	
	public void abrirContaPoupanca(int id, double saldo) {
		cp = new ContaPoupanca(id, saldo, this);
	}
}
