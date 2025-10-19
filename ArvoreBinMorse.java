import java.util.Scanner;

public class ArvoreBinMorse {
    private Nodo raiz;
    private final int ESQUERDA = 0;
    private final int DIREITA = 1;

    public ArvoreBinMorse() {
        raiz = new Nodo();
    }

    // Metodo pra iniciar a arvore com o alfabeto e os numeros
    public void inicializar() {
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    public void inserir(String codigo_morse, char caracter) {
        int tamanho_string = codigo_morse.length();
        Nodo atual = this.raiz;
        for (int i = 0; i < tamanho_string; i++) {
            // Define a direção do próximo nó
            int direcao;
            if (codigo_morse.charAt(i) == '.')
                direcao = ESQUERDA;
            else
                direcao = DIREITA;

            // Caso não haja um nó filho nessa direção, ele cria um nó com
            // caracter = ' ', representando um nó vazio
            if (direcao == ESQUERDA && atual.getFilhoEsquerdo() == null) {
                atual.setFilhoEsquerdo(new Nodo());
            } else if (direcao == DIREITA && atual.getFilhoDireito() == null) {
                atual.setFilhoDireito(new Nodo());
            }

            // Se for o último caracter do código morse, ele define o caracter do filho
            // na direção correta para o caracter passado como parâmetro, efetivamente
            // inserindo o caracter
            if (i == (tamanho_string - 1)) {
                if (direcao == ESQUERDA)
                    atual.getFilhoEsquerdo().setCaracter(caracter);
                else
                    atual.getFilhoDireito().setCaracter(caracter);

            } else {
                // Caso não seja o último, define atual como o próximo nó
                // para continuar percorrendo a árvore
                if (direcao == ESQUERDA)
                    atual = atual.getFilhoEsquerdo();
                else
                    atual = atual.getFilhoDireito();
            }
        }
    }

    // Método para buscar caracteres na árvore e retorná-los traduzidos
    public String buscar(String codigo_morse) {
        String[] letras = codigo_morse.split(" ");
        String retorno = "";

        // Percorre a lista, traduzindo cada caracter
        for (String letra : letras) {
            Nodo atual = this.raiz;
            int tamanho = letra.length();

            // Percorre a arvore até chegar no caracter
            for (int i = 0; i < tamanho; i++) {
                if (atual != null) {
                    switch (letra.charAt(i)) {
                        case '.':
                            atual = atual.getFilhoEsquerdo();
                            break;
                        case '-':
                            atual = atual.getFilhoDireito();
                            break;
                        default:
                            return null;
                    }
                } else {
                    // Retorna null caso o nó não exista
                    return null;
                }
            }
            if (atual.getCaracter() != ' ')
               retorno += atual.getCaracter();
            else
                // Retorna null caso o nó exista, mas o caracter não foi inserido
                return null;
        }
        return retorno;
    }

    // Método para remover caracteres da árvore
    public boolean remover(String codigo_morse) {
        int tamanho_codigo = codigo_morse.length();
        Nodo[] nodos_percorridos = new Nodo[tamanho_codigo+1];
        Nodo atual = this.raiz;
        nodos_percorridos[0] = this.raiz;

        // Percorre a arvore até achar o nodo do caracter, retorna falso caso o nodo não exista
        for (int i = 0; i < tamanho_codigo; i++) {
            if (codigo_morse.charAt(i) == '.' && atual.getFilhoEsquerdo() != null) {
                atual = atual.getFilhoEsquerdo();
                nodos_percorridos[i+1] = atual;
            } else if (codigo_morse.charAt(i) == '-' && atual.getFilhoDireito() != null) {
                atual = atual.getFilhoDireito();
                nodos_percorridos[i+1] = atual;
            } else {
                return false;
            }
        }

        if (atual.getCaracter() == ' ')
            return false;
        
        // Efetivamente remove o caracter
        atual.setCaracter(' ');

        // Limpa os nodos que não tem mais uso após a remoção do caracter
        for (int i = tamanho_codigo; i >= 1; i--) {
            atual = nodos_percorridos[i];

            // Remove o nó se isso não causar perdas de outros nós, se não puder retorna true,
            // pois os nós que não tem mais utilidade já foram removidos
            if (atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null && atual.getCaracter() == ' ') {
                Nodo pai = nodos_percorridos[i-1];
                if (pai.getFilhoEsquerdo() == atual)
                    pai.setFilhoEsquerdo(null);
                else if (pai.getFilhoDireito() == atual)
                    pai.setFilhoDireito(null);
            } else {
                return true;
            }
        }
        return true;
    }


    // Método auxiliar recursivo para a exibição
    private void exibir_arvore_recursivo(Nodo atual, int nivel) {
        if (atual == null) {
            return;
        }

        // Processa o nó (imprime após subárvore direita para um formato mais 'vertical')
        exibir_arvore_recursivo(atual.getFilhoDireito(), nivel + 1);

        // Imprime a indentação
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // 4 espaços para indentação
        }

        // Imprime o caracter. Se for a raiz ou um nó de passagem (' '),
        // indica com 'start' ou apenas com um símbolo.
        char caracter = atual.getCaracter();
        if (nivel == 0) {
            System.out.println("(start)");
        } else if (caracter != ' ') {
            System.out.println("[" + caracter + "]");
        } else {
            System.out.println("(-)");
        }

        // Processa a subárvore esquerda
        exibir_arvore_recursivo(atual.getFilhoEsquerdo(), nivel + 1);
    }

    // Método público para iniciar a exibição
    public void exibir_arvore() {
        System.out.println("\nEstrutura da Árvore Binária Morse");
        exibir_arvore_recursivo(this.raiz, 0);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinMorse arvore = new ArvoreBinMorse();

        // Inicializa automaticamente com o alfabeto e números [cite: 9]
        arvore.inicializar();

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Menu Árvore Binária Morse ---");
            System.out.println("1. Inserir Novo Caractere");
            System.out.println("2. Buscar/Traduzir Código Morse (Entrada do Usuário)");
            System.out.println("3. Remover Caractere");
            System.out.println("4. Exibir Árvore Hierárquica");
            System.out.println("5. Reinicializar Árvore (Carregar Automaticamente)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            // Leitura da opção
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha
            } else {
                System.out.println("Opção inválida. Digite um número.");
                scanner.nextLine(); // Consome a entrada inválida
                opcao = 0;
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Caractere (1 letra/numero): ");
                    String charStr = scanner.nextLine().toUpperCase();
                    if (charStr.length() != 1) {
                        System.out.println("Entrada inválida. Digite apenas 1 caractere.");
                        break;
                    }
                    char caracter = charStr.charAt(0);

                    System.out.print("Digite o Código Morse (apenas . e -): ");
                    String codigo = scanner.nextLine();

                    arvore.inserir(codigo, caracter);
                    System.out.println("Caractere '" + caracter + "' inserido com sucesso (ou atualizado).");
                    break;

                case 2:
                    System.out.print("Digite o Código Morse para tradução (separado por espaço, ex: ... --- ...): ");
                    String morseEntrada = scanner.nextLine();
                    String resultado = arvore.buscar(morseEntrada);

                    if (resultado != null) {
                        System.out.println("Tradução: " + resultado);
                    } else {
                        System.out.println("Erro: Código Morse inválido ou caractere não encontrado na árvore.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o Código Morse do caractere a remover (ex: ... para 'S'): ");
                    String morseRemover = scanner.nextLine();

                    if (arvore.remover(morseRemover)) {
                        System.out.println("Caractere removido e nós desnecessários limpos.");
                    } else {
                        System.out.println("Erro: Caractere não encontrado ou código inválido.");
                    }
                    break;

                case 4:
                    arvore.exibir_arvore();
                    break;

                case 5:
                    arvore.inicializar();
                    System.out.println("Árvore reinicializada.");
                    break;

                case 6:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close(); // Fecha o Scanner ao sair
    }
}
