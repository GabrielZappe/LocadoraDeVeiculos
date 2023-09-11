public class Veiculo {
    private String placa;
    private String nome;
    private TipoVeiculo tipo;
    private boolean disponivel;
    private Cliente cliente; // Adicionado cliente associado ao veículo

    public Veiculo(String placa, String nome, TipoVeiculo tipo) {
        this.placa = placa;
        this.nome = nome;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

}
