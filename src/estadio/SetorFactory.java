package estadio;

public class SetorFactory {
    private static SetorFactory instance;

    private SetorFactory() {}

    public static SetorFactory getInstance() {
        if (instance == null) {
            instance = new SetorFactory();
        }
        return instance;
    }

    public Setor criarSetor(int id, String nome) {
        return new SetorImpl(id, nome);
    }

}
