/**
 * SortingProject
 */
public class SortingProject {

    public static void main(String[] args) {
        int[] arr = {3, 54, 21, 1, 58, 87, 89, 9000, 2, 1};

        long startTime = System.nanoTime();

        for(int value : arr){
            System.out.print(" " + value);
        }

        //BubbleSort(arr);
        
        MergeSort(arr);
        
        for (int value : arr){
            System.out.print(" " + value);
        }
        //InsertionSort(arr);
        System.out.println();
        for(int value:arr){
            System.out.print(" " + value);
        }
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println(elapsedNanos);
        System.out.println(elapsedNanos/1000000);
    }

public static void BubbleSort(int[] arr){

        int temp;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++)
            //swapping
            if(arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

public static void SelectionSort(int[] arr){
    int minIndex, temp;

    for(int i = 0; i < arr.length; i++){
        minIndex = i;

        for(int j = i; j < arr.length; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }

        temp = arr[i];
        arr[i] = minIndex;
        arr[minIndex] = temp;

    }
}


public static void InsertionSort(int[] arr){
    int temp, j;
    
    for(int i = 0; i < arr.length; i++) {
        temp = arr[i];
        //this loop will move out elements
        for(j = i; j > 0 && arr[j -1] > temp; j--){
            arr[j] = arr[j - 1];
        }

        arr[j] = temp;
    }
}

public static void MergeSort(int[] arr){
    int length = arr.length;

    if(length <= 1) return;

    int middle = length / 2;
    int[] leftArray = new int[middle];
    int[] rightArray = new int[length - middle];

    int l = 0; // index to keep track for our left array
    int r = 0; // index to keep track for our right array

    //populate the left and right arrays
    for(; l < length; l++){
        if(l < middle){
            leftArray[l] = arr[l];
        }else{
            rightArray[r] = arr[l];
            r++;
        }
    }

    MergeSort(leftArray);
    MergeSort(rightArray);
    Merge(leftArray, rightArray, arr);
}
public static void Merge(int[] leftArray, int[] rightArray, int[] array){
    int leftArraySize = leftArray.length;
    int rightArraySize = rightArray.length;

    int mainIndex = 0, leftArrayIndex = 0, rightArrayIndex = 0;

    if(leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){
        if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]){
            array[mainIndex] = leftArray[leftArrayIndex];
            mainIndex++;
            leftArrayIndex++;
        }else{
            array[mainIndex] = rightArray[rightArrayIndex];
            mainIndex++;
            rightArrayIndex++;
        }
    }

    while (leftArrayIndex < leftArraySize) {
        array[mainIndex] = leftArray[leftArrayIndex];
        mainIndex++;
        leftArrayIndex++;        
    }

    while (rightArrayIndex < rightArraySize) {
        array[mainIndex] = rightArray[rightArrayIndex];
        mainIndex++;
        rightArrayIndex++;
    }
}
}