public enum SubMenuOperacoes {
    
	CADASTRAR_CLIENTE("Cadastrar cliente PF/PJ"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_CONDUTOR("Cadastrar condutor"),

	LISTAR_CLIENTES_SEG("Listar cliente PF/PJ por seguradora"),
    LISTAR_SINISTROS_CLI("Listar sinistros por cliente"),
    LISTAR_VEICULOS_CLI("Listar veiculo por cliente"),
	LISTAR_SEGUROS_SEG("Listar seguros por seguradora"),

	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubMenuOperacoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}