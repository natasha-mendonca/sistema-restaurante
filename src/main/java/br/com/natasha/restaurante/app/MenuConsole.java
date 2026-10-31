package br.com.natasha.restaurante.app;

import br.com.natasha.restaurante.cardapio.Lanche;
import br.com.natasha.restaurante.pedido.Pedido;

import java.util.Collection;
import java.util.Scanner;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String lerNomeCliente() {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        return nome;
    }

    public int lerOpcaoLanche() {
        System.out.println("=== CARDÁPIO ===");
        System.out.println("1 - X-Burger  R$ 16,00");
        System.out.println("2 - X-Salada  R$ 18,00");
        System.out.println("3 - X-Bacon   R$ 22,00");
        System.out.print("Escolha o lanche: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public boolean perguntarAdicionarMais() {
        System.out.print("Deseja adicionar mais um item? (s/n): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("Pedido nº " + pedido.getNumero() + " - Cliente: " + pedido.getNomeCliente());
        for (Lanche lanche : pedido.getItens()) {
            System.out.printf(" %s - R$ %.2f%n", lanche.getNome(), lanche.getPreco());
        }
        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println("=== FECHAMENTO DO DIA ===");
        System.out.printf("Total vendido: R$ %.2f%n", total);
        System.out.println();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}