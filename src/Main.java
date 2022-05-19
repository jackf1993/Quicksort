/* author: Jack Farah
 * description: Implementation of Quicksort algorithm sorting 10 rand numbers at time complexity of O(nlogn).
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();   // Random object created
        int [] numbers = new int [5];  // initializing array of size 10 to build array with rand ints.

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt() % 10;  // storing the rand ints generated into the array names numbers
        }

        System.out.println("Before:");   //printing unsorted array
        printArray(numbers);

        quicksort(numbers, 0, numbers.length-1); //calling quicksort method

        System.out.println("After:");   // printing sorted array
        printArray(numbers);
    }

   /* type: method
    * return type: void
    * parameters: int[] array, int lowIndex, int highIndex
    * description: recursively sorts out the array by "dividing and concurring" approach. This method initializes the
    *                          left pointer to increase its index by calling the partition method, which to do the
    *                          actual comparison.
    */
    private static void quicksort(int [] array, int lowIndex, int highIndex){

        if(lowIndex >= highIndex){
            return;
        }
        int leftPointer = partition(array, lowIndex, highIndex);
        swap(array, leftPointer, highIndex);

        quicksort(array, lowIndex, leftPointer -1);
        quicksort(array, leftPointer +1, highIndex );
    }

    /* type: method
     * return type: int
     * parameters: int [] array, int lowIndex, int highIndex
     * Description: increments the leftPointer until a lower element is found compared to the pivot and decrements the
     *              rightPointer until a high element is found compared to the pivot. Once both are found, we call the
     *              swap method.
     */
    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){

            while(array[leftPointer] <= pivot && leftPointer< rightPointer){
                leftPointer++;
            }

            while(array[rightPointer]>= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);

        }
        return leftPointer;
    }

    private static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }



    private static void printArray(int[] numbers) { //print method to print the arrays
        for(int i =0; i < numbers.length ; i++){
            System.out.print(numbers[i] +", ");
        }
        System.out.print("\b");
        System.out.println("");
    }
}
