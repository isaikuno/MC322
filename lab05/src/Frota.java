import java.util.ArrayList;

public class Frota {
    
    //Argumentos do construtor:
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    public static ArrayList<Frota> listaTotalfFrotas = new ArrayList<>();


    public Frota(String code, Veiculo veiculo){
        this.code = code;
        listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(veiculo);
        listaTotalfFrotas.add(this);
    }

    //Atributo dataNascimento
    public String getCode() {
        return code;
     }
    public void setDataNascimento(String code) {
        this.code = code;
    }

    //Atributo listaVeiculos
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

  public boolean addVeiculo(Veiculo v){
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

  public String toString () {
    String str = "\n---Classe Frota---\nCode: " + getCode() + 
                "\nLista de Veiculos: " + getListaVeiculos() + "\n";
    return str;
  }

}
