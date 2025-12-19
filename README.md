# Java Task Manager | Gestor de Tarefas em Java

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![XML](https://img.shields.io/badge/XML-005FAD?style=for-the-badge&logo=xml&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34C26?style=for-the-badge&logo=html5&logoColor=white)

**Projeto Académico de Linguagens de Programação**

[Português](#português) • [English](#english)

</div>

---

## Português

### 📋 Descrição do Projeto

O **Gestor de Tarefas** é uma aplicação de consola desenvolvida em Java que implementa um sistema completo de gestão de tarefas com persistência de dados. Este projeto académico foi desenvolvido no âmbito da unidade curricular de **Linguagens de Programação** do 2º ano de licenciatura, demonstrando a aplicação prática de conceitos avançados de Programação Orientada a Objetos, persistência de dados e geração de relatórios.

A aplicação oferece funcionalidades essenciais para gestão eficiente de tarefas, incluindo criação, edição, remoção e consulta de tarefas, com suporte para prioridades, estados de progresso e análise de dados através de relatórios HTML formatados.

### 🎯 Objetivos Académicos

Este projeto tem como principais objetivos a demonstração de competências nas seguintes áreas:

- **Programação Orientada a Objetos (POO)**: Implementação de classes concretas, interfaces, herança e encapsulamento
- **Design Patterns**: Aplicação de padrões arquiteturais como DAO (Data Access Object) e Service Layer
- **Interfaces e Contratos**: Definição e implementação da interface `IGestorDeTarefas`
- **Gestão de Dados**: Persistência de dados utilizando ficheiros XML com API DOM
- **Segurança e Validação**: Tratamento rigoroso de exceções e validação de entrada
- **Geração de Relatórios**: Criação dinâmica de documentos HTML com análise de dados
- **Estruturas de Dados**: Manipulação eficiente de listas e ordenação de elementos
- **Enumerações e Tipos**: Utilização de enums para representar estados e prioridades

### ✨ Funcionalidades Principais

#### 1. Gestão Completa de Tarefas
- Operações CRUD (Create, Read, Update, Delete) completas
- Criação de tarefas com descrição detalhada
- Edição de propriedades de tarefas existentes
- Remoção segura com tratamento de erros
- Consulta e listagem de todas as tarefas

#### 2. Sistema de Prioridades
- Três níveis de prioridade: **Baixa**, **Normal**, **Alta**
- Atribuição e modificação de prioridades
- Ordenação de relatórios por prioridade
- Visualização clara de urgência das tarefas

#### 3. Gestão de Estados
- Três estados possíveis: **Pendente**, **Em Progresso**, **Concluída**
- Transição automática entre estados
- Controlo de estado de conclusão
- Rastreamento de progresso

#### 4. Persistência de Dados
- **Armazenamento em XML**: Serialização completa de todas as tarefas
- **Carregamento Automático**: Recuperação de tarefas ao iniciar a aplicação
- **Gravação Segura**: Backup automático de dados
- **Compatibilidade**: Formato XML padrão (DOM API)

#### 5. Geração de Relatórios
- **Relatórios HTML Formatados**: Estilo CSS profissional
- **Agrupamento por Estado**: Organização lógica das tarefas
- **Ordenação por Prioridade**: Visualização hierárquica
- **Estatísticas**: Contagem de tarefas por estado e prioridade

#### 6. Tratamento de Exceções
- Exceção personalizada `TarefaNaoEncontradaException`
- Gestão robusta de erros de entrada
- Validação rigorosa de dados
- Mensagens de erro claras ao utilizador

### 🔧 Tecnologias e Ferramentas

| Tecnologia | Utilização | Versão |
|------------|-----------|--------|
| **Java** | Linguagem de programação principal | 8+ |
| **XML** | Formato de persistência de dados | 1.0 |
| **DOM API** | Processamento de ficheiros XML | Java Standard |
| **HTML5** | Formato de relatórios | 5.0 |
| **Git** | Controlo de versão | - |
| **Eclipse IDE** | Ambiente de desenvolvimento | - |

### 🏗️ Arquitetura do Sistema

```
Trabalho_Individual_1/
├── src/
│   ├── Main.java                           # Ponto de entrada da aplicação
│   ├── Entities/                           # Modelos e Enumerações
│   │   ├── Estado.java                     # Enumeração dos estados de uma tarefa
│   │   ├── Prioridade.java                 # Enumeração dos níveis de prioridade
│   │   └── TarefaNaoEncontradaException.java # Exceção personalizada
│   ├── Interfaces/                         # Contratos de Negócio
│   │   └── IGestorDeTarefas.java           # Interface do gestor de tarefas
│   └── Services/                           # Lógica de Negócio
│       ├── Tarefa.java                     # Modelo de tarefa com getters/setters
│       └── GestorDeTarefas.java            # Implementação do gestor de tarefas
├── bin/                                    # Ficheiros compilados (.class)
├── dados/
│   ├── tarefas.xml                         # Ficheiro de persistência de tarefas
│   └── relatorio.html                      # Relatório gerado em HTML
├── .project                                # Ficheiro de configuração Eclipse
├── .classpath                              # Definição do classpath
└── README.md                               # Este ficheiro
```

#### Descrição das Camadas

1. **Models/Entities (Modelos de Domínio)**
   - Classe `Tarefa`: Representa uma tarefa individual com atributos (id, descrição, prioridade, estado, data de criação)
   - Enum `Prioridade`: Define os níveis de prioridade disponíveis
   - Enum `Estado`: Define os estados possíveis de uma tarefa
   - Exceção `TarefaNaoEncontradaException`: Lançada em operações inválidas

2. **Interfaces**
   - `IGestorDeTarefas`: Define o contrato para o gestor de tarefas

3. **Services (Serviços - Lógica de Negócio)**
   - `GestorDeTarefas`: Implementação completa da interface
   - Métodos CRUD (Create, Read, Update, Delete)
   - Métodos de persistência (guardar/carregar XML)
   - Método de geração de relatórios HTML
   - Tratamento de exceções personalizadas

### 🚀 Como Executar o Projeto

#### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Sistema operativo compatível (Windows, Linux, macOS)

#### Passos de Instalação

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/Rnarciso15/java-task-manager.git
   cd java-task-manager
   ```

2. **Compilar o projeto**
   ```bash
   javac -d bin -sourcepath src src/Main.java
   ```

3. **Executar a aplicação**
   ```bash
   java -cp bin Main
   ```

#### Estrutura de Diretórios Gerados
Após a primeira execução, o sistema criará automaticamente:
- `dados/tarefas.xml` - Ficheiro de persistência de tarefas
- `dados/relatorio.html` - Relatório gerado em HTML

### 📚 Exemplos de Utilização

#### Exemplo 1: Criar uma Nova Tarefa

```
========================================
     GESTOR DE TAREFAS - MENU PRINCIPAL
========================================

1. Criar Tarefa
2. Listar Tarefas
3. Editar Tarefa
4. Remover Tarefa
5. Gerar Relatório
6. Sair

Escolha uma opção: 1

--- Criar Nova Tarefa ---
Descrição da tarefa: Implementar funcionalidade de login
Prioridade (1-Baixa, 2-Normal, 3-Alta): 3
Estado (1-Pendente, 2-Em Progresso, 3-Concluída): 1

✓ Tarefa criada com sucesso!
ID da tarefa: 1
```

#### Exemplo 2: Listar Tarefas

```
Escolha uma opção: 2

========================================
          TAREFAS GUARDADAS
========================================

[Tarefa #1]
Descrição: Implementar funcionalidade de login
Prioridade: Alta
Estado: Pendente
Data de Criação: 2025-12-19

[Tarefa #2]
Descrição: Escrever testes unitários
Prioridade: Normal
Estado: Em Progresso
Data de Criação: 2025-12-18

Total de tarefas: 2
```

#### Exemplo 3: Editar uma Tarefa

```
Escolha uma opção: 3

ID da tarefa a editar: 1
Nova descrição: Implementar sistema de autenticação
Novo estado (1-Pendente, 2-Em Progresso, 3-Concluída): 2

✓ Tarefa atualizada com sucesso!
```

#### Exemplo 4: Gerar Relatório

```
Escolha uma opção: 5

✓ Relatório gerado com sucesso!
Localização: dados/relatorio.html
```

### 📚 Conceitos de Programação Aplicados

#### Programação Orientada a Objetos
- **Classe Tarefa**: Representa uma entidade de negócio
  - Atributos privados com encapsulamento
  - Métodos getters e setters para acesso controlado
  - Construtores parametrizados
- **Herança**: Potencial para extensão futura (ex: `TarefaRecorrente`)
- **Encapsulamento**: Proteção de dados sensíveis
- **Polimorfismo**: Implementação da interface `IGestorDeTarefas`

#### Interfaces e Contratos
- **`IGestorDeTarefas`**: Define o contrato que `GestorDeTarefas` implementa
- Método `criarTarefa()`
- Método `listarTarefas()`
- Método `editarTarefa()`
- Método `removerTarefa()`
- Método `guardarXML()`
- Método `carregarXML()`
- Método `gerarRelatorioHTML()`

#### Enumerações
- **`Prioridade`**: Encapsulamento de valores (Baixa, Normal, Alta)
- **`Estado`**: Encapsulamento de estados (Pendente, Em Progresso, Concluída)
- Type-safety em tempo de compilação
- Facilita validação e organização do código

#### Exceções Personalizadas
- **`TarefaNaoEncontradaException`**: Exceção específica do domínio
- Herda de `Exception`
- Lançada quando tentativa de acesso a tarefa inexistente
- Tratamento granular de erros

#### Gestão de Ficheiros XML
- **API DOM**: Parsing e manipulação de documentos XML
- Criação de elementos XML dinâmicos
- Escrita e leitura estruturada de dados
- Persistência de estado da aplicação

#### Geração de Relatórios HTML
- Construção dinâmica de documentos HTML
- Agrupamento inteligente de dados
- Ordenação por critérios de negócio
- CSS inline para formatação profissional
- Estatísticas e sumários

#### Estruturas de Dados
- **ArrayList/List**: Armazenamento de tarefas
- **HashMap**: Possível indexação por ID
- **Comparators**: Ordenação customizada
- **Streams API**: Filtragem e transformação de dados

### 👥 Autor

**Ricardo Narciso**
- GitHub: [@Rnarciso15](https://github.com/Rnarciso15)
- Email: (Contacto disponível via perfil GitHub)

### 📝 Contexto Académico

**Unidade Curricular**: Linguagens de Programação  
**Ano Letivo**: 2024/2025  
**Nível**: 2º Ano de Licenciatura  
**Tipo**: Trabalho Individual 1

Este projeto demonstra competências em:
- Aplicação de conceitos teóricos de Programação Orientada a Objetos
- Desenvolvimento de software com arquitetura modular
- Implementação de sistemas de persistência de dados
- Manipulação de ficheiros XML
- Geração de relatórios dinâmicos
- Tratamento robusto de erros e exceções

### 📄 Licença

Este é um projeto académico desenvolvido exclusivamente para fins educacionais. O código está disponível para consulta e aprendizagem.

---

## English

### 📋 Project Description

The **Task Manager** is a console application developed in Java that implements a complete task management system with data persistence. This academic project was developed as part of the **Programming Languages** course in the 2nd year of undergraduate studies, demonstrating the practical application of advanced Object-Oriented Programming concepts, data persistence, and report generation.

The application provides essential functionalities for efficient task management, including creation, editing, removal, and consultation of tasks, with support for priorities, progress states, and data analysis through formatted HTML reports.

### 🎯 Academic Objectives

This project aims to demonstrate competencies in the following areas:

- **Object-Oriented Programming (OOP)**: Implementation of concrete classes, interfaces, inheritance, and encapsulation
- **Design Patterns**: Application of architectural patterns such as DAO (Data Access Object) and Service Layer
- **Interfaces and Contracts**: Definition and implementation of the `IGestorDeTarefas` interface
- **Data Management**: Data persistence using XML files with DOM API
- **Security and Validation**: Rigorous exception handling and input validation
- **Report Generation**: Dynamic creation of HTML documents with data analysis
- **Data Structures**: Efficient manipulation of lists and element sorting
- **Enumerations and Types**: Use of enums to represent states and priorities

### ✨ Main Features

#### 1. Complete Task Management
- Complete CRUD operations (Create, Read, Update, Delete)
- Task creation with detailed description
- Editing properties of existing tasks
- Safe removal with error handling
- Query and listing of all tasks

#### 2. Priority System
- Three priority levels: **Low**, **Normal**, **High**
- Assignment and modification of priorities
- Report sorting by priority
- Clear visualization of task urgency

#### 3. Status Management
- Three possible states: **Pending**, **In Progress**, **Completed**
- Automatic state transitions
- Completion state control
- Progress tracking

#### 4. Data Persistence
- **XML Storage**: Complete serialization of all tasks
- **Automatic Loading**: Task recovery when starting the application
- **Safe Writing**: Automatic data backup
- **Compatibility**: Standard XML format (DOM API)

#### 5. Report Generation
- **Formatted HTML Reports**: Professional CSS styling
- **Status Grouping**: Logical task organization
- **Priority Sorting**: Hierarchical visualization
- **Statistics**: Task count by status and priority

#### 6. Exception Handling
- Custom exception `TarefaNaoEncontradaException`
- Robust input error management
- Rigorous data validation
- Clear error messages to user

### 🔧 Technologies and Tools

| Technology | Usage | Version |
|-----------|-------|---------|
| **Java** | Main programming language | 8+ |
| **XML** | Data persistence format | 1.0 |
| **DOM API** | XML file processing | Java Standard |
| **HTML5** | Report format | 5.0 |
| **Git** | Version control | - |
| **Eclipse IDE** | Development environment | - |

### 🏗️ System Architecture

```
Trabalho_Individual_1/
├── src/
│   ├── Main.java                           # Entry point of the application
│   ├── Entities/                           # Models and Enumerations
│   │   ├── Estado.java                     # Enumeration of task states
│   │   ├── Prioridade.java                 # Enumeration of priority levels
│   │   └── TarefaNaoEncontradaException.java # Custom exception
│   ├── Interfaces/                         # Business Contracts
│   │   └── IGestorDeTarefas.java           # Task manager interface
│   └── Services/                           # Business Logic
│       ├── Tarefa.java                     # Task model with getters/setters
│       └── GestorDeTarefas.java            # Task manager implementation
├── bin/                                    # Compiled files (.class)
├── dados/
│   ├── tarefas.xml                         # Task persistence file
│   └── relatorio.html                      # Generated HTML report
├── .project                                # Eclipse configuration file
├── .classpath                              # Classpath definition
└── README.md                               # This file
```

#### Layer Description

1. **Models/Entities (Domain Models)**
   - `Tarefa` class: Represents an individual task with attributes (id, description, priority, state, creation date)
   - Enum `Prioridade`: Defines available priority levels
   - Enum `Estado`: Defines possible task states
   - Exception `TarefaNaoEncontradaException`: Thrown on invalid operations

2. **Interfaces**
   - `IGestorDeTarefas`: Defines the contract for the task manager

3. **Services (Services - Business Logic)**
   - `GestorDeTarefas`: Complete interface implementation
   - CRUD methods (Create, Read, Update, Delete)
   - Persistence methods (save/load XML)
   - HTML report generation method
   - Custom exception handling

### 🚀 How to Run the Project

#### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Compatible operating system (Windows, Linux, macOS)

#### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Rnarciso15/java-task-manager.git
   cd java-task-manager
   ```

2. **Compile the project**
   ```bash
   javac -d bin -sourcepath src src/Main.java
   ```

3. **Run the application**
   ```bash
   java -cp bin Main
   ```

#### Generated Directory Structure
After the first execution, the system will automatically create:
- `dados/tarefas.xml` - Task persistence file
- `dados/relatorio.html` - Generated HTML report

### 📚 Usage Examples

#### Example 1: Create a New Task

```
========================================
     TASK MANAGER - MAIN MENU
========================================

1. Create Task
2. List Tasks
3. Edit Task
4. Remove Task
5. Generate Report
6. Exit

Choose an option: 1

--- Create New Task ---
Task description: Implement login functionality
Priority (1-Low, 2-Normal, 3-High): 3
Status (1-Pending, 2-In Progress, 3-Completed): 1

✓ Task created successfully!
Task ID: 1
```

#### Example 2: List Tasks

```
Choose an option: 2

========================================
          SAVED TASKS
========================================

[Task #1]
Description: Implement login functionality
Priority: High
Status: Pending
Creation Date: 2025-12-19

[Task #2]
Description: Write unit tests
Priority: Normal
Status: In Progress
Creation Date: 2025-12-18

Total tasks: 2
```

#### Example 3: Edit a Task

```
Choose an option: 3

Task ID to edit: 1
New description: Implement authentication system
New status (1-Pending, 2-In Progress, 3-Completed): 2

✓ Task updated successfully!
```

#### Example 4: Generate Report

```
Choose an option: 5

✓ Report generated successfully!
Location: dados/relatorio.html
```

### 📚 Applied Programming Concepts

#### Object-Oriented Programming
- **Tarefa Class**: Represents a business entity
  - Private attributes with encapsulation
  - Getter and setter methods for controlled access
  - Parameterized constructors
- **Inheritance**: Potential for future extension (e.g., `TarefaRecorrente`)
- **Encapsulation**: Protection of sensitive data
- **Polymorphism**: Implementation of the `IGestorDeTarefas` interface

#### Interfaces and Contracts
- **`IGestorDeTarefas`**: Defines the contract that `GestorDeTarefas` implements
- `criarTarefa()` method
- `listarTarefas()` method
- `editarTarefa()` method
- `removerTarefa()` method
- `guardarXML()` method
- `carregarXML()` method
- `gerarRelatorioHTML()` method

#### Enumerations
- **`Prioridade`**: Encapsulation of values (Low, Normal, High)
- **`Estado`**: Encapsulation of states (Pending, In Progress, Completed)
- Type-safety at compile time
- Facilitates validation and code organization

#### Custom Exceptions
- **`TarefaNaoEncontradaException`**: Domain-specific exception
- Inherits from `Exception`
- Thrown when attempting to access non-existent task
- Granular error handling

#### XML File Management
- **DOM API**: Parsing and manipulation of XML documents
- Dynamic creation of XML elements
- Structured data writing and reading
- Application state persistence

#### HTML Report Generation
- Dynamic HTML document construction
- Intelligent data grouping
- Sorting by business criteria
- Inline CSS for professional formatting
- Statistics and summaries

#### Data Structures
- **ArrayList/List**: Storage of tasks
- **HashMap**: Possible indexing by ID
- **Comparators**: Custom sorting
- **Streams API**: Data filtering and transformation

### 👥 Author

**Ricardo Narciso**
- GitHub: [@Rnarciso15](https://github.com/Rnarciso15)
- Email: (Contact available via GitHub profile)

### 📝 Academic Context

**Course**: Programming Languages  
**Academic Year**: 2024/2025  
**Level**: 2nd Year Undergraduate  
**Type**: Individual Assignment 1

This project demonstrates competencies in:
- Application of Object-Oriented Programming theoretical concepts
- Software development with modular architecture
- Data persistence systems implementation
- XML file manipulation
- Dynamic report generation
- Robust error and exception handling

### 📄 License

This is an academic project developed exclusively for educational purposes. The code is available for consultation and learning.

---

<div align="center">

**Developed with ☕ and Java**

**Last Updated**: December 19, 2025

</div>
