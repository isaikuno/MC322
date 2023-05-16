import java.util.Date;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;
    public ClientePJ (String nome, String endereco, 
                      String cnpj, Date dataFundacao, int qtdeFuncionarios){

        // chama o construtor da superclasse
        super(nome, endereco);
        if (Validacao.validarCNPJ(cnpj)){ //verifica se o cnpj esta certo, se nao, retorna como "invalido"
             this.cnpj = cnpj;
             } else {
              this.cnpj = "invalido";
            }
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    
    //GETTERS E SETTERS
    //Atributo cpnj
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //Atributo dataFundacao
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    //Atributo qtdeFuncionarios
    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    //calcula o valor do seguro
    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.valor * (1 + (getQtdeFuncionarios())/100) * getListaVeiculos().size();
    }


    @Override
         //Metodo toString
         public String toString () {
            String str = "\n---Classe Cliente---\nCNPJ: "+ getCnpj() + 
            "\nValor do Seguro: " + getValorSeguro() + "\nData de Fundação: " + getDataFundacao() +
            "\nQuantidade de Funncionarios: " + getQtdeFuncionarios() +
            "\nNome: " + getNome() + "\nEndereco: " + getEndereco() +
            "\nLista de Veiculos: " + getListaVeiculos() + "\n";
           return str;
    }

}
