package org.candle.decompiler.intermediate.expression;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import org.apache.bcel.generic.InstructionHandle;

public class Switch extends ConditionalExpression {

	private final Expression left;
	
	public Switch(InstructionHandle instructionHandle, Expression left) {
		super(instructionHandle);
		this.left = left;
	}
	
	@Override
	public void write(Writer writer) throws IOException {
		writer.write("switch(");
		left.write(writer);
		writer.append(")");
	}

	@Override
	public Set<Expression> nestedExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void negate() {
		// TODO Auto-generated method stub
		
	}

}
