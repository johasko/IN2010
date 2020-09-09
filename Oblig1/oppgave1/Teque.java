import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Teque {
    static ArrayList<Integer> tall = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int x = Integer.parseInt(line[1]);

            if (cmd.length() == 10) {
                push_front(x);
            }
            else if (cmd.length() == 9) {
                push_back(x);
            }
            else if (cmd.length() == 11) {
                push_middle(x);
            }
            else if (cmd.length() == 3) {
                get(x);
            }

        }
    }

    public static void push_front(int i) {
        tall.add(0, i);
    }

    public static void push_back(int i){
        tall.add(i);
    }
    public static void push_middle(int i){
        tall.add(((tall.size()+1)/2), i);
    }
    public static void get(int i){
        System.out.println(tall.get(i));
    }
}
