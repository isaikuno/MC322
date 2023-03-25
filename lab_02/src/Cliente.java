import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    //Atributos do construtor
    private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;

    //Construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
        if (this.validarCPF(cpf)){ //verifica se o cpf esta certo, se nao, retorna como "invalido"
            this.cpf = cpf;
        } else {
            this.cpf = "invalido";
        }
	}

    //Metodo toString
    public String toString(){
        String str = "---Classe Cliente---\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nData de Nascimento: " + this.dataNascimento + "\nIdade: " + this.idade + "\nEndereco: " + this.endereco + "\n";
        return str;
    }

    //Metodo validarCPF
    private boolean validarCPF(String cpf){
        cpf = cpf.replaceAll("[^\\d]", ""); //remove todos os caracteres nao numericos
        if (cpf.length() != 11){//verifica se o tamanho do cpf tem 11 digitos
            return false;
        }; 

        //Verifica se todos os caracteres nao sao iguais
        Pattern pattern = Pattern.compile("^(\\d)\\1+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }

        //Verifica se os digitos verificadores d0 e d1 sao verdadeiros
        if (!digitos_verif(cpf, 0) || !digitos_verif(cpf, 1)){
            return false;
        }

        return true;
    }

    //Metodo boleano que verifica os digitos verificadores do cpf
    private boolean digitos_verif(String cpf, int digito){
        int soma_final=0, resto, d1;
        //Realiza a soma dos digitos iniciais do cpf multiplicados por 10, 9,..., 2.
        for (int i =10; i>=2; i--){
            soma_final = soma_final + Character.getNumericValue(cpf.charAt(10+digito-i))*i;
        }

        //Define o digito com base no resto da divisao da soma por 11
        resto = soma_final%11;
        if (resto == 0 || resto == 1 ){
            d1 = 0;
        } else {
            d1 = 11-resto;
        }
        //Verifica se o digito difere do que consta no cpf
        if (Character.getNumericValue(cpf.charAt(9+digito)) != d1){
            return false;
        }
        return true;
    }

    //Getters e Setters
    //Atributo nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    //Atributo cpf
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
    //Atributo dataNascimento
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
    //Atributo idade
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
    //Atributo endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
}

