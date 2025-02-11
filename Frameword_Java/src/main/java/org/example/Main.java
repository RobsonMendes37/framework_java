package org.example;

import org.example.model.Produto;
import org.example.repository.InFileRepository;
import org.example.utils.Utils;

/**
 * Classe principal da aplicação, responsável por orquestrar as operações do sistema de gerenciamento de produtos.
 * Ela cria o repositório de produtos, realiza operações como salvar, listar, buscar, atualizar e deletar produtos
 * e exibe o estado do repositório antes e após cada operação.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema de gerenciamento de produtos...");

        // Criando o repositório em arquivo (arquivo 'produtos.dat')
        InFileRepository<Produto> fileRepo = new InFileRepository<>("produtos.dat");

        // 2. Exibindo todos os produtos salvos no arquivo
        System.out.println("\nLista de Produtos (Arquivo) antes da inserção:");
        Utils.listarProdutos(fileRepo);  // Usando o método da classe Utils

        // 1. Salvando produtos no arquivo
        Produto p1 = new Produto("Laptop", 7010.0);
        Produto p2 = new Produto("Mouse", 507.0);
        Produto p3 = new Produto("Teclado", 450.0);
        fileRepo.save(p1);
        fileRepo.save(p2);
        fileRepo.save(p3);

        // 2. Exibindo todos os produtos salvos no arquivo
        System.out.println("\nLista de Produtos (Arquivo) após inserção:");
        Utils.listarProdutos(fileRepo);  // Usando o método da classe Utils

        // 3. Encontrando um produto por ID (index)
        System.out.println("\nBuscando produto por ID (index 1):");
        Produto produtoEncontrado = fileRepo.findById(2);
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }

        // 4. Atualizando um produto (index 0)
        System.out.println("\nAtualizando produto no índice 0...");
        Produto produtoAtualizado = new Produto("Laptop", 2800.0); // Alterando o preço
        fileRepo.update(produtoAtualizado);
        System.out.println("Produto atualizado com sucesso!");

        // Exibindo todos os produtos após a atualização
        System.out.println("\nLista de Produtos após atualização:");
        Utils.listarProdutos(fileRepo);  // Usando o método da classe Utils

        // 5. Deletando um produto (index 2)
        System.out.println("\nDeletando produto no índice 2...");
        fileRepo.delete(2);  // Deletando o produto no índice 2 (Teclado)
        System.out.println("Produto deletado com sucesso!");

        // Exibindo todos os produtos após a remoção
        System.out.println("\nLista de Produtos após remoção:");
        Utils.listarProdutos(fileRepo);  // Usando o método da classe Utils

        // Finalizando
        System.out.println("\nFim da execução.");

    }
}
