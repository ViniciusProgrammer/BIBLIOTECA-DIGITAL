package exceptions;

public class LivroIndisponivelException extends Exception {
    public LivroIndisponivelException(String message) {
        super(message); // se o livro não está disponivel
    }
}
