import java.util.ArrayList;
import java.util.Date;   

public class Sinistro {
    //Argumentos do construtor
    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    public static ArrayList<Sinistro> listaTotalSinistros = new ArrayList<>();


    //Construtor
    public Sinistro(int id, Date data, String endereco, Condutor condutor, Seguro seguro){
        this.id = id;
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
        listaTotalSinistros.add(this);
    }

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Sinistro---\nID: " + getId() +
                     "\nData: " + getData() + "\nEndereco: " + getEndereco() +
                     "\nNome do Condutor: " + getCondutor().getNome() + 
                     "\nID do Seguro: " + getSeguro().getId() +
                     "\n";
        return str;
    }


    //Getters e setters
    //Atributo ID
    public int getId(){ 
        return id;
    }

    //Atributo Data
    public Date getData(){
        return data;
    }
    public void setData(Date data) {
		this.data = data;
	}

    //Atributo Endereco
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

    //Atributo Condutor
    public Condutor getCondutor(){
        return condutor;
    }
    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }

    //Atributo Seguro
    public Seguro getSeguro(){
        return seguro;
    }
    public void setSeguro(Seguro seguro){
        this.seguro = seguro;
    }

}
