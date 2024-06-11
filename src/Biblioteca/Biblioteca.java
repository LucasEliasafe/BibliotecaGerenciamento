package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(String titulo) {
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void emprestarLivro(String titulo, String emailUsuario) {
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo) && !l.isEmprestado())
                .findFirst()
                .orElse(null);

        if (livro == null) {
            System.out.println("Livro não disponível ou não encontrado.");
            return;
        }

        Usuario usuario = usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(emailUsuario))
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        livro.setEmprestado(true);
        System.out.println("Livro " + titulo + " emprestado para " + usuario.getNome());
    }

    public void devolverLivro(String titulo) {
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo) && l.isEmprestado())
                .findFirst()
                .orElse(null);

        if (livro == null) {
            System.out.println("Livro não encontrado ou não está emprestado.");
            return;
        }

        livro.setEmprestado(false);
        System.out.println("Livro " + titulo + " devolvido.");
    }
}
