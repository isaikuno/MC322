import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {

    //Metodo validarTelfone
    public static boolean validarTelefone(String telefone){
        //retorna se tiver letras
        Pattern pattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telefone);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }

        //deve ter entre 8 ou 9 ou 11 ou 13 digitos
        //tira tudo que nao seja digito
        telefone = telefone.replaceAll("[^\\d]", ""); //remove todos os caracteres nao numericos
        if (telefone.length() != 8 && telefone.length() != 9 && telefone.length() != 11 && telefone.length() != 13 ){
            return false;
        };
        return true;
    }

    //Metodo validarNome
    public static boolean validarNome(String nome){
        //Pode ter apenas letras
        Pattern pattern = Pattern.compile("\\d|\\W", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }
        return true;
    }

    
    //Metodo validarCPF
    public static boolean validarCPF(String cpf){
        cpf = cpf.replaceAll("[^\\d]", ""); //remove todos os caracteres nao numericos
        if (cpf.length() != 11){//verifica se o tamanho do cpf tem 11 digitos
            return false;
        }; 

        //Verifica se todos os caracteres nao sao iguais
        Pattern pattern = Pattern.compile("^(\\d)\\1+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }

        //Verifica se os digitos verificadores d0 e d1 sao verdadeiros
        if (!digitos_verif_cpf(cpf, 0) || !digitos_verif_cpf(cpf, 1)){
            return false;
        }
        return true;
    }

    //Metodo boleano que verifica os digitos verificadores do cpf
    private static boolean digitos_verif_cpf(String cpf, int digito){
        int soma_final=0, resto, d1;
        //Realiza a soma dos digitos iniciais do cpf multiplicados por 10, 9,..., 2.
        for (int i =10; i>=2; i--){
            soma_final = soma_final + Character.getNumericValue(cpf.charAt(10+digito-i))*i;
        }

        //Define o digito com base no resto da divisao da soma por 11
        resto = soma_final%11;
        if (resto == 0 || resto == 1 ){
            d1 = 0;
        } else {
            d1 = 11-resto;
        }
        //Verifica se o digito difere do que consta no cpf
        if (Character.getNumericValue(cpf.charAt(9+digito)) != d1){
            return false;
        }
        return true;
    }


    //Metodo validarCNPJ
    public static boolean validarCNPJ(String cnpj){
        cnpj = cnpj.replaceAll("[^\\d]", ""); //remove todos os caracteres nao numericos
        if (cnpj.length() != 14){//verifica se o tamanho do cnpj tem 14 digitos
            return false;
        }; 

        //Verifica se todos os caracteres nao sao iguais
        Pattern pattern = Pattern.compile("^(\\d)\\1+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cnpj);
        boolean matchFound = matcher.find();
        if (matchFound){
            return false;
        }

        //Verifica se os digitos verificadores d0 e d1 sao verdadeiros
        if (!digitos_verif_cnpj(cnpj, 1) || !digitos_verif_cnpj(cnpj, 0)){
            return false;
        }
        return true;
    }

    //Metodo boleano que verifica os digitos verificadores do cnpj
    private static boolean digitos_verif_cnpj(String cnpj, int digito){
        int soma_final=0, resto, d1;
        final int[] fator = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        //Realiza a soma dos digitos iniciais do cnpj multiplicados por fator.
        for (int i=0; i<(13-digito); i++){
            soma_final = soma_final + Character.getNumericValue(cnpj.charAt(i))*fator[i+digito];
        }

        //Define o digito com base no resto da divisao da soma por 11
        resto = soma_final%11;
        if (resto == 0 || resto == 1 ){
            d1 = 0;
        } else {
            d1 = 11-resto;
        }
        //Verifica se o digito difere do que consta no cnpj
        if (Character.getNumericValue(cnpj.charAt(13-digito)) != d1){
            return false;
        }
        return true;
    }


}