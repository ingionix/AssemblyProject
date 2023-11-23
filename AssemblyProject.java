import java.util.*;
public class AssemblyProject {

        public static void main(String[] args) {
            ArrayList<String> items;
            ArrayList<String> names;
            ArrayList<Integer> itemLengthAndNumber;
            ArrayList<Integer> numbers;
            Scanner input = new Scanner(System.in);
            boolean isLengthAndNumberSet = false;  // add this line
            items = new ArrayList<String>();
            names = new ArrayList<String>();
            itemLengthAndNumber = new ArrayList<Integer>();
            numbers = new ArrayList<Integer>();
            int prefixSum = 0;
            String userItem;
            do {

                System.out.println("***********Open Menu************ \n");
                System.out.println("To Select number of items and length of Names and Numbers press 1 \n");
                System.out.println("To Enter the items press 2 \n");
                System.out.println("To show the entered items in the same sequence of entrance 3 \n");
                System.out.println("To show the entered items classified as Names and Numbers 4\n");
                System.out.println("To Perform Ascending sorting on Names press 5\n");
                System.out.println("To perform Prefix sums on Numbers press 6.\n");
                System.out.println("To Display sorted Names press 7\n");
                System.out.println("To display Prefix sums of Numbers press 8 \n");
                System.out.println("To Exit press 9 \n ");
                String option = input.next();

                switch (option.trim()){

                    case "1": {
                        System.out.println("Enter the number of items: (8 to 12) ");
                        int numItems = input.nextInt();
                        itemLengthAndNumber.add(numItems);

                        System.out.println("Enter the maximum length for the name and number: (4 to 6)");
                        int maxLength = input.nextInt();
                        itemLengthAndNumber.add(maxLength);
                        System.out.println( "number of items: " + itemLengthAndNumber.get(0) + " maximum length: " + itemLengthAndNumber.get(1));

                        isLengthAndNumberSet = true;  // add this line
                        input.nextLine();
                        break;
                    }
                    case "2": {
                        if (!isLengthAndNumberSet) {  // add this line
                            System.out.println("Please enter the number of items and their maximum length first.");
                        }
                        else {
                            for(int i = 0; i < itemLengthAndNumber.get(0); i++) {
                                System.out.println("Enter the items No "+ (i+1) );
                                userItem = input.next();
                                if(userItem.length() > itemLengthAndNumber.get(1)) {
                                    System.out.println("your Item size is too large! Restart and Try again.");
                                    return;
                                }
                                else {
                                    items.add(userItem);
                                    input.nextLine();
                                }

                            }
                        }


                        break;
                    }

                    case "3": {
                        System.out.println("Your items are: ");
                        for(int i = 0; i < itemLengthAndNumber.get(0); i++) {
                            System.out.println(" Item No" + (i+1) + ": " +items.get(i));

                        }


                        break;
                    }
                    case "4": {
                        for (String item : items) {
                            boolean isNumber = true;
                            for (char c : item.toCharArray()) {
                                if (!Character.isDigit(c)) {
                                    isNumber = false;
                                    break;
                                }
                            }

                            if (isNumber) {
                                numbers.add(Integer.parseInt(item));
                            } else {
                                names.add(item);
                            }
                        }
                        System.out.println("Names: ");
                        for(String name : names){
                            System.out.println(name );
                        }
                        System.out.println("=============\n");
                        System.out.println("Numbers: ");
                        for(Integer number : numbers){
                            System.out.println(number);
                        }

                        break;
                    }
                    case "5": {
                        Collections.sort(names);
                        System.out.println("Names successfully sorted.\n");
                        break;
                    }
                    case "6": {
                        for(Integer number : numbers) {
                            prefixSum += number;
                        }
                        System.out.println("Prefix Sum done successfully ");
                        break;
                    }
                    case "7": {
                        System.out.println("Sorted names are: " + names);

                        break;
                    }
                    case "8": {
                        System.out.println("Prefix Sum is: " + prefixSum);
                        break;
                    }
                    case "9": {
                        System.out.println("Good bye!");
                        System.exit(0);

                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + option);
                }

            } while(true);
        }
    }



