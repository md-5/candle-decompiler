package org.candle.decompiler.intermediate.code.conditional;

import org.apache.bcel.generic.InstructionHandle;
import org.candle.decompiler.intermediate.code.AbstractIntermediate;
import org.candle.decompiler.intermediate.visitor.IntermediateVisitor;

public class ElseIntermediate extends AbstractIntermediate {

	public ElseIntermediate(InstructionHandle instruction) {
		super(instruction);
	}
	
	@Override
	public String toString() {
		return "Else";
	}

	@Override
	public void accept(IntermediateVisitor visitor) {
		visitor.visitElseLine(this);
	}

}
