import java.io.*;//imports input and output methods
import java.util.Scanner;//imports Scanner
import java.util.Random;//imports Random class
public class ElementMonsterFight{


   //introduces player to game and asks if they want to play a round
   public static void gameIntro(){
      Scanner scan = new Scanner(System.in);
      System.out.println("Welcome to Elemental Monster Fight!");
      System.out.println("In this game, you will choose to fight three different element types of monster. Each monster has a weakness.");
      System.out.println("You will also choose a fighter type. Try to choose a type advantage so you can inflict extra damage to the monster!");
      System.out.println("Do you want to play a new round? (Y/N)");
      String beginGame = scan.nextLine();
      if(beginGame.equals("Y") || beginGame.equals("y") || beginGame.equals("yes") ||beginGame.equals("Yes") || beginGame.equals("YES")){
         System.out.println("Great! Lets set some things up first!");
      }else{
         System.out.println("Maybe next time...:*(");
         System.exit(0);
      }
      }
      
   //prints monsters from a .txt file to screen
   public static void printMonster(String file, String monsterType)throws IOException{
      File myFile = new File(file);
      Scanner monsterPicture = new Scanner(myFile);
      while (monsterPicture.hasNext()){
         System.out.println(monsterPicture.nextLine());
      }
      System.out.println("Get ready! A " + monsterType + " monster has appeared!");
      monsterPicture.close();  
   }   
   
   //main method
   public static void main(String[] args)throws IOException{
      
      //array list to hold different element types for the fighter and the monster    
      String[] typeCollection = {"fire", "Fire", "FIRE", "water", "Water", "WATER", "poison", "Poison", "POISON"};
                               
      gameIntro();//calls gameIntro method
      String monsterType = BattleSystem.getMonster();//asks user what type of monster they want to fight and assigns it to variable
      String fighterType = BattleSystem.getFighter();//asks user what type of fighter they want to fight as and assigns it to variable 
      
      //switch statement that checks the different cases of monsterType
      switch(monsterType){
         case "Water":
         case "WATER":
         case "water":
            printMonster("watermonster.txt", "water");//prints .txt file of water monster to console
            //if-else-if statement to determine what type advantage there will be in the battle and calls the corresponding BattleSystem method
            if(fighterType.equals(typeCollection[6]) || fighterType.equals(typeCollection[7]) || fighterType.equals(typeCollection[8])){
               BattleSystem.playerAdvBattle(100, 100);
            }else if(fighterType.equals(typeCollection[0]) || fighterType.equals(typeCollection[1]) || fighterType.equals(typeCollection[2])){
               BattleSystem.monsterAdvBattle(100, 100);
            }else{
               BattleSystem.neutralBattle(100, 100);
            }
            break;
         case "Fire":
         case "FIRE":
         case "fire":
            printMonster("firemonster.txt", "fire");//prints .txt file of fire monster to console
            //if-else-if statement to determine what type advantage there will be in the battle and calls the corresponding BattleSystem method
            if(fighterType.equals(typeCollection[3]) || fighterType.equals(typeCollection[4]) || fighterType.equals(typeCollection[5])){
               BattleSystem.playerAdvBattle(100, 100);
            }else if(fighterType.equals(typeCollection[6]) || fighterType.equals(typeCollection[7]) || fighterType.equals(typeCollection[8])){
               BattleSystem.monsterAdvBattle(100, 100);
            }else{
               BattleSystem.neutralBattle(100, 100);
            }
            break;
         case "Poison":
         case "poison":
         case "POISON":
            printMonster("poisonmonster.txt", "poison");//prints .txt file of poison monster to console
            //if-else-if statement to determine what type advantage there will be in the battle and calls the corresponding BattleSystem method
            if(fighterType.equals(typeCollection[0]) || fighterType.equals(typeCollection[1]) || fighterType.equals(typeCollection[2])){
               BattleSystem.playerAdvBattle(100, 100);
            }else if(fighterType.equals(typeCollection[3]) || fighterType.equals(typeCollection[4]) || fighterType.equals(typeCollection[5])){
               BattleSystem.monsterAdvBattle(100, 100);
            }else{
               BattleSystem.neutralBattle(100, 100);
            }

            break;
      }//closing switch


}//closing main
  
 
 
}//closing class
