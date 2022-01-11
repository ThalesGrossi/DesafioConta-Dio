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
			Conta contaCorrente1 = new ContaCorrente(1000.0, cliente1);
			Conta contaCorrente2 = new ContaCorrente(2000.0, cliente2);
			Conta contaPoupanca1 = new ContaPoupanca(4000.0, cliente1);
			Conta contaPoupanca2 = new ContaPoupanca(8000.0, cliente2);
			TipoDeConta corrente = TipoDeConta.CORRENTE;
			TipoDeConta poupanca = TipoDeConta.POUPANCA;
			banco.abrirConta(contaCorrente1, corrente);
			banco.abrirConta(contaCorrente2, corrente);
			banco.abrirConta(contaPoupanca1, poupanca);
			banco.abrirConta(contaPoupanca2, poupanca);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 3 - Depositando ==========");
			ContaCorrente cc1 = banco.obterCCorrentePeloId(1);
			cc1.depositar(500);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 4 - Sacando ==========");
			ContaPoupanca cp1 = banco.obterCPoupancaPeloId(1);
			cp1.sacar(500.0);
			System.out.println(banco);

//			System.out.println("\n========== Teste 5 - Saque maior que saldo ==========");
//			cp1.sacar(4000.0);
//			System.out.println(banco);

			System.out.println("\n========== Teste 6 - Transferir CC - CC ==========");
			ContaCorrente cc2 = banco.obterCCorrentePeloId(2);
			cc2.transferir(cc1, 10.0);
			
			System.out.println("\n========== Teste 7 - Transferir CC - CP==========");
			cc1.transferir(cp1, 20.0);
			
			System.out.println("\n========== Teste 8 - Transferir CP - CP==========");
			ContaPoupanca cp2 = banco.obterCPoupancaPeloId(2);
			cp1.transferir(cp2, 35.0);
			
			System.out.println("\n========== Teste 9 - Transferir CP - CC ==========");
			cp2.transferir(cc2, 41.0);
			System.out.println(banco);
			
			System.out.println("\n========== Teste 10 - Transferir mais que ou saldo ==========");
			cc1.transferir(cc2, 10000.0);
			System.out.println(banco);
			
			System.out.println("\n========== FIM DOS TESTES ==========");
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
