package org.example.netty.sort.algorithm;

import org.example.netty.sort.bean.SortBean;

public interface MergeSortAPI extends SortAPI {

    void merge(SortBean sortBean, Object[] arrays, int left, int mid, int right, Object[] temp);

    void sort(SortBean sortBean, Object[] arrays, int left, int right, Object[] temp);

}
