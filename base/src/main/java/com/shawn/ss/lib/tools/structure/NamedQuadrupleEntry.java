package com.shawn.ss.lib.tools.structure;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.List;

public class NamedQuadrupleEntry<K1, K2,K3, V> extends QuadrupleEntry<K1, K2,K3, V> implements  java.io.Serializable,NamedStructure  {
    private static final long serialVersionUID = -6491721149061230385L;

    public static <K1,K2,K3,V> NamedQuadrupleEntryBuilder<K1,K2,K3,V> newBuilder(String k1n, String k2n,String k3n, String vn){
        return new NamedQuadrupleEntryBuilder<>(k1n,k2n,k3n,vn);
    }

    public static <K1,K2,K3,V> NamedQuadrupleEntryListBuilder<K1,K2,K3,V> newListBuilder(String k1n,String k2n,String k3n,String vn){
        return new NamedQuadrupleEntryListBuilder<>(k1n,k2n,k3n,vn);
    }

    public static <K1,K2,K3,V> NamedQuadrupleEntry<K1,K2,K3,V> newInstance(String k1n, String k2n, String k3n,String vn, K1 k1, K2 k2,K3 k3, V v){
        return new NamedQuadrupleEntryBuilder<K1,K2,K3,V>(k1n,k2n,k3n,vn).newInstance(k1,k2,k3,v);
    }

    private final NamedQuadrupleEntryBuilder<K1,K2,K3,V> builder;

    public final static class NamedQuadrupleEntryListBuilder<K1,K2,K3,V> extends NamedQuadrupleEntryBuilder<K1,K2,K3,V> {

        final List<NamedQuadrupleEntry<K1,K2,K3,V>> list;

        NamedQuadrupleEntryListBuilder(String key1Name,String key2Name,String key3Name, String valueName) {
            super(key1Name,key2Name,key3Name, valueName);
            list= CollectionHelper.newList();
        }

        public NamedQuadrupleEntryListBuilder<K1,K2,K3,V> addInstance(K1 k1,K2 k2,K3 k3, V v){
            list.add(new NamedQuadrupleEntry<K1,K2,K3,V>(k1,k2,k3,v,this));
            return this;
        }

        public List<NamedQuadrupleEntry<K1,K2,K3,V>> getList() {
            return list;
        }
    }

    public static class NamedQuadrupleEntryBuilder<K1,K2,K3,V>{

        final String key1Name;
        final String key2Name;
        final String key3Name;
        final String valueName;

        NamedQuadrupleEntryBuilder(String key1Name, String key2Name,String key3Name, String valueName) {
            this.key1Name = key1Name;
            this.key2Name = key2Name;
            this.key3Name = key3Name;
            this.valueName = valueName;
        }

        public NamedQuadrupleEntry<K1,K2,K3,V> newInstance(K1 k1, K2 k2,K3 k3, V v){
            return new NamedQuadrupleEntry<K1,K2,K3,V>(k1,k2,k3,v,this);
        }

        public String getKey1Name() {
            return key1Name;
        }

        public String getKey2Name() {
            return key2Name;
        }

        public String getKey3Name() {
            return key3Name;
        }

        public String getValueName() {
            return valueName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NamedQuadrupleEntryBuilder)) return false;

            NamedQuadrupleEntryBuilder<?, ?, ?, ?> that = (NamedQuadrupleEntryBuilder<?, ?, ?, ?>) o;

            if (!getKey1Name().equals(that.getKey1Name())) return false;
            if (!getKey2Name().equals(that.getKey2Name())) return false;
            if (!getKey3Name().equals(that.getKey3Name())) return false;
            return getValueName().equals(that.getValueName());
        }

        @Override
        public int hashCode() {
            int result = getKey1Name().hashCode();
            result = 31 * result + getKey2Name().hashCode();
            result = 31 * result + getKey3Name().hashCode();
            result = 31 * result + getValueName().hashCode();
            return result;
        }

        @Override
        public String toString() {
            return " Name:{" +
                    "" + key1Name  +
                    "," + key2Name +
                    "," + key3Name +
                    ", " + valueName  +
                    '}';
        }
    }

    public String getKey1Name() {
        return builder.getKey1Name();
    }

    public String getKey2Name() {
        return builder.getKey2Name();
    }

    public String getValueName() {
        return builder.getValueName();
    }

    private NamedQuadrupleEntry(K1 k1, K2 k2,K3 k3, V v, NamedQuadrupleEntryBuilder<K1,K2,K3,V> builder) {
        super(k1, k2,k3, v);
        this.builder=builder;
    }

    public NamedQuadrupleEntry<K1,K2,K3,V> newInstance(K1 k1, K2 k2,K3 k3, V v) {
        return builder.newInstance(k1, k2,k3, v);
    }

    public NamedQuadrupleEntryBuilder<K1,K2,K3,V> getBuilder() {
        return builder;
    }



    @Override
    public String toString() {
        return super.toString()+builder.toString();
    }

    @Override
    public boolean isSameType(NamedStructure str) {
        return this.getClass().equals(str.getClass()) && this.getName().equals(str.getName());
    }

    @Override
    public String getName() {
        return builder.toString();
    }

    @Override
    public String getDescription() {
        return "this class define "+getKey1Name() +" "+getKey2Name() +" "+ getKey2Name() +" "+getValueName()+" Quadruple group";
    }


}
