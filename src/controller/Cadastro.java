package controller;

import exception.CadastroException;
import model.Sexo;
import service.Arquivo;
import model.Habilidade;
import model.Pesssoa;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cadastro {
    private Pesssoa pesssoa = new Pesssoa();
    private Arquivo arquivo = new Arquivo();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pesssoa getPesssoa() {
        return pesssoa;
    }

    public void setNome(String nome){
        nome = verificaTamanho(nome, 30);
        pesssoa.setNome(nome.toUpperCase().toUpperCase());
    }

    public void setCpf(String cpf) throws CadastroException {
        cpf = cpf.replaceAll("[^0-9]+","");
        if (cpf.length() == 11) {
            pesssoa.setCpf(cpf);
        } else {
            throw new CadastroException("CPF inválido!");
        }
    }

    public void setDataNascimento(String dataNascimento) throws CadastroException{
        if (dataNascimento.length() == 10) {
            pesssoa.setDataNascimento(LocalDate.parse(dataNascimento, fmt));
        } else {
            throw new CadastroException("Data inválida: digite uma data assim dd/MM/YYYY");
        }
    }

    public void setSexo(Character sexo) throws CadastroException{
        if (sexo == 'M') {
            pesssoa.setSexo(Sexo.MASCULINO);
        } else if (sexo == 'F'){
            pesssoa.setSexo(Sexo.FEMiNINO);
        }else {
            throw new CadastroException("Sexo inválido: digite M para Masculino ou F para Feminino");
        }
    }

    public void setLogradouro(String logradouro){
        logradouro = verificaTamanho(logradouro, 40);
        pesssoa.getEndereco().setLogradouro(logradouro.toUpperCase());
    }

    public void setNumero(String numero){
        if (numero.length() < 5) {
            numero = preecherZero(numero,5);
            pesssoa.getEndereco().setNumero(numero);
        } else {
            pesssoa.getEndereco().setNumero(numero);
        }
    }

    public void setComplemento(String complemento){
        complemento = verificaTamanho(complemento, 20);
        pesssoa.getEndereco().setComplemento(complemento.toUpperCase());
    }

    public void setBairro(String bairro){
        bairro = verificaTamanho(bairro, 30);
        pesssoa.getEndereco().setBairro(bairro.toUpperCase());
    }

    public void setCidade(String cidade){
        cidade = verificaTamanho(cidade, 40);
        pesssoa.getEndereco().setCidade(cidade.toUpperCase());
    }

    public void setEstado(String estado){
        pesssoa.getEndereco().setEstado(estado.toUpperCase());
    }

    public void setEmail(String email){
        email = verificaTamanho(email, 50);
        pesssoa.getContato().setEmail(email.toLowerCase());
    }

    public void setTelefone(String telefone){
        telefone = verificaNumero(telefone);
        pesssoa.getContato().setTelefone(telefone);
    }

    public void setCelular(String celular){
        celular = verificaNumero(celular);
        pesssoa.getContato().setCelular(celular);
    }

    public void setWhatsApp(Character whatsApp) throws CadastroException{
        if (whatsApp == 'T') {
            pesssoa.getContato().setWhatsApp(true);
        }else if(whatsApp == 'F'){
            pesssoa.getContato().setWhatsApp(false);
        }else {
            throw new CadastroException("Valor inválido: digite T para Sim ou F para não");
        }
    }

    public void setCargo(String cargo) {
        cargo = verificaTamanho(cargo, 30);
        pesssoa.getProfissao().setCargo(cargo.toUpperCase());
    }

    public void setNomeEmpresa(String nomeEmpresa){
        nomeEmpresa = verificaTamanho(nomeEmpresa,30);
        pesssoa.getProfissao().setNomeEmpresa(nomeEmpresa.toUpperCase());
    }

    public void setSalario(String salario){
        String sal = salario.replaceAll("[^0-9,]","").replace(",",".");
        pesssoa.getProfissao().setSalario(Double.valueOf(sal));
    }

    public void setEmpregoAtual(Character empregoAtual){
        if (empregoAtual == 'T') {
            pesssoa.getProfissao().setEmpregoAtual(true);
        }else {
            pesssoa.getProfissao().setEmpregoAtual(false);
        }
    }

    public void setPretencaoMinima(String salario){
        String sal = salario.replaceAll("[^0-9,]","").replace(",",".");
        pesssoa.getPretencaoSalarial().setValorMinimo(Double.valueOf(sal));
    }

    public void setPretencaoMaxima(String salario){
        String sal = salario.replaceAll("[^0-9,]","").replace(",",".");
        pesssoa.getPretencaoSalarial().setValorMaximo(Double.valueOf(sal));
    }

    public void setHabilidades(String habilidades){
        String[] listaHabilidade = habilidades.replace(" ","").split(",");

        for (String nomeHabilidade : listaHabilidade) {
            Habilidade habilidade = new Habilidade();
            habilidade.setNome(nomeHabilidade);
            pesssoa.getHabilidades().add(habilidade);
        }
    }

    public void salvar(){
        arquivo.salvar(pesssoa);
    }

    public void enviar() {
        arquivo.enviar(pesssoa);
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

    private String verificaNumero(String numero) {
        numero = numero.replaceAll("[^0-9]","");
        if (numero.length() != 0) {
            return numero;
        } else {
            return preecherZero(numero, 11);
        }
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
