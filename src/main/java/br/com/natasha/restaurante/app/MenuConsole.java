package br.com.natasha.restaurante.app;

import br.com.natasha.restaurante.cardapio.ItemCardapio;
import br.com.natasha.restaurante.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Modificar pedido");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return lerInteiro();
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
        return lerInteiro();
    }

    public boolean perguntarAdicionarMais() {
        System.out.print("Deseja adicionar mais um item? (s/n): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public boolean perguntarAdicional(String adicional) {
        System.out.printf("Adicionar %s? (s/n): ", adicional);
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("Pedido nº " + pedido.getNumero() + " - Cliente: " + pedido.getNomeCliente());
        for (ItemCardapio itemCardapio : pedido.getItens()) {
            System.out.printf(" %s - R$ %.2f%n", itemCardapio.getDescricao(), itemCardapio.getPreco());
        }
        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirFechamentoDoDia(double total, HashSet<String> combinacoes) {
        System.out.println("=== FECHAMENTO DO DIA ===");
        System.out.printf("Total vendido: R$ %.2f%n", total);
        System.out.printf("Combinações diferentes: %d%n", combinacoes.size());
        for (String combinacao : combinacoes) {
            System.out.println(" - " + combinacao);
        }
        System.out.println();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public boolean perguntarRetirar(String ingrediente) {
        System.out.printf("Retirar %s? (s/n): ", ingrediente);
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("s");
    }

    public int lerNumeroPedido() {
        System.out.print("Número do pedido: ");
        return lerInteiro();
    }

    public int lerOpcaoModificacao() {
        System.out.println("=== MODIFICAR PEDIDO ===");
        System.out.println("1 - Acrescentar item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Cancelar pedido");
        System.out.print("Escolha uma opção: ");
        return lerInteiro();
    }

    public int lerNumeroItem(Pedido pedido) {
        int contador = 1;
        for (ItemCardapio itemCardapio : pedido.getItens()) {
            System.out.printf(" %d. %s - R$ %.2f%n", contador, itemCardapio.getDescricao(), itemCardapio.getPreco());
            contador++;
        }
        System.out.print("Número do item: ");
        return lerInteiro();
    }

    private int lerInteiro() {
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Valor inválido. Digite um número: ");
            }
        }
    }
}