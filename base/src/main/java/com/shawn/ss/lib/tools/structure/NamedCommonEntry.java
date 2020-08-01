package com.shawn.ss.lib.tools.structure;

import com.shawn.ss.lib.tools.CollectionHelper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NamedCommonEntry<K, V> extends CommonEntry<K,V> implements  java.io.Serializable,NamedStructure {
	private static final long serialVersionUID = -8499721149061103585L;

	public static <K,V> NamedCommonEntryBuilder<K,V> newBuilder(String kn,String vn){
		return new NamedCommonEntryBuilder<>(kn,vn);
	}

	public static <K,V> NamedCommonEntryListBuilder<K,V> newListBuilder(String kn,String vn){
		return new NamedCommonEntryListBuilder<>(kn,vn);
	}

	public static <K,V> CommonEntry<K,V> newInstance(String kn,String vn,K k,V v){
		return new NamedCommonEntryBuilder<K,V>(kn,vn).newInstance(k,v);
	}

	private final NamedCommonEntryBuilder<K,V> builder;

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
		return "this class define "+getKeyName() +" "+getValueName()+" pair";
	}

	public final static class NamedCommonEntryListBuilder<K,V> extends NamedCommonEntryBuilder<K,V>{

		final List<NamedCommonEntry<K, V>> list;

		NamedCommonEntryListBuilder(String keyName, String valueName) {
			super(keyName, valueName);
			list= CollectionHelper.newList();
		}

		public NamedCommonEntryListBuilder<K, V> addInstance(K k, V v){
			list.add(new NamedCommonEntry<K, V>(k,v,this));
			return this;
		}

		public List<NamedCommonEntry<K, V>> getList() {
			return list;
		}
	}

	public static class NamedCommonEntryBuilder<K,V>{

		final String keyName;
		final String valueName;

		NamedCommonEntryBuilder(String keyName, String valueName) {
			this.keyName = keyName;
			this.valueName = valueName;
		}

		public NamedCommonEntry<K, V> newInstance(K k, V v){
			return new NamedCommonEntry<K, V>(k,v,this);
		}

		public String getKeyName() {
			return keyName;
		}

		public String getValueName() {
			return valueName;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof NamedCommonEntryBuilder)) return false;

			NamedCommonEntryBuilder<?, ?> that = (NamedCommonEntryBuilder<?, ?>) o;

			if (!getKeyName().equals(that.getKeyName())) return false;
			return getValueName().equals(that.getValueName());
		}

		@Override
		public int hashCode() {
			int result = getKeyName().hashCode();
			result = 31 * result + getValueName().hashCode();
			return result;
		}

		@Override
		public String toString() {
			return " Tag:{" +
					"" + keyName  +
					", " + valueName  +
					'}';
		}
	}

	private NamedCommonEntry(K key, V value,NamedCommonEntryBuilder<K,V> NamedCommonEntryBuilder) {
		super(key, value);
		builder = NamedCommonEntryBuilder;
	}

	public String getKeyName() {
		return builder.getKeyName();
	}

	public String getValueName() {
		return builder.getValueName();
	}

	public NamedCommonEntry<K, V> newInstance(K k, V v) {
		return builder.newInstance(k, v);
	}

	public NamedCommonEntryBuilder<K, V> getBuilder() {
		return builder;
	}

	@Override
	public String toString() {
		return super.toString()+builder.toString();
	}
}
