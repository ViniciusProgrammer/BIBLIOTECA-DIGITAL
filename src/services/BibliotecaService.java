package services;

import entities.EmprestimoLivro;
import entities.Livro;
import entities.Usuario;
import exceptions.DadosInvalidosExceptions;
import exceptions.LivroIndisponivelException;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<EmprestimoLivro> livrosEmprestados = new ArrayList<>();
    private Livro livro;
    private Usuario usuario;

    public void cadastrarLivro(String titulo, String autor, String isbn, int quantidade) {
            Livro livro = new Livro(titulo, autor, isbn, quantidade);
            this.livros.add(livro);
    }

    public void cadastrarUsuario(String nome, String email, String telefone) {
        try {
            if (nome == null || nome.isBlank()) {
                throw new DadosInvalidosExceptions("O nome do usuário não pode ser nulo ou vázio");
            } else if (email == null || email.isBlank() || !email.contains("@")) {
                throw new DadosInvalidosExceptions("O email fornecido é inválido");
            } else if (telefone == null || telefone.isBlank()) {
                throw new DadosInvalidosExceptions("O telefone fornecido é inválido");
            }

            Usuario usuario = new Usuario(nome, email, telefone);
            this.usuarios.add(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }

    /*
    public EmprestimoLivro emprestarLivro(String isbn, String emailUsuario) {
        // FALTA A IMPLEMENTAÇÃO DA LÓGICA COMPLEXA AQUI
    }
    */

    public void pegarLivroEmprestado(String nomeDoLivro, int quantidadeCopiasSolicitadas) {
        try {
            if (!livro.getTitulo().equals(nomeDoLivro) || livro.getQuantidadeDisponivel() <= 0) {
                throw new LivroIndisponivelException("O livro solicitado está sem disponibilidade no momento");
            }

            for (Livro livro : livros) {
                if (livro.getTitulo().equals(nomeDoLivro)) {
                    // Precisa elaborar uma lógica para decrementar isso aqui
                    //   livro.getQuantidadeDisponivel() -= quantidadeCopiasSolicitadas;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean devolverLivro(String isbn, String emailUsuario, int quantidade) {
        boolean isbnEValido = false;
        boolean emailEValido = false;
        boolean quantidadeEValida = false;

        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                // Consertar o erro aqui
                //  livro.devolverLivro(quantidade);
                isbnEValido = true;
            }
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(emailUsuario)) {
                emailEValido = true;
            }
        }

        if (quantidade > 0) {
            quantidadeEValida = true;
        }

        if (isbnEValido && emailEValido && quantidadeEValida) {
            return true;
        }

        return false;
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }
    }

    public void listarEmprestimosAtivos() {
        for (EmprestimoLivro emprestimoLivro : livrosEmprestados) {
            System.out.println(emprestimoLivro);
        }
    }

    public Livro consultarDisponibilidadeDoLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.println("Livro " + livro.getTitulo() + " está disponível");
                System.out.println(livro.getQuantidadeDisponivel() + " cópias disponíveis");

                return livro;
            }
        }

        return null;
    }
}
