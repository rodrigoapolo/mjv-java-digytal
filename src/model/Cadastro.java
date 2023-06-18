package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cadastro {
    private Pesssoa pesssoa;
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cadastro() {
        this.pesssoa = new Pesssoa();
    }

    public Pesssoa getPesssoa() {
        return pesssoa;
    }

    public void setNome(String nome){
        if (nome.length() >= 30) {
            pesssoa.setNome(nome.substring(0,30));
        }else {
            pesssoa.setNome(nome);
        }
    }

    public void setCpf(String cpf){
        pesssoa.setCpf(cpf.replaceAll("[^0-9]+",""));
    }

    public void setDataNascimento(String dataNascimento){
        pesssoa.setDataNascimento(LocalDate.parse(dataNascimento, fmt));
    }

    public void setSexo(Character sexo){
        if (sexo == 'M') {
            pesssoa.setSexo(SEXO.MASCULINO);
        } else if (sexo == 'M'){
            pesssoa.setSexo(SEXO.FEMiNINO);
        }else {
            //TODO fazer o erro
        }
    }

    public void setLogradouro(String logradouro){
        pesssoa.getEndereco().setLogradouro(logradouro.toUpperCase());
    }

    public void setNumero(String numero){
        pesssoa.getEndereco().setNumero(numero);
    }

    public void setComplemento(String complemento){
        pesssoa.getEndereco().setComplemento(complemento);
    }

    public void setBairro(String bairro){
        pesssoa.getEndereco().setBairro(bairro.toUpperCase());
    }

    public void setCidade(String cidade){
        pesssoa.getEndereco().setCidade(cidade.toUpperCase());
    }

    public void setEstado(String estado){
        pesssoa.getEndereco().setEstado(estado.toUpperCase());
    }

    public void setEmail(String email){
        pesssoa.getContato().setEmail(email.toLowerCase());
    }

    public void setTelefone(String telefone){
        pesssoa.getContato().setTelefone(telefone.replaceAll("[^0-9]",""));
    }

    public void setCelular(String celular){
        pesssoa.getContato().setCelular(celular.replaceAll("[^0-9]",""));
    }

    public void setWhatsApp(Character whatsApp){
        if (whatsApp == 'T') {
            pesssoa.getContato().setWhatsApp(true);
        }else {
            pesssoa.getContato().setWhatsApp(false);
        }
    }

    public void setCargo(String cargo) {
        pesssoa.getProfissao().setCargo(cargo.toUpperCase());
    }

    public void setNomeEmpresa(String nomeEmpresa){
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
}
