package estadio;

public class SetorImpl implements Setor {
    private int id;
    private String nome;

    public SetorImpl(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void imprimirCatalogo() {
        System.out.printf("%d - %s\n", id, nome);
    }

}
