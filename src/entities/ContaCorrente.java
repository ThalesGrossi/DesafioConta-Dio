package entities;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(double saldo, Cliente cliente) {
		super(saldo, cliente);
	}
	
	@Override
	public String toString() {
		return "Conta corrente=[id=" + super.getId() + ", saldo=" + super.getSaldo() + "]";
	}
}
