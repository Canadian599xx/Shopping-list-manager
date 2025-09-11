import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    private ArrayList<String> list;
    private ArrayList<String> checkoff;
    Scanner scan2 = new Scanner(System.in);

    public Shopping(){
        list = new ArrayList<String>();
        checkoff = new ArrayList<String>();
    }

    public boolean checker(String item){
        item = item.toLowerCase();
        boolean repeat = false;
        for (String s : list) {
            if (s.equals(item)) {
                repeat = true;
            }
        }
        return repeat;

    }

    public void addItem(String item){
        item = item.toLowerCase();
        list.add(item);
        checkoff.add("Not Checked");
    }

    public void removeItem() {

        if (list.isEmpty()){
            System.out.println("Your list is empty! add some stuff first!");
        }
        else {
            int itemnum = 1;
            System.out.println("Which item would you like to remove?\n(choose the number associated with the item and press enter)\n");
            for (String s : list) {
                System.out.println(itemnum + ". " + s);
                itemnum++;
            }
            try {
                int itempick = scan2.nextInt();
                list.remove(itempick - 1);
            } catch (Exception e) {
                System.out.println("That is not a valid selection, returning to menu");
            }
        }
    }

    public void done(){
        int itemdex = 1;
        System.out.println("Which item would you like to check off?\n(choose the number associated with the item and press enter)\n");
        for (String s : list) {
            System.out.println(itemdex + ". " + s);
            itemdex++;
        }
        try{
            int itempick = scan2.nextInt();
            checkoff.remove(itempick - 1);
            checkoff.add(itempick - 1,"Checked");
        }
        catch (Exception e){
            System.out.println("That is not a valid selection, please try again");
        }


    }



    public void displayList(){
        int itemdex = 0;
        for (String s : list){
            System.out.print(itemdex+1 + ". " + s);

            if (checkoff.get(itemdex).equals("Checked")){
                System.out.println(" x");
            }
            else {
                System.out.println(" -");
            }
            itemdex++;
        }
    }


}
