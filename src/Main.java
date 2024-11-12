import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean done = false;
        do
        {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Choose an option ", "[AaDdIiPpQq]");

            if (choice.equalsIgnoreCase("A"))
                addItem();

            else if (choice.equalsIgnoreCase("D"))
                    deleteItem();

            else if (choice.equalsIgnoreCase("I"))
                    insertItem();

            else if (choice.equalsIgnoreCase("P"))
                    printList();

            else if (choice.equalsIgnoreCase("Q"))
            {
                done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
            }

            else
                System.out.println("Invalid input. Try again.");
            } while (!done);
    }

    private static void displayMenu()
    {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the myArrList");
        System.out.println("Q - Quit");
    }

    private static void addItem()
    {
        String newItem = SafeInput.getNonZeroLenString(in, "Enter a new item to add");
        myArrList.add(newItem);
        System.out.println("Item added.");
    }

    private static void deleteItem()
    {
        if (myArrList.isEmpty())
        {
            System.out.println("The myArrList is empty. No items to delete.");
            return;
        }

        printList();

        int itemNumber = SafeInput.getRangedInt(in, "Enter the number of the item to delete:", 1, myArrList.size());

        myArrList.remove(itemNumber - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem()
    {
        if (myArrList.isEmpty())
        {
            System.out.println("The myArrList is empty. Adding item at position 1.");
            addItem();
            return;
        }

        printList();

        int position = SafeInput.getRangedInt(in, "Enter the position to insert the new item (1 to " + (myArrList.size() + 1) + "): ", 1, myArrList.size() + 1);

        String newItem = SafeInput.getNonZeroLenString(in, "Enter a new item to insert");

        myArrList.add(position - 1, newItem);
        System.out.println("Item inserted.");
    }

    private static void printList()
    {
        if (myArrList.isEmpty())
            System.out.println("The myArrList is empty.");

        else
            for (int i = 0; i < myArrList.size(); i++)
                System.out.println((i + 1) + ". " + myArrList.get(i));
    }

}
