package entities;

import exceptions.DadosInvalidosExceptions;
import exceptions.UsuarioBloqueadoException;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nome;
    private final String email;
    private final String telefone;
    private double multa;
    private final List<EmprestimoLivro> livrosPegosImprestadosAtivo = new ArrayList<>(3);

    public Usuario(String nome, String email, String telefone) throws DadosInvalidosExceptions {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosExceptions("O nome não pode ser nulo ou vazio");
        }

        if (email == null || email.isBlank()) {
            throw new DadosInvalidosExceptions("O email não pode ser nulo ou vazio");
        }

        if (telefone == null || telefone.isBlank()) {
            throw new DadosInvalidosExceptions("O telefone não pode ser nulo ou vazio");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void podePegarLivro(Livro livro, Usuario usuario) {
        try {
            this.livrosPegosImprestadosAtivo.add(new EmprestimoLivro(livro, usuario));

            if (this.livrosPegosImprestadosAtivo.size() > 3 && multa > 10.0) {
                throw new UsuarioBloqueadoException("O usuário não pode pegar livro no momento");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionarMulta() {

    }

    public void pagarMulta() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
