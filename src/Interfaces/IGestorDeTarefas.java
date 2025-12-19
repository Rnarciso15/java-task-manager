package Interfaces;

import java.util.List;

import Entities.Estado;
import Entities.TarefaNaoEncontradaException;
import Services.Tarefa;

/**
 * Interface que define as operações fundamentais de gestão de tarefas.
 * 
 * <p>Esta interface estabelece o contrato que deve ser seguido por todas
 * as classes responsáveis pela gestão de tarefas, em conformidade com o
 * princípio da Inversão de Dependência (DIP), promovendo uma arquitetura
 * modular, extensível e de fácil manutenção.</p>
 * 
 * <p>As classes que a implementam deverão assegurar a manipulação segura
 * de objetos do tipo {@link Tarefa}, respeitando os princípios da
 * Programação Orientada a Objetos.</p>
 */
public interface IGestorDeTarefas {   
    
    void adicionarTarefa(Tarefa tarefa);    
    
    void removerTarefa(String titulo) throws TarefaNaoEncontradaException;    
    
    void alterarEstado(String titulo, Estado novoEstado) throws TarefaNaoEncontradaException;
    
    List<Tarefa> listarTarefas();       
    
    Tarefa buscarPorTitulo(String titulo) throws TarefaNaoEncontradaException;   
    
    List<Tarefa> listarPorEstado(Estado estado);   
    
    int contarTarefas();
}
