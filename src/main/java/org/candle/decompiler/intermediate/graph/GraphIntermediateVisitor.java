package org.candle.decompiler.intermediate.graph;

import java.util.TreeSet;

import org.candle.decompiler.intermediate.code.AbstractIntermediate;
import org.candle.decompiler.intermediate.code.IntermediateComparator;
import org.candle.decompiler.intermediate.graph.context.GraphUpdatedListener;
import org.candle.decompiler.intermediate.graph.context.IntermediateGraphContext;
import org.candle.decompiler.intermediate.visitor.EmptyIntermediateVisitor;

public abstract class GraphIntermediateVisitor extends EmptyIntermediateVisitor {

	protected final IntermediateComparator comparator = new IntermediateComparator();
	protected final IntermediateGraphContext igc;
	protected final boolean listenForUpdates;
	
	public GraphIntermediateVisitor(IntermediateGraphContext igc) {
		this(igc, false);
	}
	
	public GraphIntermediateVisitor(IntermediateGraphContext igc, boolean listenForUpdates) {
		this.igc = igc;
		this.listenForUpdates = listenForUpdates;
	}
	
	public void process() {

		GraphUpdatedListener gul = new GraphUpdatedListener();
		if(listenForUpdates) {
			igc.getIntermediateGraph().addGraphListener(gul);
		}
		while(true) {
			TreeSet<AbstractIntermediate> snapshot = (TreeSet)igc.getOrderedIntermediate().clone();
			
			for(AbstractIntermediate vertex : snapshot) {
				vertex.accept(this);
			}
			//reset the update listener.
			if(!gul.isUpdated()) {
				break;
			}
			else {
				gul.reset();
			}
		}
		igc.getIntermediateGraph().removeGraphListener(gul);
	}
}
