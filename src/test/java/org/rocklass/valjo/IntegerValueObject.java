package org.rocklass.valjo;

public class IntegerValueObject extends TypeValueObject<Integer> {

	public IntegerValueObject() {
		super();
	}

	public IntegerValueObject(Integer value) {
		super(value);
	}

	public IntegerValueObject(ValueObject<Integer> valueObject) {
		super(valueObject);
	}
}
