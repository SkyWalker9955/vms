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
        double moneyPool = 0;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        //Prompt
        System.out.println("Taking bills: $1, 5; Coins: 5, 10, 25");

        //Payment Simulation
        System.out.print("\nSelect 1 for $1\nSelect 2 for $5\nSelect 3 for 5¢\n Select 4 for 10¢\nSelect 5 for 25¢\nSelect 0 if you are done inserting cash");

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
                    flag = false;
                    break;
            }
        }

        System.out.println("You've got " + moneyPool);

        //-------------------------------------------------------------------------

        //set your file path here
        String filePath = "/Users/mikelevytskyi/Projects/Maven/vms/update.json";

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode node = JsonMapper.parse(filePath);
            Config config = mapper.treeToValue(node.get("config"), Config.class);
            List items = JsonMapper.readItems(node);

            int setup[][] = new int[config.getRows()][Integer.valueOf(config.getColumns())];

            //items.stream().forEach(x -> System.out.println(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //------------------------------------------------------------

        //After update is read, based on config we need a setup to happen.


    }
}
