package GeneticItems;

import java.util.*;

public class RealChromosome {

	private List<DoubleGene> genes = new ArrayList<DoubleGene>();
	
	public void setGeneAt(int pos, DoubleGene gene) {
		genes.set(pos, gene);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public DoubleGene getGeneAt(int pos) {
		return genes.get(pos);
	}
	
	public int Length() {
		return genes.size();
	}
		
	public void addGene(DoubleGene gene) {
		genes.add(gene);
	}
	
	public RealChromosome() {
		super();
	}
	
	public RealChromosome(List<DoubleGene> genes) {
		this.genes = genes;
	}

	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < genes.size(); i++) {
			str += genes.get(i).toString();
		}
		return str;
	}
	
}
