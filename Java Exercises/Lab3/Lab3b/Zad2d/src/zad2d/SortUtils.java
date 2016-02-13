/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2d;

/**
 *
 * @author sstoyanov
 */
public class SortUtils {
    
    public void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%1s ", a[i]);
        }
        System.out.println();
    }
            
    public int[] mergeSort(int[] a)
    {
        if (a.length == 1)
        {
            return a; //If the left/right subarray reach a length of 1, this bottom of the recursion returns the array of 1 element...
        }

        //Split the array into two parts...
        int middle = a.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
        {
            left[i] = a[i];
        }
        int[] right = new int[a.length - middle];
        for (int i = 0; i < a.length - middle; i++)
        {
            right[i] = a[i + middle];
        }

        //Recursively invoke this method to split and merge every left and right subarray into two parts until their length is 1...
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
    }
    
    private int[] merge(int[] left, int[] right){
        int l = 0;
        int r = 0;

        //Here we merge the recieved  subarrays from the recursions in otder to merge them...
        //After all the parts are recursively splited and sorted, the first started method comes here and merge the first two already         
        // sorted arrays and finally returns the whole array sorted...
        int[] sorted = new int[left.length + right.length];
        for (int i = 0; i < left.length + right.length; i++)
        {
            if (l < left.length && r < right.length)
            {
                if (left[l] < right[r])
                {
                    sorted[i] = left[l];
                    l++;
                }
                else
                {
                    sorted[i] = right[r];
                    r++;
                }
            }
            else
            {
                if (l < left.length)
                {
                    sorted[i] = left[l];
                    l++;
                }
                else
                {
                    sorted[i] = right[r];
                    r++;
                }
            }
        }
        
        return sorted;
    }
}
