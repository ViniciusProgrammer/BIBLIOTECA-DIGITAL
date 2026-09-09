package entities;

import exceptions.DadosInvalidosExceptions;
import exceptions.IsbnException;
import exceptions.LivroIndisponivelException;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidadeDisponivel;
    private int quantidadeTotalDoExemplarCadastrado;

    public Livro(String titulo, String autor, String isbn, int quantidadeDisponivel) {
        try {
            if (titulo == null || titulo.isBlank()) {
                throw new DadosInvalidosExceptions("O título não pode ser nulo ou vazio");
            }

            if (autor == null || autor.isBlank()) {
                throw new DadosInvalidosExceptions("O autor não pode ser nulo ou vazio");
            }

            if (isbn == null || isbn.isBlank() || isbn.length() < 13) {
                throw new DadosInvalidosExceptions("A ISBN não pode ser nulo, vazio ou menos de 13 caracteres");
            }

            if (quantidadeDisponivel <= 0) {
                throw new IllegalArgumentException("A quantidade não pode ser negativa ou zero");
            }

            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.quantidadeDisponivel = quantidadeDisponivel;
        } catch (DadosInvalidosExceptions | IllegalArgumentException e) {
            System.out.println(e.getMessage());
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

    public boolean temDisponibilidade() {
        if (quantidadeDisponivel <= quantidadeTotalDoExemplarCadastrado) {
            return true;
        }

        return false;
    }

    public void adicionarExemplar(int quantidadeAAdicionar) {
        quantidadeDisponivel += quantidadeAAdicionar;
    }

    public void removerExemplar(int quantidadeARemover) {
        try {
            if (quantidadeARemover > quantidadeDisponivel) {
                throw new LivroIndisponivelException("A quantidade indisponivel no momento");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
