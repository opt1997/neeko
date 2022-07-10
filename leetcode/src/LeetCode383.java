import java.util.HashMap;

// 383. 赎金信 https://leetcode.cn/problems/ransom-note/
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rMap = new HashMap<>();
        for (Character c : ransomNote.toCharArray()) {
            rMap.put(c, rMap.getOrDefault(c,0)+1);
        }
        for (Character c : magazine.toCharArray()) {
            if (rMap.get(c)!=null) {
                Integer num = rMap.get(c);
                if (num==1) {
                    rMap.remove(c);
                }else {
                    rMap.put(c, rMap.get(c)-1);
                }
                if (rMap.size()==0) {
                    return true;
                }
            }
        }
        return false;
    }
}
