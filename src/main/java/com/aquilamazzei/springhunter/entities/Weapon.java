package com.aquilamazzei.springhunter.entities;

import com.aquilamazzei.springhunter.consts.QualityTypes;
import com.aquilamazzei.springhunter.consts.WeaponType;
import com.aquilamazzei.springhunter.logics.Dice;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NonNull private WeaponType type;

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
        System.out.println("got quality " + gotQuality.ordinal());
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
                System.out.println(item.getQuality().ordinal());
                return item;
            }
        }

        return list.get(0);
    }

    public void luckUpgrade(Hero hero){

    }
}
