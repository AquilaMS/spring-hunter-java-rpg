package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroClassRepository extends JpaRepository<HeroClass, Long> {
}
