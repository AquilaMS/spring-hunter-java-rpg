package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import com.aquilamazzei.springhunter.utils.enums.WeaponType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Hero extends Peon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Player player;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "heroclass_id")
    private HeroClass heroClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    private Double luck;

    public Hero(Player player, HeroClass heroClass, String name) {
        this.player = player;
        this.heroClass = heroClass;
        this.luck = heroClass.getLuck();

        setLife(heroClass.getLife());
        setDamage(heroClass.getDamage());
        setDefense(heroClass.getDefense());
        setName(name);
    }

    public void equipWeapon(Weapon weapon){
        ClassNames ownerClass = this.getHeroClass().getClassName();
        Double luckBonus = Weapon.insertBonus(weapon, this);
        Double newWeaponDamage = (weapon.getDamage()) + (weapon.getDamage() * luckBonus);

        Double specBonus = Weapon.insertBonus(weapon, this);

        if(ownerClass == ClassNames.BARBARIAN && weapon.getType() == WeaponType.AXE) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.SOLDIER && weapon.getType() == WeaponType.SWORD) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.BASTION && weapon.getType() == WeaponType.SHIELD) {newWeaponDamage += specBonus;}
        else if(ownerClass == ClassNames.TREASURE_HUNTER && weapon.getType() == WeaponType.PISTOL) {newWeaponDamage += specBonus;}

        if(ownerClass == ClassNames.SCRAPPER) {newWeaponDamage += specBonus * 0.8;}
        if(newWeaponDamage > getDamage()) {setDamage(newWeaponDamage);}

        setWeapon(weapon);
        System.out.println(getWeapon());
    }

    public void passLevel(){
        setLevel(getLevel() + 1);
        setLife(getLife() + 50);
        setDamage(getDamage() + 1.0);
        setDefense(getDefense() + 1.0);

        ClassNames ownerClass = getHeroClass().getClassName();
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
