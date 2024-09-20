package meu;

import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    private List<Pessoa> pessoas;
    private int contadorId = 1; // Para gerar IDs únicos

    public Cadastro() {
        pessoas = new ArrayList<>();
    }

    // Método para cadastrar uma pessoa
    public void cadastrarPessoa(String nome, String sobrenome, String genero, String dataNascimento) {
        Pessoa novaPessoa = new Pessoa(contadorId++, nome, sobrenome, genero, dataNascimento);
        pessoas.add(novaPessoa);
    } 

    // Método para listar todas as pessoas
    public List<Pessoa> listar() {
        return pessoas;
    }

    // Método para pesquisar uma pessoa pelo ID
    public Pessoa pesquisar(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; // Retorna null se não encontrar a pessoa
    }

    // Método para alterar os dados de uma pessoa
    public void alterar(int id, String novoNome, String novoSobrenome, String novoGenero, String novaDataNascimento) {
        Pessoa pessoa = pesquisar(id);
        if (pessoa != null) {
            pessoa.setNome(novoNome);
            pessoa.setSobrenome(novoSobrenome);
            pessoa.setGenero(novoGenero);
            pessoa.setDataNascimento(novaDataNascimento);
        }
    }

    // Método para excluir uma pessoa pelo ID
    public void excluir(int id) {
        Pessoa pessoa = pesquisar(id);
        if (pessoa != null) {
            pessoas.remove(pessoa);
        }
    }

    // Método para gravar os dados (neste exemplo, apenas uma simulação)
    public void gravarDados() {
        // Simulação de gravação (neste caso, os dados já estão na memória)
        System.out.println("Dados gravados com sucesso!");
    }
}
