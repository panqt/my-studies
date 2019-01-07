package pers.panqt.data.structure.tree.huffman;

import java.util.*;

/**
 *  @time       2019年01月07日	5:49
 *	@since      V0.1
 *	@author     panqt
 *	@comment    哈夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr ={1,4,5,11,15,16,31,26};
        createHuffmanTree(createList(arr));
    }

    private static List<Node> createList(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for(int i:arr){
            Node node = new Node(i);
            nodes.add(node);
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node node = new Node(nodes.get(0).value+nodes.get(1).value);
            node.setLeft(nodes.get(0));
            node.setRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
        }
        return nodes.get(0);
    }

    static StringBuilder sb = new StringBuilder();
    static Map<Byte,String> huffcodes = new HashMap<>();
    /**
     * 根据哈夫曼树获取哈夫曼编码表
     * */
    public static Map<Byte,String> getHuffmancodes(Node node) {
        if (node!=null){
            getCodes(node.left,"0",sb);
            getCodes(node.right,"1",sb);
        }
        return huffcodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.aByte==null){//不是叶子
            getCodes(node.left,  "0",  sb2);
            getCodes(node.right,  "1",  sb2);
        }else {
            huffcodes.put(node.aByte,sb2.toString());
        }
    }
}
