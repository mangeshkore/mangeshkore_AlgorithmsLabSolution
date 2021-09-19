package com.lab.second.main;

import com.lab.second.service.TargetService;

import java.util.Scanner;

/**
 * PayMoney. processes thousands of transactions daily amounting to crores of Rupees. They
 * also have a daily target that they must achieve. Given a list of transactions done by
 * PayMoney and a daily target, your task is to determine at which transaction PayMoney
 * achieves the same. If the target is not achievable, then display the target is not achieved.
 */

public class TargetCalculation {
    public static void main(String args[]) {
        TargetService targetService = new TargetService();
        Scanner sc = new Scanner(System.in);
        int transactionSize = 0;

        System.out.println("Enter the size of transaction");
        transactionSize = sc.nextInt();
        int[] transactionArray = new int[transactionSize];
        System.out.println("Enter the values of array");
        for (int i = 0; i < transactionSize; i++) {
            transactionArray[i] = sc.nextInt();
        }

        System.out.println("Enter the total no of targets that needs to be achieved");
        int numberOfTargets = sc.nextInt();
        int numberOfTransactions;
        while (numberOfTargets > 0) {
            System.out.println("Enter the value of target");
            int target = sc.nextInt();
            numberOfTransactions = targetService.checkTarget(target, transactionArray);
            targetService.printTarget(numberOfTransactions);
            numberOfTargets--;
        }
    }
}
