import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros; //Sinistros apenas do cliente
    private ArrayList<Condutor> listaCondutores;
    private Double valorMensal;
    public static ArrayList<Seguro> listaTotalSeguros = new ArrayList<>();


    public Seguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora){
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = 0.0;
        listaTotalSeguros.add(this);
    }

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Seguro---\nID: " + getId() +
                     "\nData de Inicio: " + getDataInicio() + "\nData de Fim: " + getDataFim() +
                     "\nSeguradora: " + getSeguradora() +
                     "\nValor Mensal: " + getValorMensal() + 
                     "\nLista de Sinistros: " + getListaSinistros() +
                     "\nLista de Condutores: " + getListaSinistros();
        return str;
    }

    public boolean desautorizarCondutor(Condutor c){
        return false;
    }
    
    public boolean autorizarCondutor(Condutor c){
        return false;
    }

    public Double calcularValor(){
        return 0.0;
    }

    //Método gerar sinistro
	public boolean gerarSinistro(String pessoa, int id, Date data, String endereco, Condutor condutor){
        return false;
	}

    //Getters e setters
    //Atributo ID
    public int getId(){ 
        return id;
    }

    //Atributo DataInicio
    public Date getDataInicio(){
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

    //Atributo DataFim
    public Date getDataFim(){
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

    //Atributo seguradora
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

    //Atributo listaSinistros
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

    //Atributo listaCondutores
	public ArrayList<Condutor> getListaCondutores() {
		return listaCondutores;
	}
	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}

    //Atributo valorMensal
    public Double getValorMensal(){ 
        return valorMensal;
    }
    public void setValorMensal(Double valorMensal){
        this.valorMensal = valorMensal;
    }



}
