package com.lab.second.service;

import java.util.HashMap;
import java.util.Map;

public class DenominationService {

    public void sortArray(int[] array, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            sortArray(array, left, m);
            sortArray(array, m + 1, right);
            merge(array, left, m, right);
        }
    }

    public void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = array[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = array[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    public Map<Integer, Integer> findDenominations(int amount, int[] denominationArray) {
        int numberOfNotes;
        Map<Integer, Integer> notesMap = new HashMap<>();
        try {
            for (int i = denominationArray.length - 1; i >= 0; --i) {
                if (amount > denominationArray[i]) {
                    numberOfNotes = (amount / denominationArray[i]);
                    notesMap.put(denominationArray[i],numberOfNotes);
                    amount = amount % denominationArray[i];
                }
            }
            if(amount > 0){
                System.out.println("Payment is not possible for the amount with available currency denominations");
                System.exit(0);

            }
            return notesMap;
        }catch (ArithmeticException e){
            System.out.println("We got a wrong denomination. Exception :: "+e.getMessage());
            System.exit(0);
        }
        return notesMap;
    }

    public void printDenominations(Map<Integer, Integer> notesMap) {
        System.out.println("Your payment approach in order to give min no of notes will be");
        for (Map.Entry<Integer,Integer> entry : notesMap.entrySet())
            System.out.println(entry.getKey() + ":"+ entry.getValue());
    }
}

