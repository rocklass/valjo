package org.rocklass.valjo;

public class StringValueObject extends TypeValueObject<String> {

	public StringValueObject() {
		super();
	}

	public StringValueObject(String value) {
		super(value);
	}

	public StringValueObject(ValueObject<String> valueObject) {
		super(valueObject);
	}
}
