package exceptions;

public class DadosInvalidosExceptions extends Exception {
    public DadosInvalidosExceptions(String message) {
        super(message); // para erros de validação dos atriburos
    }
}
