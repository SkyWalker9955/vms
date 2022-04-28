package com.mikelevytskyi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        double moneyPool = 0;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        //Prompt
        System.out.println("Taking bills: $1, 5; Coins: 5, 10, 25");

        //Payment Simulation
        System.out.print("\nSelect 1 for $1\nSelect 2 for $5\nSelect 3 for 5¢\nSelect 4 for 10¢\nSelect 5 for 25¢\nSelect 0 if you are done inserting cash\n\n");

        while(flag) {
            //user input
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("$1 added");
                    moneyPool = moneyPool + 1;
                    break;
                case 2:
                    System.out.println("$5 added");
                    moneyPool = moneyPool + 5;
                    break;
                case 3:
                    System.out.println("$0.05 added");
                    moneyPool = moneyPool + 0.05;
                    break;
                case 4:
                    System.out.println("$0.1 added");
                    moneyPool = moneyPool + 0.1;
                    break;
                case 5:
                    System.out.println("$0.25 added");
                    moneyPool = moneyPool + 0.25;
                    break;
                case 0:
                    if(moneyPool == 0) {
                        System.out.println("Your balance is $0.0, insert money to proceed.");
                    }
                    else{
                        flag = false;
                    }
                    break;
            }
        }

        System.out.println("You've got $" + moneyPool);

        //-------------------------------------------------------------------------

        //set your file path here
        String filePath = "/Users/mikelevytskyi/Projects/Maven/vms/update.json";

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode node = JsonMapper.parse(filePath);
            Config config = mapper.treeToValue(node.get("config"), Config.class);
            List items = JsonMapper.readItems(node);

            //System.out.println(items.size());

            //Prompt customer for product selection
            System.out.println("Make a selection, please.");
            String productSelection = scanner.nextLine();

            //assign items and display vending machine interface
            String setup[][] = new String[config.getRows()][Integer.valueOf(config.getColumns())];
            int listIndex = 0;

            for( int i = 0; i < config.getRows(); i++ ){

                for (int j=0; j< Integer.valueOf(config.getColumns()); j++) {
                    System.out.print("| " + alphabet[i] + j + "-");

                    if(listIndex < 9){
                        Item item = (Item) items.get(listIndex);
                        setup[i][j] = item.getName();
                        System.out.print(setup[i][j] + " |");
                    }
                    else {
                        setup[i][j] = "Empty-Tray";
                        System.out.print(setup[i][j] + " |");
                    }
                    listIndex = listIndex + 1;
                }
                System.out.println("\n");
            }

            //at this point user has made a selection, let's work with it





            //items.stream().forEach(x -> System.out.println(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //------------------------------------------------------------

        //After update is read, based on config we need a setup to happen.


    }
}
