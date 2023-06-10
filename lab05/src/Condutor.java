import java.util.ArrayList;
import java.util.Date;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;


    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNascimento){
        if (Validacao.validarCPF(cpf)){ //verifica se o cpf esta certo, se nao, retorna como "invalido"
         this.cpf = cpf;
        } else {
         this.cpf = "invalido";
        }

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
        this.dataNascimento = dataNascimento;
        listaSinistros = new ArrayList<Sinistro>();
    }

	public String toString () {
		String str = "\n---Classe Condutor---\nCPF: " + getCpf() + 
					"\nNome: " + getNome() +
					"\nTelefone: " + getTelefone() +
					"\nEndereço: " + getEndereco() +
					"\nEmail: " + getEmail() +
					"\nData de Nascimento: " + getDataNascimento() + "\n";
		return str;
	  }

    //Getters e Setters
    //Atributo cpf
    public String getCpf() {
        return cpf;
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

    //Atributo dataNascimento
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

    //Atributo listaSinistros
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

    public boolean adicionarSinistro(Sinistro s){
        this.listaSinistros.add(s);
        if (this.listaSinistros.contains(s)){
            return true;
        } 
        return false;
  }
    


}
