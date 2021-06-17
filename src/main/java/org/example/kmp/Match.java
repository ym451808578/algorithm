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
        int[] next2 = getNext2(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(next2));
        System.out.println(kmpSearch(str1, str2, next));
        System.out.println(kmpSearch2(str1, str2, next2));
    }

    public static int[] getNext2(String dest) {
        int[] next = new int[dest.length()];
        char[] arr = dest.toCharArray();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < dest.length() - 1) {
            if (k == -1 || arr[j] == arr[k]) {
                ++k;
                ++j;
                if (arr[j] != arr[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }

            } else {
                k = next[k];
            }
        }
        return next;
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

    public static int kmpSearch2(String str1, String str2, int[] next) {
        int i = 0, j = 0;
        int sLen = str1.length();
        int pLen = str2.length();
        char[] sArr = str1.toCharArray();
        char[] pArr = str2.toCharArray();
        while (i < sLen && j < pLen) {
            if (j == -1 || sArr[i] == pArr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int kmpSearch(String str1, String str2, int[] next) {

        // 遍历
        // i指向str1，j指向str2
        for (int i = 0, j = 0; i < str1.length(); i++) {

            // 需要处理 str1.charAt(i) != str2.charAt(j)，去调整j 的大小
            // KMP算法核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            // 找到了
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
