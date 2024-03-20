import java.lang.Math;
import java.util.ArrayList;

public class BattleCharacters {

    private String name;
    private int hp;
    private int attack;
    private int cost;
    private double attackSpeed;


    public BattleCharacters(String name, int hp, int attack, int cost, double attackSpeed) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.cost = cost;
        this.attackSpeed = attackSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public static void main (String args[]) {

        // LIBRARY OF UNITS
        BattleCharacters scv = new BattleCharacters("SCV", 60, 5, 50, 10 * (Math.round(15/16.0 * 10) / 10.0));
        BattleCharacters marine = new BattleCharacters("Marine", 40, 6, 50, 10 * (Math.round(15/16.0 * 10) / 10.0));
        BattleCharacters firebat = new BattleCharacters("Firebat", 50, 8, 50, 10 * (Math.round(22/16.0 * 10) / 10.0));
        BattleCharacters ghost = new BattleCharacters("Ghost", 45, 10, 25, 10 * (Math.round(22/16.0 * 10) / 10.0));
        BattleCharacters vulture = new BattleCharacters("Vulture", 80, 20, 75, 10 * (Math.round(30/16.0 * 10) / 10.0));
        BattleCharacters goliath = new BattleCharacters("Goliath", 125, 12, 100, 10 * (Math.round(22/16.0 * 10) / 10.0));
        BattleCharacters wraith = new BattleCharacters("Wraith", 120, 8, 150, 10 * (Math.round(30/16.0 * 10) / 10.0));
        BattleCharacters battlecruiser = new BattleCharacters("Battlecruiser", 500, 25, 400, 10 * (Math.round(30/16.0 * 10) / 10.0));
        BattleCharacters valkyrie = new BattleCharacters("Valkyrie", 200, 48, 250, 10 * (Math.round(64/16.0 * 10) / 10.0));

        // FIGHT
        BattleManager.fight(battlecruiser, 1, valkyrie, 1);

        // COMPLEXFIGHT
        ArrayList<BattleCharacters> player1 = new ArrayList<>();
        player1.add(scv);
        player1.add(vulture);
        player1.add(firebat);
        player1.add(wraith);
        player1.add(valkyrie);
        player1.add(vulture);

        ArrayList<BattleCharacters> player2 = new ArrayList<>();
        player2.add(scv);
        player2.add(battlecruiser);
        player2.add(goliath);

        BattleManager.complexFight(player1, player2);

    }
}