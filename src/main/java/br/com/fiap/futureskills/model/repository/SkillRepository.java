package br.com.fiap.futureskills.model.repository;

import br.com.fiap.futureskills.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}