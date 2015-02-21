package org.rocklass.valjo;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class TypeValueObjectTest {
	
	private static final Integer ANY_INTEGER = RandomUtils.nextInt(0, 63);
	
	private static final Integer ANOTHER_INTEGER = RandomUtils.nextInt(64, 127);
	
	private static final String ANY_STRING = RandomStringUtils.random(ANY_INTEGER);
	
	private static final String ANOTHER_STRING = RandomStringUtils.random(ANOTHER_INTEGER);
	
    @Test
    public void canConstructAnEmptyIntegerValueObject() {
        TypeValueObject<Integer> integerValue = new IntegerValueObject();
        
        assertNull(integerValue.getValue());
    }
    
    @Test
    public void canConstructAnEmptyStringValueObject() {
        TypeValueObject<String> stringValue = new StringValueObject();
        
        assertNull(stringValue.getValue());
    }
    
    @Test
    public void canConstructANonEmptyIntegerValueObject() {
        TypeValueObject<Integer> integerValue = new IntegerValueObject(ANY_INTEGER);
        
        assertEquals(ANY_INTEGER, integerValue.getValue());
    }
    
    @Test
    public void canConstructANonEmptyStringValueObject() {
        TypeValueObject<String> stringValue = new StringValueObject(ANY_STRING);
        
        assertEquals(ANY_STRING, stringValue.getValue());
    }
    
    @Test
    public void canCopyAnIntegerValueObject() {
        TypeValueObject<Integer> integerValue1 = new IntegerValueObject(ANY_INTEGER);
        TypeValueObject<Integer> integerValue2 = new IntegerValueObject(integerValue1);
        
        assertEquals(integerValue1, integerValue2);
        assertNotSame(integerValue1, integerValue2);
    }
    
    @Test
    public void canCopyAStringValueObject() {
        TypeValueObject<String> stringValue1 = new StringValueObject(ANY_STRING);
        TypeValueObject<String> stringValue2 = new StringValueObject(stringValue1);
        
        assertEquals(stringValue1, stringValue2);
        assertNotSame(stringValue1, stringValue2);
    }
    
    @Test
    public void canCompareTwoIntegerValueObjects() {
        TypeValueObject<Integer> integerValue1 = new IntegerValueObject(ANY_INTEGER);
        TypeValueObject<Integer> integerValue2 = new IntegerValueObject(ANY_INTEGER);
        
        assertEquals(integerValue1, integerValue2);
        assertNotSame(integerValue1, integerValue2);
        
        TypeValueObject<Integer> integerValue3 = new IntegerValueObject(ANOTHER_INTEGER);
        
        assertNotEquals(integerValue1, integerValue3);
    }
    
    @Test
    public void canCompareTwoStringValueObjects() {
        TypeValueObject<String> stringValue1 = new StringValueObject(ANY_STRING);
        TypeValueObject<String> stringValue2 = new StringValueObject(ANY_STRING);
        
        assertEquals(stringValue1, stringValue2);
        assertNotSame(stringValue1, stringValue2);
        
        TypeValueObject<String> stringValue3 = new StringValueObject(ANOTHER_STRING);
        
        assertNotEquals(stringValue1, stringValue3);
    }
}
