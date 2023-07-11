package br.com.alura.screenmatch.domain.filme;

/*
    Representa uma classe imutável (atributos, construtor e métodos de leitura)
 */
public record FilmeSaveDTO(String nome, Integer duracao, Integer lancamento, String genero) {
}
