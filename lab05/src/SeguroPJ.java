import java.util.Calendar;
import java.util.Date;

public class SeguroPJ extends Seguro{
    //Argumentos Construtor
    private Frota frota;
    private ClientePJ cliente;

    //Construtor
    public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente){
        super(id, dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
        super.setValorMensal(calcularValor());
    }

    //Metodo toString
    @Override
    public String toString(){
        String str = "\n---Classe SeguroPJ---\nID: " + getId() +
                 "\nData de Inicio: " + getDataInicio() + "\nData de Fim: " + getDataFim() +
                 "\nFrota de Código: " + getFrota().getCode() +
                 "\nCNPJ do Cliente: " + getCliente().getCnpj() +
                 "\nSeguradora: " + getSeguradora().getNome() +
                 "\nValor Mensal: " + getValorMensal() + 
                 "\nLista de Sinistros: " + getListaSinistros() +
                 "\nLista de Condutores: " + getListaCondutores() + "\n";
        return str;
    }

    //Metodos
    @Override
    public boolean desautorizarCondutor(Condutor c){
        if (super.getListaCondutores().contains(c) == false){
            System.out.println("Esse condutor não está listado neste seguro\n");
            return false;
        }
        super.getListaCondutores().remove(c);
        System.out.println("Condutor foi removido do seguro com sucesso\n");
        return true;
    }

    @Override
    public boolean autorizarCondutor(Condutor c){
        if (super.getListaCondutores().contains(c) == true){
            System.out.println("Esse condutor já está listado neste seguro\n");
            return false;
        }
        super.getListaCondutores().add(c);
        System.out.println("Condutor foi adicionado ao seguro com sucesso\n");
        return true;
    }

    //Calcula valor do Seguro
    @Override
    public Double calcularValor(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cliente.getDataFundacao());
        int AnosPosFundacao = 2023 - calendar.get(Calendar.YEAR);
        

        //Depende da idade do cliente e a quantidade de veiculos
        //Eh considerado que o cliente sempre será maior de idade e com menos de 90 anos

        int qtdSinistroCliente = super.getListaSinistros().size();
        int qtdSinistroCondutorTotal = 0;
        int qtdVeiculoTotal = 0;

        //Soma de todos os Veiculos do cliente
        for (int i=0; i<cliente.getListaFrotas().size(); i++){
            qtdVeiculoTotal +=  cliente.getListaFrotas().get(i).getListaVeiculos().size();
        }

        //Soma de todos os sinistros dos condutores neste seguro
        for (int i=0; i<super.getListaCondutores().size(); i++){
            qtdSinistroCondutorTotal +=  super.getListaCondutores().get(i).getListaSinistros().size();
        }

        return (CalcSeguro.VALOR_BASE.valor * (10 + (super.getListaCondutores().size())/10) *
         (1+1/(qtdVeiculoTotal + 2)) *
         (1+1/(AnosPosFundacao + 2)) *
         (2+qtdSinistroCliente/10) *
         (5+qtdSinistroCondutorTotal/10)
         );
    }

    //Método gerar sinistro
    @Override
	public boolean gerarSinistro(String pessoa, int id, Date data, String endereco, Condutor condutor){
        //O condutor do sinistro pode ser o cliente ou uma outra pessoa(condutor) que esta no seguro.
        //Para identificar tal pessoa, a String pessoa será utilizado.
        
        //Cria o sinistro
        Sinistro s = new Sinistro(id, data, endereco, condutor, this);

        //Se for condutor, adiciona na lista de sinistros do condutor
        if (pessoa == "Condutor"){
            if 	(condutor.getListaSinistros().contains(s) == true){
                System.out.println("O sinistro de ID "+ s.getId() + " já existe.\n");
                return false;
            } else {
                System.out.println("O sinistro de ID "+ s.getId() + " foi adicionado com sucesso.\n");
                condutor.getListaSinistros().add(s);
                return true;
            }
        //Se for cliente, adiciona o sinistro na lista de sinistros do seguro
        } else if (pessoa == "Cliente"){
            if 	(super.getListaSinistros().contains(s) == true){
                System.out.println("O sinistro de ID "+ s.getId() + " já existe.\n");
                return false;
            } else {
                System.out.println("O sinistro de ID "+ s.getId() + " foi adicionado com sucesso.\n");
                super.getListaSinistros().add(s);
                return true;
            }
        } 
        return false;
	}



    //Getters e Setters
    public Frota getFrota(){
        return frota;
    }
    public void setFrota(Frota frota){
        this.frota = frota;
    }

    public ClientePJ getCliente(){
        return cliente;
    }
    public void setCliente(ClientePJ cliente){
        this.cliente = cliente;
    }
}
