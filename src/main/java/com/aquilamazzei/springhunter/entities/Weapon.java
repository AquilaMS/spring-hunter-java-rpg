package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.utils.enums.QualityTypes;
import com.aquilamazzei.springhunter.utils.enums.WeaponType;
import com.aquilamazzei.springhunter.logics.Dice;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Weapon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WeaponType type;

    private String name;
    private Double damage;
    private Double spec_bonus;
    private Double rarity;

    @Enumerated(EnumType.STRING)
    private QualityTypes quality;

    public Weapon(WeaponType type, String name, Double damage, Double spec_bonus, Double rarity) {
        QualityTypes gotQuality = createQuality();
        this.type = type;
        this.name = name;
        this.damage = (damage + (damage * gotQuality.ordinal() * 0.15))+(Dice.rollD20()/10)*damage;
        this.spec_bonus = spec_bonus;
        this.quality = gotQuality;
        this.rarity = rarity;
    }

    public QualityTypes createQuality(){
        int diceRoll = Dice.rollD20();
        switch (diceRoll) {
            case 1 -> {return QualityTypes.TRASH;}
            case 20 -> {return QualityTypes.UNIQUE;}
        }

        if(diceRoll > 1 && diceRoll <= 5){return QualityTypes.COMMON;}
        if(diceRoll > 6 && diceRoll <= 10){return QualityTypes.RARE;}
        if(diceRoll > 11 && diceRoll <= 15){return QualityTypes.MASTERCRAFTED;}
        if(diceRoll > 16 && diceRoll <= 19){return QualityTypes.MAGIC;}

        return QualityTypes.COMMON;
    }

    public static Weapon selectItemFromList(List<Weapon> list, Double dice){
        Double sumRarity = 0.0;
        for(Weapon item : list){
            sumRarity += item.getRarity();
            if (dice <= sumRarity){
                return item;
            }
        }
        return list.get(0);
    }

    public static Double insertBonus(Hero hero){
        double bonus = 0.0;
        if (Dice.rollD20() <= hero.getLuck()){
            bonus = (hero.getLuck())/10;
        }
        return bonus;
    }
}
