package galgo;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChromosome<T> {
	
	private List<GenericGene<T>> genes = new ArrayList<GenericGene<T>>();
	
	public void setGeneAt(int pos, GenericGene<T> gene) {
		genes.set(pos, gene);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public GenericGene<T> getGeneAt(int pos) {
		return genes.get(pos);
	}
	
	public int Length() {
		return genes.size();
	}
		
	public void addGene(GenericGene<T> gene) {
		genes.add(gene);
	}
	
	public AbstractChromosome() {
		super();
	}
	
	public AbstractChromosome(List<GenericGene<T>> genes) {
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
