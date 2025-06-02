package estadio;

public class Local {

    private static Local instance;
    private String nome;

    protected Local(){

    }

    public static Local getInstance() {
        if (instance == null) {
            instance = new Local();
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void Apresentacao() {
        System.out.println("Esta é a apresentação genérica de um Local.");
    }
}
