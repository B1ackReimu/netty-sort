package org.example.netty.sort.factory;

public enum SortAlgorithm {

    MERGE_SORT("mergeSort"),QUICK_SORT("quickSort");

    private final String algorithm;

    SortAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
