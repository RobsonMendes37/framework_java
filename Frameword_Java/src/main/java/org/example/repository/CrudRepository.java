/**
 * Interface que define as operações básicas de um repositório para manipulação de dados.
 *
 * Esta interface fornece os métodos essenciais para um repositório genérico, permitindo salvar,
 * buscar, atualizar, deletar e listar entidades do tipo T.
 *
 * Métodos:
 * - save(T entity): Salva a entidade no repositório.
 * - findById(int id): Retorna a entidade correspondente ao ID fornecido.
 * - update(T entity): Atualiza a entidade no repositório.
 * - delete(int id): Remove a entidade do repositório pelo ID.
 * - findAll(): Retorna uma lista de todas as entidades do repositório.
 *
 * param <T> o tipo da entidade que será gerenciada pelo repositório.
 */

package org.example.repository;

import java.util.List;

public interface CrudRepository<T>{
    void save(T entity);
    T findById(int id);
    void update(T entity);
    void delete(int id);
    List<T> findAll();
}