import java.util.ArrayList;

public class Seguradora {
	//Argumentos do Construtor
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSinistros = new ArrayList<Sinistro>();
		listaClientes = new ArrayList<Cliente>();
	}

	//Metodo toString
    public String toString(){
        String str = "\n---Classe Seguradora---\nNome: " + getNome() + 
					 "\nTelefone: " + getTelefone() +"\nEmail: " + getEmail() + 
					 "\nEndereco: " + getEndereco() + 
					 "\nLista de Sinistros: "+ getlistaSinistros() +
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
	public boolean removerCliente(String cliente){

		for (int i=0; i<listaClientes.size(); i++){
			if(listaClientes.get(i).getNome() == cliente){
				System.out.println("O cliente "+ cliente + " foi removido com sucesso.\n");
       			this.listaClientes.remove(i);
				return true;
			}
		}
		System.out.println("Não é possível remover o clinete "+ cliente + " pois ele não está cadastrado.\n");
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

	//Método gerar sinistro
	public boolean gerarSinistro(Sinistro s){
		if 	(listaSinistros.contains(s) == true){
			System.out.println("O sinistro de ID "+ s.getId() + " já existe.\n");
			return false;
		} else {
			System.out.println("O sinistro de ID "+ s.getId() + " foi adicionado com sucesso.\n");
       		this.listaSinistros.add(s);
			return true;
		}
	}

	//Método visualizarSinistro
	public boolean visualizarSinistro(String cliente){
		ArrayList<Integer> posicao = new ArrayList<Integer>();
		for (int i=0; i<listaSinistros.size(); i++){
			if (listaSinistros.get(i).getCliente().getNome() == cliente){
				posicao.add(i); //adiciona as posicoes dos sinistros do cliente c na array posicoes
			}
		}
		if (posicao.isEmpty() == true){
			System.out.println("Não há sinistros com o nome do cliente " + cliente + ".\n");
			return false;
		}else{
			System.out.println("O(s) sinistro(s) do cliente " + cliente + " é/são:\n");
			for (int i=0; i<posicao.size(); i++){
				System.out.println(listaSinistros.get(posicao.get(i)));
			}
			return true;
		}
	}

	//Metodo listarSinistros
	public ArrayList<Sinistro> listarSinistros (){
		if (listaSinistros.isEmpty()){
			System.out.println("Não há sinistros.\n");
			return null;
		} else {
			System.out.println("Os sinistros são:\n");
			return listaSinistros;
		}
	} 



	//Getters e setters 
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

	//Atributo listaSinistros
	public ArrayList<Sinistro> getlistaSinistros() {
		return listaSinistros;
	}
	public void setlistaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	//Atributo listaClientes
	public ArrayList<Cliente> getlistaClientes() {
		return listaClientes;
	}
	public void setlistaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}