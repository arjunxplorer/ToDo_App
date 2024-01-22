import java.util.Scanner;
import java.util.ArrayList;
public class todo_list {
    public static void main(String[] args){
        ArrayList<String> arr= new ArrayList<String>();
        todo(arr);    
    }
    public static void todo(ArrayList<String> arr){
        //defining a scanner
        Scanner sc= new Scanner(System.in);
        //while loop runs inifinitly until user exits 
        while(true){
            //printing the options for user
            System.out.println("┌──────────────── TO-DO LIST ────────────────┐");
            System.out.println("│ 1. ADD                                     │");
            System.out.println("│ 2. REMOVE                                  │");
            System.out.println("│ 3. EDIT                                    │");
            System.out.println("│ 4. DISPLAY                                 │");
            System.out.println("│ 5. SWAP                                    │");
            System.out.println("│ 6. MOVE                                    │");
            System.out.println("│ 7. CLEAR                                   │");
            System.out.println("│ 8. EXIT                                    │");
            System.out.println("└────────────────────────────────────────────┘");
            
            //asking for which option they want to take and getting input from the user

            System.out.println("Enter the number to proceed:");
            int number= sc.nextInt();
            sc.nextLine();

            String input;


            //using switch statement to perform particular function based on user's choice

            switch(number){
                //adding the user input to arraylist
                case 1:
                //asking
                    System.out.println("Enter the text you want to add:");
                    input=sc.nextLine();
                //calling add function
                    Add(input, arr);
                //getting out of switch statement
                    break;

                //removing user input 
                case 2:
                //asking for index from which they want to remove the data
                    System.out.println("Which index you want to remove?");
                    int index= sc.nextInt();
                //calling function
                    Remove(index, arr);
                    break;

                //editing the list 
                case 3:
                //first displaying the list to edit
                    display(arr);
                //then, asking which list they want to edit
                    System.out.println("Which item in the list you want to edit?");
                    int list_item= sc.nextInt();
                //if the user's index is greater, then print the error message
                    if(list_item>arr.size()){
                        System.out.println("There is no item in this index "+list_item+1+".");
                        return;
                    }
                //avoiding scanner bug
                    sc.nextLine();
                    edit(list_item, arr, sc);
                    break;
                
                //displaying the user list
                case 4:
                    display(arr);
                //exit from the program after dislpaying the list
                    System.exit(0);
                    break;

                //swaping the list
                case 5:
                //displays the list and asks for initial and target index for swapping
                    display(arr);
                    System.out.println("Which item you want to shift?");
                    int initial= sc.nextInt();
                    System.out.println("Where you want to shift?");
                    int last=sc.nextInt();
                    swap(initial, last, arr);

                //moving a particular list to particular index
                case 6:
                //first displaying the list to the user
                    display(arr);
                //asking for initial index
                    System.out.println("which list do you want to move?");
                    int target=sc.nextInt();
                    sc.nextLine();
                //getting data from that index
                    String user_input= arr.get(target);
                //asking for final index
                    System.out.println("Where do you want to move?");
                    int destination= sc.nextInt();
                    move(target, user_input, destination, arr);
                    break;

                //clearing the complete list
                case 7:
                    Clear(sc, arr);
                    break;
                
                //exits from the program
                case 8:
                    System.out.println("Thank you for using my program...");
                    System.exit(0);
                    break;
                //if user enters any other number then default message will be printed
                default:
                    System.out.println("You are allowed to put number between 1 and 6");
                    System.out.println("Try Again");
            }
        }
    }

    //add the user input to arraylist
    public static void Add(String input, ArrayList<String> arr){
        arr.add(input);
        System.out.println();
    }

    //removes the list item from the arraylist based on index given by the user
    public static void Remove(int index, ArrayList<String> arr){
        arr.remove(index);
        System.out.println("The item in "+index+" has been removed.");
        System.out.println();
    }

    //ask for user input and set the input on user's desire index
    public static void edit(int index, ArrayList<String> arr, Scanner sc){
        System.out.println("Enter your text: ");
        String input= sc.nextLine();
        
        arr.set(index, input);
        System.out.println("Your input is edited in "+(index)+".");
        System.out.println();
    }

    //display the todo-list
    public static void display(ArrayList<String> arr){
        //if it's empty this runs
        if(arr.size()==0){
            System.out.println("┌──────────────── TO-DO LIST ────────────────┐");
            System.out.println("Your list is empty. If you want to add proceed below.");
            System.out.println("└────────────────────────────────────────────┘");
            return;
        }
        //otherwise this part will run
        System.out.println("┌──────────────── TASK LIST ────────────────┐");
        int i=1;
        for(String ele: arr){
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println(i+" "+ele+" ");
            System.out.println("└────────────────────────────────────────┘");
            i++;
        }
        System.out.println("└────────────────────────────────────────────┘");
        System.out.println();
    }

    //clear the whole todo-list
    public static void Clear(Scanner sc, ArrayList<String> arr){
        //asks user for yes or no and takes the input
        System.out.println("Are you really want to clear your complete list (y/n):");
        char c= sc.next().charAt(0);
        //if yes then clear the list, else display the options
        if(c=='Y'||c=='y'){
            arr.clear();
            System.out.println("Your list is cleared.");
        }else{
            todo(arr);
        }
        System.out.println();
    }

    //swap the two list according to user 
    public static void swap(int initial, int last, ArrayList<String> arr){
        //created a temporary arraylist to store the initial input from the list
        ArrayList<String> temp= new ArrayList<String>();
        //index of that initial list 
        int tempIndex=initial;
        //stores the input from last index into temp arraylist
        temp.add(arr.get(last));
        //adding the initial input to the destination index 
        arr.set(last, arr.get(initial));
        //now adding other input file to initial index
        arr.set(tempIndex, temp.get(0));

        System.out.println("Changes has been made successfully...");

    }
    
    //moves the input data from one index to other and remainig lists are shifted by one
    public static void move(int target, String user_input, int destination, ArrayList<String> arr){
        //
        arr.remove(target);
        arr.add(destination, user_input);
        System.out.println("Your list is added to index "+ target+". ");
    }
    
}


