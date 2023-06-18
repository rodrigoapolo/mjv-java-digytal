package view;

import controller.Cadastro;
import exception.CadastroException;
import model.Habilidade;

public class Main {
    public static void main(String[] args) {
        /* TODO
                criar mais clsse
                dados null
         */
        Cadastro cadastro = null;
        try {
            cadastro = new Cadastro();
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
            cadastro.setEmpregoAtual('F');
            cadastro.setPretencaoMinima("R$ 5.279,33");
            cadastro.setPretencaoMaxima("R$ 5.279,33");
            cadastro.setHabilidades("Java, Vue3, Postgres, Spring");
        } catch (CadastroException c) {
            System.out.println(c.getMessage());
        }

        System.out.println(cadastro.getPesssoa().getNome());
        System.out.println(cadastro.getPesssoa().getCpf());
        System.out.println(cadastro.getPesssoa().getDataNascimento());
        System.out.println(cadastro.getPesssoa().getSexo());
        System.out.println(cadastro.getPesssoa().getEndereco().getLogradouro());
        System.out.println(cadastro.getPesssoa().getEndereco().getNumero());
        System.out.println(cadastro.getPesssoa().getEndereco().getComplemento());
        System.out.println(cadastro.getPesssoa().getEndereco().getBairro());
        System.out.println(cadastro.getPesssoa().getEndereco().getCidade());
        System.out.println(cadastro.getPesssoa().getEndereco().getEstado());
        System.out.println(cadastro.getPesssoa().getContato().getEmail());
        System.out.println(cadastro.getPesssoa().getContato().getTelefone());
        System.out.println(cadastro.getPesssoa().getContato().getCelular());
        System.out.println(cadastro.getPesssoa().getContato().isWhatsApp());
        System.out.println(cadastro.getPesssoa().getProfissao().getCargo());
        System.out.println(cadastro.getPesssoa().getProfissao().getNomeEmpresa());
        System.out.println(cadastro.getPesssoa().getProfissao().getSalario());
        System.out.println(cadastro.getPesssoa().getProfissao().isEmpregoAtual());
        System.out.println(cadastro.getPesssoa().getPretencaoSalarial().getValorMinimo());
        System.out.println(cadastro.getPesssoa().getPretencaoSalarial().getValorMaximo());

        for (Habilidade habilidade : cadastro.getPesssoa().getHabilidades()) {
            System.out.println(habilidade.getNome());
        }





    }
}