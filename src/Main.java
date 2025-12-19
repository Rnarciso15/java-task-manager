import java.util.List;
import java.util.Scanner;

import Entities.Estado;
import Entities.Prioridade;
import Entities.TarefaNaoEncontradaException;
import Services.GestorDeTarefas;
import Services.Tarefa;

/**
 * Programa Principal — Aplicação de Gestão de Tarefas.
 * 
 * <p>Esta aplicação permite ao utilizador realizar operações essenciais de
 * gestão de tarefas, nomeadamente:
 * <ul>
 *   <li>Adicionar uma nova tarefa;</li>
 *   <li>Listar todas as tarefas registadas;</li>
 *   <li>Remover uma tarefa pelo título;</li>
 *   <li>Alterar o estado de uma tarefa;</li>
 *   <li>Guardar tarefas num ficheiro XML;</li>
 *   <li>Carregar tarefas a partir de um ficheiro XML;</li>
 *   <li>Gerar um relatório em formato HTML das tarefas pendentes.</li>
 * </ul>
 * </p>
 * 
 * <p>Desenvolvido em Java, seguindo os princípios da Programação Orientada
 * a Objetos, garantindo modularidade, legibilidade e robustez na execução.</p>
 */
public class Main {

    public static void main(String[] args) {

        var gestor = new GestorDeTarefas();
        var scanner = new Scanner(System.in);
        var continuar = true;

        System.out.println("==============================================");
        System.out.println("          BEM-VINDO AO GESTOR DE TAREFAS      ");
        System.out.println("==============================================");

        while (continuar) {
            mostrarMenu();
            var opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1 -> adicionarTarefa(gestor, scanner);
                case 2 -> listarTarefas(gestor);
                case 3 -> removerTarefa(gestor, scanner);
                case 4 -> alterarEstado(gestor, scanner);
                case 5 -> guardarEmXML(gestor);
                case 6 -> carregarDeXML(gestor);
                case 7 -> gerarRelatorioHTML(gestor);
                case 0 -> {
                    continuar = false;
                    System.out.println("\nAplicação terminada. Obrigado por utilizar o Gestor de Tarefas.");
                }
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (continuar && opcao != 0) {
                System.out.print("\nPrima ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /** Apresenta o menu principal ao utilizador. */
    private static void mostrarMenu() {
        System.out.println("\n==============================================");
        System.out.println("                 MENU PRINCIPAL               ");
        System.out.println("==============================================");
        System.out.println("1 - Adicionar nova tarefa");
        System.out.println("2 - Listar todas as tarefas");
        System.out.println("3 - Remover uma tarefa pelo título");
        System.out.println("4 - Alterar o estado de uma tarefa");
        System.out.println("5 - Guardar tarefas em ficheiro XML");
        System.out.println("6 - Carregar tarefas de ficheiro XML");
        System.out.println("7 - Gerar relatório HTML de tarefas pendentes");
        System.out.println("0 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    /** Lê e valida uma opção numérica introduzida pelo utilizador. */
    private static int lerOpcao(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /** Permite ao utilizador adicionar uma nova tarefa. */
    private static void adicionarTarefa(GestorDeTarefas gestor, Scanner scanner) {
        System.out.println("\n==============================");
        System.out.println("       ADICIONAR TAREFA       ");
        System.out.println("==============================");

        System.out.print("Título: ");
        var titulo = scanner.nextLine().trim();
        if (titulo.isEmpty()) {
            System.out.println("O título não pode estar vazio.");
            return;
        }

        System.out.print("Descrição: ");
        var descricao = scanner.nextLine().trim();
        if (descricao.isEmpty()) {
            System.out.println("A descrição não pode estar vazia.");
            return;
        }

        System.out.println("\nPrioridade:");
        System.out.println("1 - Alta");
        System.out.println("2 - Média");
        System.out.println("3 - Baixa");
        System.out.print("Escolha: ");
        var escolha = lerOpcao(scanner);

        Prioridade prioridade = null;

        switch (escolha) {
            case 1 -> prioridade = Prioridade.ALTA;
            case 2 -> prioridade = Prioridade.MEDIA;
            case 3 -> prioridade = Prioridade.BAIXA;
        }

        if (prioridade == null) {
            System.out.println("Prioridade inválida. Foi atribuída prioridade MÉDIA por defeito.");
            prioridade = Prioridade.MEDIA;
        }
        
        var tarefa = new Tarefa(titulo, descricao, prioridade);

        try {
            gestor.adicionarTarefa(tarefa);
            System.out.println("\nTarefa adicionada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    /** Lista todas as tarefas registadas. */
    private static void listarTarefas(GestorDeTarefas gestor) {
        var tarefas = gestor.listarTarefas();

        System.out.println("\n==============================");
        System.out.println("        LISTA DE TAREFAS      ");
        System.out.println("==============================");

        if (tarefas.isEmpty()) {
            System.out.println("Não existem tarefas registadas.");
            return;
        }

        for (Tarefa t : tarefas) {
            System.out.printf("- %s (%s, %s)%n", t.getTitulo(), t.getPrioridade(), t.getEstado());
        }

        System.out.println("\nTotal: " + tarefas.size() + " tarefa(s).");
    }

    /** Remove uma tarefa pelo título, mostrando primeiro a lista existente. */
    private static void removerTarefa(GestorDeTarefas gestor, Scanner scanner) {
        var tarefas = gestor.listarTarefas();

        if (tarefas.isEmpty()) {
            System.out.println("Não existem tarefas para remover.");
            return;
        }

        listarTarefas(gestor);
        System.out.print("\nIntroduza o título exato da tarefa a remover: ");
        var titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("O título não pode estar vazio.");
            return;
        }

        try {
            gestor.removerTarefa(titulo);
            System.out.println("Tarefa removida com sucesso.");
        } catch (TarefaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Altera o estado de uma tarefa existente, mostrando primeiro a lista. */
    private static void alterarEstado(GestorDeTarefas gestor, Scanner scanner) {
        var tarefas = gestor.listarTarefas();

        if (tarefas.isEmpty()) {
            System.out.println("Não existem tarefas para alterar.");
            return;
        }

        listarTarefas(gestor);
        System.out.print("\nIntroduza o título exato da tarefa cujo estado pretende alterar: ");
        var titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("O título não pode estar vazio.");
            return;
        }

        System.out.println("\nSelecione o novo estado:");
        System.out.println("1 - Pendente");
        System.out.println("2 - Em progresso");
        System.out.println("3 - Concluída");
        System.out.print("Escolha: ");
        var escolha = lerOpcao(scanner);

        Estado novoEstado = null;

        switch (escolha) {
            case 1 -> novoEstado = Estado.PENDENTE;
            case 2 -> novoEstado = Estado.EM_PROGRESSO;
            case 3 -> novoEstado = Estado.CONCLUIDA;
        }

        if (novoEstado == null) {
            System.out.println("Opção inválida. O estado foi definido como PENDENTE por defeito.");
            novoEstado = Estado.PENDENTE;
        }


        try {
            gestor.alterarEstado(titulo, novoEstado);
            System.out.println("Estado atualizado com sucesso.");
        } catch (TarefaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Guarda as tarefas num ficheiro XML. */
    private static void guardarEmXML(GestorDeTarefas gestor) {
        try {
            gestor.guardarEmXML("dados/tarefas.xml");
            System.out.println("Ficheiro XML guardado com sucesso em 'dados/tarefas.xml'.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao guardar o ficheiro XML: " + e.getMessage());
        }
    }

    /** Carrega as tarefas a partir de um ficheiro XML. */
    private static void carregarDeXML(GestorDeTarefas gestor) {
        try {
            gestor.carregarDeXML("dados/tarefas.xml");
            System.out.println("Tarefas carregadas com sucesso. Total: " + gestor.contarTarefas());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao carregar o ficheiro XML: " + e.getMessage());
        }
    }

    /** Gera um relatório HTML com as tarefas pendentes. */
    private static void gerarRelatorioHTML(GestorDeTarefas gestor) {
        try {
            gestor.gerarRelatorioHTML("dados/relatorio.html");
            System.out.println("Relatório HTML gerado com sucesso em 'dados/relatorio.html'.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao gerar o relatório HTML: " + e.getMessage());
        }
    }
}
