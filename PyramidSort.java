public class PyramidSort {
    static void pyrSort(int[] arr)
    {
        for (int i = arr.length/2 - 1; i >= 0; i--)
            collect(arr, arr.length, i);

        for (int i = arr.length-1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            collect(arr, i, 0);
        }
    }

    static void collect(int[] arr, int size, int root)
    {
        int largest = root;
        int left = 2*root + 1;
        int right = 2*root + 2;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != root)
        {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            collect(arr, size, largest);
        }
    }

    static void printArray(int[] arr)
    {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] mas = {-86, 28, -5, 7, 0, 19, 76, 0, -99};
        pyrSort(mas);
        printArray(mas);
    }
}
