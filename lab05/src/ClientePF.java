import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente{
  private final String cpf;
  private String genero;
	private String educacao;
  private Date dataNascimento;
  private ArrayList<Veiculo> listaVeiculos;
  public static ArrayList<ClientePF> listaTotalClientesPF = new ArrayList<>();


  public ClientePF (String nome, String telefone, String endereco, String email, String cpf,
                    String genero, String educacao, Date dataNascimento) {
    // chama o construtor da superclasse
    super(nome, telefone, endereco, email);
    if (Validacao.validarCPF(cpf)){ //verifica se o cpf esta certo, se nao, retorna como "invalido"
      this.cpf = cpf;
    } else {
      this.cpf = "invalido";
    }
    this.genero = genero;
    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    listaVeiculos = new ArrayList<Veiculo>();
    listaTotalClientesPF.add(this);
  
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

  //Atributo listaVeiculos
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
  public boolean cadastrarVeiculo(Veiculo v){
    this.listaVeiculos.add(v);
    if (this.listaVeiculos.contains(v)){
      return true;
    } 
    return false;
  }

  public boolean removerVeiculo(Veiculo v){
    this.listaVeiculos.remove(v);
    if (this.listaVeiculos.contains(v)){
      return false;
    } 
    return true;
  }

        
  @Override
  //Metodo toString
  public String toString () {
    String str = "\n---Classe Cliente PF---\nNome: " + getNome() + 
                "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco() +
                "\nEmail: " + getEmail() + "\nCPF: " + getCpf() + "\nGenero: " + getGenero() +
                "\nEducação: " + getEducacao() + "\nData de Nascimento: " + getDataNascimento() +
                "\nLista de Veiculos: " + getListaVeiculos() + "\n";
    return str;
  }
}