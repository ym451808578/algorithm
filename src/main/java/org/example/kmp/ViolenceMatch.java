package org.example.kmp;

/**
 * @author Castle
 * @Date 2021/6/15 10:45
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "烦恼不寻人 寻人 人 人自寻烦恼 烦恼 恼";
        String str2 = "人自寻烦恼";
        System.out.println(match(str1, str2));
    }

    public static int match(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int str1Len = chars1.length;
        int str2Len = chars2.length;
        int str1Index = 0;
        int str2Index = 0;
        while (str1Index < str1Len && str2Index < str2Len) {
            if (chars1[str1Index] == chars2[str2Index]) {
                str1Index++;
                str2Index++;
            } else {
                str1Index = str1Index - (str2Index - 1);
                str2Index = 0;
            }
        }
        if (str2Index == str2Len) {
            return str1Index - str2Index;
        } else {
            return -1;
        }
    }
}
