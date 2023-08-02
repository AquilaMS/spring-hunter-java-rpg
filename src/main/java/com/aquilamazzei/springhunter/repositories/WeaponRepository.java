package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
