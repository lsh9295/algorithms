import java.io.*;
import java.util.*;

class User implements Comparable<User>{
    int idx;
    int age;
    String name;

    public User(int idx, int age, String name) {
        this.idx = idx;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        if (this.age == o.age)
            return Integer.compare(this.idx, o.idx);
        
        return Integer.compare(this.age, o.age);
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<User> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new User(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        while(!pq.isEmpty()) {
            User user = pq.poll();
            System.out.println(user.age + " " + user.name);
        }
    }
}