package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class HeroProfession implements Serializable {
    /*
    *  heroClassesList.add(new HeroClass(ClassNames.BARBARIAN,150.0,3.0, 2.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.SOLDIER,120.0,4.0, 4.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.BASTION,110.0,3.0, 7.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.TREASURE_HUNTER,90.0,3.0, 4.0, 3.0));
        heroClassesList.add(new HeroClass(ClassNames.SCRAPPER,100.0,3.0, 3.0, 2.0));
        * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ClassNames className;
    private Double life;
    private Double damage;
    private Double defense;
    private Double luck;

    public HeroProfession(ClassNames className) {
        this.className = className;

        switch (className){
            case BARBARIAN -> {
                this.life = 170.0;
                this.damage = 4.0;
                this.defense = 3.0;
                this.luck = 1.0;
            }
            case SOLDIER -> {
                this.life = 140.0;
                this.damage = 5.0;
                this.defense = 5.0;
                this.luck = 1.0;
            }
            case BASTION -> {
                this.life = 130.0;
                this.damage = 4.0;
                this.defense = 8.0;
                this.luck = 1.0;
            }
            case TREASURE_HUNTER -> {
                this.life = 110.0;
                this.damage = 4.0;
                this.defense = 3.0;
                this.luck = 3.0;
            }
            case SCRAPPER -> {
                this.life = 130.0;
                this.damage = 4.0;
                this.defense = 4.0;
                this.luck = 2.0;}
        }
    }
}
