package br.com.natasha.restaurante.app;

import br.com.natasha.restaurante.cardapio.ComBaconExtra;
import br.com.natasha.restaurante.cardapio.ComCheddar;
import br.com.natasha.restaurante.cardapio.ItemCardapio;
import br.com.natasha.restaurante.cardapio.LancheFactory;
import br.com.natasha.restaurante.pedido.GerenciadorPedidos;
import br.com.natasha.restaurante.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public boolean adicionarLanche(Pedido pedido, int opcaoLanche, boolean comCheddar, boolean comBaconExtra) {

        ItemCardapio item;

        if (opcaoLanche == 1) {
            item = (LancheFactory.xBurger());
        } else if (opcaoLanche == 2) {
            item = (LancheFactory.xSalada());
        } else if (opcaoLanche == 3) {
            item = (LancheFactory.xBacon());
        } else {
            return false;
        }
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
}
