package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Entities.Estado;
import Entities.Prioridade;
import Entities.TarefaNaoEncontradaException;
import Interfaces.IGestorDeTarefas;

/**
 * Implementação concreta da interface {@link IGestorDeTarefas}.
 * 
 * <p>Esta classe constitui o núcleo funcional do sistema de gestão de tarefas,
 * encarregando-se de realizar as operações de criação, leitura, atualização
 * e remoção (CRUD), bem como de efetuar a persistência em ficheiros XML e a
 * geração de relatórios em formato HTML.</p>
 * 
 * <p>Adota uma estrutura modular, coesa e facilmente extensível, aplicando
 * os princípios de encapsulamento, abstração e responsabilidade única.</p>
 */
public class GestorDeTarefas implements IGestorDeTarefas {
    
    private List<Tarefa> tarefas;
    
    public GestorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    
    @Override
    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa não pode ser nula.");
        }

        for (var tar : tarefas) {
            if (tar.getTitulo().equalsIgnoreCase(tarefa.getTitulo())) {
                throw new IllegalArgumentException(
                    "Já existe uma tarefa com o título '" + tarefa.getTitulo() + "'.");
            }
        }

        tarefas.add(tarefa);
    }

    @Override
    public void removerTarefa(String titulo) throws TarefaNaoEncontradaException {
        var removida = tarefas.removeIf(
            tarefa -> tarefa.getTitulo().equalsIgnoreCase(titulo)
        );

        if (!removida) {
            throw new TarefaNaoEncontradaException(titulo);
        }
    }

    @Override
    public void alterarEstado(String titulo, Estado novoEstado)
            throws TarefaNaoEncontradaException {

        var tarefa = buscarPorTitulo(titulo);
        tarefa.setEstado(novoEstado);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    @Override
    public List<Tarefa> listarPorEstado(Estado estado) {
        List<Tarefa> filtradas = new ArrayList<>();

        for (var tarefa : tarefas) {
            if (tarefa.getEstado() == estado) {
                filtradas.add(tarefa);
            }
        }

        return filtradas;
    }

    @Override
    public int contarTarefas() {
        return tarefas.size();
    }

    @Override
    public Tarefa buscarPorTitulo(String titulo) throws TarefaNaoEncontradaException {
        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                return t;
            }
        }
        throw new TarefaNaoEncontradaException(titulo);
    }

       /**
     * Guarda todas as tarefas num ficheiro XML.
     *
     * @param caminho caminho do ficheiro (por exemplo, "dados/tarefas.xml")
     * @throws Exception se ocorrer um erro durante o processo de escrita
     */
    public void guardarEmXML(String caminho) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var doc = builder.newDocument();

        var raiz = doc.createElement("tarefas");
        doc.appendChild(raiz);

        for (Tarefa t : tarefas) {
            var tarefaElement = doc.createElement("tarefa");

            tarefaElement.appendChild(criarElemento(doc, "titulo", t.getTitulo()));
            tarefaElement.appendChild(criarElemento(doc, "descricao", t.getDescricao()));
            tarefaElement.appendChild(criarElemento(doc, "dataCriacao", t.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            tarefaElement.appendChild(criarElemento(doc, "prioridade", t.getPrioridade().name()));
            tarefaElement.appendChild(criarElemento(doc, "estado", t.getEstado().name()));

            raiz.appendChild(tarefaElement);
        }

        var transformerFactory = TransformerFactory.newInstance();
        var transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        var ficheiro = new File(caminho);
        if (ficheiro.getParentFile() != null) {
            ficheiro.getParentFile().mkdirs();
        }

        transformer.transform(new DOMSource(doc), new StreamResult(ficheiro));
    }

    /**
     * Carrega as tarefas a partir de um ficheiro XML existente.
     * 
     * <p>Se o ficheiro não existir, o sistema reinicia a lista de tarefas.</p>
     *
     * @param caminho caminho do ficheiro XML
     * @throws Exception se ocorrer um erro de leitura ou de análise
     */
    public void carregarDeXML(String caminho) throws Exception {
        var ficheiro = new File(caminho);

        if (!ficheiro.exists()) {
            this.tarefas = new ArrayList<>();
            return;
        }

        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var doc = builder.parse(ficheiro);
        doc.getDocumentElement().normalize();

        var listaTarefas = doc.getElementsByTagName("tarefa");
        List<Tarefa> tarefasCarregadas = new ArrayList<>();

        for (int i = 0; i < listaTarefas.getLength(); i++) {
            var node = listaTarefas.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                var elemento = (Element) node;

                var titulo = getValorTag(elemento, "titulo");
                var descricao = getValorTag(elemento, "descricao");
                var dataStr = getValorTag(elemento, "dataCriacao");
                var prioridadeStr = getValorTag(elemento, "prioridade");
                var estadoStr = getValorTag(elemento, "estado");

                var data = LocalDateTime.parse(dataStr);
                var prioridade = Prioridade.valueOf(prioridadeStr);
                var estado = Estado.valueOf(estadoStr);

                var tarefa = new Tarefa(titulo, descricao, data, prioridade, estado);
                tarefasCarregadas.add(tarefa);
            }
        }

        this.tarefas = tarefasCarregadas;
    }

    /**
     * Gera um relatório HTML simples, organizado por estado das tarefas.
     * 
     * <p>O relatório apresenta três secções:
     * <ul>
     *   <li>Tarefas Pendentes</li>
     *   <li>Tarefas em Progresso</li>
     *   <li>Tarefas Concluídas </li>
     * </ul>
     * </p>
     *
     * @param caminho caminho do ficheiro HTML a criar
     * @throws IOException se ocorrer um erro de escrita
     */
    public void gerarRelatorioHTML(String caminho) throws IOException {
        var ficheiro = new File(caminho);
        if (ficheiro.getParentFile() != null) {
            ficheiro.getParentFile().mkdirs();
        }

        var pendentes = listarPorEstado(Estado.PENDENTE);
        var emProgresso = listarPorEstado(Estado.EM_PROGRESSO);
        var concluidas = listarPorEstado(Estado.CONCLUIDA);

        var prioridadeComparator = Comparator.comparing(Tarefa::getPrioridade);

        pendentes.sort(prioridadeComparator);
        emProgresso.sort(prioridadeComparator);
        concluidas.sort(prioridadeComparator);

        try (var writer = new PrintWriter(new FileWriter(ficheiro))) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='pt-PT'>");
            writer.println("<head>");
            writer.println("  <meta charset='UTF-8'>");
            writer.println("  <title>Relatório de Tarefas</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Relatório de Tarefas</h1>");
            writer.println("<p>Gerado em: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</p>");
            writer.println("<hr>");

            // Secção: Pendentes
            writer.println("<h2>Tarefas Pendentes</h2>");
            if (pendentes.isEmpty()) {
                writer.println("<p><i>Não existem tarefas pendentes.</i></p>");
            } else {
                for (var tarefa : pendentes) {
                    String cor = switch (tarefa.getPrioridade()) {
                        case ALTA -> "red";
                        case MEDIA -> "orange";
                        case BAIXA -> "green";
                    };
                    writer.printf("<p><font color='%s'>• [%s]</font> <b>%s</b> — %s<br><small>Criada em: %s</small></p>%n",
                            cor, tarefa.getPrioridade(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            }

            // Secção: Em Progresso
            writer.println("<h2>Tarefas em Progresso</h2>");
            if (emProgresso.isEmpty()) {
                writer.println("<p><i>Não existem tarefas em progresso.</i></p>");
            } else {
                for (var tarefa : emProgresso) {
                    String cor = switch (tarefa.getPrioridade()) {
                        case ALTA -> "red";
                        case MEDIA -> "orange";
                        case BAIXA -> "green";
                    };
                    writer.printf("<p><font color='%s'>• [%s]</font> <b>%s</b> — %s<br><small>Criada em: %s</small></p>%n",
                            cor, tarefa.getPrioridade(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            }

            // Secção: Concluídas
            writer.println("<h2>Tarefas Concluídas</h2>");
            if (concluidas.isEmpty()) {
                writer.println("<p><i>Não existem tarefas concluídas.</i></p>");
            } else {
                for (var tarefa : concluidas) {
                    String cor = switch (tarefa.getPrioridade()) {
                        case ALTA -> "red";
                        case MEDIA -> "orange";
                        case BAIXA -> "green";
                    };
                    writer.printf("<p><font color='%s'>• [%s]</font> <b>%s</b> — %s<br><small>Criada em: %s</small></p>%n",
                            cor, tarefa.getPrioridade(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }
            }

            writer.println("<hr>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    
    /** Cria um elemento XML com nome e valor associados. */
    private Element criarElemento(Document doc, String nome, String valor) {
        var elemento = doc.createElement(nome);
        elemento.appendChild(doc.createTextNode(valor != null ? valor : ""));
        return elemento;
    }

    /** Obtém o valor textual de uma tag XML. */
    private String getValorTag(Element pai, String nomeTag) {
        var lista = pai.getElementsByTagName(nomeTag);
        if (lista == null || lista.getLength() == 0) {
            return "";
        }
        var node = lista.item(0);
        return node.getTextContent();
    }
}