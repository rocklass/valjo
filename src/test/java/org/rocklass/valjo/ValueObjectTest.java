package org.rocklass.valjo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class ValueObjectTest {
	
	private static final Integer ANY_INTEGER = RandomUtils.nextInt(0, 63);
	
	private static final String ANY_STRING = RandomStringUtils.random(ANY_INTEGER);
	
	@Test
	public void canSetAnIntegerValueObject() {
		ValueObject<Integer> integerValue = new IntegerValueObject();

		assertNull(integerValue.getValue());

		integerValue.setValue(ANY_INTEGER);

		assertEquals(ANY_INTEGER, integerValue.getValue());
	}

	@Test
	public void canSetAStringValueObject() {
		ValueObject<String> stringValue = new StringValueObject();

		assertNull(stringValue.getValue());

		stringValue.setValue(ANY_STRING);

		assertEquals(ANY_STRING, stringValue.getValue());
	}
}
