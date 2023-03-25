
public class Main {
    public static void main(String[] args) throws Exception {
        //teste 1 - atribuir dados para cada classe e printar. A classe Cliente tera input de um cpf errado
        Sinistro acidente = new Sinistro("21/04", "Rua Candido");
        System.out.println(acidente.toString());
        
        Cliente cliente1 = new Cliente ("Jorge", "280.012.80938", "02/02/1999", 23, "Rua Amorim" );
        System.out.println(cliente1.toString());

        Seguradora seguradora1 = new Seguradora("MaisSeguro", "(44)91838-3421", "Mais@gmail.com", "Rua Comendador");
        System.out.println(seguradora1.toString());

        Veiculo veiculo1 = new Veiculo("IBD9806", "Ford", "C20");
        System.out.println(veiculo1.toString());

        //Redefine o cpf do objeto cliente1 e printa ele
        cliente1.setCpf("280.012.38938");
        System.out.println("cpf atualizado: " + cliente1.getCpf() + "\n");

    }
}
