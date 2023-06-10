import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");

        //INICIALIZAR OBJETOS PARA AS CLASSES
        Veiculo veiculo1 = new Veiculo("AAA1111", "Ford", "C21", 2005);
        Veiculo veiculo2 = new Veiculo("BBB2222", "Ford", "C22", 2006);
        Veiculo veiculo3 = new Veiculo("CCC2222", "Ford", "C23", 2007);
        System.out.println(veiculo1.toString());
        System.out.println(veiculo2.toString());
        System.out.println(veiculo3.toString());

        Frota frota1 = new Frota("A0001", veiculo2);
        System.out.println(frota1.toString());

        ClientePJ clientePJ1 = new ClientePJ("Jozerbaldo", "13 98768-9877","Rua Cassio", "meuemail@gmail","37.514.580.0001-45", formatadata.parse("15/01/2012"));
        ClientePF clientePF1 = new ClientePF("Claudete", "6543-1234","Rua Moraes", "C@gmail", "280.012.38938", "Pos", "fem", formatadata.parse("11/01/1990"));
        clientePJ1.cadastrarFrota(frota1);
        clientePJ1.atualizarFrota("adicionar",frota1, veiculo3);
        clientePF1.cadastrarVeiculo(veiculo1);
        System.out.println(clientePJ1.toString());
        System.out.println(clientePF1);

        Condutor condutor1 = new Condutor("20", "Henrique", "83172", "Rua Professor", "Henrique@gmail", formatadata.parse("15/01/2000"));
        Condutor condutor2 = new Condutor("280.012.38938", "Claudete", "6543-1234", "Rua Moraes", "C@gmail", formatadata.parse("11/01/1990"));
        System.out.println(condutor1.toString());
        System.out.println(condutor2.toString());

        Seguradora seguradora1 = new Seguradora("37.514.580.0001-45","MaisSeguro", "(44)91838-3421", "Mais@gmail.com", "Rua Comendador");

        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePF1);

        seguradora1.gerarSeguro(0003, formatadata.parse("25/07/2014"), formatadata.parse("27/07/2014"), seguradora1, frota1, clientePJ1);
        seguradora1.gerarSeguro(0004, formatadata.parse("15/07/2014"), formatadata.parse("25/07/2014"), seguradora1, veiculo1, clientePF1);
        seguradora1.gerarSeguro(0005, formatadata.parse("30/07/2015"), formatadata.parse("30/10/2015"), seguradora1, veiculo1, clientePF1);

        seguradora1.getlistaSeguros().get(0).autorizarCondutor(condutor1);
        seguradora1.getlistaSeguros().get(1).autorizarCondutor(condutor2);

        seguradora1.getlistaSeguros().get(0).gerarSinistro("Condutor", 0012, formatadata.parse("22/07/2014"), "Rua abc", condutor1);
        seguradora1.getlistaSeguros().get(1).gerarSinistro("Cliente", 0022, formatadata.parse("22/07/2015"), "Rua def", condutor2);

        System.out.println(seguradora1.toString());
        System.out.println("\n");
        System.out.println(seguradora1.getlistaSeguros().get(0));

        //listando clientes do tipo juridico e fisico na seguradora1
        System.out.println( seguradora1.listarClientes("juridica"));
        System.out.println(seguradora1.listarClientes("fisica"));

        //Cancelando Seguro
        seguradora1.cancelarSeguro(seguradora1.getlistaSeguros().get(2));

        //lista os sinistros do clientePF1
        System.out.println("\n Os sinistros da Claudete são \n" + seguradora1.getSinistrosPorCliente(clientePF1) + "\n");

        //calcula a receita da seguradora
        System.out.println("A receita da seguradora é R$"+ seguradora1.calcularReceita()  + "\n");

        //Atualizar valor do Seguro no cliente
        System.out.println("O valor mensal da Claudete é R$" + seguradora1.getlistaSeguros().get(1).getValorMensal() + "\n");

//-------------Inicio menu interativo--------------------
        MenuOperacoes operacao;
		do {
			exibirMenuOp();
			operacao = inputMenuOp();
			executarMenuOp(operacao);
		}while(operacao != MenuOperacoes.SAIR);
		System.out.println("Menu Finalizado");
    }

    
// --------------Metodos do Menu Interativo-------------------

//exibir menu de Operacoes
private static void exibirMenuOp() {
    MenuOperacoes menuOp[] = MenuOperacoes.values();
    System.out.println("Menu principal");
    for(MenuOperacoes operacao: menuOp) {
        System.out.println(operacao.ordinal() + "- " + operacao.getDescricao());
    }
}

//Usuario escolhe que operacao fazer do menu principal
private static MenuOperacoes inputMenuOp() {
    Scanner scan = new Scanner(System.in);
    MenuOperacoes opercaoSelecionada;
    int input = -1;
    while(input < 0 || input > (MenuOperacoes.values().length-1)){
        System.out.println("Digite uma operacao: ");
        input = scan.nextInt();
    }
    opercaoSelecionada = MenuOperacoes.values()[input];
    return opercaoSelecionada;
}

//executar opções do menu externo
private static void executarMenuOp(MenuOperacoes operacao) throws Exception {
    switch(operacao) {
        case CADASTROS:
            SubMenu(operacao);
            break;
        case LISTAR:
            SubMenu(operacao);
            break;
        case EXCLUIR:
            SubMenu(operacao);
            break;
        case CALCULAR_RECEITA_SEGURADORA:
            FuncionalidadesMenu.calcularReceitaSeguradora();
            break;
        case SAIR:
            break;
    }
}

//-------------- SUB MENU ---------------
private static void SubMenu(MenuOperacoes operacao) throws Exception {
    SubMenuOperacoes opSubMenu;
    do {
        exibirSubMenu(operacao);
        opSubMenu = inputSubMenu(operacao);
        executarSubMenu(opSubMenu);
    }while(opSubMenu != SubMenuOperacoes.VOLTAR);
}

private static void exibirSubMenu(MenuOperacoes operacao) {
    SubMenuOperacoes[] subMenu = operacao.getSubMenu();
    System.out.println(operacao.getDescricao());
    for(int i=0; i<subMenu.length; i++) {
        System.out.println(i +"- " + subMenu[i].getDescricao());
    }
}

//Usuario escolhe a operacao do submenu
private static SubMenuOperacoes inputSubMenu(MenuOperacoes operacao) {
    Scanner scan = new Scanner(System.in);
    int input = -1;
    SubMenuOperacoes opercaoSelecionada;
    while(input < 0 || input > operacao.getSubMenu().length - 1){
        System.out.println("Digite uma opcao: ");
        input = scan.nextInt();
    }
    opercaoSelecionada = operacao.getSubMenu()[input];
    return opercaoSelecionada;
}

public static void executarSubMenu(SubMenuOperacoes opSubMenu) throws Exception {
    switch(opSubMenu) {
    case CADASTRAR_CLIENTE:
        FuncionalidadesMenu.cadastrarCliente();
        break;
    case CADASTRAR_VEICULO:
        FuncionalidadesMenu.cadastrarVeiculo();
        break;
    case CADASTRAR_SEGURADORA:
        FuncionalidadesMenu.cadastrarSeguradora();
        break;
    case CADASTRAR_CONDUTOR:
        FuncionalidadesMenu.cadastrarCondutor();
        break;
    case LISTAR_CLIENTES_SEG:
        FuncionalidadesMenu.listarClientesSeg();
        break;
    case LISTAR_SINISTROS_CLI:
        FuncionalidadesMenu.listarSinistrosCli();
        break;
    case LISTAR_VEICULOS_CLI:
        FuncionalidadesMenu.listarVeiculosCli();
        break;
    case LISTAR_SEGUROS_SEG:
        FuncionalidadesMenu.listarSegurosSeg();
        break;
    case EXCLUIR_CLIENTE:
        FuncionalidadesMenu.excluirCliente();
        break;
    case EXCLUIR_VEICULO:
        FuncionalidadesMenu.excluirVeiculo();
        break;

    case VOLTAR:
        break;
    }
}

}
