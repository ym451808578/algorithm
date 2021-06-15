package org.example.dp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Castle
 * @Date 2021/6/15 9:14
 */
@Data
@AllArgsConstructor
public class Goods {
    private String name;
    private int weight;
    private int value;
}
