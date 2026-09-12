package entities;

import exceptions.DadosInvalidosExceptions;
import exceptions.IsbnException;
import exceptions.LivroIndisponivelException;
import exceptions.QuantidadeInvalidaException;

public class Livro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private int quantidadeDisponivel;
    private int quantidadeTotalDoExemplarCadastrado;

    public Livro(String titulo, String autor, String isbn, int quantidadeDisponivel) throws DadosInvalidosExceptions {
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
            throw new QuantidadeInvalidaException("A quantidade não pode ser negativa ou zero");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeTotalDoExemplarCadastrado += quantidadeDisponivel;
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

    public boolean temDisponibilidade() {
        if (getQuantidadeDisponivel() > 0) {
            return true;
        }

        return false;
    }

    public void adicionarExemplar(int quantidadeAAdicionar) {
        quantidadeDisponivel += quantidadeAAdicionar;
        quantidadeTotalDoExemplarCadastrado += quantidadeAAdicionar;
    }

    public void removerExemplar(int quantidadeARemover) {
        try {
            if (quantidadeARemover <= quantidadeDisponivel) {
                quantidadeDisponivel -= quantidadeARemover;
            } else {
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
