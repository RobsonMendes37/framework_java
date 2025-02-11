/**
 * A classe Produto representa um produto em um sistema de gerenciamento de produtos.

 * Esta classe implementa a interface Serializable, permitindo que objetos da classe
 * sejam facilmente gravados em um arquivo ou transmitidos pela rede. Cada produto possui
 * um nome e um preço, que são definidos através do construtor e podem ser acessados e
 * modificados por métodos getter e setter.

 * A classe sobrescreve o método toString para fornecer uma representação em formato de
 * string mais legível dos produtos, facilitando sua exibição.

 * Atributos:
 * - nome: nome do produto.
 * - preco: preço do produto.

 * Métodos:
 * - Construtor: para inicializar um produto com nome e preço.
 * - Getter e Setter: para acessar e modificar os atributos.
 * - toString: para exibir o produto de maneira formatada.

 * Exemplo de uso:
 * Produto p = new Produto("Laptop", 2000.0);
 * System.out.println(p); // Exibe: Produto{nome='Laptop', preco=2000.0}
 */


package org.example.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double preco;

    // Construtor
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Sobrescrevendo o toString para exibição dos produtos
    @Override
    public String toString() {
        return "Produto{" + "nome='" + nome + '\'' + ", preco=" + preco + '}';
    }
}
