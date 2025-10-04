package org.livraria;

import org.livraria.domain.Biblioteca;
import org.livraria.domain.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema exemplo de tarefa sobre encapsulamento e coesão.");

        //Criação de lista para livros;
        List<Livro> livros = new ArrayList<Livro>();

        //Criação de livros para serem adicionado a biblioteca posteriormente.
        livros = criacaoLivros(livros);

        //Livro auxiliar que vai ajudar nos testes
        Livro livroAux = new Livro("9788536304113", "Padrões de Projeto em Java", 407);

        //Adicionando livros na biblioteca
        Biblioteca biblioteca = new Biblioteca(livros);

        //Adiciona um novo livro a biblioteca
        biblioteca.addLivro(livroAux);

        //Empresa dois livros da biblioteca e testa também quando um livro já está emprestado.
        biblioteca.emprestaLivro("9780134685991");
        biblioteca.emprestaLivro("9788536304113");
        biblioteca.emprestaLivro("9780134685991");

        //Devolve o dois livros emprestados anteriormente.
        biblioteca.devolverLivro("9780134685991");
        biblioteca.devolverLivro("9788536304113");

        //Busca um livro da biblioteca e mostra seu título
        Livro livroBuscado = biblioteca.buscarLivro("9781265058432");
        System.out.println(livroBuscado.getTitulo());

    }

    private static List<Livro> criacaoLivros(List<Livro> livros) {
        Livro livro1 = new Livro("9780134685991", "Effective Java, 3ª edição", 412);
        Livro livro2 = new Livro("9781265058432", "Java: The Complete Reference, 13ª edição", 1280);
        Livro livro3 = new Livro("9780321349606", "Java Concurrency in Practice", 432);
        Collections.addAll(livros, livro1, livro2, livro3);
        return livros;
    }
}