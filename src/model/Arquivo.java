package model;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Arquivo {

    private final String path = "/home/rodrigoapolo/jobby/files/";
    private String delimitador;
    private boolean enviar;
    private Pesssoa pesssoa;

    public Arquivo() {
        File destino = new File(path.substring(0,25));
        destino.mkdir();
        destino = new File(path.substring(0,31));
        destino.mkdir();
    }

    public void salvar(Pesssoa pesssoa){
        this.pesssoa = pesssoa;
        gerarArquivo( false);
    }
    public void enviar(Pesssoa pesssoa){
        this.pesssoa = pesssoa;
        gerarArquivo( true);
    }

    private void gerarArquivo(boolean enviar){
        StringBuilder destino = new StringBuilder(path);
        this.enviar = enviar;
        if(this.enviar){
            destino.append("cadastro-"+pesssoa.getCpf()+".txt");
        }else {
            destino.append("cadastro.csv");
        }
        delimitador = enviar ? "" : ";";
        criarArquivo(destino.toString());
    }

    private void criarArquivo(String destino) {
        try {
            StringBuilder conteudo = escreverLayoutDelimitado();

            Path arquivoDestino = Paths.get(destino);
            Files.write(arquivoDestino, conteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private StringBuilder escreverLayoutDelimitado() {
        StringBuilder conteudo = new StringBuilder();
        if(!enviar)
            conteudo.append(geralTitulo());
        conteudo.append(pesssoa.getNome() + delimitador);
        conteudo.append(pesssoa.getCpf()+ delimitador);
        conteudo.append(pesssoa.getDataNascimento().toString().replace("-","")+ delimitador);
        conteudo.append((pesssoa.getSexo() == SEXO.MASCULINO ? "M" : "F")+ delimitador);
        conteudo.append(pesssoa.getEndereco().getLogradouro()+ delimitador);
        conteudo.append(pesssoa.getEndereco().getNumero()+ delimitador);
        conteudo.append(pesssoa.getEndereco().getComplemento()+ delimitador);
        conteudo.append(pesssoa.getEndereco().getBairro()+ delimitador);
        conteudo.append(pesssoa.getEndereco().getCidade()+ delimitador);
        conteudo.append(pesssoa.getEndereco().getEstado()+ delimitador);
        conteudo.append(pesssoa.getContato().getEmail()+ delimitador);
        conteudo.append(pesssoa.getContato().getTelefone()+ delimitador);
        conteudo.append(pesssoa.getContato().getCelular()+ delimitador);
        conteudo.append(((pesssoa.getContato().isWhatsApp()? "T" : "0"))+ delimitador);
        conteudo.append(pesssoa.getProfissao().getCargo()+delimitador);
        conteudo.append(pesssoa.getProfissao().getNomeEmpresa()+delimitador);
        conteudo.append(preecherZero(
                pesssoa.getProfissao()
                        .getSalario()
                        .toString()
                        .replace(".",""),10)+delimitador);
        conteudo.append((pesssoa.getProfissao().isEmpregoAtual() ? "T" : "")+delimitador);
        conteudo.append(preecherZero(
                pesssoa.getPretencaoSalarial()
                        .getValorMinimo()
                        .toString()
                        .replace(".",""),10)+delimitador);
        conteudo.append(preecherZero(
                pesssoa.getPretencaoSalarial()
                        .getValorMaximo()
                        .toString()
                        .replace(".",""),10)+delimitador);

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
        conteudo.append(verificaTamanho(listHabilidade.toString(), 50)+delimitador);
        conteudo.append(System.lineSeparator());
        return conteudo;
    }

    private String geralTitulo(){
        StringBuilder titulo = new StringBuilder();
        titulo.append("Nome"+delimitador+"CPF"+delimitador+"Data"+delimitador+"Sexo"+delimitador);
        titulo.append("Lougradouro"+delimitador+"Numero"+delimitador+"Complemento"+delimitador+"Bairro"
                +delimitador+"Cidade"+delimitador+"Estado"+delimitador);
        titulo.append("E-mail"+delimitador+"Telefone"+delimitador+"Celular"+delimitador+"Celular é Whats"+delimitador);
        titulo.append("Profissão"+delimitador+"Empresa"+delimitador+"Salário"+delimitador+"Emprego Atual"+delimitador);
        titulo.append("Pretenção Mínima"+delimitador+"Pretenção Máxima"+delimitador+"Habilidades"+delimitador);
        titulo.append(System.lineSeparator());
        return titulo.toString();
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
