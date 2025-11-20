package br.com.fiap.futureskills.controller;

import br.com.fiap.futureskills.model.dto.SkillDTO;
import br.com.fiap.futureskills.model.entity.Skill;
import br.com.fiap.futureskills.model.repository.SkillRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillRepository repository;

    // GET - Listar
    @GetMapping
    public ModelAndView listar() {
        List<Skill> skills = repository.findAll();
        ModelAndView mv = new ModelAndView("lista-skills");
        mv.addObject("skills", skills);
        return mv;
    }

    // GET - Tela de Cadastro
    @GetMapping("/novo")
    public ModelAndView novo() {
        return new ModelAndView("formulario-skill").addObject("skillDTO", new SkillDTO("", "", ""));
    }

    // POST - Salvar
    @PostMapping("/salvar")
    public String salvar(@Valid SkillDTO skillDTO, BindingResult result) {
        if (result.hasErrors()) return "formulario-skill";
        repository.save(new Skill(skillDTO));
        return "redirect:/skills";
    }

    // GET - Tela de Edição
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        Skill skill = repository.findById(id).orElseThrow();
        SkillDTO dto = new SkillDTO(skill.getNome(), skill.getNivel(), skill.getDescricao());
        ModelAndView mv = new ModelAndView("formulario-skill");
        mv.addObject("skillDTO", dto);
        mv.addObject("id", id);
        return mv;
    }

    // POST - Atualizar (Simulando PUT via form HTML)
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid SkillDTO skillDTO, BindingResult result) {
        if (result.hasErrors()) return "formulario-skill";
        Skill skill = new Skill(skillDTO);
        skill.setId(id);
        repository.save(skill);
        return "redirect:/skills";
    }

    // GET - Excluir (Simulando DELETE via link)
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/skills";
    }
}