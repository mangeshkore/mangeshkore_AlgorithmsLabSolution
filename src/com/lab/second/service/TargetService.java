package com.lab.second.service;

public class TargetService {

    public int checkTarget(int target, int[] transactionArray) {
        int sum = 0;
        for (int i = 0; i < transactionArray.length; i++) {
            sum = sum + transactionArray[i];
            if (target <= sum) {
                return i + 1;
            }
        }
        return 0;
    }

    public void printTarget(int numberOfTransactions) {
        if (numberOfTransactions == 0)
            System.out.println("The target is not achieved");
        System.out.println("Target achieved after " + numberOfTransactions + " transactions\n");
    }
}
