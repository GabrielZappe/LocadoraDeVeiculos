import java.time.LocalDateTime;

public class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataHoraInicio;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataHoraInicio) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataHoraInicio = dataHoraInicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }
}
