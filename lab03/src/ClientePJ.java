import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;

    public ClientePJ (String nome, String endereco, Date dataLicenca,
                      String educacao, String genero, String classeEconomica, 
                      String cnpj, Date dataFundacao){

        // chama o construtor da superclasse
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica);
        if (this.validarCNPJ(cnpj)){ //verifica se o cpf esta certo, se nao, retorna como "invalido"
             this.cnpj = cnpj;
             } else {
              this.cnpj = "invalido";
            }
        this.dataFundacao = dataFundacao;
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


    @Override
         //Metodo toString
         public String toString () {
            String str = "\n---Classe Cliente---\nCNPJ: "+ getCnpj() + "\nData de Fundação: " + getDataFundacao() +
             "\nNome: " + getNome() + "\nEndereco: " + getEndereco() +
            "\nData Licença: " + getDataLicenca() +
            "\nEducação: " + getEducacao() + 
            "\nGenero: " + getGenero() + "\nClasse Econômica: " + getClasseEconomica() +
            "\nLista de Veiculos: " + getListaVeiculos() + "\n";
           return str;
    }

    //Metodo validarCNPJ
    public boolean validarCNPJ(String cnpj){
        cnpj = cnpj.replaceAll("[^\\d]", ""); //remove todos os caracteres nao numericos
        if (cnpj.length() != 14){//verifica se o tamanho do cnpj tem 14 digitos
            return false;
        }; 

        //Verifica se todos os caracteres nao sao iguais
        Pattern pattern = Pattern.compile("^(\\d)\\1+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cnpj);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }

        //Verifica se os digitos verificadores d0 e d1 sao verdadeiros
        if (!digitos_verif(cnpj, 1) || !digitos_verif(cnpj, 0)){
            return false;
        }

        return true;
    }

    //Metodo boleano que verifica os digitos verificadores do cnpj
    private boolean digitos_verif(String cnpj, int digito){
        int soma_final=0, resto, d1;
        final int[] fator = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        //Realiza a soma dos digitos iniciais do cnpj multiplicados por fator.
        for (int i=0; i<(13-digito); i++){
            soma_final = soma_final + Character.getNumericValue(cnpj.charAt(i))*fator[i+digito];
        }

        //Define o digito com base no resto da divisao da soma por 11
        resto = soma_final%11;
        if (resto == 0 || resto == 1 ){
            d1 = 0;
        } else {
            d1 = 11-resto;
        }
        //Verifica se o digito difere do que consta no cnpj
        if (Character.getNumericValue(cnpj.charAt(13-digito)) != d1){
            return false;
        }
        return true;
    }

}
