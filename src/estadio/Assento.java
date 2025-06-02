package estadio;

public interface Assento {
    void inicializarAssentos();
    void imprimirAssentos(int quantidadeDeSetores);
    boolean reservarAssento(int fila, int assento, int quantidadeDeSetores);
    boolean liberarAssento(int fila, int assento, int quantidadeDeSetores);
    Setor getSetor();
}


