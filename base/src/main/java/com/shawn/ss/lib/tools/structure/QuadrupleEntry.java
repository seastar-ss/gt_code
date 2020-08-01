package com.shawn.ss.lib.tools.structure;

public class QuadrupleEntry<K1, K2, K3, V> implements java.io.Serializable {
    private final K1 k1;
    private final K2 k2;
    private final K3 k3;
    private final V v;

    public QuadrupleEntry(K1 k1, K2 k2, K3 k3, V v) {
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.v = v;
    }

    public K1 getK1() {
        return k1;
    }

    public K2 getK2() {
        return k2;
    }

    public K3 getK3() {
        return k3;
    }

    public V getV() {
        return v;
    }





    @Override
    public String toString() {
        return "QuadrupleEntry{" +
                "k1 :" + k1 +
                ", k2 :" + k2 +
                ", k3 :" + k3 +
                ", v :" + v +
                '}';
    }
}
