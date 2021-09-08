package org.example.netty.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MergePackage {

    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\nhaha!\n".getBytes());
        split(source);
    }

    public static void split(ByteBuffer source) {
        source.flip();
        int oldLimit = source.limit();
        System.out.println("old limit:" + oldLimit);
        for (int i = 0; i < oldLimit; i++) {
            if (source.get(i) == '\n') {
                System.out.println(i);
                System.out.println(source.position());
                ByteBuffer target = ByteBuffer.allocate(i + 1 - source.position());
                // 0 ~ limit
                source.limit(i + 1);
                target.put(source); // 从source读，向target写
                ByteBufferUtil.debugAll(target);
                source.limit(oldLimit);
            }
        }
        source.compact();
    }
}
