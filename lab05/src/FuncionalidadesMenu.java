import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class FuncionalidadesMenu {
    
    //-------------------- CADASTRAR CLIENTES --------------------
    public static void cadastrarCliente() throws Exception {
        Scanner scan = new Scanner(System.in);
        int tipo;
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");

        do{
        System.out.println("1- Cliente PF\n2- Cliente PJ\n");
        tipo = scan.nextInt();
        scan.nextLine();
        }while (tipo != 1 && tipo != 2);
        
        System.out.println("Digite o nome do cliente");
        String nome = scan.nextLine();

        System.out.println("Digite o telefone do cliente");
        String telefone = scan.nextLine();
        
        System.out.println("Digite o endereco");
        String endereco = scan.nextLine();

        System.out.println("Digite o email");
        String email = scan.nextLine();

        if (tipo == 1){//Cliente PF
          
          System.out.println("Digite o nivel de educacao");
          String educacao = scan.nextLine();

          System.out.println("Digite o genero");
          String genero = scan.nextLine();

          System.out.println("Digite o CPF");
          String cpf = scan.nextLine();

          System.out.println("Digite a Data de Nascimento no formato dd/MM/yyyy");
          Date dataNascimento = new Date();
          dataNascimento = formatadata.parse(scan.nextLine());

          ClientePF c = new ClientePF(nome, telefone, endereco, email, cpf, genero, educacao, dataNascimento);
          System.out.println("Cliente cadastrado");
          System.out.println(c.toString());

        }else{
          System.out.println("Digite o cnpj");
          String cnpj = scan.nextLine();

          System.out.println("Digite a Data de Fundacao no formato dd/MM/yyyy");
          Date dataFundacao = new Date();
          dataFundacao = formatadata.parse(scan.nextLine());

          ClientePJ c = new ClientePJ(nome, telefone, endereco, email, cnpj, dataFundacao);
          System.out.println("Cliente cadastrado");
          System.out.println(c.toString());
        }
    }

    public static void cadastrarVeiculo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a placa do carro");
        String placa = scan.nextLine();

        System.out.println("Digite a marca do carro");
        String marca = scan.nextLine();

        System.out.println("Digite o modelo do carro");
        String modelo = scan.nextLine();

        System.out.println("Digite o ano de fabricacao do carro");
        int anoFabricacao = scan.nextInt();

        Veiculo v = new Veiculo(placa, marca, modelo, anoFabricacao);
        System.out.println("Veiculo cadastrado");
        System.out.println(v.toString());

    }

    public static void cadastrarSeguradora() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o cnpj da seguradora");
        String cnpj = scan.nextLine();

        System.out.println("Digite o nome da seguradora");
        String nome = scan.nextLine();

        System.out.println("Digite o telefone da seguradora");
        String telefone = scan.nextLine();

        System.out.println("Digite o email da seguradora");
        String email = scan.nextLine();

        System.out.println("Digite o endereco da seguradora");
        String endereco = scan.nextLine();

        Seguradora s = new Seguradora(cnpj, nome, telefone, email, endereco);
        System.out.println("Seguradora cadastrada");
        System.out.println(s.toString());

    }

    public static void cadastrarCondutor()  throws Exception {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite o cpf da condutor");
        String cpf = scan.nextLine();

        System.out.println("Digite o nome do condutor");
        String nome = scan.nextLine();

        System.out.println("Digite o telefone do condutor");
        String telefone = scan.nextLine();

        System.out.println("Digite o email do condutor");
        String email = scan.nextLine();

        System.out.println("Digite o endereco do condutor");
        String endereco = scan.nextLine();

        System.out.println("Digite a Data de Nascimento no formato dd/MM/yyyy");
          Date dataNascimento = new Date();
          dataNascimento = formatadata.parse(scan.nextLine());

        Condutor c = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
        System.out.println("Condutor cadastrada");
        System.out.println(c.toString());
    }

    public static void listarClientesSeg() {
        for (int i=0; i<Seguradora.listaTotalSeguradoras.size(); i++){
            System.out.println("\nOs clientes da seguradora " + Seguradora.listaTotalSeguradoras.get(i).getNome() + " são:");
            for (int j=0; j<Seguradora.listaTotalSeguradoras.get(i).getlistaClientes().size(); j++){
                System.out.println("\n" + Seguradora.listaTotalSeguradoras.get(i).getlistaClientes().get(j).toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarSinistrosCli() {
        for (int i=0; i<Cliente.listaTotalClientes.size(); i++){
            System.out.println("\nOs sinistros do cliente " + Cliente.listaTotalClientes.get(i).getNome() + " são:");
            for (int j=0; j<Sinistro.listaTotalSinistros.size(); j++){
                if (Sinistro.listaTotalSinistros.get(j).getCondutor().getNome() == Cliente.listaTotalClientes.get(i).getNome()){
                    System.out.println("\n" + Sinistro.listaTotalSinistros.get(j).toString());
                }
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarVeiculosCli() {
        for (int i=0; i<ClientePF.listaTotalClientesPF.size(); i++){
            System.out.println("Os veiculos do clientePF " + ClientePF.listaTotalClientesPF.get(i).getNome() + " são:");
            for (int j=0; j<ClientePF.listaTotalClientesPF.get(i).getListaVeiculos().size(); j++){
                System.out.println("\n" + ClientePF.listaTotalClientesPF.get(i).getListaVeiculos().get(j).toString());
            }
        }
        for (int i=0; i<ClientePJ.listaTotalClientesPJ.size(); i++){
            System.out.println("As frotas do clientePJ " + ClientePJ.listaTotalClientesPJ.get(i).getNome() + " são:");
            for (int j=0; j<ClientePJ.listaTotalClientesPJ.get(i).getListaFrotas().size(); j++){
                System.out.println("\n" + ClientePJ.listaTotalClientesPJ.get(i).getListaFrotas().get(j).toString());
            }
        }

        System.out.println("---------------------------------------------------");
    }

    public static void listarSegurosSeg(){
        for (int i=0; i<Seguradora.listaTotalSeguradoras.size(); i++){
            System.out.println("Os seguros da seguradora " + Seguradora.listaTotalSeguradoras.get(i).getNome() + " são:");
            for (int j=0; j<Seguradora.listaTotalSeguradoras.get(i).getlistaSeguros().size(); j++){
                System.out.println("\n" + Seguradora.listaTotalSeguradoras.get(i).getlistaSeguros().get(j).toString());
            }
        }
    }

    public static void excluirCliente(){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Clientes:\n");
        for (int i=0; i<Cliente.listaTotalClientes.size(); i++){
            System.out.println(i + "- " + Cliente.listaTotalClientes.get(i).getNome() + " do endereco " + Cliente.listaTotalClientes.get(i).getEndereco());
        }

        if (Cliente.listaTotalClientes.size() == 0){
            System.out.println("Não há clientes");
        }else{
          while(input<0 || input>Cliente.listaTotalClientes.size()-1){
              System.out.println("Digite um numero de um Cliente para excluir");
              input = scan.nextInt();
          }
          for (int i = 0; i<Seguradora.listaTotalSeguradoras.size(); i++){
            if (Seguradora.listaTotalSeguradoras.get(i).getlistaClientes().contains(Cliente.listaTotalClientes.get(input))){
                Seguradora.listaTotalSeguradoras.get(i).removerCliente(Cliente.listaTotalClientes.get(input));
            }
          }
          Cliente.listaTotalClientes.remove(input);
        }
    }

    public static void excluirVeiculo(){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Veiculos:\n");
        for (int i=0; i<Veiculo.listaTotalVeiculos.size(); i++){
            System.out.println(i + "- " + "placa " +Veiculo.listaTotalVeiculos.get(i).getPlaca() + ", modelo " + Veiculo.listaTotalVeiculos.get(i).getModelo());
        }

        if (Veiculo.listaTotalVeiculos.size() == 0){
            System.out.println("Não há veiculos");
        }else{
         while(input<0 || input>Veiculo.listaTotalVeiculos.size()-1){
            System.out.println("Digite um numero de um Veiculo para excluir");
            input = scan.nextInt();
         }
        for (int i = 0; i<ClientePF.listaTotalClientesPF.size(); i++){
            if (ClientePF.listaTotalClientesPF.get(i).getListaVeiculos().contains(Veiculo.listaTotalVeiculos.get(input))){
                ClientePF.listaTotalClientesPF.get(i).removerVeiculo(Veiculo.listaTotalVeiculos.get(input));
            }
        }
        for (int i = 0; i<ClientePJ.listaTotalClientesPJ.size(); i++){
            for (int j=0; j<ClientePJ.listaTotalClientesPJ.get(i).getListaFrotas().size(); j++){
                if (ClientePJ.listaTotalClientesPJ.get(i).getListaFrotas().get(j).getListaVeiculos().contains(Veiculo.listaTotalVeiculos.get(input))){
                    ClientePJ.listaTotalClientesPJ.get(i).getListaFrotas().get(j).removerVeiculo(Veiculo.listaTotalVeiculos.get(input));
            }
            }
        }
        Veiculo.listaTotalVeiculos.remove(input);
        }
    }

    public static void calcularReceitaSeguradora(){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Seguradoras:\n");
        for (int i=0; i<Seguradora.listaTotalSeguradoras.size(); i++){
            System.out.println(i + "- " + Seguradora.listaTotalSeguradoras.get(i).getNome());
        }

        while(input<0 || input>Seguradora.listaTotalSeguradoras.size()-1){
            System.out.println("Digite um numero de uma Seguradora para visualizar sua Receita");
            input = scan.nextInt();
        }
        System.out.println("O valor da receita da "+  Seguradora.listaTotalSeguradoras.get(input).getNome()+ " é " +Seguradora.listaTotalSeguradoras.get(input).calcularReceita());
    }

}
