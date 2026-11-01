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
                        boolean comCheddar = menu.perguntarAdicional("Deseja adicional de cheddar?");
                        boolean comBaconExtra = menu.perguntarAdicional("Deseja adicional de bacon?");
                        if (!sistema.adicionarLanche(pedido, opcaoLanche, comCheddar, comBaconExtra)) {
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
                    menu.exibirFechamentoDoDia(total);
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

