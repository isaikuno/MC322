import java.util.ArrayList;

public abstract class Cliente {
    //Atributos do construtor
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
	public static ArrayList<Cliente> listaTotalClientes = new ArrayList<>();

    
    //Construtor
	public Cliente(String nome, String telefone, String endereco, String email ) {
		if (Validacao.validarNome(nome)){ //verifica se o nome esta certo, se nao, retorna como "invalido"
               this.nome = nome;
             } else {
              this.nome = "invalido";
            }

		if (Validacao.validarTelefone(telefone)){ //verifica se o telefone esta certo, se nao, retorna como "invalido"
			this.telefone = telefone;
		  } else {
		   this.telefone = "invalido";
		 }
		this.endereco = endereco;
		this.email = email;
		listaTotalClientes.add(this);
	}

    

    //Metodo toString
    public String toString(){
        String str = "\n---Classe Cliente---\nNome: " + getNome() +
		 "\nTelefone: " + getTelefone() + "\nEndereco: " + getEndereco() + 
		 "\nEmail: " + getEmail();
        return str;
    }

    //Getters e Setters
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
	
    //Atributo endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	//Atributo email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

