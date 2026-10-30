package br.com.natasha.restaurante.pedido;

import br.com.natasha.restaurante.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;

    private ArrayList<Lanche> itens = new ArrayList<>(); /* todo pedido tem uma lista de itens*/

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero; //não tem regra, quem gera o número é o Gerenciador de pedido
        setNomeCliente(nomeCliente); //nome cliente tem uma regra = não pode ser vazio, e quem cuida dessa regra é o setter, por isso precisa passar por ele
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Lanche> getItens() {
        return itens;
    }

    public void adicionarItem(Lanche lanche) {
        itens.add(lanche);
    }

    public double calcularTotal() {
        double total = 0;
        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }
        return total;
    }
}



