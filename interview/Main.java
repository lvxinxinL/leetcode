package interview;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();

            String strDescription = in.nextLine();

            int totalWeight = 0;
            StringBuffer sb = new StringBuffer();
            int currentLength = 0;
            for (char c : strDescription.toCharArray()) {
                if (Character.isDigit(c)) {
                    currentLength = currentLength * 10 + (c - '0');
                } else {
                    sb.append(String.valueOf(Character.toLowerCase(c)).repeat(currentLength));
                    totalWeight += currentLength * getUniqueChars(sb.toString()).size();
                    sb.setLength(0);
                    currentLength = 0;
                }
            }
            if (sb.length() > 0) {
                totalWeight += currentLength * getUniqueChars(sb.toString()).size();
            }

            if (totalWeight < k) {
                System.out.println("-1");
            }
            in.close();
        }
    }

    private static Set<Character> getUniqueChars(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }
}