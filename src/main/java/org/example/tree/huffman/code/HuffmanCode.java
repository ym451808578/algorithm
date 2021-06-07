package org.example.tree.huffman.code;

import java.io.*;
import java.util.*;

/**
 * @author castle
 */
public class HuffmanCode {

    private Map<Byte, String> huffmanCodeMap = new HashMap<>();


    public void zipFile(String srcFile, String destFile) {
        try (FileInputStream fileInputStream = new FileInputStream(srcFile)) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            byte[] huffmanBytes = huffmanZip(bytes);

            try (FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    objectOutputStream.writeObject(huffmanBytes);
                    System.out.println(huffmanCodeMap);
                    objectOutputStream.writeObject(huffmanCodeMap);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unZipFile(String srcFile, String destFile) {
        try (FileInputStream fileInputStream = new FileInputStream(srcFile)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                byte[] huffmanBytes = (byte[]) objectInputStream.readObject();
                Map<Byte, String> huffmanCodeMap = (Map<Byte, String>) objectInputStream.readObject();
                byte[] bytes = decode(huffmanCodeMap, huffmanBytes);
                try (FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {
                    fileOutputStream.write(bytes);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] huffmanZip(byte[] bytes) {
        List<Node> nodeList = getNodes(bytes);
        Node root = createHuffmanTree(nodeList);
        Map<Byte, String> map = getCodes(root);
        byte[] zip = zip(bytes, map);
        return zip;
    }

    /**
     * 将bytes转为Node列表
     *
     * @param bytes
     * @return
     */
    public List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodeArrayList.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodeArrayList;
    }

    /**
     * 创建huffman树
     *
     * @param nodeList
     * @return
     */
    public Node createHuffmanTree(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);
            Node tempParent = new Node(null, left.getWeight() + right.getWeight());
            tempParent.setLeft(left);
            tempParent.setRight(right);
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(tempParent);
        }
        return nodeList.get(0);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        if (root.getLeft() != null) {
            preOrder(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrder(root.getRight());
        }

    }

    public Map<Byte, String> getCodes(Node root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return null;
        }
        getCodes(root.getLeft(), "0", builder);
        getCodes(root.getRight(), "1", builder);
        return huffmanCodeMap;
    }

    /**
     * 将huffman树转为huffman编码
     *
     * @param node
     * @param code
     * @param stringBuilder
     */
    private void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder tempStringBuilder = new StringBuilder(stringBuilder);
        tempStringBuilder.append(code);
        if (node != null) {
            if (node.getData() == null) {
                getCodes(node.getLeft(), "0", tempStringBuilder);
                getCodes(node.getRight(), "1", tempStringBuilder);
            } else {
                huffmanCodeMap.put(node.getData(), tempStringBuilder.toString());
            }
        }
    }

    public byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodeMap.get(b));
        }
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String byteString;
            if (i + 8 > stringBuilder.length()) {
                byteString = stringBuilder.substring(i);
            } else {
                byteString = stringBuilder.substring(i, i + 8);
            }
            huffmanBytes[index] = (byte) Integer.parseInt(byteString, 2);
            index++;
        }
        return huffmanBytes;
    }

    public byte[] decode(Map<Byte, String> huffmanCodeMap, byte[] huffmanBytes) {
        System.out.println(Arrays.toString(huffmanBytes));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i != huffmanBytes.length - 1);
            byte b = huffmanBytes[i];
            builder.append(byteToString(flag, b));
        }
        System.out.println(builder.toString());

        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        System.out.println(map);

        List<Byte> byteList = new ArrayList<>();

        for (int i = 0; i < builder.length() - 1; ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = builder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            byteList.add(b);
            i += count;
        }
        byte[] bytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }
        return bytes;
    }

    private String byteToString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String tempStr = Integer.toBinaryString(temp);
        if (flag) {
            return tempStr.substring(tempStr.length() - 8);
        } else {
            return tempStr;
        }
    }
}
