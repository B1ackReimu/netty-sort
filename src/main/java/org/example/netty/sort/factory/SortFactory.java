package org.example.netty.sort.factory;

import org.example.netty.sort.algorithm.MergeSort;
import org.example.netty.sort.algorithm.SortAPI;
import org.example.netty.sort.bean.SortBean;
import org.example.netty.sort.bean.TestBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SortFactory {

    private static Map<String, SortAPI> sortAPIService = new HashMap<>();

    public static void main(String[] args) throws Exception {
        TestBean[] testBeans = new TestBean[1000000];
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            TestBean testBean = new TestBean();
            testBean.setAge(random.nextInt(100000) + 1);
            testBean.setName("test" + random.nextInt(50000) + 1);
            testBeans[i] = testBean;
        }
        SortAPI sortAPI = new MergeSort();
        SortBean sortBean = new SortBean("age", SortBean.TYPE_INT, true);
        long l = System.currentTimeMillis();
        sortAPI.sort(sortBean, testBeans);
        System.out.println(System.currentTimeMillis() - l);
    }
}
