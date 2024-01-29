import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder sb;
        boolean isAnswer;
        
        for (String skill_tree : skill_trees) {
            sb = new StringBuilder();
            isAnswer = true;
            
            for (int i = 0; i < skill_tree.length(); i++) {
                String subSkill = skill_tree.substring(i, i + 1);
                
                if (skill.contains(subSkill)) {
                    sb.append(subSkill);
                }
            }
            String buffer = sb.toString();
            
            for (int i = 0; i < sb.length(); i++) {
                if (skill.charAt(i) != buffer.charAt(i)) {
                    isAnswer = false;
                    
                    break;
                }
            }
            if (isAnswer)
                answer++;
        }
        return answer;
    }
}