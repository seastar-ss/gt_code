package com.shawn.ss.lib.tools.structure;

public class TripleEntry<K1, K2, V> implements  java.io.Serializable  {
    private final K1 k1;
    private final K2 k2;
    private final V v;

    public TripleEntry(K1 k1, K2 k2, V v) {
        this.k1 = k1;
        this.k2 = k2;
        this.v = v;
    }

    public K1 getK1() {
        return k1;
    }

    public K2 getK2() {
        return k2;
    }

    public V getV() {
        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripleEntry)) return false;

        TripleEntry<?, ?, ?> that = (TripleEntry<?, ?, ?>) o;

        if (getK1() != null ? !getK1().equals(that.getK1()) : that.getK1() != null) return false;
        if (getK2() != null ? !getK2().equals(that.getK2()) : that.getK2() != null) return false;
        return getV() != null ? getV().equals(that.getV()) : that.getV() == null;
    }

    @Override
    public int hashCode() {
        int result = getK1() != null ? getK1().hashCode() : 0;
        result = 31 * result + (getK2() != null ? getK2().hashCode() : 0);
        result = 31 * result + (getV() != null ? getV().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripleEntry{" +
                "k1 :" + k1 +
                ", k2 :" + k2 +
                ", v :" + v +
                '}';
    }
}
