package estadio;

public class AssentoFactory {
    public Assento criarAssento(Setor setor) {
            return new AssentoImpl(setor);
    }
}
