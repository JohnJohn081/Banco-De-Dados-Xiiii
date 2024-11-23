
# Banco de Dados XIII

Este repositório contém um projeto desenvolvido em **Java** com conexão ao banco de dados **MySQL** utilizando o **JDBC**. O objetivo é demonstrar como criar, manipular e gerenciar dados em um banco de dados relacional diretamente via código Java.

## 🚀 Funcionalidades

- **Conexão com MySQL:** Configuração e execução de operações com JDBC.
- **CRUD Completo:** Exemplos práticos de *Create*, *Read*, *Update* e *Delete*.
- **Validação de Dados:** Tratamento de erros e exceções relacionadas ao banco de dados.
- **Estrutura Modular:** Código organizado em camadas (DAO, serviços, etc.).

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 8 ou superior)
- **Banco de Dados:** MySQL
- **Biblioteca:** JDBC (Java Database Connectivity)
- **IDE Recomendadas:** IntelliJ IDEA, Eclipse ou VS Code com extensão para Java

## 📂 Estrutura do Projeto
```plaintext
Banco-De-Dados-XIIII/
├── src/                      # Código fonte do projeto
│   ├── dao/                  # Data Access Objects (DAO)
│   ├── models/               # Classes de modelo (entidades)
│   ├── services/             # Lógica de negócios
│   └── utils/                # Classes utilitárias (ex.: conexão com o banco)
├── lib/                      # Dependências externas (se necessário)
├── resources/                # Arquivos de configuração e SQL
└── README.md                 # Documentação do repositório
```

## 📝 Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/JohnJohn081/Banco-De-Dados-Xiiii.git
   ```

2. **Configure o banco de dados MySQL:**
   - Certifique-se de ter o MySQL instalado.
   - Crie um banco de dados e configure o arquivo de conexão:
     ```sql
     CREATE DATABASE banco_xiii;
     ```
   - Atualize as credenciais no arquivo `ConnectionUtils.java`:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/banco_xiii";
     private static final String USER = "seu_usuario";
     private static final String PASSWORD = "sua_senha";
     ```

3. **Compile e execute:**
   - Use sua IDE preferida ou compile no terminal:
     ```bash
     javac -d bin src/**/*.java
     java -cp bin Main
     ```

4. **Teste as operações:**
   - O projeto inclui operações de exemplo como inserção, consulta e exclusão.

## 📌 Contribuições

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma nova branch para sua funcionalidade:
   ```bash
   git checkout -b nova-funcionalidade
   ```
3. Submeta um pull request com a descrição das alterações.

## 🧑‍💻 Autor

Criado com ❤️ por [John](https://github.com/JohnJohn081).

---

### 📜 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais informações.
```

