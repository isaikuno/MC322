import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //INICIALIZAR OBJETOS PARA AS CLASSES
        Veiculo veiculo1 = new Veiculo("AAA1111", "Ford", "C21", 2005);
        Veiculo veiculo2 = new Veiculo("BBB2222", "Ford", "C22", 2006);
        Veiculo veiculo3 = new Veiculo("CCC3333", "Ford", "C23", 2007);

        Date data = new Date();

        ClientePJ clientePJ1 = new ClientePJ("Jozerbaldo", "Rua Cassio", data, "Ens superior", "masc", "C", "37.514.580.0001-45", data);
        ClientePF clientePF1 = new ClientePF("Claudete", "Rua Moraes", data, "Pos", "fem", "A", "280.012.38938", data);
        ClientePF clientePF2 = new ClientePF("Totoro", "Rua Chimarrao", data, "Ens superior", "masc", "B", "123.456.759-09", data);

        //instanciando uma serguradora
        Seguradora seguradora1 = new Seguradora("MaisSeguro", "(44)91838-3421", "Mais@gmail.com", "Rua Comendador");

        Sinistro sinistro1 = new Sinistro("10/02/2006", "Rua Benjamin", seguradora1, veiculo1, clientePF1);
        Sinistro sinistro2 = new Sinistro("11/03/2006", "Rua Jacaranda", seguradora1, veiculo1, clientePF1);

        // Printar todas as classes
        System.out.println(veiculo1.toString());
        System.out.println(veiculo2.toString());
        System.out.println(veiculo3.toString());
        System.out.println(clientePJ1.toString());
        System.out.println(clientePF1.toString());
        System.out.println(clientePF2.toString());
        System.out.println(seguradora1.toString());
        System.out.println(sinistro1.toString());
        System.out.println(sinistro2.toString());
        System.out.println("--------------------------------------");


        //Cadastrar os 3 clientes na seguradora1, tentar cadastrar novamente o clientePF1 e então remover clientePF2
        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.removerCliente("Totoro");
        System.out.println(seguradora1.toString());
        System.out.println("--------------------------------------");

        //ValidarCPF e CNPJ:
        if (clientePJ1.validarCNPJ(clientePJ1.getCnpj())){
            System.out.println("CNPJ de clientePJ1 eh valido");
        }else {
            System.out.println("CNPJ de clientePJ1 eh invalido");}

        if (clientePF1.validarCPF(clientePF1.getCpf())){
            System.out.println("CPF de clientePF1 eh valido");
        }else {
            System.out.println("CPF de clientePF1 eh invalido");}

        if (clientePF2.validarCPF(clientePF2.getCpf())){
            System.out.println("CPF de clientePF2 eh valido");
        }else {
            System.out.println("CPF de clientePF2 eh invalido");
        System.out.println("--------------------------------------");}

        //Adcionar veiculos no cliente
        clientePJ1.addListaVeiculos(veiculo2);
        clientePF1.addListaVeiculos(veiculo1);
        clientePF1.addListaVeiculos(veiculo3);
        System.out.println(clientePJ1.toString());
        System.out.println(clientePF1.toString());
        System.out.println("--------------------------------------");

        //Adicionando 2 sinistros na seguradora e tentando adicionar novamente o mesmo sinistro
        seguradora1.gerarSinistro(sinistro1);
        seguradora1.gerarSinistro(sinistro1);
        seguradora1.gerarSinistro(sinistro2);
        System.out.println(seguradora1.toString());//Devido ao elevado tamanho do Sys out, 
                                                    //no toString() da classe Sinistro, o objeto seguradora, 
                                                    //veiculo e cliente foram reduzidos ao seus nomes.
        System.out.println("--------------------------------------");

        //Chamar metodo listarClientes
        System.out.println(seguradora1.listarClientes("juridica"));
        System.out.println("--------------------------------------");

        
        //Chamar metodo visualizar sinistro
        seguradora1.visualizarSinistro("Claudete");
        System.out.println("--------------------------------------");

        //Chamar metodo listarSinistros
        System.out.println(seguradora1.listarSinistros());
        System.out.println("--------------------------------------");

        //Chamar método System.In
        leitura_dados(seguradora1);

    }
    public static void leitura_dados(Seguradora seguradora){
        int loop = 1;
        Scanner scan = new Scanner(System.in);
        while (loop == 1){
        System.out.println("Sistema de input\nSelecione o que deseja visualizar da classe seguradora inserindo o digito indicado\n"+
                             "1. Nome\n2. Telefone\n3. Email\n4. Endereco\n5. Lista de Sinistros\n6. Lista de Clientes\n7. Sair do sistema de input");
        String digito = scan.nextLine();
        System.out.println("--------------------------------------");
        if(digito.equals("1")){
            System.out.println("O nome eh " + seguradora.getNome() + " \n");
        }else if (digito.equals("2")){
            System.out.println("O telefone eh " + seguradora.getTelefone() + " \n");
        }else if (digito.equals("3")){
            System.out.println("O email eh " + seguradora.getEmail() + " \n");
        }else if (digito.equals("4")){
            System.out.println("O endereco eh " + seguradora.getEndereco() + " \n");
        }else if (digito.equals("5")){
            System.out.println("A lista de sinistros eh " + seguradora.getlistaSinistros() + " \n");
        }else if (digito.equals("6")){
            System.out.println("A lista de clientes eh " + seguradora.getlistaClientes() + " \n");
        }else if (digito.equals("7")){
            loop = 0;
        }
        System.out.println("--------------------------------------");
    }
    scan.close();
    }
}
