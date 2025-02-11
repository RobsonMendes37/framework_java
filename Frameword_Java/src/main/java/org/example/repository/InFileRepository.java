package org.example.repository;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de um repositório genérico que armazena dados em um arquivo.
 *
 * Esta classe implementa a interface CrudRepository e oferece métodos para salvar,
 * buscar, atualizar, excluir e listar entidades do tipo T em um arquivo.
 * As entidades são serializadas para o armazenamento em arquivo e desserializadas
 * para leitura. O arquivo utilizado é especificado no momento da criação do repositório.
 *
 * A classe é parametrizada com o tipo T, que deve ser uma classe que implementa
 * a interface Serializable.
 *
 * Métodos principais:
 * - save(T entity): Salva a entidade no arquivo, adicionando-a à lista existente.
 * - findById(int id): Retorna a entidade no índice especificado (ID) da lista.
 * - update(T entity): Atualiza a entidade no arquivo, substituindo a existente.
 * - delete(int id): Remove a entidade do arquivo com base no índice (ID).
 * - findAll(): Retorna a lista de todas as entidades armazenadas no arquivo.
 *
 * param <T> Tipo da entidade que será manipulada pelo repositório.
 */


public class InFileRepository<T extends Serializable> implements CrudRepository<T> {
//    List<T> findAll();

    private final String filename;

    public InFileRepository(String filename){
        this.filename = filename;
    }

    @Override
    public void save(T entity){
        List<T> entities = findAll();
        entities.add(entity);
        writeToFile(entities);
    }

    @Override
    public T findById(int id){
        List<T> entities = findAll(); // Lê todos os dados
        return (id >= 0 && id < entities.size()) ? entities.get(id) : null; // Retorna o item com o id
    }

    @Override
    public void update(T entity){
        List<T> entities = findAll();
        int index = entities.indexOf(entity); // Encontra o índice do item
        if (index != -1) { // Se o item for encontrado
            entities.set(index, entity); // Atualiza o item
            writeToFile(entities); // Salva a lista atualizada
        }
    }

    @Override
    public void delete(int id){
        List<T> entities = findAll();
        if (id >= 0 && id < entities.size()) {
            entities.remove(id); // Remove o item pelo índice
            writeToFile(entities); // Salva a lista atualizada
        }
    }

    @Override
    public List<T> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject(); // Lê os objetos do arquivo
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Se o arquivo não existir, retorna uma lista vazia
        }
    }

    // Método auxiliar para gravar no arquivo
    private void writeToFile(List<T> entities) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(entities); // Escreve os objetos no arquivo
        } catch (IOException e) {
            e.printStackTrace(); // Caso ocorra algum erro
        }
    }
}
