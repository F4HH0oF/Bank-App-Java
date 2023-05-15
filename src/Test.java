
import java.util.*;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Test {
    public static void zaglavie() {
        System.out.println("+---------------------------------+");
        System.out.println("|        Welcome to ZaBo's        |");
        System.out.println("|       Movie catalogue App       |");
        System.out.println("+---------------------------------+");
        Test.filmiList();
    }

    public static void filmiList() {
        Scanner input = new Scanner(System.in);
        LinkedList<Katalog> temperatureInfos = new LinkedList(new Filmi().returnListInfoWidgets("C:\\Users\\user\\Documents\\NetBeansProjects\\Bank-App-Java\\src\\movies.csv"));

        System.out.print("-----------------" + "\n" + "Choose a filter criteria:" + "\n" + "1. Genre" + "\n" + "2. Year of release" + "\n" + "3. No filter" + "\n" + "0. Exit" + "\n" + "I choose: ");
        try {
            int izbor = input.nextInt();

            switch (izbor) {
                case 0:
                    System.out.println("Thank you for using our application!");
                    System.exit(0);
                    break;
                case 1:
                    Test.genre(temperatureInfos);
                    break;

                case 2:
                    Test.year(temperatureInfos);
                    break;

                case 3:
                    Test.noFilter(temperatureInfos);
                    break;
                default:
                    System.out.println("No such option..." + "\n" + "-----------------");
                    Test.filmiList();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("Input mismatch.");
            Test.filmiList();
        }
    }
    
    
    
    
    
    public static void genre(LinkedList<Katalog> bonko){
        Scanner input = new Scanner(System.in);
        System.out.print("-----------------"+ "\n" +"Choose a genre:" + "\n" + "1. Action" + "\n" + "2. Drama" + "\n" + "3. Sci-Fi" + "\n" + "4. Western"  + "\n" + "5. Romance" + "\n" + "6. Crime" + "\n" + "I choose: ");
        int n = input.nextInt();
        String janr = "";
       
        switch(n){
            case 1: janr = "Action";
            break;
            case 2: janr = "Drama";
            break;
            case 3: janr = "Sci-Fi";
            break;
            case 4: janr = "Western";
            break;
            case 5: janr = "Romance";
            break;
            case 6: janr = "Crime";
            break;
            default: System.out.println("Missing genre" + "\n" + "-----------------");
                     Test.genre(bonko);                
        }
        System.out.print("Choose sorting factor" + "\n" + "1. Year of release" + "\n" + "2. Duration" + "\n" + "3. Rating" + "\n" + "I choose: ");
        int sortirovka = input.nextInt();
        final String janr2=janr;
        switch(sortirovka){
            case 1: System.out.println(janr2 + " movies:");
                    bonko.stream()
                    .filter(x -> x.getGenre().equals(janr2))
                    .sorted(Comparator.comparingInt(Katalog::getYear))
                    .forEach(System.out::println);
                    Test.filmiList();
            break;
            case 2: System.out.println(janr2 + " movies:");
                    bonko.stream()
                    .filter(x -> x.getGenre().equals(janr2))
                    .sorted(Comparator.comparingInt(Katalog::getDuration))
                    .forEach(System.out::println);
                    Test.filmiList();
            break;
            case 3: System.out.println(janr2 + " movies:");
                    bonko.stream()
                    .filter(x -> x.getGenre().equals(janr2))
                    .sorted(Comparator.comparingDouble(Katalog::getRating))
                    .forEach(System.out::println);
                    Test.filmiList();
            break;
            default:System.out.println("Invalid sorting factor, please try again.");
                    Test.genre(bonko);
            break;        
        }
        
    }
    
    
    
    public static void year(LinkedList<Katalog> bonko){
       
        Scanner input = new Scanner(System.in);
        int godina;
        System.out.print("-----------------"+ "\n" +"Choose a method:" + "\n" + "1. Before given year" + "\n" + "2. After given year" + "\n" + "3. Exact year" + "\n" + "I choose: "); 
        int metod = input.nextInt();
         System.out.print("Choose sorting factor" + "\n" + "1. Year of release" + "\n" + "2. Duration" + "\n" + "3. Rating" + "\n" + "I choose: ");
        int sortirane = input.nextInt();
        System.out.print("Enter an year(1950-2022): ");
        godina = input.nextInt();
        while(godina<1950 && godina>2022){
            System.out.println( "Check the parameters again!");
        godina = input.nextInt();
        }
        switch(metod*3 + (sortirane+2)*4){
            case 15:
                bonko.stream()
                .filter(x -> x.getYear()<=godina)
                .sorted(Comparator.comparingInt(Katalog::getYear))
                .forEach(System.out::println);
               break;
            case 19: 
                bonko.stream()
                .filter(x -> x.getYear()<=godina)
                .sorted(Comparator.comparingInt(Katalog::getDuration))
                .forEach(System.out::println);
                break;
            case 23:
                bonko.stream()
                .filter(x -> x.getYear()<=godina)
                .sorted(Comparator.comparingDouble(Katalog::getRating))
                .forEach(System.out::println);
                break;
            case 18: 
                bonko.stream()
                .filter(x -> x.getYear()>=godina)
                .sorted(Comparator.comparingInt(Katalog::getYear))
                .forEach(System.out::println);
                break;
            case 22:
                bonko.stream()
                .filter(x -> x.getYear()>=godina)
                .sorted(Comparator.comparingInt(Katalog::getDuration))
                .forEach(System.out::println);
                break;
            case 26:
                bonko.stream()
                .filter(x -> x.getYear()>=godina)
                .sorted(Comparator.comparingDouble(Katalog::getRating))
                .forEach(System.out::println);
                break;
            case 21:
                bonko.stream()
                .filter(x -> x.getYear()==godina)
                .sorted(Comparator.comparingInt(Katalog::getYear))
                .forEach(System.out::println);
                break;
            case 25:
                bonko.stream()
                .filter(x -> x.getYear()==godina)
                .sorted(Comparator.comparingInt(Katalog::getDuration))
                .forEach(System.out::println);
                break;
            case 29:
                bonko.stream()
                .filter(x -> x.getYear()==godina)
                .sorted(Comparator.comparingDouble(Katalog::getRating))
                .forEach(System.out::println);
                break;
            default: System.out.println("-----------------"+ "\n" +"Choose a real method" + "\n" + "-----------------");
                     Test.year(bonko);
                break;
        }
        
        Test.filmiList();
            
    }
    
    
    public static void noFilter(LinkedList<Katalog> bonko){
        bonko.stream()
        .sorted(Comparator.comparingInt(Katalog::getYear))
        .forEach(System.out::println);
    }
    
}
