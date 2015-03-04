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
        TypeValueObject<Integer> integerValue3 = new IntegerValueObject(ANOTHER_INTEGER);
        TypeValueObject<String> stringValue = new StringValueObject(ANY_STRING);
        
        assertEquals(integerValue1, integerValue2);
        assertNotSame(integerValue1, integerValue2);
        assertEquals(integerValue1, integerValue1);
        assertNotEquals(integerValue1, null);
        assertNotEquals(integerValue1, stringValue);
        assertNotEquals(integerValue1, integerValue3);
        
        integerValue1.setValue(null);
        integerValue3.setValue(null);
        
        assertNotEquals(integerValue1, integerValue2);
        assertEquals(integerValue1, integerValue3);
    }
    
    @Test
    public void canCompareTwoStringValueObjects() {
        TypeValueObject<String> stringValue1 = new StringValueObject(ANY_STRING);
        TypeValueObject<String> stringValue2 = new StringValueObject(ANY_STRING);
        TypeValueObject<String> stringValue3 = new StringValueObject(ANOTHER_STRING);
        TypeValueObject<Integer> integerValue = new IntegerValueObject(ANY_INTEGER);
        
        assertEquals(stringValue1, stringValue2);
        assertNotSame(stringValue1, stringValue2);
        assertEquals(stringValue1, stringValue1);
        assertNotEquals(stringValue1, null);
        assertNotEquals(stringValue1, integerValue);
        assertNotEquals(stringValue1, stringValue3);
        
        stringValue1.setValue(null);
        stringValue3.setValue(null);
        
        assertNotEquals(stringValue1, stringValue2);
        assertEquals(stringValue1, stringValue3);
    }
    
    @Test
    public void canGetStringOfIntegerValueObject() {
    	TypeValueObject<Integer> integerValue = new IntegerValueObject(ANY_INTEGER);
    	
    	assertEquals(ANY_INTEGER.toString(), integerValue.toString());
    }
    
    @Test
    public void canGetStringOfStringValueObject() {
    	TypeValueObject<String> stringValue = new StringValueObject(ANY_STRING);
    	
    	assertEquals(ANY_STRING, stringValue.toString());
    }
    
    @Test
    public void canComputeHashCodeOfIntegerValueObject() {
    	TypeValueObject<Integer> integerValue1 = new IntegerValueObject(ANY_INTEGER);
    	TypeValueObject<Integer> integerValue2 = new IntegerValueObject(ANY_INTEGER);
    	
    	assertEquals(integerValue1.hashCode(), integerValue2.hashCode());
    	
    	integerValue1.setValue(null);
        
        assertNotEquals(0, integerValue1.hashCode());
    }
    
    @Test
    public void canComputeHashCodeOfStringValueObject() {
    	TypeValueObject<String> stringValue1 = new StringValueObject(ANY_STRING);
    	TypeValueObject<String> stringValue2 = new StringValueObject(ANY_STRING);
    	
    	assertEquals(stringValue1.hashCode(), stringValue2.hashCode());
    	
    	stringValue1.setValue(null);
    	
    	assertNotEquals(0, stringValue1.hashCode());
    }
}
