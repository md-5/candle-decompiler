package org.candle.decompiler.intermediate.code;

import org.apache.bcel.generic.InstructionHandle;
import org.candle.decompiler.intermediate.visitor.IntermediateVisitor;

public class BooleanBranchOutcome extends AbstractIntermediate {

	private final Boolean expressionOutcome;
	
	public BooleanBranchOutcome(InstructionHandle instruction, BooleanBranchIntermediate intermediate, Boolean expressionOutcome) {
		super(instruction);
		this.expressionOutcome = expressionOutcome;
	}
	
	public Boolean getExpressionOutcome() {
		return expressionOutcome;
	}

	@Override
	public void accept(IntermediateVisitor visitor) {
		visitor.visitBooleanBranchOutcome(this);
	}
	
	@Override
	public String toString() {
		return "Outcome: "+expressionOutcome.toString().toUpperCase();
	}

}
