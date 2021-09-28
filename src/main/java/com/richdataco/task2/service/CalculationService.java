package com.richdataco.task2.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CalculationService {

    /**
     * This function is used to handle data transformation (string --> array of int)
     * @param data which is the list of input numbers (in the format of string).
     * @return the result of calling tripletsZero.
     * @throws Exception if non-int type exist in the input list.
     */
    public ArrayList<int[]> performCalculation(String data) throws Exception {
        // format input data into an array of int
        String[] items = data.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] input = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                input[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException e) {
                throw new Exception("Please input an integer array!");
            };
        }
        // call the tripletsZero
        return tripletsZero(input);
    }

    /**
     * This is the function which perform the algorithm logic.
     * @param arr which is the list of input numbers.
     * @return return an arrayList of int array, each of the int array contains an unique
     * triplet with the sum of 0.
     */
    public ArrayList<int[]> tripletsZero(int arr[]) {
        // get the length of the input array
        int arrLength = arr.length;
        ArrayList<int[]> returnList = new ArrayList<int[]>();

        // sort the input numbers in ascending order
        Arrays.sort(arr);

        // for each number, check whether there exist two bigger numbers which make the sum of these three to 0. (two pointers)
        for (int i = 0; i < arrLength - 2; i++) {
            if ( i > 0 && arr[i] == arr[i-1]) continue;
            int left = i + 1;
            int right = arrLength - 1;
            while (left < right) {
                if (arr[left] + arr[right] == -arr[i]) {
                    int[] triplet = new int[]{arr[i], arr[left], arr[right]};
                    returnList.add(triplet);
                    System.out.println(arr[i]+", "+arr[left]+", "+arr[right]);

                    // to avoid duplicate triplet
                    while (arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                }
                // move the pointer based on different conditions
                else if (arr[left] + arr[right] > -arr[i]) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return returnList;
    }

}
