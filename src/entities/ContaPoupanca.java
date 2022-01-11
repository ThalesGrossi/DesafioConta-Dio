package entities;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(int id, double saldo, Cliente cliente) {
		super(id, saldo, cliente);
	}
	
	@Override
	public String toString() {
		return "[id=" + super.getId() + ", saldo=" + super.getSaldo() + "]";
	}
}
