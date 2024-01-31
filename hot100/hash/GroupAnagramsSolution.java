package hot100.hash;

import java.util.*;

/**
 * 49. 字母异位词分组
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-31-11:13
 */
public class GroupAnagramsSolution {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 字母异位词分组
     * @param strs 字符串数组
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 字母异位词排序之后是相同的字符串，以排序后的字符串为键
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());// 已存在该字符串序列
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
