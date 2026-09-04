package exerciciometodos;

public class Fornecedor {
    private String empresa;
    private String endereco;
    private String inscricaoEstadual;
    private String nomeContato;

    public Fornecedor(String empresa, String endereco,
            String inscricaoEstadual, String nomeContato) {
        this.empresa = empresa;
        this.endereco = endereco;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeContato = nomeContato;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }
}
