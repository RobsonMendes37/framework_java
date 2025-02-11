package org.example.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de um repositório em memória para manipulação de dados.
 *
 * Esta classe implementa a interface CrudRepository e oferece métodos para salvar,
 * buscar, atualizar, excluir e listar entidades do tipo T, utilizando uma lista em memória
 * para armazenar os dados. Não há persistência em arquivo ou banco de dados, todos os
 * dados são mantidos enquanto o programa estiver em execução.
 *
 * Métodos principais:
 * - save(T entity): Adiciona a entidade à lista.
 * - findById(int id): Retorna a entidade no índice especificado (ID) da lista.
 * - update(T entity): Atualiza a entidade na lista.
 * - delete(int id): Remove a entidade da lista pelo índice (ID).
 * - findAll(): Retorna a lista de todas as entidades armazenadas em memória.
 *
 * param <T> Tipo da entidade que será manipulada pelo repositório.
 */

public class InMemoryRepository<T> implements CrudRepository<T> {
    private List<T> entities = new ArrayList<>();

    @Override
    public void save(T entity){
        entities.add(entity);
    }

    @Override
    public T findById(int id){
        return (id >= 0 && id < entities.size()) ? entities.get(id) : null;
    }

    @Override
    public void update(T entity){
        int index = entities.indexOf(entity);
        if(index != -1){
            entities.set(index,entity);
        }
    }

    @Override
    public void delete(int id){
        if(id >= 0 && id < entities.size()) {
            entities.remove(id);
        }
    }

    @Override
    public List<T> findAll(){
        return entities;
    }

}
