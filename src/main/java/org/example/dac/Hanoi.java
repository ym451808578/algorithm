package org.example.dac;

/**
 * @author Castle
 * @Date 2021/6/9 15:59
 */
public class Hanoi {

    public void tower(int num,String a, String b, String c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "-->" + c);
        }else {
            tower(num-1,"A","C","B");
            System.out.println("第"+num+"个盘从"+a+"-->"+c);
            tower(num-1,"B","A","C");
        }
    }
}
