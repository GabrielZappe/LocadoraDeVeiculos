import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Alterar veículo cadastrado");
            System.out.println("3. Buscar veículo por parte do nome");
            System.out.println("4. Cadastrar cliente");
            System.out.println("5. Alterar cliente");
            System.out.println("6. Alugar veículo");
            System.out.println("7. Devolver veículo");
            System.out.println("8. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a placa do veículo:");
                    String placa = scanner.next();
                    System.out.println("Digite o nome do veículo:");
                    String nome = scanner.next();
                    System.out.println("Digite o tipo do veículo (PEQUENO, MEDIO, SUV):");
                    TipoVeiculo tipo = TipoVeiculo.valueOf(scanner.next().toUpperCase());

                    if (locadora.buscarVeiculoPorPlaca(placa) == null) {
                        Veiculo veiculo = new Veiculo(placa, nome, tipo);
                        locadora.cadastrarVeiculo(veiculo);
                        System.out.println("Veículo cadastrado com sucesso!");
                    } else {
                        System.out.println("Veículo com a mesma placa já cadastrado.");
                    }
                    break;

                case 2:
                    System.out.println("Digite a placa do veículo que deseja alterar:");
                    String placaAlterar = scanner.next();
                    Veiculo veiculoParaAlterar = locadora.buscarVeiculoPorPlaca(placaAlterar);
                    if (veiculoParaAlterar != null) {
                        System.out.println("Digite o novo nome do veículo:");
                        String novoNome = scanner.next();
                        veiculoParaAlterar.setNome(novoNome); // Correção aqui
                        System.out.println("Veículo alterado com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;


                case 3:
                    System.out.println("Digite parte do nome do veículo:");
                    String parteNome = scanner.next();
                    List<Veiculo> veiculosEncontrados = locadora.buscarVeiculoPorNome(parteNome);
                    if (!veiculosEncontrados.isEmpty()) {
                        System.out.println("Veículos encontrados:");
                        for (Veiculo v : veiculosEncontrados) {
                            System.out.println("Placa: " + v.getPlaca() + ", Nome: " + v.getNome());
                        }
                    } else {
                        System.out.println("Nenhum veículo encontrado com esse nome.");
                    }
                    break;

                case 4:
                    // Cadastrar cliente
                    break;

                case 5:
                    // Alterar cliente (pessoa física e jurídica)
                    break;

                case 6:
                    // Alugar veículo para pessoa física e jurídica
                    break;

                case 7:
                    // Devolver veículo para pessoa física e jurídica
                    break;

                case 8:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
