package com.lab.second.main;

import com.lab.second.service.DenominationService;


import java.util.Map;
import java.util.Scanner;

public class Denominations {
    public static void main(String[] args) {
        DenominationService denominationService = new DenominationService();
        Scanner sc = new Scanner(System.in);
        int denominationArraySize;

        System.out.println("Enter the size of currency denominations");
        denominationArraySize = sc.nextInt();
        int[] denominationArray = new int[denominationArraySize];
        System.out.println("Enter the currency denominations value");
        for (int i = 0; i < denominationArraySize; i++) {
            denominationArray[i] = sc.nextInt();
        }
        denominationService.sortArray(denominationArray, 0, denominationArray.length - 1);

        System.out.println("Enter the amount you want to pay");
        int amount = sc.nextInt();
        Map<Integer, Integer> notesMap = denominationService.findDenominations(amount, denominationArray);
        denominationService.printDenominations(notesMap);
    }
}
