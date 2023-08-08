package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.utils.Choices;
import com.aquilamazzei.springhunter.utils.enums.ChoicesOptions;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@NoArgsConstructor
public class HeroClass {
    /*
    *  heroClassesList.add(new HeroClass(ClassNames.BARBARIAN,150.0,3.0, 2.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.SOLDIER,120.0,4.0, 4.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.BASTION,110.0,3.0, 7.0, 1.0));
        heroClassesList.add(new HeroClass(ClassNames.TREASURE_HUNTER,90.0,3.0, 4.0, 3.0));
        heroClassesList.add(new HeroClass(ClassNames.SCRAPPER,100.0,3.0, 3.0, 2.0));
        * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private ClassNames className;
    private Double life;
    private Double damage;
    private Double defense;
    private Double luck;

    public HeroClass(ClassNames className) {
        this.className = className;

        switch (className){
            case BARBARIAN -> {
                this.life = 150.0;
                this.damage = 3.0;
                this.defense = 2.0;
                this.luck = 1.0;
            }
            case SOLDIER -> {
                this.life = 120.0;
                this.damage = 4.0;
                this.defense = 4.0;
                this.luck = 1.0;
            }
            case BASTION -> {
                this.life = 110.0;
                this.damage = 3.0;
                this.defense = 7.0;
                this.luck = 1.0;
            }
            case TREASURE_HUNTER -> {
                this.life = 90.0;
                this.damage = 3.0;
                this.defense = 4.0;
                this.luck = 3.0;
            }
            case SCRAPPER -> {
                this.life = 110.0;
                this.damage = 3.0;
                this.defense = 3.0;
                this.luck = 2.0;}
        }
    }
}
