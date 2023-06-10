import java.util.ArrayList;

public class Veiculo {
    //Argumentos do Construtor
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	public static ArrayList<Veiculo> listaTotalVeiculos = new ArrayList<Veiculo>();
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		listaTotalVeiculos.add(this);
	}

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Veiculo---\nPlaca: " + getPlaca() + 
					 "\nMarca: " + getMarca() + "\nModelo: " + getModelo() + 
					 "\nAno de Fabricação: " + getAnoFabricacao() + "\n";
        return str;
    }

	//Getters e Setters
    //Atributo placa
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
    //Atributo marca
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
    //Atributo modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	//Atributo anoFabricacao
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
}
