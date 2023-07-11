package br.com.alura.screenmatch.domain.filme;

/*
    Representa uma classe imutável (atributos, construtor e métodos de leitura)
 */
public record FilmeUpdateDTO(Long id, String nome, Integer duracao, Integer lancamento, String genero) {
}
