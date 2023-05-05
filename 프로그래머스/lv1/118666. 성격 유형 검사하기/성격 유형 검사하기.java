import java.util.HashMap;

class Solution {
    public String solution(String[] surveys, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < surveys.length; i++) {
            String[] category = surveys[i].split(""); // ex) ["A", "N"]
            int choice = choices[i];
            int point = 0;

            switch (choice) {
                case 1:
                    point = map.get(category[0]);
                    point += 3;
                    map.replace(category[0], point);
                    break;
                case 2:
                    point = map.get(category[0]);
                    point += 2;
                    map.replace(category[0], point);
                    break;
                case 3:
                    point = map.get(category[0]);
                    point += 1;
                    map.replace(category[0], point);
                    break;
                case 4:
                    break;
                case 5:
                    point = map.get(category[1]);
                    point += 1;
                    map.replace(category[1], point);
                    break;
                case 6:
                    point = map.get(category[1]);
                    point += 2;
                    map.replace(category[1], point);
                    break;
                case 7:
                    point = map.get(category[1]);
                    point += 3;
                    map.replace(category[1], point);
                    break;
            }
        }
        if (map.get("R") >= map.get("T"))
            answer = answer.concat("R");
        else
            answer = answer.concat("T");

        if (map.get("C") >= map.get("F"))
            answer = answer.concat("C");
        else
            answer = answer.concat("F");

        if (map.get("J") >= map.get("M"))
            answer = answer.concat("J");
        else
            answer = answer.concat("M");

        if (map.get("A") >= map.get("N"))
            answer = answer.concat("A");
        else
            answer = answer.concat("N");

        return answer;
    }
}