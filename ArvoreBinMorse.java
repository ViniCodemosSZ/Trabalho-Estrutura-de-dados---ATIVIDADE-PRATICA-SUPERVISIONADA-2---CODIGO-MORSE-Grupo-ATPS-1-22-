public class ArvoreBinMorse {
    private Nodo raiz;
    private final int ESQUERDA = 0;
    private final int DIREITA = 1;

    public ArvoreBinMorse() {
        raiz = new Nodo();
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
}
