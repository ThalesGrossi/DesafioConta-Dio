package entities;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(int id, double saldo, Cliente cliente) {
		super(id, saldo, cliente);
	}
	
	@Override
	public String toString() {
		return "[id=" + super.getId() + ", saldo=" + super.getSaldo() + "]";
	}
}
