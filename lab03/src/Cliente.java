
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    //Atributos do construtor
    private String nome;
    private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;


    //Construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        listaVeiculos = new ArrayList<Veiculo>();
	}

    

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Cliente---\nNome: " + getNome() + "\nEndereco: " + getEndereco() +
         "\nData Licença: " + getDataLicenca() +
         "\nEducação: " + getEducacao() + 
         "\nGenero: " + getGenero() + "\nClasse Econômica: " + getClasseEconomica() +
         "\nLista de Veiculos: " + getListaVeiculos() + "\n";
        return str;
    }

    //Getters e Setters
    //Atributo nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    //Atributo endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
    //Atributo genero
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

    //Atributo classeEconomica
	public String getClasseEconomica() {
		return classeEconomica;
	}
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

    //Atributo listaVeiculos
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
    public void addListaVeiculos(Veiculo v){
        this.listaVeiculos.add(v);
    }
    
}

