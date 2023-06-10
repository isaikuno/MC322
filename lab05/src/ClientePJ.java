import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;
    private ArrayList<Frota> listaFrotas;
    public static ArrayList<ClientePJ> listaTotalClientesPJ = new ArrayList<>();


    public ClientePJ (String nome, String telefone, String endereco, String email,
                      String cnpj, Date dataFundacao){

        // chama o construtor da superclasse
        super(nome, telefone, endereco, email);
        if (Validacao.validarCNPJ(cnpj)){ //verifica se o cnpj esta certo, se nao, retorna como "invalido"
             this.cnpj = cnpj;
             } else {
              this.cnpj = "invalido";
            }
        this.dataFundacao = dataFundacao;
        listaFrotas = new ArrayList<Frota>();
        listaTotalClientesPJ.add(this);

    }
    
    //GETTERS E SETTERS
    //Atributo cpnj
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //Atributo dataFundacao
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    //Atributo listaFrota
	public ArrayList<Frota> getListaFrotas() {
		return listaFrotas;
	}
	public void setListaFrotas(ArrayList<Frota> listaFrotas) {
		this.listaFrotas = listaFrotas;
	}

    public boolean cadastrarFrota(Frota frota){
        this.listaFrotas.add(frota);
        if (this.listaFrotas.contains(frota)){
            return true;
          } 
          return false;
    }

    //metodo que adiciona ou remove um veiculo de uma frota
    public boolean atualizarFrota(String comando, Frota frota, Veiculo veiculo){
        if (listaFrotas.contains(frota) == false){
            System.out.println("A frota não existe");
            return false;
        }
        if (comando == "adicionar"){
            System.out.println("Foi adicionado o veiculo na frota");
            frota.addVeiculo(veiculo);
            return true;
        } if (comando == "remover") {
            System.out.println("Foi removido o veiculo da frota");
            frota.removerVeiculo(veiculo);
            return true;
        }
        return false;
    }

    //metodo que remove a frota
    public boolean atualizarFrota(Frota frota){
        if (listaFrotas.contains(frota) == false){
            return false;
        }
        listaFrotas.remove(frota);
        return true;
    }

    //lista(printa) os veiculos pela frota dada
    public boolean getVeiculosPorFrota(Frota frota){
        if (listaFrotas.contains(frota) == false){
            return false;
        }
        System.out.println(frota.getListaVeiculos());
        return true;
    }


    @Override
         //Metodo toString
         public String toString () {
            String str = "\n---Classe Cliente PJ---\nNome: " + getNome() + 
            "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco() +
            "\nEmail: " + getEmail() + "\nCNPJ: "+ getCnpj() + 
            "\nData de Fundação: " + getDataFundacao() +
            "\nLista de Frotas: " + getListaFrotas() + "\n";
           return str;
    }

}
