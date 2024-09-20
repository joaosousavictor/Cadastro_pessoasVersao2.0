package meu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private String genero;
    private String dataNascimento;

    // Formato da data
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtor
    public Pessoa(int id, String nome, String sobrenome, String genero, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para calcular a idade
    public int getIdade() {
        LocalDate dataNasc = LocalDate.parse(dataNascimento, formatter);
        return (int) ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
    }

    // Método toString para salvar os dados no formato texto
    @Override
    public String toString() {
        return id + ";" + nome + ";" + sobrenome + ";" + genero + ";" + dataNascimento + ";" + getIdade();
    }
}
