package com.mikelevytskyi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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
        double change = 0;
        Scanner scanner = new Scanner(System.in);

        //Prompt
        System.out.println("Taking bills: $1, 5; Coins: 5, 10, 25;");

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
            List<Item> items = JsonMapper.readItems(node);

            //System.out.println(items.size());

            //Prompt customer for product selection
            System.out.println("Make a selection, please.\n");

            //assign items and display vending machine interface
            String[][] setup = new String[config.getRows()][Integer.parseInt(config.getColumns())];
            int listIndex = 0;
            for( int i = 0; i < config.getRows(); i++ ){

                for (int j = 0; j< Integer.parseInt(config.getColumns()); j++) {
                    //System.out.print("| " + alphabet[i] + j + "-");

                    if(listIndex < 9){
                        Item item = items.get(listIndex);
                        setup[i][j] = Character.toString(alphabet[i]) + Integer.toString(j) + "-" + item.getName();
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
            listIndex = 0;

            //Take in user input
            String productSelection = scanner.next();

            //System.out.println(productSelection.length());

            //at this point user has made a selection, let's work with it
            char[] selection = new char[productSelection.length()];
            String[] tokens = new String[2];
            String[] priceTokens = new String[2];

            for (int i = 0; i < config.getRows(); i++) {
                for (int j = 0; j < Integer.parseInt(config.getColumns()); j++) {
                    boolean doesContain = setup[i][j].contains(productSelection);
                    //System.out.println(doesContain + " " + setup[i][j]);

                    if(doesContain == true) {
                        int itemsLength = items.size();
                        //System.out.println(setup[i][j]);
                        tokens = setup[i][j].split("-");
                    }
                }
            }

            //finding the item and decreasing its amount on purchase.

            for (int i = 0; i < items.size(); i++) {
                boolean isSelectedItem = items.get(i).getName().contains(tokens[1]);
                //System.out.println(isSelectedItem);
                if (isSelectedItem /* && moneyPool >= Double.parseDouble(items.get(i).getPrice()) */){

                    priceTokens = items.get(i).getPrice().split("\\$");
                    /*
                    for (int j = 0; j < priceTokens.length; j++) {
                        System.out.println(priceTokens[1] + "~~~");
                    }
                    */
                    //calculate change
                    if(moneyPool < Double.parseDouble(priceTokens[1])) {
                        System.out.println("Price is: " + items.get(i).getPrice());
                        System.out.println("Insufiicient Funds.");

                        System.out.println("Serving a product...\n...\n...\n...");
                        System.out.println("Transaction Completed. Have a good day.");

                    }
                    else if (moneyPool >= Double.parseDouble(priceTokens[1])){
                        change = moneyPool - Double.parseDouble(priceTokens[1]);
                        System.out.println("Price is: " + items.get(i).getPrice() + "\nYour change is: " + "$" + (Math.round(change*100.0)/100.0));

                        /*
                        It would need to return to add funds
                         */
                    }
                    //reduce amount in stock
                    items.get(i).setAmount(items.get(i).getAmount() - 1);
                }
            }


            //items.stream().forEach(x -> System.out.println(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
