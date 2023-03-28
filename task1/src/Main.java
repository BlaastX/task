import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // размер массива
        int m = Integer.parseInt(args[1]); // длина обхода
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        ArrayList<Integer> path = findPath(arr, m);
        System.out.println("Полученный путь: " + path.toString().replaceAll("[\\[\\],]", ""));
    }

    public static ArrayList<Integer> findPath(int[] arr, int m) {
        ArrayList<Integer> path = new ArrayList<>();
        int currentIndex = 0;
        while (path.size() < arr.length) {
            int nextIndex = (currentIndex + m - 1) % arr.length;
            path.add(arr[nextIndex]);
            arr = removeElementAtIndex(arr, nextIndex);
            currentIndex = nextIndex % arr.length;
        }
        return path;
    }

    public static int[] removeElementAtIndex(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }
}
