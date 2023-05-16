public enum SubMenuOperacoes {
    
	CADASTRAR_CLIENTE("Cadastrar cliente PF/PJ"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	LISTAR_CLIENTES_SEG("Listar cliente PF/PJ por seguradora"),
	LISTAR_SINISTROS_SEG("Listar sinistros por seguradora"),
    LISTAR_SINISTROS_CLI("Listar sinistros por cliente"),
	LISTAR_VEICULOS_SEG("Listar veiculo por seguradora"),
    LISTAR_VEICULOS_CLI("Listar veiculo por cliente"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sininstro"),
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