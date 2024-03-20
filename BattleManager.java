import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class BattleManager {
    public static String fight(BattleCharacters C1, int quant1, BattleCharacters C2, int quant2) {
        //PRINT EACH PLAYER'S UNIT AND HOW MANY THERE ARE
        if (quant1 > 1) {
            System.out.println("Player 1 has " + quant1 + " " + C1.getName() + "s");
        } else if (quant1 == 1) {
            System.out.println("Player 1 has " + quant1 + " " + C1.getName());
        }
        if (quant2 > 1) {
            System.out.println("Player 2 has " + quant2 + " " + C2.getName() + "s");
        } else if (quant2 == 1) {
            System.out.println("Player 2 has " + quant2 + " " + C2.getName());
        }
        System.out.println();
        System.out.println("BATTLE \n");

        int iquant1 = quant1;
        int iquant2 = quant2;

        int player1hp = C1.getHp();
        int player2hp = C2.getHp();

        //RUNS A LOOP USED AS TIME AND HAS UNITS ATTACK ON MULTIPLES OF THEIR ATTACK SPEED
        //EX) IF A UNITS ATTACK SPEED IS 9, UNIT WILL ATTACK WHEN TIME = 9, 18, 27, 36...
        for (int time = 0; time < 1000; time++) {
            if (time % C1.getAttackSpeed() == 0) {
                C2.setHp(C2.getHp() - (C1.getAttack() * quant1));
            }
            if (time % C2.getAttackSpeed() == 0) {
                C1.setHp(C1.getHp() - (C2.getAttack() * quant2));
            }
            //EXITS TIME LOOP IF HP <= 0
            if (C1.getHp() <= 0 && C2.getHp() <= 0) {
                System.out.println("Draw");
                break;
            }
            if (C1.getHp() <= 0 && quant1 > 0) {
                quant1--;
                if (quant1 != 0) {
                    C1.setHp(player1hp);
                }
            }
            if (C1.getHp() <= 0 && quant1 == 0) {
                System.out.println("Player 2 Wins");
                break;
            }
            if (C2.getHp() <= 0 && quant2 > 0) {
                quant2--;
                if (quant2 != 0) {
                    C2.setHp(player2hp);
                }
            }
            if (C2.getHp() <= 0 && quant2 == 0) {
                System.out.println("Player 1 Wins");
                break;
            }
        }
        C1.setHp(player1hp);
        C2.setHp(player2hp);

        System.out.println("\nPlayer 1 cost: " + C1.getCost() * iquant1 + "\n" + "Player 2 cost: " + C2.getCost() * iquant2);

        return null;
    }


    public static String complexFight(ArrayList<BattleCharacters> C1, ArrayList<BattleCharacters> C2) {

        int player1hp = 0;
        int player1Cost = 0;
        int player2hp = 0;
        int player2Cost = 0;

        //SUMS UP TOTAL HP AND COST FOR EACH PLAYER AND PRINTS IT
        for (int i = 0; i < C1.size(); i++) {
            player1hp += C1.get(i).getHp();
            player1Cost += C1.get(i).getCost();
        }
        for (int i = 0; i < C2.size(); i++) {
            player2hp += C2.get(i).getHp();
            player2Cost += C2.get(i).getCost();
        }

        // PRINTS BOTH PLAYER'S UNITS IN ORDER AND THE TOTAL HP AND COST
        System.out.println("Player 1 has:");
        for (int i = 0; i < C1.size(); i++) {
            System.out.println(C1.get(i).getName());
        }
        System.out.println("\nStarting Hp: " + player1hp);
        System.out.println("Cost: " + player1Cost);

        System.out.println("\n");

        System.out.println("Player 2 has:");
        for (int i = 0; i < C2.size(); i++) {
            System.out.println(C2.get(i).getName());
        }
        System.out.println("\nStarting Hp: " + player2hp);
        System.out.println("Cost: " + player2Cost);

        System.out.println("\n----------------------");
        System.out.println("        BATTLE!");
        System.out.println("----------------------\n");

        int iquant1 = C1.size();
        int iquant2 = C2.size();

        String winner = "";
        int firstHealth1 = 0;
        int firstHealth2 = 0;

        if (C1.size() > 0) {
            firstHealth1 = C1.get(0).getHp();
        }
        if (C2.size() > 0) {
            firstHealth2 = C2.get(0).getHp();
        }

        int currentDefenderHp1 = C1.get(0).getHp();
        int currentDefenderHp2 = C2.get(0).getHp();

        // FOR LOOP TO REPRESENT PASSAGE OF TIME
        for (int time = 0; time < 1000; time++) {
            for (int i = 0; i < C1.size(); i++) {
                if (time % C1.get(i).getAttackSpeed() == 0) {
                    //USED FOR TESTING
//                        System.out.print(time + " ");
//                        System.out.print(i + " ");
//                        System.out.print(C1.get(i).getAttackSpeed() + " ");
//                        System.out.print(C2.get(0).getHp() + " ");
//                        System.out.println(C1.get(i).getAttack());
                    currentDefenderHp2 -= C1.get(i).getAttack();
                    C2.get(0).setHp(C2.get(0).getHp() - C1.get(i).getAttack());
                }
            }
            //System.out.println();
            for (int i = 0; i < C2.size(); i++) {
                if (time % C2.get(i).getAttackSpeed() == 0) {
                    //USED FOR TESTING
//                        System.out.print(time + " ");
//                        System.out.print(i + " ");
//                        System.out.print(C2.get(i).getAttackSpeed() + " ");
//                        System.out.print(C1.get(0).getHp() + " ");
//                        System.out.println(C2.get(i).getAttack());
                    currentDefenderHp1 -= C2.get(i).getAttack();
                    C1.get(0).setHp(C1.get(0).getHp() - C2.get(i).getAttack());
                }
            }

            //CHECKS IF FIRST UNIT IN PLAYERS ARRAYLIST HAS HP <= 0. IF IT DOES, IT IS REMOVED FROM THE ARRAYLIST OF UNITS
            //AND PRINTS ITS TIME OF DEATH. NEXT UNIT IN THE ARRAYLIST TAKES DAMAGE
            if (currentDefenderHp1 <= 0) {
                player1hp -= firstHealth1;
                System.out.println("Player 1's " + C1.get(0).getName() + " is dead at " + time + " seconds.");
                C1.get(0).setHp(firstHealth1);
                C1.remove(0);
                if (C1.size() > 0) {
                    currentDefenderHp1 = C1.get(0).getHp();
                    firstHealth1 = C1.get(0).getHp();
                }
            }
            if (currentDefenderHp2 <= 0) {
                player2hp -= firstHealth2;
                System.out.println("Player 2's " + C2.get(0).getName() + " is dead at " + time + " seconds.");
                C2.get(0).setHp(firstHealth2);
                C2.remove(0);
                if (C2.size() > 0) {
                    currentDefenderHp2 = C2.get(0).getHp();
                    firstHealth2 = C2.get(0).getHp();
                }
            }

            if (C1.size() == 0 && C2.size() == 0) {
                winner = "DRAW. NO ONE";
                break;
            }
            if (C1.size() == 0) {
                winner = "PLAYER 2";
                break;
            }
            if (C2.size() == 0) {
                winner = "PLAYER 1";
                break;
            }
        }

        System.out.println("\n" + winner + " WINS");

        return null;
    }
}
