package Entities;

/**
 * Exceção lançada quando é efetuada uma tentativa de aceder
 * a uma tarefa que não existe no sistema.
 * 
 * <p>Por exemplo, ao tentar remover ou consultar uma tarefa
 * cujo título não corresponde a nenhuma das tarefas registadas.</p>
 */
public class TarefaNaoEncontradaException extends Exception {
    
    /**
     * Cria uma nova exceção com uma mensagem descritiva.
     * 
     * @param titulo o título da tarefa que não foi encontrada
     */
    public TarefaNaoEncontradaException(String titulo) {
        super("A tarefa '" + titulo + "' não foi encontrada.");
    }
}