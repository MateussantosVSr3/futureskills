package br.com.fiap.futureskills.model.entity;

import br.com.fiap.futureskills.model.dto.SkillDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "T_GS_SKILL")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nivel; // Ex: Básico, Avançado, Especialista
    private String descricao;

    public Skill() {}

    public Skill(SkillDTO dto) {
        this.nome = dto.nome();
        this.nivel = dto.nivel();
        this.descricao = dto.descricao();
    }

    // Getters e Setters (gere na IDE: Alt+Insert)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}