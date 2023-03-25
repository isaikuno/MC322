public class Seguradora {
	//Argumentos do Construtor
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	//Metodo toString
    public String toString(){
        String str = "---Classe Seguradora---\nNome: " + this.nome + "\nTelefone: " + this.telefone +"\nEmail: " + this.email + "\nendereco: " + this.endereco + "\n";
        return str;
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
}