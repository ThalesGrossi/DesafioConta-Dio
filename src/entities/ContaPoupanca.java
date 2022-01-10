package entities;

public class ContaPoupanca {

	private int id;
	private double saldo;
	private Cliente cliente;
	
	public ContaPoupanca() {
	}

	public ContaPoupanca(int id, double saldo, Cliente cliente) {
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
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
		ContaPoupanca other = (ContaPoupanca) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public void sacar(double quantia) {
		try {
			if (saldoSuficiente(quantia)) {
				saldo -= quantia;
			} else {
				throw new RuntimeException("Erro ao tentar sacar. Saldo insuficiente");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean saldoSuficiente(double quantia) {
		return saldo > quantia;
	}
	
	public void depositar(double quantia) {
		saldo +=quantia;
	}
	
	public void transferir(ContaCorrente contaCorrente, double quantia) {
		this.sacar(quantia);
		contaCorrente.depositar(quantia);
	}
	
	public void transferir(ContaPoupanca contaPoupanca, double quantia) {
		this.sacar(quantia);
		contaPoupanca.depositar(quantia);
	}
}
