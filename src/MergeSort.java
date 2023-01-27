 class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {2, 5, 23, 6, 6, 10, 3, 7, 9};
        for (int item: mergeSort(array)) {
            System.out.print(" " + item);
        }
    }
    public static int[] mergeSort(int[] sortArray){
        if (sortArray.length == 1)
            return sortArray;
        else{
            int divLength = (sortArray.length + 1)/ 2;
            int[] firstPart = new int[divLength];
            int[] secondPart = new int[sortArray.length - firstPart.length];

            for (int i = 0; i < firstPart.length; i++) {
                firstPart[i] = sortArray[i];
                if (i < secondPart.length)
                    secondPart[i] = sortArray[divLength + i];
            }

            return mergeArray(mergeSort(firstPart), mergeSort(secondPart));
        }
    }
    private static int [] mergeArray(int[] firstArray, int[] secondArray){
        int[] resultArray = new int [(firstArray.length + secondArray.length)];
        for (int f = 0, s = 0, i = 0; i < resultArray.length; i++) {
            if (firstArray.length > f && secondArray.length > s){
                if (firstArray[f] > secondArray[s]) {
                    resultArray[i] = secondArray[s];
                    s++;
                }
                else {
                    resultArray[i] = firstArray[f];
                    f++;
                }
            }
            else if (firstArray.length <= f){
                resultArray[i] = secondArray[s];
                s++;
            }
            else {
                resultArray[i] = firstArray[f];
                f++;
            }
        }
        return resultArray;
    }
}
