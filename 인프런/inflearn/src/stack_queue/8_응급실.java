import java.io.*;
import java.util.*;

class Patient {
    int id;
    int p;
    public Patient(int id, int p) {
        this.id = id;
        this.p = p;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        Queue<Patient> queue = new LinkedList<>();

        int N = Integer.parseInt(st1.nextToken()); // 환자 수
        int M = Integer.parseInt(st1.nextToken()); // M번 째 환자

        for (int i = 0; i < N; i++) {
            queue.offer(new Patient(i, Integer.parseInt(st2.nextToken())));
        }
        int answer = 0;

        while (!queue.isEmpty()) {
            Patient tmp = queue.poll();
            for (Patient patient : queue) {
                if (patient.p > tmp.p) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == M) {
                    System.out.println(answer);
                }
            }
        }
    }
}