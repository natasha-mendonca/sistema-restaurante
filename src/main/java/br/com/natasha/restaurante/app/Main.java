package br.com.natasha.restaurante.app;


import br.com.natasha.restaurante.pedido.Pedido;

public class Main {
    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        int opcao = 1;

        while (opcao != 0) {
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {
                case 1:
                    String nome = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nome);
                    boolean continuar = true;
                    while (continuar) {
                        int opcaoLanche = menu.lerOpcaoLanche();
                        boolean semQueijo = menu.perguntarRetirar("queijo");
                        boolean semAlface = menu.perguntarRetirar("alface");
                        boolean semTomate = menu.perguntarRetirar("tomate");
                        boolean semCebola = menu.perguntarRetirar("cebola");
                        boolean comCheddar = menu.perguntarAdicional("cheddar (+ R$ 4,00)");
                        boolean comBaconExtra = menu.perguntarAdicional("bacon extra (+ R$ 6,00)");
                        if (!sistema.adicionarLanche(pedido, opcaoLanche, semQueijo, semAlface, semTomate, semCebola, comCheddar, comBaconExtra)) {
                            menu.exibirMensagem("Lanche inválido.");
                        }
                        continuar = menu.perguntarAdicionarMais();
                    }
                    menu.exibirPedido(pedido);
                    break;

                case 2:
                    menu.exibirPedidos(sistema.listarPedidos());
                    break;
                case 3:
                    double total = sistema.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total, sistema.listarCombinacoes());
                    break;
                case 4:
                    int numeroPedido = menu.lerNumeroPedido();
                    Pedido pedidoEncontrado = sistema.buscarPedido(numeroPedido);
                    if (pedidoEncontrado == null) {
                        menu.exibirMensagem("Pedido não encontrado.");
                        break;
                    }
                    int opcaoModificacao = menu.lerOpcaoModificacao();
                    if (opcaoModificacao == 1) {
                        int opcaoLanche = menu.lerOpcaoLanche();
                        boolean semQueijo = menu.perguntarRetirar("queijo");
                        boolean semAlface = menu.perguntarRetirar("alface");
                        boolean semTomate = menu.perguntarRetirar("tomate");
                        boolean semCebola = menu.perguntarRetirar("cebola");
                        boolean comCheddar = menu.perguntarAdicional("cheddar (+ R$ 4,00)");
                        boolean comBaconExtra = menu.perguntarAdicional("bacon extra (+ R$ 6,00)");
                        if (!sistema.adicionarLanche(pedidoEncontrado, opcaoLanche, semQueijo, semAlface, semTomate, semCebola, comCheddar, comBaconExtra)) {
                            menu.exibirMensagem("Lanche inválido.");
                        }
                        menu.exibirPedido(pedidoEncontrado);
                    } else if (opcaoModificacao == 2) {
                        int numeroItem = menu.lerNumeroItem(pedidoEncontrado);
                        if (!sistema.removerItem(pedidoEncontrado, numeroItem)) {
                            menu.exibirMensagem("Item inválido.");
                        }
                        menu.exibirPedido(pedidoEncontrado);
                    } else if (opcaoModificacao == 3) {
                        sistema.cancelarPedido(numeroPedido);
                        menu.exibirMensagem("Pedido cancelado.");
                    } else {
                        menu.exibirMensagem("Opção inválida.");
                    }
                    break;
                case 0:
                    menu.exibirMensagem("Até amanhã!");
                    break;
                default:
                    menu.exibirMensagem("Opção inválida.");
            }

        }
    }
}

