
import java.util.ArrayList;

public class Cliente {
    //Atributos do construtor
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;


    //Construtor
	public Cliente(String nome, String endereco) {
		if (Validacao.validarNome(nome)){ //verifica se o nome esta certo, se nao, retorna como "invalido"
               this.nome = nome;
             } else {
              this.nome = "invalido";
            }
		this.endereco = endereco;
        listaVeiculos = new ArrayList<Veiculo>();

	}

    

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Cliente---\nNome: " + getNome() + "\nEndereco: " + getEndereco() +
         "\nValor do Seguro: " + getValorSeguro() +
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

    //Atributo Valor seguro
	public double getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
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

	public double calculaScore(){
		return 0;
	}
    
}

