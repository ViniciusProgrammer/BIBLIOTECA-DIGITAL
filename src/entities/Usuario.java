package entities;

import exceptions.DadosInvalidosExceptions;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private double multa;
    private int quantidadeLivrosPegouEmprestado;

    public Usuario(String nome, String email, String telefone) {
        if (validarNome(nome)) {
            this.nome = nome;
        }

        if (validarEmail(email)) {
            this.email = email;
        }

        if (validarTelefone(telefone)) {
            this.telefone = telefone;
        }
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

//    public boolean podePegarLivro(int quantidadeSolicitada) {
//        //retorna true se tiver menos de 3 empréstimos ativos e multa < 10
//    }

    public void adicionarMulta() {

    }

    public void pagarMulta() {

    }

    private boolean validarNome(String nome) {
        try {
            if (nome == null || nome.isBlank()) {
                throw new DadosInvalidosExceptions("Nome do usuário não pode ser nulo ou vázio");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validarEmail(String email) {
        try {
            if (email == null || email.isBlank() || !email.contains("@")) {
                throw new DadosInvalidosExceptions("O email precisa ser válido");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validarTelefone(String telefone) {
        try {
            if (telefone == null || telefone.isBlank()) {
                throw new DadosInvalidosExceptions("O telefone não é válido");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
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
