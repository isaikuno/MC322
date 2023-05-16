import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    //Lista das instancias de cada classe
    private static ArrayList<Seguradora> listaTotalSeguradoras = new ArrayList<Seguradora>();
    private static ArrayList<Cliente> listaTotalClientes = new ArrayList<Cliente>();
    private static ArrayList<Veiculo> listaTotalVeiculos = new ArrayList<Veiculo>();
    private static ArrayList<Sinistro> listaTotalSinistros = new ArrayList<Sinistro>();


    public static void main(String[] args) throws Exception {
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");

        //INICIALIZAR OBJETOS PARA AS CLASSES
        Veiculo veiculo1 = new Veiculo("AAA1111", "Ford", "C21", 2005);
        Veiculo veiculo2 = new Veiculo("BBB2222", "Ford", "C22", 2006);
        listaTotalVeiculos.add(veiculo1);
        listaTotalVeiculos.add(veiculo2);

        ClientePJ clientePJ1 = new ClientePJ("Jozerbaldo", "Rua Cassio", "37.514.580.0001-45", formatadata.parse("15/01/2012"), 100);
        ClientePF clientePF1 = new ClientePF("Claudete", "Rua Moraes", formatadata.parse("11/01/2013"), "Pos", "fem", "A", "280.012.38938", formatadata.parse("15/06/2000"));
        listaTotalClientes.add(clientePJ1);
        listaTotalClientes.add(clientePF1);

        Seguradora seguradora1 = new Seguradora("MaisSeguro", "(44)91838-3421", "Mais@gmail.com", "Rua Comendador");
        listaTotalSeguradoras.add(seguradora1);
        
        clientePJ1.addListaVeiculos(veiculo1);
        clientePF1.addListaVeiculos(veiculo2);

        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePF1);

        Sinistro sinistro1 = new Sinistro(formatadata.parse("25/07/2014"), "Rua Benjamin", seguradora1, veiculo1, clientePF1);
        Sinistro sinistro2 = new Sinistro(formatadata.parse("29/07/2014"), "Rua Jacaranda", seguradora1, veiculo1, clientePJ1);
        listaTotalSinistros.add(sinistro1);
        listaTotalSinistros.add(sinistro2);

        seguradora1.gerarSinistro(sinistro1);
        seguradora1.gerarSinistro(sinistro2);
        System.out.println(seguradora1.toString());

        //listando clientes do tipo juridico e fisico na seguradora1
        System.out.println( seguradora1.listarClientes("juridica"));
        System.out.println(seguradora1.listarClientes("fisica"));
        //lista os sinistros de cada cliente
        seguradora1.visualizarSinistro(clientePF1.getNome());
        seguradora1.visualizarSinistro(clientePJ1.getNome());
        //lista os sinistros da seguradora1
        System.out.println(seguradora1.listarSinistros());
        //calcula a receita da seguradora
        System.out.println("A receita da seguradora é "+ seguradora1.calcularReceita());

        //Atualizar valor do Seguro no cliente
        clientePF1.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePF1));
        System.out.println("O seguro do cliente " + clientePF1.getNome() + " é " + clientePF1.getValorSeguro());

        clientePJ1.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePJ1));
        System.out.println("O seguro do cliente " + clientePJ1.getNome() + " é " + clientePJ1.getValorSeguro());


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
        case GERAR_SINISTRO:
            Sinistro s = FuncionalidadesMenu.gerarSinistro(listaTotalSeguradoras, listaTotalVeiculos, listaTotalClientes);
            listaTotalSinistros.add(s);
            break;
        case TRANSFERIR_SEGURO:
            FuncionalidadesMenu.tranferirSeguro(listaTotalSeguradoras);
            break;
        case CALCULAR_RECEITA_SEGURADORA:
            FuncionalidadesMenu.calcularReceitaSeguradora(listaTotalSeguradoras);
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
        Cliente c = FuncionalidadesMenu.cadastrarCliente();
        listaTotalClientes.add(c);
        break;
    case CADASTRAR_VEICULO:
        Veiculo v = FuncionalidadesMenu.cadastrarVeiculo();
        listaTotalVeiculos.add(v);
        break;
    case CADASTRAR_SEGURADORA:
        Seguradora s = FuncionalidadesMenu.cadastrarSeguradora();
        listaTotalSeguradoras.add(s);
        break;
    case LISTAR_CLIENTES_SEG:
        FuncionalidadesMenu.listarClientesSeg(listaTotalSeguradoras);
        break;
    case LISTAR_SINISTROS_SEG:
        FuncionalidadesMenu.listarSinistrosSeg(listaTotalSeguradoras);
        break;
    case LISTAR_SINISTROS_CLI:
        FuncionalidadesMenu.listarSinistrosCli(listaTotalClientes, listaTotalSinistros);
        break;
    case LISTAR_VEICULOS_CLI:
        FuncionalidadesMenu.listarVeiculosCli(listaTotalClientes);
        break;
    case LISTAR_VEICULOS_SEG:
        FuncionalidadesMenu.listarVeiculosSeg(listaTotalSeguradoras);
        break;
    case EXCLUIR_CLIENTE:
        FuncionalidadesMenu.excluirCliente(listaTotalClientes);
        break;
    case EXCLUIR_VEICULO:
        FuncionalidadesMenu.excluirVeiculo(listaTotalVeiculos);
        break;
    case EXCLUIR_SINISTRO:
        FuncionalidadesMenu.excluirSinistro(listaTotalSinistros);
        break;
    case VOLTAR:
        break;
    }
}

}


    // public static void leitura_dados(Seguradora seguradora){
    //     int loop = 1;
    //     Scanner scan = new Scanner(System.in);
    //     while (loop == 1){
    //     System.out.println("Sistema de input\nSelecione o que deseja visualizar da classe seguradora inserindo o digito indicado\n"+
    //                          "1. Nome\n2. Telefone\n3. Email\n4. Endereco\n5. Lista de Sinistros\n6. Lista de Clientes\n7. Sair do sistema de input");
    //     String digito = scan.nextLine();
    //     System.out.println("--------------------------------------");
    //     if(digito.equals("1")){
    //   
    //     }else if (digito.equals("5")){
    //         System.out.println("A lista de sinistros eh " + seguradora.getlistaSinistros() + " \n");
    //     }else if (digito.equals("6")){
    //         System.out.println("A lista de clientes eh " + seguradora.getlistaClientes() + " \n");
    //     }else if (digito.equals("7")){
    //         loop = 0;
    //     }
    //     System.out.println("--------------------------------------");
    // }
    // scan.close();
//      }
// }
