public class Heapsort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //membangun heap sort Maksimum
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Menyortir array dengan mempertahankan properti heap
        for (int i = n - 1; i > 0; i--) {
            // Menukar elemen teratas yang merupakan elemen terbesar dengan elemen terakhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Memanggil heapify pada subarray yang belum terurut
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inisialisasi node terbesar sebagai root
        int leftChild = 2 * i + 1; // Indeks anak kiri dalam array
        int rightChild = 2 * i + 2; // Indeks anak kanan dalam array

        // Jika anak kiri lebih besar dari root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // Jika anak kanan lebih besar dari root
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // Jika node terbesar bukan lagi root
        if (largest != i) {
            // Menukar elemen root dengan elemen terbesar
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Melakukan rekursi pada subarray yang terpengaruh
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,7,9,10,8,3,4};
        heapSort(arr);

        System.out.println("Hasil pengurutan:");
        for (int i : arr)
            System.out.print(i + " ");
    }
}
