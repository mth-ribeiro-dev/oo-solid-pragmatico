package org.livraria.domain;

public class Livro {

    private final String ISBN;
    private String titulo;
    private Integer numeroPaginas;
    private boolean emprestado = false;


    public Livro(String ISBN, String titulo, Integer numeroPaginas){

        if (ISBN == null || ISBN.length() != 13) {
            throw new IllegalArgumentException("O código ISBN deve ter exatamente 13 caracteres.");
        }
        this.ISBN = ISBN;

        if (numeroPaginas == null || numeroPaginas < 1) {
            throw new IllegalArgumentException("Número de páginas não pode ser menos que 1");
        }
        this.numeroPaginas = numeroPaginas;

        if (titulo == null || titulo.length() <= 1) {
            throw new IllegalArgumentException("O título deve ter pelo menos 2 ou mais caracteres.");
        }
        this.titulo = titulo;

        emprestado = false;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.length() <= 1) {
            throw new IllegalArgumentException("O título deve ter pelo menos 2 ou mais caracteres.");
        }
        this.titulo = titulo;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        if (numeroPaginas == null || numeroPaginas < 1) {
            throw new IllegalArgumentException("Número de páginas não pode ser menos que 1");
        }
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar(){
        if (emprestado){
            throw new IllegalArgumentException("Livro já emprestado");
        }
        this.emprestado = true;
    }

    public void devolver(){
        this.emprestado = false;
    }
}
