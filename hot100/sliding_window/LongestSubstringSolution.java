package hot100.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-16-10:46
 */
public class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口，保证窗口内的字符不重复 => 哈希集合 HashSet
        Set<Character> set = new HashSet<>();
        int rk = -1, ans = 0;
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            // 每次移动一格左指针，从哈希集合中移除一个字符
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 不断向右移动右指针，直到遇到重复字符
            while (rk + 1< length && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));// 将字符加入哈希集合与后面的比较
                rk++;
            }
            // 计算当前没有重复的最长子串长度是否要更新
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
