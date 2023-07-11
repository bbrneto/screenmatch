package br.com.alura.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer duracao;

    @Column(name = "ano_lancamento")
    private Integer lancamento;

    private String genero;

    public Filme() {
    }

    public Filme(FilmeSaveDTO dto) {
        this.nome = dto.nome();
        this.duracao = dto.duracao();
        this.lancamento = dto.lancamento();
        this.genero = dto.genero();
    }

    public void atualiza(FilmeUpdateDTO dto) {
        this.nome = dto.nome();
        this.duracao = dto.duracao();
        this.lancamento = dto.lancamento();
        this.genero = dto.genero();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getLancamento() {
        return lancamento;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", lancamento=" + lancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

}
