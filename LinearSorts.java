/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsorts;

/**
 *
 * @author paul5
 */
public class LinearSorts {
    
    
    
    private int[] randomizedQuickselect(int[] nums, int l, int r){
        
        int[] copy = java.util.Arrays.copyOf(nums, nums.length);
        
    }
    
    
    
    /**
     * This method implements counting sort with 0-indexed arrays
     * @param nums int array to be sorted
     * @param sorted int array with sorted output
     * @param k int max value
     */
    private int[] countingSort(int[] nums, int[] sorted,int k ){
        
        int[] counts = new int[k+1];
        
        for (int i = 0; i <= k; i++)
            counts[i] = 0;
        
        //increment counter array if value j is seen
        //counts[i] will contain the number of elements equal to i
        //after this loop
        for (int j = 0; j < nums.length;j++)
            counts[nums[j]] = counts[nums[j]]+1;
        
        //counts[i] will now contain the number of elements <= i
        for (int i = 1; i <= k; i++){
            counts[i] = counts[i] + counts[i-1];
        }
        
        for (int j = nums.length-1; j >= 0; j--){
            sorted[counts[nums[j]]-1] = nums[j];
            counts[nums[j]] = counts[nums[j]] - 1;
        }
        
        return sorted;
    }
    
    /**
     * Simple method to nicely print an array
     * @param nums int array to be printed 
     */
    private void printArray(int[] nums){
        for (int i: nums){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    
    /**
     * Method to find the largest value in an array
     * @param nums int array you wish to find the max of
     * @return max largest int in the array nums
     */
    private int findMax(int[] nums){
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }
    
    
    /**
     * This main method runs 5 test cases on each of the sorts implemented above
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
        
        int[] nums1 = {2,14,16,24,10};
        int[] nums11 = new int[nums1.length];
        int[] nums2 = {1,5,4,7,8,34,16,9,2};
        int[] nums22 = new int[nums2.length];
        int[] nums3 = {32, 25, 16, 98, 28, 87, 36, 5, 58, 21, 40, 71, 55, 21, 4, 52, 32, 51, 4, 44};
        int[] nums33 = new int[nums3.length];
        int[] nums4 = {27, 5, 21, 51, 64, 88, 5, 77, 67, 87, 81, 17, 95, 88, 46, 32, 63, 76, 18, 83};
        int[] nums44 = new int[nums4.length];
        int[] nums5 = {49, 52, 34, 47, 62, 71, 12, 6, 63, 87, 85, 94, 69, 55, 39, 46, 3, 70, 57, 65,
            67, 58, 84, 43, 21, 50, 93, 74, 96, 43, 20, 50, 7, 25, 77, 73, 12, 28, 9, 58, 30, 16, 23,
            48, 72, 22, 63, 73, 60, 99, 60, 80, 69, 58, 43, 16, 46, 37, 81, 5, 59, 61, 84, 14, 84, 19,
            98, 3, 45, 46, 25, 77, 50, 14, 29, 50, 54, 53, 1, 59};
        int[] nums55 = new int[nums5.length];
        
        LinearSorts ls = new LinearSorts();
        
        ls.printArray(nums2);
        ls.printArray(ls.countingSort(nums2, nums22, ls.findMax(nums2)));
        System.out.println("-----------------------------------------");
        
        ls.printArray(nums1);
        ls.printArray(ls.countingSort(nums1, nums11, ls.findMax(nums1)));
        System.out.println("-----------------------------------------");
  
        ls.printArray(nums3);
        ls.printArray(ls.countingSort(nums3, nums33, ls.findMax(nums3)));
        System.out.println("-----------------------------------------");
 
        ls.printArray(nums4);
        ls.printArray(ls.countingSort(nums4, nums44, ls.findMax(nums4)));
        System.out.println("-----------------------------------------");
        
        ls.printArray(nums5);
        ls.printArray(ls.countingSort(nums5, nums55, ls.findMax(nums5)));
        System.out.println("-----------------------------------------");
        
        
        
        
    }
    
}
