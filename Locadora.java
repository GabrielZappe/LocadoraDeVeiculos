import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Locadora {
    private static List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;


    public Locadora() {
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    Scanner scanner = new Scanner(System.in);

    public void cadastrarVeiculo(Veiculo veiculo) {
        // Verifique se o veículo já está cadastrado pela placa
        if (null == buscarVeiculoPorPlaca(veiculo.getPlaca())) {
            veiculos.add(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Veículo com a mesma placa já cadastrado.");
        }
    }

    static Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public List<Veiculo> buscarVeiculoPorNome(String parteNome) {
        List<Veiculo> resultados = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().contains(parteNome)) {
                resultados.add(veiculo);
            }
        }
        return resultados;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorId(cliente.getId()) == null) {
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Cliente com o mesmo ID já cadastrado.");
        }
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public Aluguel buscarAluguelPorPlaca(String placa) {
        for (Aluguel aluguel : alugueis) {
            Veiculo veiculo = aluguel.getVeiculo();
            if (veiculo.getPlaca().equals(placa)) {
                return aluguel;
            }
        }
        return null;
    }

    public LocalDateTime getHora() { //arrumar esse caos
        int dia, mes, ano, hora, min;

        System.out.print("Dia: ");
        dia = scanner.nextInt();
        System.out.print("Mes: ");
        mes = scanner.nextInt();
        System.out.print("Ano: ");
        ano = scanner.nextInt();
        System.out.print("Hora: ");
        hora = scanner.nextInt();
        System.out.print("Minuto: ");
        min = scanner.nextInt();

        LocalDateTime dataHora = LocalDateTime.of(ano, mes, dia, hora, min);
        return dataHora;
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo, LocalDateTime dataHoraInicio){
        veiculo.setDisponivel(true);

        Aluguel aluguel = new Aluguel(cliente, veiculo, dataHoraInicio);
        alugueis.add(aluguel);
        System.out.println("Aluguel realizado com sucesso!");
    }

    public void devolverVeiculo(Aluguel aluguel, LocalDateTime dataHoraFim) {
        Veiculo veiculo = aluguel.getVeiculo();
        LocalDateTime dataHoraInicio = aluguel.getDataHoraInicio();

        double valorAluguel = calcularValorAluguel(aluguel, dataHoraInicio, dataHoraFim);

        Devolucao devolucao = new Devolucao(aluguel, dataHoraFim, valorAluguel);
        veiculo.setDisponivel(false);

        System.out.println("Devolução realizada com sucesso!");
        System.out.printf("O valor total do aluguel foi de: %.2f", valorAluguel);
        System.out.println();

        valorAluguel = 0;
    }

    private double calcularValorAluguel(Aluguel aluguel, LocalDateTime inicio, LocalDateTime fim) {

        Veiculo veiculo = aluguel.getVeiculo();
        long diasCompletos = Duration.between(inicio, fim).toDays();


        double valorDiario = switch (veiculo.getTipo()) {
            case PEQUENO -> 100.0;
            case MEDIO -> 150.0;
            case SUV -> 200.0;
            default -> 0.0;
        };


        double valorAluguel = valorDiario * diasCompletos;


        if (aluguel.getCliente().isPessoaJuridica() && diasCompletos > 3) {
            valorAluguel *= 0.9;
        } else if (!aluguel.getCliente().isPessoaJuridica() && diasCompletos > 5) {
            valorAluguel *= 0.95;
        }

        return valorAluguel;
    }

}
