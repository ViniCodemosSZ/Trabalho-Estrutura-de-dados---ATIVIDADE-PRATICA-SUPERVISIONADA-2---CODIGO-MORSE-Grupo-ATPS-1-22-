# Trabalho-Estutura-de-Dados--Arvore-Binaria-Morse
Implementação de um programa em Java que utiliza uma **Árvore Binária** para realizar a codificação e decodificação de caracteres (letras e números) utilizando o **Código Morse**.

# Tradutor de Código Morse - Estrutura de Dados em Java

## Sobre o Projeto
O projeto implementa um tradutor de Código Morse utilizando uma **Árvore Binária** para armazenar e buscar os caracteres de forma eficiente. A estrutura da árvore segue o padrão do Código Morse, onde:
- A **Raiz** da árvore é o ponto de partida.
- Cada **Ponto (`.`)** no Código Morse corresponde a um movimento para o **filho esquerdo** na árvore.
- Cada **Traço (`-`)** no Código Morse corresponde a um movimento para o **filho direito** na árvore.

Dessa forma, o caminho da raiz até um nó folha ou nó de passagem representa o código Morse único de um caractere.

## Estruturas Implementadas
* **`Nodo.java`:**
  * Representa um nó na Árvore Binária.
  * Contém o atributo `caracter` (o caractere representado, e.g., 'A', 'B', '1', ou `' '` para nós de passagem).
  * Possui referências para `filho_esquerdo` (código `.`) e `filho_direito` (código `-`).

* **`ArvoreBinMorse.java`:**
  * Classe principal que gerencia a árvore.
  * **`inicializar()`:** Preenche a árvore com o alfabeto (A-Z) e números (0-9) e seus respectivos códigos Morse.
  * **`inserir(String codigo_morse, char caracter)`:** Insere um novo caractere ou atualiza um existente na árvore com base no código Morse fornecido. Se o caminho não existir, cria os nós de passagem necessários.
  * **`buscar(String codigo_morse)`:** Traduz uma string de códigos Morse (separados por espaço) para a sequência de caracteres correspondente, percorrendo a árvore.
  * **`remover(String codigo_morse)`:** Remove um caractere da árvore (definindo o `caracter` do nó para `' '`) e limpa recursivamente os nós de passagem que se tornaram desnecessários (nós sem caractere e sem filhos).
  * **`exibir_arvore()`:** Exibe a estrutura hierárquica da Árvore Binária de forma visual no console.

## Funcionalidades
O programa principal (`main`) oferece um menu interativo com as seguintes opções:

1.  **Inserir Novo Caractere:** Permite adicionar um novo caractere e seu código Morse (útil para pontuação ou novos símbolos).
2.  **Buscar/Traduzir Código Morse:** Traduz uma sequência de códigos Morse (separados por espaço, ex: `... --- ...`) para o texto.
3.  **Remover Caractere:** Remove um caractere da árvore pelo seu código Morse.
4.  **Exibir Árvore Hierárquica:** Mostra a estrutura atual da árvore no console, indicando a raiz, nós de passagem (`-`) e os caracteres inseridos (`[Caractere]`).
5.  **Reinicializar Árvore:** Recarrega o alfabeto e os números padrões (A-Z e 0-9).
6.  **Sair:** Encerra o programa.

## Estrutura de Arquivos

O projeto está organizado em duas classes principais:

- `Nodo.java`: Definição do nó da árvore.
- `ArvoreBinMorse.java`: Implementação da Árvore Binária Morse e a classe principal (`main`) com o menu interativo.

## Como Executar

Para compilar e executar o projeto, siga os passos abaixo:

1.  **Pré-requisitos:**
    * É necessário ter o **JDK (Java Development Kit)** instalado em sua máquina.

2.  **Compilação:**
    * Abra um terminal ou prompt de comando na pasta raiz do projeto (onde os arquivos `.java` estão localizados).
    * Execute o seguinte comando para compilar todos os arquivos:
        ```bash
        javac *.java
        ```
    * Alternativamente, pode-se simplesmente abrir o projeto em uma IDE de preferência (Netbeans, IntelliJ, Eclipse, etc.), adicionar todos os arquivos e executar.

3.  **Execução:**
    * Após a compilação, execute o programa com o comando:
        ```bash
        java ArvoreBinMorse
        ```

4.  **Interação:**
    * Um menu interativo será exibido no terminal, permitindo que você utilize todas as funcionalidades do tradutor Morse.
