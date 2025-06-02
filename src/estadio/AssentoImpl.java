package estadio;

public class AssentoImpl implements Assento {
    Setor setor;
    int quantidadeDeFilas = 6;
    int quantidadeDeCadeiras = 10;
    int[][][] assentos = new int[quantidadeDeFilas][quantidadeDeCadeiras][4];

    public AssentoImpl(Setor setor) {
        this.setor = setor;
    }

    public void inicializarAssentos() {
        for (int i = 0; i < quantidadeDeFilas; i++) {
            for (int j = 0; j < quantidadeDeCadeiras; j++) {
                for (int k = 0; k < 4; k++) {
                    assentos[i][j][k] = 0;
                }
            }
        }
    }

    public void imprimirAssentos(int quantidadeDeSetores) {
        System.out.printf("Assentos disponíveis para o Setor %s:\n", setor.getNome());
        for (int i = 0; i < quantidadeDeFilas; i++) {
            System.out.printf("Fila %d: ", i + 1);
            for (int j = 0; j < quantidadeDeCadeiras; j++) {
                if (assentos[i][j][quantidadeDeSetores - 1] == 0) {
                    System.out.printf("%d ", j + 1);
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public boolean avaliarAssento(int fila, int assento, int quantidadeDeSetores) {
        return fila >= 1 && fila <= quantidadeDeFilas && assento >= 1 && assento <= quantidadeDeCadeiras &&
                assentos[fila - 1][assento - 1][quantidadeDeSetores - 1] == 0;
    }

    public boolean reservarAssento(int fila, int assento, int quantidadeDeSetores) {
        if (avaliarAssento(fila, assento, quantidadeDeSetores)) {
            assentos[fila - 1][assento - 1][quantidadeDeSetores - 1] = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean liberarAssento(int fila, int assento, int quantidadeDeSetores) {
        if (!avaliarAssento(fila, assento, quantidadeDeSetores)) {
            assentos[fila - 1][assento - 1][quantidadeDeSetores - 1] = 0;
            return true;
        } else {
            return false;
        }
    }

    public Setor getSetor() {
        return setor;
    }


}
