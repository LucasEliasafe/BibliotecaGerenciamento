package Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Cadastrar Usuário");
            System.out.println("5. Listar Usuários");
            System.out.println("6. Emprestar Livro");
            System.out.println("7. Devolver Livro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    Livro livro = new Livro(titulo, autor);
                    biblioteca.adicionarLivro(livro);
                    break;
                case 2:
                    System.out.print("Digite o título do livro a ser removido: ");
                    titulo = scanner.nextLine();
                    biblioteca.removerLivro(titulo);
                    break;
                case 3:
                    biblioteca.listarLivros();
                    break;
                case 4:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, email);
                    biblioteca.cadastrarUsuario(usuario);
                    break;
                case 5:
                    biblioteca.listarUsuarios();
                    break;
                case 6:
                    System.out.print("Digite o título do livro: ");
                    titulo = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    email = scanner.nextLine();
                    biblioteca.emprestarLivro(titulo, email);
                    break;
                case 7:
                    System.out.print("Digite o título do livro: ");
                    titulo = scanner.nextLine();
                    biblioteca.devolverLivro(titulo);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}