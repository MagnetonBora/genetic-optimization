package galgo2;

import java.util.*;

public abstract class AbstractChromosome<T extends AbstractGene> {
	
	private List<T> genes;
	
	public AbstractChromosome() {
		super();
		genes = new ArrayList<T>();
	}

	public AbstractChromosome(List<T> genes) {
		this.genes = genes;
	}
	
}
