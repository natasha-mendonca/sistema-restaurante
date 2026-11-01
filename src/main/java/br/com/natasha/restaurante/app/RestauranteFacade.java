package br.com.natasha.restaurante.app;

import br.com.natasha.restaurante.cardapio.Lanche;
import br.com.natasha.restaurante.pedido.GerenciadorPedidos;
import br.com.natasha.restaurante.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public boolean adicionarLanche(Pedido pedido, int opcaoLanche) {
        if (opcaoLanche == 1) {
            pedido.adicionarItem(new Lanche("X-Burger", 16.0));
            return true;
        } else if (opcaoLanche == 2) {
            pedido.adicionarItem(new Lanche("X-Salada", 18.0));
            return true;
        } else if (opcaoLanche == 3) {
            pedido.adicionarItem(new Lanche("X-Bacon", 22.0));
            return true;
        } else {
            return false;
        }
    }

    public Collection<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }
}
