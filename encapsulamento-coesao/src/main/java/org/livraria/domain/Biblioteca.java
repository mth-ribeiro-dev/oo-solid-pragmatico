package org.livraria.domain;

import java.util.List;

public class Biblioteca {

    private List<Livro> livros;

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
        System.out.println("Criação da biblioteca feita com sucesso");
    }

    public void addLivro(Livro livro){
        if(livro == null){
            throw new IllegalArgumentException("Livro não pode ser vazio");
        }

        for(Livro livroBiblioteca : livros){
            if (livroBiblioteca.getISBN().equals(livro.getISBN())){
                throw new IllegalArgumentException("Livro já adicionado na biblioteca.");
            }
        }

        livros.add(livro);
        System.out.println("Livro adicionado com sucesso");
    }

    public boolean emprestaLivro(String isbn){
        for (Livro livroBiblioteca : livros){
            if(livroBiblioteca.getISBN().equals(isbn) && !livroBiblioteca.isEmprestado()){
                livroBiblioteca.emprestar();
                System.out.println("Livro ISBN: "+isbn+" emprestado com sucesso");
                return true;
            }
        }
        System.out.println("Livro ISBN: "+isbn+" já está emprestado");
        return false;
    }

    public boolean devolverLivro(String isbn){
        for (Livro livroBiblioteca : livros){
            if(livroBiblioteca.getISBN().equals(isbn) && livroBiblioteca.isEmprestado()){
                livroBiblioteca.devolver();
                System.out.println("Livro ISBN: "+isbn+" devolvido com sucesso");
                return true;
            }
        }
        return false;
    }

    public Livro buscarLivro(String isbn) {
        for (Livro livroBiblioteca : livros) {
            if (livroBiblioteca.getISBN().equals(isbn)){
                return livroBiblioteca;
            }
        }
        return null;
    }
}
