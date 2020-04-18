import java.io.*;//imports input and output methods
import java.util.Scanner;//imports Scanner
import java.util.Random;//imports Random class
public class BattleSystem{
   
  //method to calculate and return total damage of a monster type-advantage attack
  public static int superAttack(int damage){
      Random rand = new Random();
      damage += rand.nextInt(31)+15;
      return damage;
   }
   
  //gets type of monster from user
  public static String getMonster(){
     Scanner scan = new Scanner(System.in);
     System.out.println("What monster type would you like to fight? (Enter Fire, Water, or Poison)");//asks user what monster type they want to fight
     String monsterType = scan.nextLine();//stores user input in monsterType variable
     return monsterType;
     }
      
  //gets type of fighter from user
  public static String getFighter(){
     Scanner scan = new Scanner(System.in);
     System.out.println("What fighter type would you like to fight as? (Enter Fire, Water, or Poison)");//asks user what fighter type they want to be
     String fighterType = scan.nextLine();//stores user input in monsterType variable
     return fighterType;
     }
  
  //calculates and returns total damage for a KICK input in a neutral type-advantage battle 
  public static int playerKick(){
      Random rand = new Random();
      int damage = rand.nextInt(11)+10;
      return damage;
   }
   
   //calculates and returns total damage for a PUNCH input in a neutral type-advantage battle
   public static int playerPunch(){
      Random rand = new Random();
      int damage = rand.nextInt(11)+5;
      return damage;
   }
   
   //method to calculate and return total damage of a monster attack with no type advantage
   public static int monsterAttack(int damage){
      Random rand = new Random();
      damage += rand.nextInt(20)+0;
      return damage;
   }

   //sets health for monster and player and uses a while-loop for turn-based combat with no type advantages 
   public static void neutralBattle(int monsterHealth, int playerHealth)throws IOException{
      System.out.println("It's time to fight! Type in your action!");
      while(monsterHealth > 0 && playerHealth > 0){
         //player's turn
         Scanner scan = new Scanner(System.in);
         System.out.println("Your turn!");
         System.out.println("KICK     PUNCH     HEAL     BLOCK");
         String playerAction = scan.nextLine();
         //if-else-if statement for player input
         if(playerAction.equals("KICK") || playerAction.equals("kick") || playerAction.equals("Kick")){
            int damage = playerKick();
            monsterHealth-= damage; 
            System.out.println("You hit the monster for " + damage + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("PUNCH") || playerAction.equals("punch") || playerAction.equals("Punch")){
            int damage = playerPunch();
            monsterHealth-= damage; 
            System.out.println("You hit the monster for " + damage + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("HEAL") || playerAction.equals("heal") || playerAction.equals("Heal")){
            playerHealth +=5;
            System.out.println("You healed for 5 points!");
            System.out.println("Your health remaining: " + playerHealth);
         }
         //checks if monster has been defeated
         if(monsterHealth <= 0){
            File myFile = new File("winnerpicture.txt");
            Scanner winnerPicture = new Scanner (myFile);
            while (winnerPicture.hasNext()){
               System.out.println(winnerPicture.nextLine());
            }
            winnerPicture.close();
            System.out.println("You won! Congratulations!");
            System.exit(0);
         }
         //monster's turn
         System.out.println("****Monster's turn! Watch out!****");
         int damage = monsterAttack(5);
         //reduces the monster's attack damage by 1/2 if the player is blocking this turn
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            playerHealth -= damage/2;
            System.out.println("You blocked half of the damage! Nice!");
         }else{
            playerHealth -= damage;
         }
         //prints to console how much damage the monster dealt to the player
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            System.out.println("****The monster hit you for a reduced "+ damage/2 +" points of damage!****");
         }else{
         System.out.println("****The monster hit you for "+ damage +" damage!****");
         }
         System.out.println("Your health remaining: " + playerHealth);
         //checks if player has been defeated 
         if(playerHealth <= 0){
            File myFile = new File("loserpicture.txt");
            Scanner loserPicture = new Scanner(myFile);
            while (loserPicture.hasNext()){
               System.out.println(loserPicture.nextLine());
            }
            loserPicture.close();
            System.out.println("You lose! Sorry, maybe next time!");
            System.exit(0);
         }  
      }//closing while-loop in battle method
   }//closing neutralBattle method
   
   //sets health for monster and player and uses a while-loop for turn-based combat with player type advantage
   public static void playerAdvBattle(int monsterHealth, int playerHealth)throws IOException{
      System.out.println("You have the type advantage this battle, your attacks will do double damage!");
      System.out.println("It's time to fight! Type in your action!");
      while(monsterHealth > 0 && playerHealth > 0){
         Scanner scan = new Scanner(System.in);
         System.out.println("Your turn!");
         System.out.println("KICK     PUNCH     HEAL     BLOCK");
         String playerAction = scan.nextLine();
         //if-else-if statment for player input
         if(playerAction.equals("KICK") || playerAction.equals("kick") || playerAction.equals("Kick")){
            int damage = playerKick();
            monsterHealth-= damage*2;//monster recieves twice as much damage  
            System.out.println("Super effective! You hit the monster for " + damage*2 + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("PUNCH") || playerAction.equals("punch") || playerAction.equals("Punch")){
            int damage = playerPunch();
            monsterHealth-= damage*2; 
            System.out.println("Super effective! You hit the monster for " + damage*2 + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("HEAL") || playerAction.equals("heal") || playerAction.equals("Heal")){
            playerHealth +=5;
            System.out.println("You healed for 5 points!");
            System.out.println("Your health remaining: " + playerHealth);
         }
         //if-statement to check if monster has been defeated
         if(monsterHealth <= 0){
            File myFile = new File("winnerpicture.txt");
            Scanner winnerPicture = new Scanner (myFile);
            while (winnerPicture.hasNext()){
               System.out.println(winnerPicture.nextLine());
            }
            winnerPicture.close();
            System.out.println("You won! Congratulations!");
            System.exit(0);
         }
         //monster's turn 
         System.out.println("****Monster's turn! Watch out!****");
         int damage = monsterAttack(0);
         //reduces the monster's attack damage by 1/2 if the player is blocking this turn
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            playerHealth -= damage/2;
            System.out.println("You blocked half of the damage! Nice!");
         }else{
            playerHealth -= damage;
         }
         //prints to console how much damage the monster dealt to the player
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            System.out.println("****The monster hit you for a reduced "+ damage/2 +" points of damage!****");
         }else{
         System.out.println("****The monster hit you for "+ damage +" damage!****");
         }
         System.out.println("Your health remaining: " + playerHealth);
         //if-statement to check if the player has been defeated
         if(playerHealth <= 0){
            File myFile = new File("loserpicture.txt");
            Scanner loserPicture = new Scanner(myFile);
            while (loserPicture.hasNext()){
               System.out.println(loserPicture.nextLine());
            }
            loserPicture.close();
            System.out.println("You lose! Sorry, maybe next time!");
            System.exit(0);
         }  
      }//closing while-loop in battle method
      }//closing playerAdvBattle method  
      
   //sets health for monster and player and uses a while-loop for turn-based combat with monster type advantage
   public static void monsterAdvBattle(int monsterHealth, int playerHealth)throws IOException{
      System.out.println("Uh oh! The monster has the type advantage this battle, its attacks will do double damage!");
      System.out.println("It's time to fight! Type in your action!");
      while(monsterHealth > 0 && playerHealth > 0){
         Scanner scan = new Scanner(System.in);
         System.out.println("Your turn!");
         System.out.println("KICK     PUNCH     HEAL     BLOCK");
         String playerAction = scan.nextLine();
         //if-else-if statement for player input
         if(playerAction.equals("KICK") || playerAction.equals("kick") || playerAction.equals("Kick")){
            int damage = playerKick();
            monsterHealth-= damage; 
            System.out.println("You hit the monster for " + damage + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("PUNCH") || playerAction.equals("punch") || playerAction.equals("Punch")){
            int damage = playerPunch();
            monsterHealth-= damage; 
            System.out.println("You hit the monster for " + damage + " damage!");
            System.out.println("Monster health remaining: " + monsterHealth);
         }else if(playerAction.equals("HEAL") || playerAction.equals("heal") || playerAction.equals("Heal")){
            playerHealth +=5;
            System.out.println("You healed for 5 points!");
            System.out.println("Your health remaining: " + playerHealth);
         }
         //if-statement used to check if monster has been defeated
         if(monsterHealth <= 0){
            File myFile = new File("winnerpicture.txt");
            Scanner winnerPicture = new Scanner (myFile);
            while (winnerPicture.hasNext()){
               System.out.println(winnerPicture.nextLine());
            }
            winnerPicture.close();
            System.out.println("You won! Congratulations! Did you hack my game??");
            System.exit(0);
         }
         //monster's turn 
         System.out.println("****Monster's turn! Watch out!****");
         int damage = superAttack(15);
         //reduces the monster's attack damage by 1/2 if the player is blocking this turn
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            playerHealth -= damage/2;
            System.out.println("You blocked half of the damage! Nice!");
         }else{
            playerHealth -= damage;
         }
         //prints to console how much damage the monster dealt to the player
         if (playerAction.equals("BLOCK") || playerAction.equals("Block") || playerAction.equals("block")){
            System.out.println("****The monster hit you for a reduced "+ damage/2 +" points of damage!****");
         }else{
         System.out.println("****The monster hit you for a super effective "+ damage +" points of damage!****");
         }
         System.out.println("Your health remaining: " + playerHealth);
         //if-statement to check if the player has been defeated
         if(playerHealth <= 0){
            File myFile = new File("loserpicture.txt");
            Scanner loserPicture = new Scanner(myFile);
            while (loserPicture.hasNext()){
               System.out.println(loserPicture.nextLine());
            }
            loserPicture.close();
            System.out.println("You lose! Sorry, maybe next time!");
            System.exit(0);
         }  
      }//closing while-loop in battle method
      }//closing monsterAdvBattle method         
   }//closing class
   
   