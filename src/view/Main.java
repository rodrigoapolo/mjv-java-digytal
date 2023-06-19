package view;

import controller.Cadastro;
import exception.CadastroException;

public class Main {
    public static void main(String[] args) {

        Cadastro cadastro = new Cadastro();
        try {
            cadastro.setNome("Raimundo Nonato Loureiro Castelo Branco");
            cadastro.setCpf("135.217.791-18");
            cadastro.setDataNascimento("16/04/1986");
            cadastro.setSexo('M');
            cadastro.setLogradouro("Ruas das laranjeiras");
            cadastro.setNumero("123");
            cadastro.setComplemento("Bl 03 ap 113");
            cadastro.setBairro("Vila Nazare");
            cadastro.setCidade("Teresina");
            cadastro.setEstado("Pi");
            cadastro.setEmail("raimundo.nonato@gmail.com");
            cadastro.setTelefone("(11) 3351-1010");
            cadastro.setCelular("(11) 94565-2353");
            cadastro.setWhatsApp('T');
            cadastro.setCargo("Analista de sistemas");
            cadastro.setNomeEmpresa("Microsoft");
            cadastro.setNomeEmpresa("Microsoft");
            cadastro.setSalario("R$ 5.279,33");
            cadastro.setEmpregoAtual('T');
            cadastro.setPretencaoMinima("R$ 5.279,33");
            cadastro.setPretencaoMaxima("R$ 5.279,33");
            cadastro.setHabilidades("Java, Vue3, Postgres, Spring");
        } catch (CadastroException c) {
            System.out.println(c.getMessage());
        }

        cadastro.salvar();
        cadastro.enviar();
    }
}