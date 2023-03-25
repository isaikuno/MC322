public class Veiculo {
    //Argumentos do Construtor
	private String placa;
	private String marca;
	private String modelo;
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}

    //Metodo toString
    public String toString(){
        String str = "---Classe Veiculo---\nPlaca: " + this.placa + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\n";
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
}
