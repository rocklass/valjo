package org.rocklass.valjo;

public interface ValueObject<VO> {
	VO getValue();
	void setValue(VO value);
}
