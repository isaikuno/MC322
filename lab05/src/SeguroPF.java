import java.util.Calendar;
import java.util.Date;

public class SeguroPF extends Seguro{
    //Argumentos Construtor
    private Veiculo veiculo;
    private ClientePF cliente;

    //Construtor
    public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente){
        super(id, dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente  = cliente;
        super.setValorMensal(calcularValor());
    }

   //Metodo toString
   public String toString(){
    String str = "\n---Classe SeguroPF---\nID: " + getId() +
                 "\nData de Inicio: " + getDataInicio() + "\nData de Fim: " + getDataFim() +
                 "\nVeiculo: " + getVeiculo() +
                 "\nCPF do Cliente: " + getCliente().getCpf() +
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

    @Override
    public Double calcularValor(){
        //Depende da idade do cliente e a quantidade de veiculos
        //Eh considerado que o cliente sempre será maior de idade e com menos de 90 anos
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cliente.getDataNascimento());
        int ano = 2023 - calendar.get(Calendar.YEAR);

        int qtdVeiculoCliente = cliente.getListaVeiculos().size();
        int qtdSinistroCliente = super.getListaSinistros().size();
        int qtdSinistroCondutorTotal = 0;

        //Soma de todos os sinistros dos condutores neste seguro
        for (int i=0; i<super.getListaCondutores().size(); i++){
            qtdSinistroCondutorTotal +=  super.getListaCondutores().get(i).getListaSinistros().size();
        }

        //cte de auxiliação para o calculo do seguro
        int constante = (1+1/(qtdVeiculoCliente+2))*(2+qtdSinistroCliente/10)*(5+qtdSinistroCondutorTotal/10);

        if (ano < 30){
         return (CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_18_30.valor * constante);
        }else if(ano >= 30 && ano < 60){
            return (CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_30_60.valor * constante);
        }else{ //(ano >= 60 && ano < 90)
            return (CalcSeguro.VALOR_BASE.valor * CalcSeguro.FATOR_60_90.valor * constante);
        }
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

    //Getters e setters
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public ClientePF getCliente(){
        return cliente;
    }
    public void setCliente(ClientePF cliente){
        this.cliente = cliente;
    }

    
}
