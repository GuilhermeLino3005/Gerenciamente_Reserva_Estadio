package estadio;

import java.util.Scanner;

public class Estadio extends Local {

    private static Estadio instancia;

    private Estadio() {
    }

    public static Estadio getInstance() {
        if (instancia == null) {
            instancia = new Estadio();
        }
        return instancia;
    }

    @Override
    public void Apresentacao() {
        System.out.println("1 - Maracanã ");
    }

    public void executar() {
        Scanner leitor = new Scanner(System.in);
        int opcaoLocal, opcao, escolha, assento, fila;

        SetorFactory setorFactory = SetorFactory.getInstance();
        AssentoFactory assentoFactory = new AssentoFactory();

        Setor setorSul = setorFactory.criarSetor(1, "Setor Sul");
        Setor setorNorte = setorFactory.criarSetor(2, "Setor Norte");
        Setor setorLeste = setorFactory.criarSetor(3, "Setor Leste");
        Setor setorOeste = setorFactory.criarSetor(4, "Setor Oeste");

        Assento assentoSul = assentoFactory.criarAssento(setorSul);
        Assento assentoNorte = assentoFactory.criarAssento(setorNorte);
        Assento assentoLeste = assentoFactory.criarAssento(setorLeste);
        Assento assentoOeste = assentoFactory.criarAssento(setorOeste);

        assentoSul.inicializarAssentos();
        assentoNorte.inicializarAssentos();
        assentoLeste.inicializarAssentos();
        assentoOeste.inicializarAssentos();

        Setor setorSelecionado = null;
        Assento assentoSelecionado = null;

        do {
            System.out.println("Digite o número do estádio que deseja acessar ");
            this.Apresentacao();
            System.out.println("0 - Sair ");

            opcaoLocal = leitor.nextInt();

            switch (opcaoLocal) {

                case 1:
                    System.out.println("Bem Vindo ao Maracanã\n");
                    do {
                        System.out.println("Escolha um setor:\n");
                        setorSul.imprimirCatalogo();
                        setorNorte.imprimirCatalogo();
                        setorLeste.imprimirCatalogo();
                        setorOeste.imprimirCatalogo();
                        System.out.println("0 - Sair");

                        opcao = leitor.nextInt();

                        switch (opcao) {
                            case 1 -> {
                                setorSelecionado = setorSul;
                                assentoSelecionado = assentoSul;
                            }
                            case 2 -> {
                                setorSelecionado = setorNorte;
                                assentoSelecionado = assentoNorte;
                            }
                            case 3 -> {
                                setorSelecionado = setorLeste;
                                assentoSelecionado = assentoLeste;
                            }
                            case 4 -> {
                                setorSelecionado = setorOeste;
                                assentoSelecionado = assentoOeste;
                            }
                            case 0 -> {
                                System.out.println("Saindo...");
                                continue;
                            }
                            default -> {
                                System.out.println("Valor inválido");
                                continue;
                            }
                        }

                        if (setorSelecionado != null) {
                            do {
                                assentoSelecionado.imprimirAssentos(opcao);
                                System.out.println("\nDigite uma opção:");
                                System.out.println("1 - Reservar um assento");
                                System.out.println("2 - Liberar um assento");
                                System.out.println("3 - Voltar");

                                escolha = leitor.nextInt();

                                switch (escolha) {
                                    case 1 -> {
                                        System.out.println("Digite a fila e o assento que deseja reservar:");
                                        fila = leitor.nextInt();
                                        assento = leitor.nextInt();
                                        if (assentoSelecionado.reservarAssento(fila, assento, opcao)) {
                                            System.out.println("Assento reservado com sucesso!");
                                        } else {
                                            System.out.println("Assento já reservado ou inválido.");
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("Digite a fila e o assento que deseja liberar:");
                                        fila = leitor.nextInt();
                                        assento = leitor.nextInt();
                                        if (assentoSelecionado.liberarAssento(fila, assento, opcao)) {
                                            System.out.println("Assento liberado com sucesso!");
                                        } else {
                                            System.out.println("Assento já estava disponível ou inválido.");
                                        }
                                    }
                                    case 3 -> System.out.println("Voltando...");
                                    default -> System.out.println("Opção inválida. Tente novamente.");
                                }

                            } while (escolha != 3);
                        }

                    } while (opcao != 0);

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoLocal != 0);
        leitor.close();
    }

    public static void main(String[] args) {
        Estadio.getInstance().executar();
    }
}