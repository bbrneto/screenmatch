package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeSaveDTO;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import br.com.alura.screenmatch.domain.filme.FilmeUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/form")
    public String form(Long id, Model model) {
        if (id != null) {
            Filme filme = repository.getReferenceById(id);

            model.addAttribute("filme", filme);
        }

        return "filmes/form";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", repository.findAll());

        return "filmes/list";
    }

    @PostMapping
    @Transactional
    public String save(FilmeSaveDTO dto) {
        var filme = new Filme(dto);

        repository.save(filme);

        return "redirect:/filmes";// Executa o metodo list()
    }

    @PutMapping
    @Transactional
    public String update(FilmeUpdateDTO dto) {
        Filme filme = repository.getReferenceById(dto.id());
        filme.atualiza(dto);

        return "redirect:/filmes";// Executa o metodo list()
    }

    @DeleteMapping
    @Transactional
    public String remove(Long id) {
        repository.deleteById(id);

        return "redirect:/filmes";
    }

}
