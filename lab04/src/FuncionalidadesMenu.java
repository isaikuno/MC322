import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class FuncionalidadesMenu {
    
    //-------------------- CADASTRAR CLIENTES --------------------
    public static Cliente cadastrarCliente() throws Exception {
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
        
        System.out.println("Digite o endereco");
        String endereco = scan.nextLine();

        if (tipo == 1){//Cliente PF
          System.out.println("Digite a Data de Licensa no formato dd/MM/yyyy");
          Date dateLicensa = new Date();
          dateLicensa = formatadata.parse(scan.nextLine());
          
          System.out.println("Digite o nivel de educacao");
          String educacao = scan.nextLine();

          System.out.println("Digite o genero");
          String genero = scan.nextLine();

          System.out.println("Digite a classe economica");
          String classeEconomica = scan.nextLine();

          System.out.println("Digite o CPF");
          String cpf = scan.nextLine();

          System.out.println("Digite a Data de Nascimento no formato dd/MM/yyyy");
          Date dataNascimento = new Date();
          dataNascimento = formatadata.parse(scan.nextLine());

          ClientePF c = new ClientePF(nome, endereco, dateLicensa, educacao, genero, classeEconomica, cpf, dataNascimento);
          System.out.println("Cliente cadastrado");
          System.out.println(c.toString());
          return c;
        }else{
          System.out.println("Digite o cnpj");
          String cnpj = scan.nextLine();

          System.out.println("Digite a Data de Fundacao no formato dd/MM/yyyy");
          Date dataFundacao = new Date();
          dataFundacao = formatadata.parse(scan.nextLine());

          System.out.println("Digite a quantidade de funcionarios");
          int qtdeFuncionarios = scan.nextInt();
          ClientePJ c = new ClientePJ(nome, endereco, cnpj, dataFundacao, qtdeFuncionarios);
          System.out.println("Cliente cadastrado");
          System.out.println(c.toString());
          return c;
        }
    }

    public static Veiculo cadastrarVeiculo() {
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
        return v;
    }

    public static Seguradora cadastrarSeguradora() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome da seguradora");
        String nome = scan.nextLine();

        System.out.println("Digite o telefone da seguradora");
        String telefone = scan.nextLine();

        System.out.println("Digite o email da seguradora");
        String email = scan.nextLine();

        System.out.println("Digite o endereco da seguradora");
        String endereco = scan.nextLine();

        Seguradora s = new Seguradora(nome, telefone, email, endereco);
        System.out.println("Seguradora cadastrada");
        System.out.println(s.toString());
        return s;
    }

    public static void listarClientesSeg(ArrayList<Seguradora> listaSeguradoras) {
        for (int i=0; i<listaSeguradoras.size(); i++){
            System.out.println("\nOs clientes da seguradora " + listaSeguradoras.get(i).getNome() + " são:");
            for (int j=0; j<listaSeguradoras.get(i).getlistaClientes().size(); j++){
                System.out.println("\n" + listaSeguradoras.get(i).getlistaClientes().get(j).toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarSinistrosSeg(ArrayList<Seguradora> listaSeguradoras) {
        for (int i=0; i<listaSeguradoras.size(); i++){
            System.out.println("\nOs sinistros da seguradora " + listaSeguradoras.get(i).getNome() + " são:");
            for (int j=0; j<listaSeguradoras.get(i).getlistaSinistros().size(); j++){
                System.out.println("\n" + listaSeguradoras.get(i).getlistaSinistros().get(j).toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarSinistrosCli(ArrayList<Cliente> listaClientes, ArrayList<Sinistro> listaSinistros) {
        for (int i=0; i<listaClientes.size(); i++){
            System.out.println("\nOs sinistros do cliente " + listaClientes.get(i).getNome() + " são:");
            for (int j=0; j<listaSinistros.size(); j++){
                if (listaSinistros.get(j).getCliente() == listaClientes.get(i)){
                    System.out.println("\n" + listaSinistros.get(j).toString());
                }
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarVeiculosCli(ArrayList<Cliente> listaClientes) {
        for (int i=0; i<listaClientes.size(); i++){
            System.out.println("Os veiculos do cliente " + listaClientes.get(i).getNome() + " são:");
            for (int j=0; j<listaClientes.get(i).getListaVeiculos().size(); j++){
                System.out.println("\n" + listaClientes.get(i).getListaVeiculos().get(j).toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public static void listarVeiculosSeg(ArrayList<Seguradora> listaSeguradoras){
        for (int i=0; i<listaSeguradoras.size(); i++){
            System.out.println("Os veiculos da seguradora " + listaSeguradoras.get(i).getNome() + " são:");
            for (int j=0; j<listaSeguradoras.get(i).getlistaClientes().size(); j++){
                for (int k=0; k<listaSeguradoras.get(i).getlistaClientes().get(j).getListaVeiculos().size(); k++){
                    System.out.println("\n" + listaSeguradoras.get(i).getlistaClientes().get(j).getListaVeiculos().get(k).toString());
                }
            }
        }
    }

    public static void excluirCliente(ArrayList<Cliente> listaClientes){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Clientes:\n");
        for (int i=0; i<listaClientes.size(); i++){
            System.out.println(i + "- " + listaClientes.get(i).getNome() + " do endereco " + listaClientes.get(i).getEndereco());
        }

        if (listaClientes.size() == 0){
            System.out.println("Não há clientes");
        }else{
          while(input<0 || input>listaClientes.size()-1){
              System.out.println("Digite um numero de um Cliente para excluir");
              input = scan.nextInt();
          }
        listaClientes.remove(input);
        }
    }

    public static void excluirVeiculo(ArrayList<Veiculo> listaVeiculos){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Veiculos:\n");
        for (int i=0; i<listaVeiculos.size(); i++){
            System.out.println(i + "- " + "placa " +listaVeiculos.get(i).getPlaca() + ", modelo " + listaVeiculos.get(i).getModelo());
        }

        if (listaVeiculos.size() == 0){
            System.out.println("Não há veiculos");
        }else{
         while(input<0 || input>listaVeiculos.size()-1){
            System.out.println("Digite um numero de um Veiculo para excluir");
            input = scan.nextInt();
         }
        listaVeiculos.remove(input);
        }
    }

    public static void excluirSinistro(ArrayList<Sinistro> listaSinistros){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Sinistros:\n");
        for (int i=0; i<listaSinistros.size(); i++){
            System.out.println(i + "- " + "ID " + listaSinistros.get(i).getId() + "do cliente" +  listaSinistros.get(i).getCliente().getNome());
        }

        if (listaSinistros.size() == 0){
            System.out.println("Não há veiculos");
        }else{
        while(input<0 || input>listaSinistros.size()-1){
            System.out.println("Digite um numero de um Veiculo para excluir");
            input = scan.nextInt();
        }
        listaSinistros.remove(input);
    }
    }

    public static Sinistro gerarSinistro( ArrayList<Seguradora> listaSeguradoras,
                                          ArrayList<Veiculo> listaVeiculos,
                                          ArrayList<Cliente> listaClientes)throws Exception{
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite a Data do Sinistro no formato dd/MM/yyyy");
        Date data = new Date();
        data = formatadata.parse(scan.nextLine());

        System.out.println("Digite endereco do sinistro");
        String endereco = scan.nextLine();

        //Seguradora
        int input = -1;
        System.out.println("Segue a lista de Seguradoras:\n");
        for (int i=0; i<listaSeguradoras.size(); i++){
            System.out.println(i + "- " + listaSeguradoras.get(i).getNome());
        }
        while(input<0 || input>listaSeguradoras.size()-1){
        System.out.println("Digite um numero de uma Seguradora para incluir ela ao sinistro");
        input = scan.nextInt();
        }
        Seguradora seguradora = listaSeguradoras.get(input);

        //Veiculo
        int input2 = -1;
        System.out.println("Segue a lista de Veiculos:\n");
        for (int i=0; i<listaVeiculos.size(); i++){
            System.out.println(i + "- " + "placa " +listaVeiculos.get(i).getPlaca() + ", modelo " + listaVeiculos.get(i).getModelo());
        }
        while(input2<0 || input2>listaVeiculos.size()-1){
        System.out.println("Digite um numero de um Cliente para incluir ele ao sinistro");
        input2 = scan.nextInt();
        }
        Veiculo veiculo = listaVeiculos.get(input2);


        //Cliente
        int input3 = -1;
        System.out.println("Segue a lista de Clientes:\n");
        for (int i=0; i<listaClientes.size(); i++){
            System.out.println(i + "- " + listaClientes.get(i).getNome() + " do endereco " + listaClientes.get(i).getEndereco());
        }
        while(input3<0 || input3>listaClientes.size()-1){
        System.out.println("Digite um numero de um Cliente para incluir ele ao sinistro");
        input3 = scan.nextInt();
        }
        Cliente cliente = listaClientes.get(input3);

        Sinistro s = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        System.out.println("Sinistro cadastrado");
        System.out.println(s.toString());
        return s;
    }

    public static void tranferirSeguro(ArrayList<Seguradora> listaSeguradoras){
        //Lista de Veiculos de um cliente muda para outro cliente
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> possiveisInputs = new ArrayList<Integer>();
        int inputCliTransf = -1;
        int inputCliReceb = -1;
        System.out.println("Segue a lista de clientes que sao segurados:\n");
        //printa todos os clientes que sao segurados
        for(int i=0; i<listaSeguradoras.size(); i++){
            for (int j=0; j<listaSeguradoras.get(i).getlistaClientes().size();j++){
                if (listaSeguradoras.get(i).getlistaClientes().get(j) != null){
                    System.out.println(i + "" + j + "- Cliente " + listaSeguradoras.get(i).getlistaClientes().get(j).getNome() + " da seguradora " + listaSeguradoras.get(i).getNome());
                    possiveisInputs.add(Integer.parseInt(i + "" + j));
                }
            }
        }
        while(!possiveisInputs.contains(inputCliTransf)){
            System.out.println("Digite um numero de um Cliente para transferir o seguro");
            inputCliTransf = scan.nextInt();
        }
        while(!possiveisInputs.contains(inputCliReceb)){
            System.out.println("Digite um numero de um Cliente para receber o seguro");
            inputCliReceb = scan.nextInt();
        }

        int indexSegT = inputCliTransf/10;
        int indexCliT = inputCliTransf%10;
        int indexSegR = inputCliReceb/10;
        int indexCliR = inputCliReceb%10;
        for (int i=0; i<listaSeguradoras.get(indexSegT).getlistaClientes().get(indexCliT).getListaVeiculos().size(); i++){
            listaSeguradoras.get(indexSegR).getlistaClientes().get(indexCliR).getListaVeiculos().add(listaSeguradoras.get(indexSegT).getlistaClientes().get(indexCliT).getListaVeiculos().get(i));
        }
        listaSeguradoras.get(indexSegR).getlistaClientes().get(indexCliR).getListaVeiculos().clear();

        //Atualizando valor de seguro dos clientea
        listaSeguradoras.get(indexSegT).getlistaClientes().get(indexCliT).setValorSeguro(listaSeguradoras.get(indexSegT).calcularPrecoSeguroCliente(listaSeguradoras.get(indexSegT).getlistaClientes().get(indexCliT)));
        listaSeguradoras.get(indexSegR).getlistaClientes().get(indexCliR).setValorSeguro(listaSeguradoras.get(indexSegR).calcularPrecoSeguroCliente(listaSeguradoras.get(indexSegR).getlistaClientes().get(indexCliR)));
        }

    public static void calcularReceitaSeguradora(ArrayList<Seguradora> listaseSeguradoras){
        int input = -1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Segue a lista de Seguradoras:\n");
        for (int i=0; i<listaseSeguradoras.size(); i++){
            System.out.println(i + "- " + listaseSeguradoras.get(i).getNome());
        }

        while(input<0 || input>listaseSeguradoras.size()-1){
            System.out.println("Digite um numero de uma Seguradora para visualizar sua Receita");
            input = scan.nextInt();
        }
        System.out.println("O valor da receita da "+  listaseSeguradoras.get(input).getNome()+ " é " +listaseSeguradoras.get(input).calcularReceita());
    }

}
