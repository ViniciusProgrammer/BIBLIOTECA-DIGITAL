package entities;

import java.time.LocalDate;

public class EmprestimoLivro {
    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private double multaAplicada;

    public EmprestimoLivro(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(7);
    }

//    public void calcularMulta() {
//        dataDevolucaoReal = livro.
//        if (dataDevolucaoReal.isAfter(dataDevolucaoPrevista)) {
//            // logica para aplicar multa
//        }
//    }


    @Override
    public String toString() {
        return "EmprestimoLivro{" +
                "livro=" + livro +
                ", usuario=" + usuario +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolucaoReal=" + dataDevolucaoReal +
                ", multaAplicada=" + multaAplicada +
                '}';
    }
}
