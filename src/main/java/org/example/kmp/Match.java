package org.example.kmp;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/15 15:18
 */
public class Match {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = getNext(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(str1,str2,getNext(str2)));
    }

    public static int[] getNext(String dest) {
        //声明next数组,最后返回
        int[] next = new int[dest.length()];
        //第一位是0
        next[0] = 0;

        // i表示字符串后缀，j表示字符串前缀
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j)时，我们需要从next[j-1]获取新的j
            // 直到我们发现有dest.charAt(i) != dest.charAt(j)成立才退出
            // 这是KMP算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];

            }
            // 当dest.charAt(i) == dest.charAt(j)时，部分匹配值就是要+1
            // charAt() 方法用于返回指定索引处的字符
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        //返回next数组
        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {

        // 遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {// i指向str1，j指向str2

            // 需要处理 str1.charAt(i) != str2.charAt(j)，去调整j 的大小
            // KMP算法核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {// 找到了
                return i - j + 1;
            }
        }
        return -1;
    }
}
