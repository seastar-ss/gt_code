package com.shawn.ss.lib.tools.structure;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.List;

public class NamedTripleEntry<K1, K2, V> extends TripleEntry<K1, K2, V> implements  java.io.Serializable,NamedStructure  {
    private static final long serialVersionUID = -8499721149061230385L;

    public static <K1,K2,V> NamedTripleEntryBuilder<K1,K2,V> newBuilder(String k1n, String k2n, String vn){
        return new NamedTripleEntryBuilder<>(k1n,k2n,vn);
    }

    public static <K1,K2,V> NamedTripleEntryListBuilder<K1,K2,V> newListBuilder(String k1n,String k2n,String vn){
        return new NamedTripleEntryListBuilder<>(k1n,k2n,vn);
    }

    public static <K1,K2,V> NamedTripleEntry<K1,K2,V> newInstance(String k1n, String k2n, String vn, K1 k1, K2 k2, V v){
        return new NamedTripleEntryBuilder<K1,K2,V>(k1n,k2n,vn).newInstance(k1,k2,v);
    }

    private final NamedTripleEntryBuilder<K1,K2,V> builder;

    public final static class NamedTripleEntryListBuilder<K1,K2,V> extends NamedTripleEntryBuilder<K1,K2,V> {

        final List<NamedTripleEntry<K1, K2, V>> list;

        NamedTripleEntryListBuilder(String key1Name,String key2Name, String valueName) {
            super(key1Name,key2Name, valueName);
            list= CollectionHelper.newList();
        }

        public NamedTripleEntryListBuilder<K1,K2, V> addInstance(K1 k1,K2 k2, V v){
            list.add(new NamedTripleEntry<K1,K2, V>(k1,k2,v,this));
            return this;
        }

        public List<NamedTripleEntry<K1,K2, V>> getList() {
            return list;
        }
    }

    public static class NamedTripleEntryBuilder<K1,K2,V>{

        final String key1Name;
        final String key2Name;
        final String valueName;

        NamedTripleEntryBuilder(String key1Name, String key2Name, String valueName) {
            this.key1Name = key1Name;
            this.key2Name = key2Name;
            this.valueName = valueName;
        }

        public NamedTripleEntry<K1,K2, V> newInstance(K1 k1, K2 k2, V v){
            return new NamedTripleEntry<K1,K2, V>(k1,k2,v,this);
        }

        public String getKey1Name() {
            return key1Name;
        }

        public String getKey2Name() {
            return key2Name;
        }

        public String getValueName() {
            return valueName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NamedTripleEntry.NamedTripleEntryBuilder)) return false;

            NamedTripleEntryBuilder<?, ?, ?> that = (NamedTripleEntryBuilder<?, ?, ?>) o;

            if (!getKey1Name().equals(that.getKey1Name())) return false;
            if (!getKey2Name().equals(that.getKey2Name())) return false;
            return getValueName().equals(that.getValueName());
        }

        @Override
        public int hashCode() {
            int result = getKey1Name().hashCode();
            result = 31 * result + getKey2Name().hashCode();
            result = 31 * result + getValueName().hashCode();
            return result;
        }

        @Override
        public String toString() {
            return " Name:{" +
                    "" + key1Name  +
                    "," + key2Name +
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

    private NamedTripleEntry(K1 k1, K2 k2, V v, NamedTripleEntryBuilder<K1,K2,V> builder) {
        super(k1, k2, v);
        this.builder=builder;
    }

    public NamedTripleEntry<K1, K2, V> newInstance(K1 k1, K2 k2, V v) {
        return builder.newInstance(k1, k2, v);
    }

    public NamedTripleEntryBuilder<K1,K2, V> getBuilder() {
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
        return "this class define "+getKey1Name() +" "+getKey2Name() +" "+getValueName()+" triple group";
    }


}
