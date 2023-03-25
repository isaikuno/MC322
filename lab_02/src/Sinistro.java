import java.lang.Math;   

public class Sinistro {
    //Argumentos do construtor
    private int id;
    private String data;
    private String endereco;

    //Construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
        this.generateId();
    }

    //Metodo toString
    public String toString(){
        String str = "---Classe Sinistro---\nID: " + this.id + "\nData: " + this.data + "\nEndereco: " + this.endereco + "\n";
        return str;
    }

    //Metodo que gera o ID
    private void generateId(){
        int min = 0;
        int max = 99999;
        this.id = (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    //Getters e setters
    //Atributo ID
    public int getId(){ 
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //Atributo Data
    public String getData(){
        return data;
    }
    public void setData(String data) {
		this.data = data;
	}

    //Atributo Endereco
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
