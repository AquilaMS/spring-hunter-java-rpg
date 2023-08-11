package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.repositories.HeroRepository;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import com.aquilamazzei.springhunter.utils.enums.WeaponType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Hero extends Peon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Player player;

    @OneToOne(cascade = CascadeType.ALL)
    private HeroProfession heroProfession;

    @OneToOne(cascade = CascadeType.ALL)
    private Weapon weapon;

    private Double luck;
    private Boolean isAlive;
    private Integer gold;

    public Hero(Player player, HeroProfession heroProfession, String name) {
        isAlive = true;
        gold = 0;

        this.player = player;
        this.heroProfession = heroProfession;
        this.luck = heroProfession.getLuck();

        setPeonName(name);
        setLife(heroProfession.getLife());
        setDamage(heroProfession.getDamage());
        setDefense(heroProfession.getDefense());
    }

    public void equipWeapon(Weapon weapon){
        ClassNames ownerClass = this.getHeroProfession().getClassName();
        Double luckBonus = Weapon.insertBonus(this);
        Double newWeaponDamage = (weapon.getDamage()) + (weapon.getDamage() * luckBonus);

        Double specBonus = Weapon.insertBonus(this);

        if(ownerClass == ClassNames.BARBARIAN && weapon.getType() == WeaponType.AXE) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.SOLDIER && weapon.getType() == WeaponType.SWORD) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.BASTION && weapon.getType() == WeaponType.SHIELD) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.TREASURE_HUNTER && weapon.getType() == WeaponType.PISTOL) {newWeaponDamage += specBonus;}

        if(ownerClass == ClassNames.SCRAPPER) {newWeaponDamage += specBonus * 0.8;}
        if(newWeaponDamage > getDamage()) {setDamage(newWeaponDamage); setWeapon(weapon);}
    }

    public void passLevel(){
        setLevel(getLevel() + 1);
        setLife(getLife() + 50);
        setDamage(getDamage() + 1.0);
        setDefense(getDefense() + 1.0);

        ClassNames ownerClass = getHeroProfession().getClassName();
        switch (ownerClass){
            case BARBARIAN -> setLife(getLife() + (getLife() * 0.05));
            case SOLDIER -> setLife(getDamage() + (getDamage() * 0.05));
            case BASTION -> setLife(getDefense() + (getDefense() * 0.07));
            case TREASURE_HUNTER -> {
                setLife(getLife() + (getLife() * 0.035));
                setDamage(getDamage() + (getDamage() * 0.035));}
            case SCRAPPER -> {
                setLife(getLife() + (getLife() * 0.03));
                setDefense(getDefense() + (getDefense() * 0.03));
                setDamage(getDamage() + (getDamage() * 0.03));
            }
        }
    }

    public void giveExp(Double exp) {
        Double needToNextLevel = 100 + (getLevel() * 50.0);
        setExperience(getExperience() + exp);
        if (getExperience() >= needToNextLevel) {
            passLevel();
            setExperience(getExperience() - needToNextLevel);
        }
    }
}
