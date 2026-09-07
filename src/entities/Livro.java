package entities;

import exceptions.DadosInvalidosExceptions;
import exceptions.IsbnException;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, String isbn, int quantidadeDisponivel) {
        if (validarTitulo(titulo)) {
            this.titulo = titulo;
        }

        if (validarAutor(autor)) {
            this.autor = autor;
        }

        if (validarIsbn(isbn)) {
            this.isbn = isbn;
        }

        if (validarQuantidade(quantidadeDisponivel)) {
            this.quantidadeDisponivel = quantidadeDisponivel;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void devolverLivro(int quantidade) {
        this.quantidadeDisponivel += quantidade;
    }

    public boolean validarIsbn(String isbn) {
        try {
            if (isbn == null || isbn.isBlank()) {
                throw new DadosInvalidosExceptions("A ISBN não pode ser nula ou vazia");
            } else if (isbn.length() < 13) {
                throw new IsbnException("A quantidade de dígitos da ISBN precisa conter 13 dígitos");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public boolean validarTitulo(String titulo) {
        try {
            if (titulo == null || titulo.isBlank()) {
                throw new DadosInvalidosExceptions("O título do livro não pode ser nulo ou vazio");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validarAutor(String autor) {
        try {
            if (autor == null || autor.isBlank()) {
                throw new DadosInvalidosExceptions("O autor do livro não pode ser nulo ou vazio");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validarQuantidade(int quantidade) {
        try {
            if (quantidade <= 0) {
                throw new DadosInvalidosExceptions("A quantidade não pode ser 0 ou negativa");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }
}
