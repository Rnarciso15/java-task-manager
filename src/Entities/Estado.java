package Entities;

/**
 * Enumeração que representa os possíveis estados de uma tarefa.
 * 
 * <p>Cada tarefa pode encontrar-se num dos seguintes estados:
 * <ul>
 *   <li><strong>PENDENTE</strong> — ainda não iniciada;</li>
 *   <li><strong>EM_PROGRESSO</strong> — atualmente em execução;</li>
 *   <li><strong>CONCLUIDA</strong> — finalizada com sucesso.</li>
 * </ul>
 * </p>
 */
public enum Estado {
    PENDENTE,           
    EM_PROGRESSO,       
    CONCLUIDA          
}
