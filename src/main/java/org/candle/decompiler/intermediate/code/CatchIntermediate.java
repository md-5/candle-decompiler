package org.candle.decompiler.intermediate.code;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.bcel.generic.InstructionHandle;
import org.candle.decompiler.intermediate.expression.Variable;
import org.candle.decompiler.intermediate.visitor.IntermediateVisitor;

public class CatchIntermediate extends AbstractIntermediate implements BlockSerializable {

	protected final BlockRange blockRange;
	protected final Variable catchVariable;
	
	public CatchIntermediate(InstructionHandle instruction, Variable catchVariable) {
		super(instruction);
		this.catchVariable = catchVariable;
		this.blockRange = new BlockRange();
	}

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		
		try {
			catchVariable.write(sw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Catch: "+sw.toString();
	}

	
	@Override
	public void accept(IntermediateVisitor visitor) {
		visitor.visitCatchLine(this);
	}

	@Override
	public BlockRange getBlockRange() {
		return blockRange;
	}

}
