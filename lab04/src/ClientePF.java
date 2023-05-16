import java.util.Calendar;
import java.util.Date;

public class ClientePF extends Cliente{
  private final String cpf;
  private String genero;
  private Date dataLicenca;
	private String educacao;
  private Date dataNascimento;
  private String classeEconomica;


  public ClientePF (String nome, String endereco, Date dataLicenca, 
                    String educacao, String genero, String classeEconomica, 
                    String cpf, Date dataNascimento) {
    // chama o construtor da superclasse
    super(nome, endereco);
    if (Validacao.validarCPF(cpf)){ //verifica se o cpf esta certo, se nao, retorna como "invalido"
      this.cpf = cpf;
    } else {
      this.cpf = "invalido";
    }
    this.genero = genero;
    this.dataLicenca = dataLicenca;
    this.educacao = educacao;
    this.classeEconomica = classeEconomica; 
    this.dataNascimento = dataNascimento;  
  }


  //Atributo cpf
  public String getCpf() {
    return cpf;
  }

  //Atributo genero
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

  //Atributo DataLicenca
	public Date getDataLicenca() {
		return dataLicenca;
	}
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

  //Atributo Educacao
	public String getEducacao() {
		return educacao;
	}
	public void setDataNascimento(String educacao) {
		this.educacao = educacao;
	}

  //Atributo dataNascimento
  public Date getDataNascimento() {
    return dataNascimento;
  }
  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  //Atributo classeEconomica
	public String getClasseEconomica() {
		return classeEconomica;
	}
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

  @Override
  //calcula o valor do seguro
  public double calculaScore(){
    //Depende da idade do cliente e a quantidade de veiculos
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(getDataNascimento());
    int ano = 2023 - calendar.get(Calendar.YEAR);

    if (ano >=18 && ano < 30){
      return CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_18_30.valor * getListaVeiculos().size();
    }else if(ano >= 30 && ano < 60){
      return CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_30_60.valor * getListaVeiculos().size();
    }else if (ano >= 60 && ano < 90){
      return CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_60_90.valor * getListaVeiculos().size();
    }
    return 0;
  }

        
  @Override
  //Metodo toString
  public String toString () {
    String str = "\n---Classe Cliente---\nCPF: "+ getCpf() + "\nValor do Seguro: "+ getValorSeguro() +
                "\nData de Nascimento: " + getDataNascimento() + 
                "\nNome: " + getNome() + "\nEndereco: " + getEndereco() +
                "\nData Licença: " + getDataLicenca() +
                "\nEducação: " + getEducacao() + 
                "\nGenero: " + getGenero() + "\nClasse Econômica: " + getClasseEconomica() +
                "\nLista de Veiculos: " + getListaVeiculos() + "\n";
    return str;
  }
}