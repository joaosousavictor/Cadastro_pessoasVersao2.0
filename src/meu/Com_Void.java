
package meu;

import javax.swing.JOptionPane;

public class Com_Void {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema de cadastro de pessoas!");

        while (true) {
            // Menu principal
            String opcao = JOptionPane.showInputDialog(
                    null, 
                    "Menu:\n1. Cadastrar\n2. Listar\n3. Pesquisar\n4. Alterar\n5. Excluir\n6. Gravar\n7. Sair\nEscolha uma opção:",
                    "Menu", 
                    JOptionPane.QUESTION_MESSAGE
            );

            switch (opcao) {
                case "1":
                    // Cadastrar pessoa
                    String nome = JOptionPane.showInputDialog(null, "Nome:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    String sobrenome = JOptionPane.showInputDialog(null, "Sobrenome:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    String genero = JOptionPane.showInputDialog(null, "Gênero:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    String dataNascimento = JOptionPane.showInputDialog(null, "Data de nascimento (dd/MM/yyyy):", "Cadastro", JOptionPane.QUESTION_MESSAGE);

                    cadastro.cadastrarPessoa(nome, sobrenome, genero, dataNascimento);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

                    // Pergunta se deseja gravar os dados
                    int respostaGravar = JOptionPane.showConfirmDialog(null, "Deseja gravar os dados?", "Gravar", JOptionPane.YES_NO_OPTION);
                    if (respostaGravar == JOptionPane.YES_OPTION) {
                        cadastro.gravarDados();
                    } else {
                        JOptionPane.showMessageDialog(null, "Os dados não foram gravados.");
                    }

                    // Pergunta se deseja voltar ao menu
                    if (!perguntaVoltarMenu()) {
                        JOptionPane.showMessageDialog(null, "Saindo do programa. Dados salvos.");
                        cadastro.gravarDados();
                        return;
                    }
                    break;

                case "2":
                    // Listar pessoas
                    listarPessoas(cadastro);
                    if (!perguntaVoltarMenu()) {
                        JOptionPane.showMessageDialog(null, "Saindo do programa. Dados salvos.");
                        cadastro.gravarDados();
                        return;
                    }
                    break;

                case "3":
                    // Pesquisar pessoa
                    String idPesquisaStr = JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser pesquisada:", "Pesquisar", JOptionPane.QUESTION_MESSAGE);
                    int idPesquisa = Integer.parseInt(idPesquisaStr);

                    Pessoa pessoaEncontrada = cadastro.pesquisar(idPesquisa);
                    if (pessoaEncontrada != null) {
                        JOptionPane.showMessageDialog(null, "Pessoa encontrada: " + pessoaEncontrada.getNome() + " " + pessoaEncontrada.getSobrenome());
                    } else {
                        JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
                    }
                    break;

                case "4":
                    // Alterar pessoa
                    String idAlterarStr = JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser alterada:", "Alterar", JOptionPane.QUESTION_MESSAGE);
                    int idAlterar = Integer.parseInt(idAlterarStr);

                    String novoNome = JOptionPane.showInputDialog(null, "Novo Nome:", "Alterar", JOptionPane.QUESTION_MESSAGE);
                    String novoSobrenome = JOptionPane.showInputDialog(null, "Novo Sobrenome:", "Alterar", JOptionPane.QUESTION_MESSAGE);
                    String novoGenero = JOptionPane.showInputDialog(null, "Novo Gênero:", "Alterar", JOptionPane.QUESTION_MESSAGE);
                    String novaDataNascimento = JOptionPane.showInputDialog(null, "Nova Data de nascimento (dd/MM/yyyy):", "Alterar", JOptionPane.QUESTION_MESSAGE);

                    cadastro.alterar(idAlterar, novoNome, novoSobrenome, novoGenero, novaDataNascimento);
                    break;

                case "5":
                    // Excluir pessoa
                    String idExcluirStr = JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser excluída:", "Excluir", JOptionPane.QUESTION_MESSAGE);
                    int idExcluir = Integer.parseInt(idExcluirStr);
                    cadastro.excluir(idExcluir);
                    break;

                case "6":
                    // Gravar dados
                    cadastro.gravarDados();
                    JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
                    break;

                case "7":
                    // Sair
                    cadastro.gravarDados();
                    JOptionPane.showMessageDialog(null, "Saindo do programa. Dados salvos.");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    // Método para listar pessoas cadastradas
    private static void listarPessoas(Cadastro cadastro) {
        StringBuilder lista = new StringBuilder("Lista de Pessoas:\n");
        for (Pessoa p : cadastro.listar()) {
            lista.append("ID: ").append(p.getId())
                    .append(", Nome: ").append(p.getNome()).append(" ").append(p.getSobrenome())
                    .append(", Gênero: ").append(p.getGenero())
                    .append(", Data de Nascimento: ").append(p.getDataNascimento())
                    .append(", Idade: ").append(p.getIdade())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para perguntar se o usuário quer voltar ao menu
    private static boolean perguntaVoltarMenu() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja voltar ao menu de opções?", "Voltar ao Menu", JOptionPane.YES_NO_OPTION);
        return resposta == JOptionPane.YES_OPTION;
    }
}
