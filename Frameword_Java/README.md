# Sistema de Gerenciamento de Produtos

Este é um simples **sistema de gerenciamento de produtos** que utiliza um repositório baseado em arquivos e em memória. O sistema permite operações básicas de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar produtos. Ele pode ser testado utilizando arquivos locais para persistência dos dados.

## Estrutura do Projeto

O projeto está estruturado em pacotes que seguem uma organização simples:

- **org.example.model**: Contém a classe `Produto`, que representa os dados dos produtos no sistema.
- **org.example.repository**: Contém os repositórios para persistência dos dados, como `InFileRepository` (para armazenamento em arquivos) e `InMemoryRepository` (para armazenamento em memória).
- **org.example.utils**: Contém a classe `Utils` com métodos auxiliares, como o método para listar os produtos no repositório.
- **org.example**: Contém a classe `Main`, que é a classe principal de entrada do sistema e orquestra todas as operações.

## Funcionalidades

O sistema permite as seguintes operações:

1. **Salvar Produtos**: Adiciona novos produtos no repositório.
2. **Listar Produtos**: Exibe todos os produtos armazenados no repositório.
3. **Buscar Produto**: Permite buscar um produto específico pelo seu índice (ID).
4. **Atualizar Produto**: Permite atualizar as informações de um produto existente.
5. **Deletar Produto**: Remove um produto do repositório.

## Estrutura do Projeto
<img src="assets/estrutura_framework.png" alt="Estrutura do Projeto" width="500">

## Como Usar

### 1. Pré-requisitos

- **Java 8+**: Certifique-se de ter o **JDK 8 ou superior** instalado no seu sistema. Você pode verificar a versão do Java com o comando:

```bash
java -version
```

### 2. Clone o Repositório

Primeiro, faça um clone do repositório para sua máquina local. Abra o terminal e execute o comando abaixo:

```bash
git clone https://github.com/RobsonMendes37/framework_java.git
cd framework_java
```

### 3. Compile e Execute o Projeto

Agora que o projeto está configurado, é hora de compilar e executá-lo.

**Compilando o projeto manualmente:**
No terminal, dentro do diretório do projeto, compile os arquivos Java com:

```bash
javac org/example/*.java org/example/repository/*.java org/example/utils/*.java org/example/model/*.java 
```

Ou faça por uma IDE como o vscode ou Intellij

Agora chame a biblioteca(.jar) no seu projeto e use a vontade!
