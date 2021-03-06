package org.candle.decompiler.intermediate.graph;

import java.util.HashSet;
import java.util.Set;

import org.apache.bcel.generic.CodeExceptionGen;
import org.apache.bcel.generic.MethodGen;
import org.candle.decompiler.intermediate.code.AbstractIntermediate;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedSubgraph;

public class IntermediateTryCatch {

	
	public IntermediateTryCatch(MethodGen method) {
		
		for(CodeExceptionGen ceg : method.getExceptionHandlers()) {
			/*
			Set<AbstractIntermediate> lineMatches = ilc.linesWithinBounds(ceg.getStartPC().getPosition(), ceg.getEndPC().getPosition());
			DirectedSubgraph<AbstractIntermediate, DefaultEdge> tryBlock = new DirectedSubgraph<AbstractIntermediate, DefaultEdge>(intermediateGraph, lineMatches, null);
			
			tryCatchSubgraph.add(tryBlock);
			
			int upperBounds = ceg.getEndPC().getPosition();
			for(AbstractIntermediate ai : lineMatches) {
				if(ai instanceof GoToIntermediate) {
					int t1 = ((GoToIntermediate) ai).getTarget().getInstruction().getPosition();
					
					if(t1 > upperBounds) {
						System.out.println("Goto breaks out of Try block to: "+t1);
					}
				}
				
				if(ai instanceof BooleanBranchIntermediate) {
					int t1 = ((BooleanBranchIntermediate) ai).getTrueTarget().getInstruction().getPosition();
					int t2 = ((BooleanBranchIntermediate) ai).getFalseTarget().getInstruction().getPosition();
					
					if(t1 > upperBounds) {
						System.out.println("Conditional breaks out of Try block to: "+t1);
					}
					
					if(t2 > upperBounds) {
						System.out.println("Conditional breaks out of Try block to: "+t2);
					}
				}
			}
			
			
			for(DirectedSubgraph<AbstractIntermediate, DefaultEdge> sub : tryCatchSubgraph) {
				System.out.println("Subgraph: ");
				Writer w = new OutputStreamWriter(System.out);
				DOTExporter<AbstractIntermediate, DefaultEdge> dot = new DOTExporter<AbstractIntermediate, DefaultEdge>(new IntegerNameProvider<AbstractIntermediate>(), new IntermediateLabelProvider(), null);
				dot.export(w, sub);
				
			}
			*/
		}
	}
}
