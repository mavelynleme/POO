// Coloca a classe no pacote separado das classes originais.
package comentados;

// Classe que serve como modelo para objetos que representam fornecedores.
public class FornecedorComentado {
    // Os atributos sao private para aplicar encapsulamento: outras classes usam
    // os setters e getters, em vez de acessar os dados diretamente.
    // String e usada porque estes dados sao textos ou identificadores sem calculos.
    private String empresa;
    private String endereco;
    private String inscricaoEstadual;
    private String nomeContato;

    // Este e o construtor da classe. Ele tem o mesmo nome da classe e nao possui
    // tipo de retorno, nem mesmo void. Um construtor inicializa o objeto durante
    // o uso de new; um metodo comum e chamado depois que o objeto ja existe.
    // Os quatro parametros recebem os dados iniciais do fornecedor.
    public FornecedorComentado(String empresa, String endereco,
            String inscricaoEstadual, String nomeContato) {
        // Em cada linha, this identifica o atributo do objeto atual.
        // O nome sem this identifica o parametro recebido pelo construtor.
        this.empresa = empresa;
        this.endereco = endereco;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeContato = nomeContato;
    }

    // Os metodos set alteram os atributos e nao retornam valores.
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // Os metodos get retornam os valores armazenados nos atributos.
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
