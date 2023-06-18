package model;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Arquivo {

    private static String path = "/home/rodrigoapolo/jobby/files/cadastro.csv";
    private static String titulos;
    public Arquivo() {
        File destino = new File(path.substring(0,25));
        destino.mkdir();
        destino = new File(path.substring(0,31));
        destino.mkdir();
        geralTitulo();
    }

    public void salvar(Pesssoa pesssoa){
        try {
            StringBuilder conteudo = escreverLayoutDelimitado(pesssoa);

            Path arquivoDestino = Paths.get(path);
            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private StringBuilder escreverLayoutDelimitado(Pesssoa pesssoa) {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(titulos);
        conteudo.append(pesssoa.getNome() + ";");
        conteudo.append(pesssoa.getCpf()+ ";");
        conteudo.append(pesssoa.getDataNascimento().toString().replace("-","")+ ";");
        conteudo.append((pesssoa.getSexo() == SEXO.MASCULINO ? "M" : "F")+ ";");
        conteudo.append(pesssoa.getEndereco().getLogradouro()+ ";");
        conteudo.append(pesssoa.getEndereco().getNumero()+ ";");
        conteudo.append(pesssoa.getEndereco().getComplemento()+ ";");
        conteudo.append(pesssoa.getEndereco().getBairro()+ ";");
        conteudo.append(pesssoa.getEndereco().getCidade()+ ";");
        conteudo.append(pesssoa.getEndereco().getEstado()+ ";");
        conteudo.append(pesssoa.getContato().getEmail()+ ";");
        conteudo.append(pesssoa.getContato().getTelefone()+ ";");
        conteudo.append(pesssoa.getContato().getCelular()+ ";");
        conteudo.append(((pesssoa.getContato().isWhatsApp()? "T" : "0"))+ ";");
        conteudo.append(pesssoa.getProfissao().getCargo()+";");
        conteudo.append(pesssoa.getProfissao().getNomeEmpresa()+";");
        conteudo.append(preecherZero(
                pesssoa.getProfissao()
                        .getSalario()
                        .toString()
                        .replace(".",""),10)+";");
        conteudo.append((pesssoa.getProfissao().isEmpregoAtual() ? "T" : "")+";");
        conteudo.append(preecherZero(
                pesssoa.getPretencaoSalarial()
                        .getValorMinimo()
                        .toString()
                        .replace(".",""),10)+";");
        conteudo.append(preecherZero(
                pesssoa.getPretencaoSalarial()
                        .getValorMaximo()
                        .toString()
                        .replace(".",""),10)+";");

        StringBuilder listHabilidade = new StringBuilder();
        int i = 0;
        for (Habilidade h : pesssoa.getHabilidades()) {
            if (i != pesssoa.getHabilidades().size()-1) {
                listHabilidade.append(h.getNome() + "-");
            } else {
                listHabilidade.append(h.getNome());
            }
            i++;
        }
        conteudo.append(verificaTamanho(listHabilidade.toString(), 50)+";");
        conteudo.append(System.lineSeparator());
        return conteudo;
    }

    private void geralTitulo(){
        StringBuilder titulo = new StringBuilder();
        titulo.append("Nome;CPF;Data;Sexo;");
        titulo.append("Lougradouro;Numero;Complemento;Bairro;Cidade;Estado;");
        titulo.append("E-mail;Telefone;Celular;Celular é Whats;");
        titulo.append("Profissão;Empresa;Salário;Emprego Atual;");
        titulo.append("Pretenção Mínima;Pretenção Máxima;Habilidades;");
        titulo.append(System.lineSeparator());
        titulos = titulo.toString();
    }

    private String verificaTamanho(String valor, int tamanhoFinal) {
        if(valor.length() < tamanhoFinal){
            return adicionalEspaco(valor, tamanhoFinal);
        }else if (valor.length() > tamanhoFinal) {
            return valor.substring(0,tamanhoFinal);
        }else {
            return valor;
        }
    }

    private String adicionalEspaco(String valor, int tamanhoFinal ) {
        StringBuilder espaco = new StringBuilder();
        for (int i = valor.length(); i<tamanhoFinal; i++){
            espaco.append(" ");
        }
        espaco.append(valor);
        return espaco.toString();
    }

    private String preecherZero(String numero, int tamanhoFinal) {
        StringBuilder zero = new StringBuilder();
        for (int i = numero.length(); i<tamanhoFinal; i++){
            zero.append("0");
        }
        zero.append(numero);
        return zero.toString();
    }
}
