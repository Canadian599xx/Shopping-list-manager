import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        boolean run = true;
        int option;
        Scanner scnr = new Scanner(System.in);
        Shopping list1 = new Shopping();
        String intro = """
                
                What would you like to do?
                
                1. Add an item to your list
                2. remove an item from your list
                3. check an item on your list
                4. view list
                5. exit
                
                (Type the number associated with the option you want and press enter)
                """;

        while(run){
            System.out.println(intro);
            try{
            option = scnr.nextInt();
            }
            catch (Exception e){
                option = 0;
                scnr.next();
            }

            switch(option){
                case 1:
                    System.out.println("Enter the name of the item you want to add:\n");
                    String shop = scnr.next();

                    boolean check = list1.checker(shop);
                    if (!check){
                        list1.addItem(shop);
                    }
                    else {
                        System.out.println("Item already on list!");
                    }

                    break;

                case 2:

                    list1.removeItem();
                    break;

                case 3:
                    list1.done();
                    break;

                case 4:
                    list1.displayList();
                    break;

                case 5:
                    run = false;
                    System.out.println("GOODBYE.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection, try again!");
                    break;

            }

        }
    }
}
