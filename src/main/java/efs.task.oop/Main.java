package efs.task.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Villager v1 = new Villager("Kashya", 30);
        Villager v2 = new Villager("Akara", 40);
        Villager v3 = new Villager("Gheed", 50);
        Villager v4 = new Villager("Deckard Cain", 85);
        Villager v5 = new Villager("Warriv", 35);
        Villager v6 = new Villager("Flawia", 25);
        v1.sayHello();
        v2.sayHello();
        v3.sayHello();
        v4.sayHello();
        v5.sayHello();
        v6.sayHello();
        ExtraordinaryVillager ev1 = new ExtraordinaryVillager(v4.getName(), v4.getAge(), ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager ev2 = new ExtraordinaryVillager(v2.getName(), v2.getAge(), ExtraordinaryVillager.Skill.SHELTER);
        ev1.sayHello();
        ev2.sayHello();

        Object objectDeckardCain = ev2;
        Object objectAkara = ev1;

        ArrayList<Villager> villagers = new ArrayList<>(Arrays.asList(v1, ev1, v3, ev2, v5, v6));
        ArrayList<Monster> monsters2 = new ArrayList<>(Arrays.asList(Monsters.andariel, Monsters.blacksmith));
        Random rn = new Random();

        while(Monsters.getMonstersHealth() > 0)
        {
            System.out.println("Potwory posiadaja jeszcze " + Monsters.getMonstersHealth() + " punkty zycia");
            int vilag = rn.nextInt(villagers.size());
            int monst = rn.nextInt(monsters2.size());
            System.out.println("Aktualnie walczacy osadnik to " + villagers.get(vilag).getName());
            villagers.get(vilag).attack(monsters2.get(monst));
            if(monsters2.get(monst).getHealth() < 0)
            {
                monsters2.remove(monst);
            }
            else
                monsters2.get(monst).attack(villagers.get(vilag));
            if(villagers.get(vilag).getHealth() < 0)
            {
                villagers.remove(vilag);
            }

        }
        System.out.println("Obozowisko ocalone!");
        ev1 = (ExtraordinaryVillager) objectAkara;
        ev2 = (ExtraordinaryVillager) objectDeckardCain;
        ev1.sayHello();
    }
}