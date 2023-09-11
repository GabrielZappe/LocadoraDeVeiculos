import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private static List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;

    public Locadora() {
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

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

    private Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {

        if (!veiculo.isDisponivel()) {
            System.out.println("Veículo não está disponível para aluguel.");
            return;
        }


        double valorAluguel = calcularValorAluguel(veiculo, dataHoraInicio, dataHoraFim);


        Aluguel aluguel = new Aluguel(cliente, veiculo, dataHoraInicio, dataHoraFim, valorAluguel);
        alugueis.add(aluguel);
        veiculo.setDisponivel(false);

        System.out.println("Aluguel realizado com sucesso!");
    }
    private double calcularValorAluguel(Veiculo veiculo, LocalDateTime inicio, LocalDateTime fim) {

        long diasCompletos = Duration.between(inicio, fim).toDays();


        double valorDiario = switch (veiculo.getTipo()) {
            case PEQUENO -> 100.0;
            case MEDIO -> 150.0;
            case SUV -> 200.0;
            default -> 0.0;
        };


        double valorAluguel = valorDiario * diasCompletos;


        if (veiculo.getCliente().isPessoaJuridica() && diasCompletos > 3) {
            valorAluguel *= 0.9;
        } else if (!veiculo.getCliente().isPessoaJuridica() && diasCompletos > 5) {
            valorAluguel *= 0.95;
        }

        return valorAluguel;
    }

}
