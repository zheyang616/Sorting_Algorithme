//Zhe Yang

/**
 * findSingle
 */
public class findSolo {

    //Define the method
    public static int binSearch(int[] arr) {
        //defining the length of the array, which set the boundaries of the search space.
        int low = 0;
        int high = arr.length - 1;

         
        //Do not know the size of the array, while loop fits the situation.
        while (low < high) {
            //binary search starts from the middle
            int mid = (high + low) / 2;

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2; // Move to the right of the pair
                } else {
                    high = mid; // Unique element is to the left
                }
            } else {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1; // Move to the right of the pair
                } else {
                    high = mid - 1; // Unique element is to the left
                }
            }
        }
 
    return arr[low];
}
    //Define the execution method
    public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 9 };
    int[] arr1 = {1, 2, 2, 9, 9 };
    int[] arr2 = {1, 1, 2, 2, 3, 3, 8};
    int[] arr3 = {1, 1, 2, 3, 3, 9, 9};
    System.out.println("The single element in arr is " + binSearch(arr));
    System.out.println("The single element in arr1 is " + binSearch(arr1));
    System.out.println("The single element in arr2 is " + binSearch(arr2));
    System.out.println("The single element in arr3 is " + binSearch(arr3));
}
}
//A brief write-up
//The issues I had including but not limited to 
//understanding what the problem is asking, 
//how to decide which half need to be cut off, and how to accomplish it etc.
//For example, according to the hint and the observation, 
//I realized that the total amount of the numbers is an odd number, 
//but the mid could be either an even or an odd number, following that, 
//each possibility has two sub-possibility, where the solo number located at,
//left or right?  After figured out these four possibilities, 
//I need to fulfill them in codes.  while loop fits the situation,
//because I do not know how big the array could be.
