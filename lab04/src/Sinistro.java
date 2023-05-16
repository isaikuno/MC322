import java.lang.Math;
import java.util.Date;   

public class Sinistro {
    //Argumentos do construtor
    private int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Construtor
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.generateId();
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Sinistro---\nID: " + getId() +
                     "\nData: " + getData() + "\nEndereco: " + getEndereco() +
                     "\nNome da seguradora: " + getSeguradora().getNome() + "\nPlaca do veiculo: " + getVeiculo().getPlaca() + 
                     "\nNome do cliente: " + getCliente().getNome() + "\n";
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

    //Atributo Seguradora
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    //Atributo Veiculo
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    //Atributo Cliente
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }


}
