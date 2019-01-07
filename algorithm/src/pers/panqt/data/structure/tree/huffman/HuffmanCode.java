package pers.panqt.data.structure.tree.huffman;

import java.util.*;

/**
 *  @time       2019年01月07日	6:16
 *	@since      V0.1
 *	@author     panqt
 *	@comment    哈夫曼编码
 */
public class HuffmanCode {

    static Map<Byte,String> huffmancodes;


    public static void main(String[] args) {
        String msg = "can a can as cananer can a can.";
        String code = huffmanZip(msg.getBytes());

        System.out.println(msg);

        String text = decode(code);

        System.out.println(text);
    }

    private static String huffmanZip(byte[] bytes){
        //统计每个byte出现的次数
        List<Node> nodes = getNotes(bytes);
        //创建哈夫曼树
        Node node = HuffmanTree.createHuffmanTree(nodes);

        //创建哈夫曼编码表
        huffmancodes = HuffmanTree.getHuffmancodes(node);

        //编码
        String code = coding(bytes);

        return code;
    }

    private static String decode(String code) {

        // 解码得到的字符串
        StringBuilder sb = new StringBuilder();

        Map<String,Byte> map = transformHuffmancodes();
        // 解码器键集合
        Set<String> keys = map.keySet();
        // 从最短的开始匹配之所以能够成功，是因为哈夫曼编码的唯一前缀性质
        // 临时的可能的键值
        String temp = "";
        // 改变temp值大小的游标
        int i = 1;
        while (code.length() > 0) {
            temp = code.substring(0, i);
            if (keys.contains(temp)) {
                char c = (char)(map.get(temp).byteValue());
                sb.append(c);
                code = code.substring(i);
                i = 1;
            } else {
                i++;
            }
        }
        return sb.toString();
        //for (int i=0;i<code.length;i++){
        //    if(i==code.length-1){
        //        sb.append(byteToBit(code[i],false));
        //    }else {
        //        sb.append(byteToBit(code[i],true));
        //    }
        //}
        //System.out.println("\n"+sb.toString());
    }

    private static Map<String,Byte> transformHuffmancodes() {
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffmancodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        return map;
    }

    private static String byteToBit(byte b,boolean flag) {
        int temp=b;
        if(flag)temp|=256;
        String str = Integer.toBinaryString(temp);
        if(flag)return str.substring(str.length()-8);
        else return str;
    }

    private static String coding( byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b :bytes){
            stringBuilder.append(huffmancodes.get(b));
        }
        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();
        //int len;
        //if(stringBuilder.length()%8==0){
        //    len = stringBuilder.length()/8;
        //}else {
        //    len = stringBuilder.length()/8 +1;
        //}
        //byte[] by = new byte[len];
        //for(int i=0;i<len;i++){
        //    String strByte;
        //    if(8*i+8>stringBuilder.length()){
        //        strByte = stringBuilder.substring(8*i);
        //    }else {
        //        strByte = stringBuilder.substring(8*i,8*i+8);
        //    }
        //    System.out.print(strByte);
        //    byte byt = (byte)Integer.parseInt(strByte,2);
        //    by[i]=byt;
        //}
        //return by;
    }

    private static List<Node> getNotes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();

        Map<Byte,Integer> map = new HashMap<>();
        for (byte b:bytes){
            Integer count = map.get(b);
            if (count==null){
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }

        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
