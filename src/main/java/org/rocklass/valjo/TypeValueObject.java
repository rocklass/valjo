package org.rocklass.valjo;

public abstract class TypeValueObject<T> implements ValueObject<T> {
	private T value;
	
	public TypeValueObject() {
		super();
	}

	public TypeValueObject(T value) {
		super();
		this.value = value;
	}
	
	public TypeValueObject(ValueObject<T> valueObject) {
		super();
		this.value = valueObject.getValue();
	}

	public final T getValue() {
		return value;
	}

	public final void setValue(T value) {
		this.value = value;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeValueObject other = (TypeValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public final String toString() {
		return "Type [value=" + value + "]";
	}
}
