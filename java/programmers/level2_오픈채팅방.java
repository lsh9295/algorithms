import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = solution(record);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s\n", result[i]);
        }
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[] command; // 명령행 분할
        String[] temp = new String[record.length]; // 여기에 Enter, Leave, Change 저장
        String[] temp2 = new String[record.length]; // user.id 저장

        for (int i = 0; i < record.length; i++) {
            command = record[i].split(" ");
            temp[i] = command[0]; // 출입
            temp2[i] = command[1]; // 유저아이디

            if (command[0].equals("Enter")) {  //  입장
                map.put(command[1], command[2]);
            } else if (command[0].equals("Leave")) {  //  퇴장
                continue;
            } else if (command[0].equals("Change")) {  // 닉네임 변경
                map.put(command[1], command[2]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("Enter") || temp[i].equals("Leave"))
                cnt++;
        }

        String[] answer = new String[cnt];
        int j = 0;
        for (int i = 0; i < record.length; i++) {
            if (temp[i].equals("Enter")) {
                answer[j] = map.get(temp2[i]) + "님이 들어왔습니다.";
            } else if (temp[i].equals("Leave")) {
                answer[j] = map.get(temp2[i]) + "님이 나갔습니다.";
            } else if (temp[i].equals("Change")) {
                continue;
            }
            j++;
        }
        return answer;
    }
}
// Enter  유저아이디 닉네임  =>  맵에 추가
// Leave  유저아이디        =>  보류
// Change 유저아이디 닉네임  =>  밸류값만 변경