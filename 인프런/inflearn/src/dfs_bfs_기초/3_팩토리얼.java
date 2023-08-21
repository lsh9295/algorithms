package dfs_bfs_기초;

public class Main {
    public static void main(String[] args){
        System.out.println(reculsive(5));
    }

    public static int reculsive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * reculsive(n - 1);
        }
    }
}