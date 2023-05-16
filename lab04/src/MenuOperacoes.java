public enum MenuOperacoes {
    CADASTROS ("Cadastros", new SubMenuOperacoes[]{
	SubMenuOperacoes.CADASTRAR_CLIENTE,
    SubMenuOperacoes.CADASTRAR_VEICULO,
    SubMenuOperacoes.CADASTRAR_SEGURADORA,
    SubMenuOperacoes.VOLTAR
    }),
    LISTAR ("Listar", new SubMenuOperacoes[]{
        SubMenuOperacoes.LISTAR_CLIENTES_SEG,
        SubMenuOperacoes.LISTAR_SINISTROS_SEG,
        SubMenuOperacoes.LISTAR_SINISTROS_CLI,
        SubMenuOperacoes.LISTAR_VEICULOS_CLI,
        SubMenuOperacoes.LISTAR_VEICULOS_SEG,
        SubMenuOperacoes.VOLTAR
    }),
    EXCLUIR ("Excluir", new SubMenuOperacoes[]{
        SubMenuOperacoes.EXCLUIR_CLIENTE,
        SubMenuOperacoes.EXCLUIR_VEICULO,
        SubMenuOperacoes.EXCLUIR_SINISTRO,
        SubMenuOperacoes.VOLTAR
    }),
    GERAR_SINISTRO ("Gerar Sinistro", new SubMenuOperacoes[]{
        SubMenuOperacoes.VOLTAR
    }),
    TRANSFERIR_SEGURO ("Transferir Seguro", new SubMenuOperacoes[]{
        SubMenuOperacoes.VOLTAR
    }),
    CALCULAR_RECEITA_SEGURADORA ("Calcular receita seguradora",new SubMenuOperacoes[]{
        SubMenuOperacoes.VOLTAR
    }),
    SAIR ("Sair", new SubMenuOperacoes[]{});
    
    private final String descricao;
    private final SubMenuOperacoes[] subMenu;

    
    MenuOperacoes(String descricao, SubMenuOperacoes[] subMenu) {
        this.descricao = descricao;
        this.subMenu = subMenu;
    }

    
    public String getDescricao() {
        return this.descricao ;
    }

    public SubMenuOperacoes[] getSubMenu() {
        return this.subMenu ;
    }
}