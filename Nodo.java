 public class Nodo {

    private char caracter;
    private Nodo filho_esquerdo;
    private Nodo filho_direito;

    public Nodo() {
        this.caracter = ' ';
        this.filho_esquerdo = null;
        this.filho_direito = null;
    }

    public Nodo getFilhoEsquerdo() {
        return this.filho_esquerdo;
    }

    public void setFilhoEsquerdo(Nodo no) {
        this.filho_esquerdo = no;
    }

    public Nodo getFilhoDireito() {
        return this.filho_direito;
    }

     public void setFilhoDireito(Nodo no) {
         this.filho_direito = no;
     }

     public char getCaracter() {
        return this.caracter;
     }

     public void setCaracter(char caracter) {
        this.caracter = caracter;
     }
}
