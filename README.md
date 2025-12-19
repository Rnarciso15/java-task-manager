# Java Task Manager | Gestor de Tarefas em Java

---

## 🇵🇹 Versão em Português (Portugal)

### Título do Projeto

**Gestor de Tarefas em Java** - Aplicação de Consola para Gestão de Tarefas

### Descrição

O Gestor de Tarefas é uma aplicação de consola desenvolvida em Java que implementa os princípios fundamentais da Programação Orientada a Objetos (POO). A aplicação foi desenvolvida no âmbito da unidade curricular de Linguagem de Programação e permite aos utilizadores criar, listar, editar e remover tarefas de forma intuitiva através de uma interface de linha de comandos.

A aplicação implementa uma arquitetura robusta com separação de responsabilidades, utilizando interfaces, classes concretas, enumerações e exceções personalizadas. Os dados são persistidos em ficheiros XML e é possível gerar relatórios em formato HTML com análises das tarefas.

### Objetivos

- Demonstrar a aplicação prática dos conceitos de Programação Orientada a Objetos em Java
- Implementar padrões de design e boas práticas de desenvolvimento
- Criar uma aplicação funcional de gestão de dados com persistência em ficheiros
- Desenvolver competências na manipulação de ficheiros XML e geração de relatórios HTML
- Aplicar tratamento de exceções e validação de dados
- Consolidar conhecimentos de estruturas de dados e algoritmos de ordenação

### Funcionalidades

- ✅ **Criar Tarefas**: Adicionar novas tarefas com descrição, prioridade e estado
- ✅ **Listar Tarefas**: Visualizar todas as tarefas guardadas no sistema
- ✅ **Editar Tarefas**: Modificar os detalhes de uma tarefa existente
- ✅ **Remover Tarefas**: Eliminar tarefas do sistema
- ✅ **Persistência de Dados**: Guardar tarefas em ficheiros XML
- ✅ **Carregamento de Dados**: Carregar tarefas de ficheiros XML
- ✅ **Gestão de Prioridades**: Atribuir níveis de prioridade (Baixa, Normal, Alta)
- ✅ **Gestão de Estados**: Controlar o estado das tarefas (Pendente, Em Progresso, Concluída)
- ✅ **Relatórios HTML**: Gerar relatórios formatados agrupados por estado e ordenados por prioridade
- ✅ **Tratamento de Exceções**: Lançamento de exceções personalizadas para situações de erro

### Tecnologias Utilizadas

- **Linguagem**: Java (JDK 11+)
- **IDE de Desenvolvimento**: Eclipse IDE
- **Processamento de Ficheiros XML**: API DOM (Document Object Model)
- **Formato de Relatórios**: HTML5
- **Controlo de Versão**: Git e GitHub
- **Sistema Operativo**: Windows / Linux / macOS

### Estrutura do Projeto

```
Trabalho_Individual_1/
├── src/
│   ├── Main.java                           # Classe principal com menu da aplicação
│   ├── Entities/
│   │   ├── Estado.java                     # Enumeração dos estados de uma tarefa
│   │   ├── Prioridade.java                 # Enumeração dos níveis de prioridade
│   │   └── TarefaNaoEncontradaException.java # Exceção personalizada
│   ├── Interfaces/
│   │   └── IGestorDeTarefas.java           # Interface do gestor de tarefas
│   └── Services/
│       ├── Tarefa.java                     # Classe que representa uma tarefa
│       └── GestorDeTarefas.java            # Implementação do gestor de tarefas
├── bin/                                    # Ficheiros compilados (.class)
├── dados/
│   ├── tarefas.xml                         # Ficheiro de persistência de tarefas
│   └── relatorio.html                      # Relatório gerado em HTML
├── .project                                # Ficheiro de configuração Eclipse
├── .classpath                              # Definição do classpath
└── README.md                               # Este ficheiro
```

### Como Executar o Projeto

#### Pré-requisitos

- Java Development Kit (JDK) versão 11 ou superior instalado
- Acesso a uma linha de comandos (PowerShell, Command Prompt, Terminal, etc.)

#### Passos para Executar

1. **Navegar até ao diretório do projeto**:
   ```bash
   cd "C:\Users\rodri\Desktop\Escola\Faculdade\2 º ano\LP\Trabalhos Individuais\Trabalho_Individual_1"
   ```

2. **Compilar o projeto** (se não estiver já compilado):
   ```bash
   javac -d bin -sourcepath src src/Main.java
   ```

3. **Executar a aplicação**:
   ```bash
   java -cp bin Main
   ```

4. **Seguir as instruções do menu** exibido na consola

#### Alternativa com Eclipse IDE

1. Importar o projeto em Eclipse (File → Import → Existing Projects into Workspace)
2. Clicar com o botão direito no ficheiro `Main.java` → Run As → Java Application

### Exemplos de Utilização

#### Exemplo 1: Criar uma Nova Tarefa

```
Menu Principal
1. Criar Tarefa
2. Listar Tarefas
3. Editar Tarefa
4. Remover Tarefa
5. Gerar Relatório
6. Sair

Escolha uma opção: 1

Descrição da tarefa: Implementar funcionalidade de login
Prioridade (1-Baixa, 2-Normal, 3-Alta): 3
Estado (1-Pendente, 2-Em Progresso, 3-Concluída): 1

Tarefa criada com sucesso!
```

#### Exemplo 2: Listar Tarefas

```
Escolha uma opção: 2

--- Tarefas Guardadas ---
ID: 1
Descrição: Implementar funcionalidade de login
Prioridade: Alta
Estado: Pendente
Data de Criação: 2025-12-19

ID: 2
Descrição: Escrever testes unitários
Prioridade: Normal
Estado: Em Progresso
Data de Criação: 2025-12-18
```

#### Exemplo 3: Gerar Relatório

```
Escolha uma opção: 5

Relatório gerado com sucesso em: dados/relatorio.html
```

O ficheiro `relatorio.html` conterá as tarefas agrupadas por estado e ordenadas por prioridade.

### Detalhes da Implementação

#### Classe Tarefa
Representa uma tarefa individual com os seguintes atributos:
- `id`: Identificador único
- `descricao`: Descrição da tarefa
- `prioridade`: Nível de prioridade
- `estado`: Estado atual da tarefa
- `dataCriacao`: Data de criação da tarefa

#### Classe GestorDeTarefas
Implementa a interface `IGestorDeTarefas` e fornece métodos para:
- Adicionar tarefas
- Remover tarefas por ID
- Listar todas as tarefas
- Atualizar tarefas existentes
- Carregar tarefas de ficheiros XML
- Guardar tarefas em ficheiros XML
- Gerar relatórios em HTML

#### Enumerações
- **Prioridade**: Baixa, Normal, Alta
- **Estado**: Pendente, Em Progresso, Concluída

#### Exceção Personalizada
- **TarefaNaoEncontradaException**: Lançada quando se tenta aceder a uma tarefa inexistente

### Autor

**Ricardo Narciso**
- Utilizador GitHub: [@Rnarciso15](https://github.com/Rnarciso15)
- Email: (Contacto disponível via perfil GitHub)

### Contexto Académico

- **Instituição**: Faculdade / Universidade (2º Ano)
- **Unidade Curricular**: Linguagem de Programação
- **Tipo de Trabalho**: Trabalho Individual 1
- **Período**: Dezembro de 2025
- **Objetivos de Aprendizagem**: POO em Java, Persistência de Dados, Geração de Relatórios

### Licença

Este projeto é disponibilizado sob a Licença MIT. Consulte o ficheiro LICENSE para mais detalhes.

---

## 🇬🇧 English Version

### Project Title

**Java Task Manager** - Console Application for Task Management

### Description

The Task Manager is a console application developed in Java that implements the fundamental principles of Object-Oriented Programming (OOP). The application was developed as part of the Programming Language course unit and allows users to create, list, edit, and remove tasks intuitively through a command-line interface.

The application implements a robust architecture with separation of concerns, using interfaces, concrete classes, enumerations, and custom exceptions. Data is persisted in XML files and it is possible to generate reports in HTML format with task analysis.

### Objectives

- Demonstrate the practical application of Object-Oriented Programming concepts in Java
- Implement design patterns and software development best practices
- Create a functional data management application with file persistence
- Develop skills in manipulating XML files and generating HTML reports
- Apply exception handling and data validation
- Consolidate knowledge of data structures and sorting algorithms

### Features

- ✅ **Create Tasks**: Add new tasks with description, priority, and status
- ✅ **List Tasks**: View all tasks stored in the system
- ✅ **Edit Tasks**: Modify the details of an existing task
- ✅ **Remove Tasks**: Delete tasks from the system
- ✅ **Data Persistence**: Save tasks to XML files
- ✅ **Data Loading**: Load tasks from XML files
- ✅ **Priority Management**: Assign priority levels (Low, Normal, High)
- ✅ **Status Management**: Control task status (Pending, In Progress, Completed)
- ✅ **HTML Reports**: Generate formatted reports grouped by status and ordered by priority
- ✅ **Exception Handling**: Raising custom exceptions for error situations

### Technologies Used

- **Language**: Java (JDK 11+)
- **Development IDE**: Eclipse IDE
- **XML File Processing**: DOM API (Document Object Model)
- **Report Format**: HTML5
- **Version Control**: Git and GitHub
- **Operating System**: Windows / Linux / macOS

### Project Structure

```
Trabalho_Individual_1/
├── src/
│   ├── Main.java                           # Main class with application menu
│   ├── Entities/
│   │   ├── Estado.java                     # Enumeration of task states
│   │   ├── Prioridade.java                 # Enumeration of priority levels
│   │   └── TarefaNaoEncontradaException.java # Custom exception
│   ├── Interfaces/
│   │   └── IGestorDeTarefas.java           # Task manager interface
│   └── Services/
│       ├── Tarefa.java                     # Class representing a task
│       └── GestorDeTarefas.java            # Implementation of the task manager
├── bin/                                    # Compiled files (.class)
├── dados/
│   ├── tarefas.xml                         # Task persistence file
│   └── relatorio.html                      # Generated HTML report
├── .project                                # Eclipse configuration file
├── .classpath                              # Classpath definition
└── README.md                               # This file
```

### How to Run the Project

#### Prerequisites

- Java Development Kit (JDK) version 11 or higher installed
- Access to a command line (PowerShell, Command Prompt, Terminal, etc.)

#### Steps to Execute

1. **Navigate to the project directory**:
   ```bash
   cd "C:\Users\rodri\Desktop\Escola\Faculdade\2 º ano\LP\Trabalhos Individuais\Trabalho_Individual_1"
   ```

2. **Compile the project** (if not already compiled):
   ```bash
   javac -d bin -sourcepath src src/Main.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin Main
   ```

4. **Follow the menu instructions** displayed in the console

#### Alternative with Eclipse IDE

1. Import the project in Eclipse (File → Import → Existing Projects into Workspace)
2. Right-click on `Main.java` file → Run As → Java Application

### Usage Examples

#### Example 1: Create a New Task

```
Main Menu
1. Create Task
2. List Tasks
3. Edit Task
4. Remove Task
5. Generate Report
6. Exit

Choose an option: 1

Task description: Implement login functionality
Priority (1-Low, 2-Normal, 3-High): 3
Status (1-Pending, 2-In Progress, 3-Completed): 1

Task created successfully!
```

#### Example 2: List Tasks

```
Choose an option: 2

--- Saved Tasks ---
ID: 1
Description: Implement login functionality
Priority: High
Status: Pending
Creation Date: 2025-12-19

ID: 2
Description: Write unit tests
Priority: Normal
Status: In Progress
Creation Date: 2025-12-18
```

#### Example 3: Generate Report

```
Choose an option: 5

Report generated successfully at: dados/relatorio.html
```

The `relatorio.html` file will contain tasks grouped by status and ordered by priority.

### Implementation Details

#### Tarefa Class
Represents an individual task with the following attributes:
- `id`: Unique identifier
- `descricao`: Task description
- `prioridade`: Priority level
- `estado`: Current status of the task
- `dataCriacao`: Task creation date

#### GestorDeTarefas Class
Implements the `IGestorDeTarefas` interface and provides methods for:
- Adding tasks
- Removing tasks by ID
- Listing all tasks
- Updating existing tasks
- Loading tasks from XML files
- Saving tasks to XML files
- Generating HTML reports

#### Enumerations
- **Prioridade**: Baixa, Normal, Alta
- **Estado**: Pendente, Em Progresso, Concluída

#### Custom Exception
- **TarefaNaoEncontradaException**: Thrown when attempting to access a non-existent task

### Author

**Ricardo Narciso**
- GitHub User: [@Rnarciso15](https://github.com/Rnarciso15)
- Email: (Contact available via GitHub profile)

### Academic Context

- **Institution**: Faculty / University (2nd Year)
- **Course Unit**: Programming Language
- **Work Type**: Individual Assignment 1
- **Period**: December 2025
- **Learning Objectives**: OOP in Java, Data Persistence, Report Generation

### License

This project is available under the MIT License. See the LICENSE file for more details.

---

**Last Updated**: December 19, 2025
