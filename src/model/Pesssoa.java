package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pesssoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private SEXO sexo;
    private Endereco endereco = new Endereco();
    private Contato contato = new Contato();
    private Profissao profissao = new Profissao();
    private PretencaoSalarial pretencaoSalarial =  new PretencaoSalarial();
    private Set<Habilidade> habilidades = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public PretencaoSalarial getPretencaoSalarial() {
        return pretencaoSalarial;
    }

    public Set<Habilidade> getHabilidades() {
        return habilidades;
    }
}
