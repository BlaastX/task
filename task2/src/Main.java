public class Main {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(getSize(n, m));
    }
    public static String getSize(int n, int m){
        int i = 1;
        String size = "";
        while (true){
            size = size + i;
            i = 1 + (i + m - 2) % n;
            if (i == 1) {
                break;
            }
        }
        return size;
    }
}
