package entities;

public abstract class Conta {

	private int id;
	private double saldo;
	private Cliente cliente;

	public Conta() {
	}

	public Conta(int id, double saldo, Cliente cliente) {
		this.id = id;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Conta other = (Conta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void sacar(double quantia) {
		if (saldoSuficiente(quantia)) {
			saldo -= quantia;
		} else {
			throw new RuntimeException("Erro ao tentar sacar. Saldo insuficiente");
		}
	}

	private boolean saldoSuficiente(double quantia) {
		return saldo > quantia;
	}

	public void depositar(double quantia) {
		saldo += quantia;
	}

	public void transferir(Conta conta, double quantia) {
		try {
		conta.depositar(quantia);
		this.sacar(quantia);
		} catch (RuntimeException e) {
			throw new RuntimeException("Erro ao tentar transferir. Saldo insuficiente.");
		}
	}

	@Override
	public String toString() {
		return "[id=" + id + ", saldo=" + saldo + "]";
	}
}
