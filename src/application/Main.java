package application;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.enums.TipoDeConta;

public class Main {

	public static void main(String[] args) {

		try {
			Banco banco = new Banco("Inter");

			System.out.println("========== Teste 1 - Criando clientes ==========");
			Cliente cliente1 = new Cliente("Thales");
			Cliente cliente2 = new Cliente("Isabella");
			banco.novoCliente(cliente1);
			banco.novoCliente(cliente2);
			System.out.println(banco);

			System.out.println("\n========== Teste 2 - Criando contas ==========");
			Conta conta1 = new ContaCorrente(1000.0, cliente1);
			Conta conta2 = new ContaCorrente(2000.0, cliente2);
			Conta conta3 = new ContaPoupanca(4000.0, cliente1);
			Conta conta4 = new ContaPoupanca(8000.0, cliente2);
			TipoDeConta corrente = TipoDeConta.CORRENTE;
			TipoDeConta poupanca = TipoDeConta.POUPANCA;
			banco.abrirConta(conta1, corrente);
			banco.abrirConta(conta2, corrente);
			banco.abrirConta(conta3, poupanca);
			banco.abrirConta(conta4, poupanca);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 3 - Depositando ==========");
			Conta c1 = banco.obterContaPeloId(1);
			c1.depositar(500);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 4 - Sacando ==========");
			Conta c3 = banco.obterContaPeloId(3);
			c3.sacar(500.0);
			System.out.println(banco);

//			System.out.println("\n========== Teste 5 - Saque maior que saldo ==========");
//			cp1.sacar(4000.0);
//			System.out.println(banco);

			System.out.println("\n========== Teste 6 - Transferir CC - CC ==========");
			Conta c2 = banco.obterContaPeloId(2);
			c2.transferir(c1, 10.0);
			
			System.out.println("\n========== Teste 7 - Transferir CC - CP==========");
			c1.transferir(c3, 20.0);
			
			System.out.println("\n========== Teste 8 - Transferir CP - CP==========");
			Conta c4 = banco.obterContaPeloId(4);
			c1.transferir(c4, 35.0);
			
			System.out.println("\n========== Teste 9 - Transferir CP - CC ==========");
			c4.transferir(c2, 41.0);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 10 - Transferir mais que ou saldo ==========");
			c1.transferir(c2, 10000.0);
			System.out.println(banco);
			
			System.out.println("\n========== FIM DOS TESTES ==========");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
