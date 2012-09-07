

public class Weight implements Comparable<Weight> {
	public int iFeature;
	public double w;
	
	public int compareTo(Weight we2) {
		Double sim1 = new Double(w);
		Double sim2 = new Double(we2.w);
		
		return sim1.compareTo(sim2);
	}
}
