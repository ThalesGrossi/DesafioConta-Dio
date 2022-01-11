package entities;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(double saldo, Cliente cliente) {
		super(saldo, cliente);
	}
	
	@Override
	public String toString() {
		return "Poupança=[id=" + super.getId() + ", saldo=" + super.getSaldo() + "]";
	}
}
