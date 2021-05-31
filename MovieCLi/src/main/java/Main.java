import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Menu menu = new Menu();
       Scanner scanner = new Scanner(System.in);
       int commandNumber;
       String continueOrNot;
       boolean checkForMenu = true;

       while(checkForMenu) {
           menu.showMenu();
           commandNumber = scanner.nextInt();
           menu.beginTransaction();
           if (commandNumber == 1) {
               menu.showMovieCrudMenu();
               commandNumber = scanner.nextInt();
               if (commandNumber == 1) {
                   menu.addMovie();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 2) {
                   menu.findMovie();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 3) {
                   menu.modifyMovie();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 4) {
                   menu.deleteMovie();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               }
           } else if (commandNumber == 2) {
               menu.showGenreCrudMenu();
               commandNumber = scanner.nextInt();
               if (commandNumber == 1) {
                   menu.addGenre();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 2) {
                   menu.findGenre();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 3) {
                   menu.modifyGenre();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 4) {
                   menu.deleteGenre();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               }
           } else if (commandNumber == 3) {
               menu.showPersonCrudMenu();
               commandNumber = scanner.nextInt();
               if (commandNumber == 1) {
                   menu.addPerson();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 2) {
                   menu.findPerson();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 3) {
                   menu.modifyPerson();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               } else if (commandNumber == 4) {
                   menu.deletePerson();
                   System.out.println("Davam etmek isteyirsiniz ? h/y");
                   continueOrNot = scanner.next();
                   if(continueOrNot.equals("y")){
                       checkForMenu = false;
                       System.exit(0);
                   }
               }
           } else {
               menu.endTransaction();
               System.exit(0);
           }
       }
    }
}
