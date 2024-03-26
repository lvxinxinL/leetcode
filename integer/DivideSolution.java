package integer;

/**
 * 整数除法：不使用 * / % 来计算 num / 2
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-03-19-21:42
 */
public class DivideSolution {
    public static void main(String[] args) {
        int divide = divide(17);
        System.out.println(divide);
    }
    private static int divide(int num) {
        int result = 0;
        int divide = 2;
        while (num > 1) {
            num -= divide;
            result += 1;
            divide +=2;
        }
        return result;
    }
}
