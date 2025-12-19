package Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entities.Estado;
import Entities.Prioridade;

/**
 * Classe abstrata que representa uma tarefa genérica no sistema.
 * 
 * <p>Esta classe estabelece a base para todas as tarefas existentes,
 * definindo os atributos e comportamentos comuns. O método abstrato
 * {@link #resumo()} deve ser implementado pelas subclasses, de forma
 * a fornecer uma descrição resumida adequada a cada tipo de tarefa.</p>
 * 
 * <p>Aplica os princípios de herança e abstração, promovendo a reutilização
 * de código e a consistência na hierarquia de tarefas.</p>
 * 
 */
public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private Prioridade prioridade;
    private Estado estado;

    /**
     * Construtor base para a criação de uma nova tarefa.
     *
     * @param titulo título da tarefa
     * @param descricao descrição detalhada da tarefa
     * @param prioridade prioridade atribuída (ALTA, MÉDIA ou BAIXA)
     */
    public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
        this.prioridade = prioridade != null ? prioridade : Prioridade.MEDIA;
        this.estado = Estado.PENDENTE;
    }

    /**
     * Construtor completo, utilizado aquando do carregamento a partir de ficheiros XML.
     *
     * @param titulo título da tarefa
     * @param descricao descrição detalhada da tarefa
     * @param dataCriacao data e hora de criação
     * @param prioridade prioridade da tarefa
     * @param estado estado atual da tarefa
     */
    public Tarefa(String titulo, String descricao, LocalDateTime dataCriacao,
                  Prioridade prioridade, Estado estado) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.prioridade = prioridade;
        this.estado = estado;
    }

   
    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public Prioridade getPrioridade() {
        return this.prioridade;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado novoEstado) {
        this.estado = novoEstado;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %s)", titulo, prioridade, estado);
    }
}