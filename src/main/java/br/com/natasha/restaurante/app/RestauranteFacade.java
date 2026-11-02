package br.com.natasha.restaurante.app;

import br.com.natasha.restaurante.cardapio.*;
import br.com.natasha.restaurante.pedido.GerenciadorPedidos;
import br.com.natasha.restaurante.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public boolean adicionarLanche(Pedido pedido, int opcaoLanche, boolean semQueijo, boolean semAlface, boolean semTomate, boolean semCebola, boolean comCheddar, boolean comBaconExtra) {

        Lanche lanche;

        if (opcaoLanche == 1) {
            lanche = (LancheFactory.xBurger());
        } else if (opcaoLanche == 2) {
            lanche = (LancheFactory.xSalada());
        } else if (opcaoLanche == 3) {
            lanche = (LancheFactory.xBacon());
        } else {
            return false;
        }
        if (semQueijo) lanche.setQueijo(false);
        if (semAlface) lanche.setAlface(false);
        if (semTomate) lanche.setTomate(false);
        if (semCebola) lanche.setCebola(false);

        ItemCardapio item = lanche;

        if (comCheddar) {
            item = new ComCheddar(item);
        }
        if (comBaconExtra) {
            item = new ComBaconExtra(item);
        }
        pedido.adicionarItem(item);
        return true;
    }

    public Collection<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public Pedido buscarPedido(int numero) {
        return gerenciador.buscarPedido(numero);
    }

    public boolean removerItem(Pedido pedido, int numeroItem) {
        int posicao = numeroItem - 1;
        if (posicao < 0 || posicao >= pedido.getItens().size()) {
            return false;
        }
        pedido.removerItem(posicao);
        return true;
    }

    public void cancelarPedido(int numero) {
        gerenciador.cancelarPedido(numero);
    }

    public HashSet<String> listarCombinacoes() {
        return gerenciador.getCombinacoes();
    }
}
