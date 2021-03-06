package org.candle.decompiler.intermediate.graph.range;

import org.candle.decompiler.intermediate.code.AbstractIntermediate;
import org.candle.decompiler.intermediate.code.conditional.IfIntermediate;
import org.candle.decompiler.intermediate.graph.GraphIntermediateVisitor;
import org.candle.decompiler.intermediate.graph.context.IntermediateGraphContext;
import org.candle.decompiler.intermediate.graph.context.NullIntermediate;

public class IfLowerRangeVisitor extends GraphIntermediateVisitor {

	public IfLowerRangeVisitor(IntermediateGraphContext igc) {
		super(igc);
	}
	
	@Override
	public void visitIfLine(IfIntermediate line) {
		AbstractIntermediate l = igc.getTrueTarget(line);
		int lower = l.getInstruction().getPosition();
		line.getBlockRange().setStart(lower);
		
		//upper range...
		AbstractIntermediate u = igc.getFalseTarget(line);
		NullIntermediate nullIntermediate = new NullIntermediate(u.getInstruction().getPrev());
		AbstractIntermediate ai = igc.getOrderedIntermediate().floor(nullIntermediate);

		if(ai != null) {
			line.getBlockRange().setEnd(ai.getInstruction().getPosition());
		}
		
	}

}
