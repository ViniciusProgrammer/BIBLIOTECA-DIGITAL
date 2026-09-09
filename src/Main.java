import entities.Livro;
import entities.Usuario;
import exceptions.DadosInvalidosExceptions;
import services.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        Usuario usuario1 = new Usuario("Beatriz", "beatriz@gmail.com", "11111-1111");

        try {
            bibliotecaService.cadastrarLivro("Java como programar", "Deitel", "9788543004792", 3);
        } catch (DadosInvalidosExceptions e) {
            throw new RuntimeException(e);
        }

        bibliotecaService.cadastrarUsuario(new Usuario("João Silva", "joao@email.com", "9999-9999"));
        bibliotecaService.cadastrarUsuario("Ana", "ana@gmail.com", "2222-2222");
        bibliotecaService.cadastrarUsuario(usuario1);

        bibliotecaService.listarUsuarios();

        bibliotecaService.listarLivrosDisponiveis();

        Livro livro = null;

        try {
            livro = new Livro("Harry Potter", "Alvaro Menezes", "3215123465475", 2);
        } catch (DadosInvalidosExceptions e) {
            throw new RuntimeException(e);
        }

        System.out.println(livro);
    }
}
