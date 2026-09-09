package services;

import entities.EmprestimoLivro;
import entities.Livro;
import entities.Usuario;
import exceptions.DadosInvalidosExceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<EmprestimoLivro> livrosEmprestados = new ArrayList<>();

    public void cadastrarLivro(String titulo, String autor, String isbn, int quantidade) throws DadosInvalidosExceptions {
        Livro livro = new Livro(titulo, autor, isbn, quantidade);
        this.livros.add(livro);
    }

    public void cadastrarUsuario(String nome, String email, String telefone) {
        Usuario usuario = new Usuario(nome, email, telefone);
        this.usuarios.add(usuario);
    }

    public void cadastrarUsuario(Usuario usuario) {
        cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }

    public EmprestimoLivro emprestarLivro(String tituloLivro, String emailUsuario, int quantidadePegarEmprestado) {
        boolean temLivroDisponivel = false;
        boolean usuarioExiste = false;
        Livro livroRetornado = null;
        Usuario usuarioRetornado = null;

        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloLivro)) {
                if (livro.getQuantidadeDisponivel() > 0 && livro.getQuantidadeDisponivel() <= quantidadePegarEmprestado) {
                    livro.removerExemplar(quantidadePegarEmprestado);
                    livroRetornado = livro;
                    temLivroDisponivel = true;
                }
            }
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(emailUsuario)) {
                usuarioRetornado = usuario;
                usuarioExiste = true;
            }
        }

        return new EmprestimoLivro(livroRetornado, usuarioRetornado, emailUsuario);
    }

    /*
    public EmprestimoLivro devolverLivro(String isbn, String emailUsuario, int quantidadeDevolvida, LocalDate dataDevolucao) {

    }
    */

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
