package org.example.tree.huffman.code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author castle
 */
public class Main {

    public static void main(String[] args) {
        String string = "i want to learn java well";
        byte[] stringBytes = string.getBytes();
        System.out.println(Arrays.toString(stringBytes));
        System.out.println(stringBytes.length);
        HuffmanCode huffmanTree = new HuffmanCode();
        List<Node> nodeList = huffmanTree.getNodes(stringBytes);
        Node root = huffmanTree.createHuffmanTree(nodeList);
        huffmanTree.preOrder(root);

        Map<Byte, String> huffmanCodeMap = huffmanTree.getCodes(root);
        System.out.println(huffmanCodeMap);
        byte[] zipBytes = huffmanTree.zip(stringBytes, huffmanCodeMap);
        System.out.println(zipBytes.length);
        byte[] decodeBytes = huffmanTree.decode(huffmanCodeMap, zipBytes);
        System.out.println(Arrays.toString(decodeBytes));
        System.out.println(new String(decodeBytes));

        System.out.println("*************");

//        String srcFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/老师笔记.pdf";
//        String destFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/11.zip";
//        huffmanTree.zipFile(srcFile, destFile); String srcFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/老师笔记.pdf";
//        String destFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/11.zip";
//        huffmanTree.zipFile(srcFile, destFile);

        String destFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/老师笔记1.pdf";
        String srcFile = "/Users/castle/Downloads/尚硅谷韩顺平老师数据结构分享/11.zip";
        huffmanTree.unZipFile(srcFile, destFile);

    }

}
