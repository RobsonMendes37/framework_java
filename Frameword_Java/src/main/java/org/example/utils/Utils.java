package org.example.utils;

import org.example.model.Produto;
import org.example.repository.InFileRepository;
import java.util.List;

/**
 * Método para listar os produtos no repositório e exibir no console.
 *
 * Este método lê todos os produtos armazenados no repositório e os exibe no console.
 * Caso não haja produtos, será exibida uma mensagem informando que nenhum produto foi encontrado.
 *
 *param fileRepo Repositório onde os produtos estão armazenados.
 */


public class Utils {

    // Método para listar os produtos no repositório
    public static void listarProdutos(InFileRepository<Produto> fileRepo) {
        List<Produto> produtos = fileRepo.findAll();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}
