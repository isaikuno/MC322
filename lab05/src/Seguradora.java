import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
	//Argumentos do Construtor
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	public static ArrayList<Seguradora> listaTotalSeguradoras = new ArrayList<>();
	
	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		if (Validacao.validarCNPJ(cnpj)){ //verifica se o telefone esta certo, se nao, retorna como "invalido"
			this.cnpj = cnpj;
		  } else {
		   this.cnpj = "invalido";
		  }
		this.nome = nome;
		if (Validacao.validarTelefone(telefone)){ //verifica se o telefone esta certo, se nao, retorna como "invalido"
			this.telefone = telefone;
		  } else {
		   this.telefone = "invalido";
		  }
		this.email = email;
		this.endereco = endereco;
		listaSeguros = new ArrayList<Seguro>();
		listaClientes = new ArrayList<Cliente>();
		listaTotalSeguradoras.add(this);
	}

	//Metodo toString
    public String toString(){
        String str = "\n---Classe Seguradora---\nCNPJ: " + getCnpj()+
					 "\nNome: " + getNome() + 
					 "\nTelefone: " + getTelefone() +"\nEmail: " + getEmail() + 
					 "\nEndereco: " + getEndereco() + 
					 "\nLista de Seguros: "+ getlistaSeguros() +
					 "\nLista de Clientes: "+ getlistaClientes() + "\n";
        return str;
    }
	
	//Metodo cadastrar Cliente
	public boolean cadastrarCliente(Cliente c){
		if 	(listaClientes.contains(c) == true){
			System.out.println("O cliente "+ c.getNome() + " já está cadastrado.\n");
			return false;
		} else {
			System.out.println("O cliente "+ c.getNome() + " foi cadastrado com sucesso.\n");
       		this.listaClientes.add(c);
			return true;
		}
    }

	//Metodo remover Cliente
	public boolean removerCliente(Cliente cliente){

		for (int i=0; i<listaClientes.size(); i++){
			if(listaClientes.get(i) == cliente){
				System.out.println("O cliente "+ cliente.getNome() + " foi removido com sucesso.\n");
       			this.listaClientes.remove(i);
				return true;
			}
		}
		System.out.println("Não é possível remover o clinete "+ cliente.getNome() + " pois ele não está cadastrado.\n");
		return false;
    }

	//Método listarClientes
	public ArrayList<Cliente> listarClientes(String tipoCliente){
		ArrayList<Cliente> clientePj = new ArrayList<Cliente>();
		ArrayList<Cliente> clientePf = new ArrayList<Cliente>();
		tipoCliente = tipoCliente.toLowerCase();

		//Verifica se a lista eh vazia
		if (listaClientes.isEmpty()){
			System.out.println("Não há clientes na seguradora " + getNome() + ".\n");
			return null;
		}
		//Separa a lista de cliente em uma de PJ e outra de PF
		for (int i=0; i<listaClientes.size(); i++){
			if ((listaClientes.get(i) instanceof ClientePJ) && (tipoCliente == "juridica")){
				clientePj.add(listaClientes.get(i));
			}else if ((listaClientes.get(i) instanceof ClientePF) && (tipoCliente == "fisica")){
				clientePf.add(listaClientes.get(i));
			}
		}
		//Retorna a lista de cliente a depender do input
		if (tipoCliente == "juridica"){
			System.out.println("Os cliente PJ na seguradora " + getNome() +" são:\n");
			return clientePj;
		}else{
			System.out.println("Os cliente PF na seguradora " + getNome() +" são:\n");
			return clientePf;
		}
	}

	//gerarSeguro para PF
	public boolean gerarSeguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora, 
								Veiculo veiculo, ClientePF cliente){
		SeguroPF s = new SeguroPF(id, dataInicio, dataFim, seguradora, veiculo, cliente);
		if (this.listaSeguros.contains(s)){
			System.out.println("Já existe esse seguro\n");
			return false;
		  } 
		listaSeguros.add(s);  
		return true;
	}
	
	//gerarSeguro para PJ
	public boolean gerarSeguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora,
								 Frota frota, ClientePJ cliente){
		SeguroPJ s = new SeguroPJ(id, dataInicio, dataFim, seguradora, frota, cliente);
		if (this.listaSeguros.contains(s)){
			System.out.println("Já existe esse seguro\n");
			return false;
		  } 
		  listaSeguros.add(s);
		  return true;
	}
	
	//Cancela Seguro
	public boolean cancelarSeguro(Seguro seguro){
		if (this.listaSeguros.contains(seguro)){
		this.listaSeguros.remove(seguro);
		return true;
		}
		return false;
	}
	
	//metodo seguros por cliente
	public ArrayList<Seguro> getSegurosPorCliente(Cliente c){
		ArrayList <Seguro> segurosCliente = new ArrayList <>();

		for (int i = 0; i< listaSeguros.size(); i++) {
			for (int j=0; j<listaSeguros.get(i).getListaCondutores().size(); j++){
				if (listaSeguros.get(i).getListaCondutores().get(j).getNome() == c.getNome()){
					segurosCliente.add(listaSeguros.get(i));
				}
			}
		}
		return segurosCliente;
	}
	
	//metodo sinistros por cliente
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente c){
		ArrayList<Sinistro> sinistrosCliente = new ArrayList<>();
		ArrayList <Seguro> segurosCliente = getSegurosPorCliente(c);

		for (int i = 0; i< segurosCliente.size(); i++) {
			for (int j=0; j<segurosCliente.get(i).getListaSinistros().size(); j++){
				sinistrosCliente.add(segurosCliente.get(i).getListaSinistros().get(j));
			}
		}
		return sinistrosCliente;
	}

	//metodo calcula receita
	public Double calcularReceita(){
		Double receita = 0.0;
		for (int i=0; i<listaSeguros.size(); i++){
			receita += listaSeguros.get(i).getValorMensal();
		}
		return receita;
	}

	//Getters e setters 
	//Atributo cnpj
	public String getCnpj() {
		return cnpj;
	}
	
	//Atributo nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Atributo telefone
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Atributo email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Atributo endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	//Atributo listaSeguros
	public ArrayList<Seguro> getlistaSeguros() {
		return listaSeguros;
	}
	public void setlistaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

	//Atributo listaClientes
	public ArrayList<Cliente> getlistaClientes() {
		return listaClientes;
	}
	public void setlistaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}