package query;

import lucene.IndexInfoStaticG;

import org.apache.lucene.search.Query;

import ec.simple.SimpleFitness;

/**
 * Store information about classification query and test/train values
 * 
 * @author Laurie
 * 
 */

public class GAFit extends SimpleFitness {

	private float f1train, f1Test, BEPTest;

	private int positiveMatchTrain, negativeMatchTrain;

	private int positiveMatchTest, negativeMatchTest, numberOfTerms = 0;

	private Query query;

	private int neutralHit = -1;

	public void setQuery(Query q) {
		query = q;
	}

	public Query getQuery() {
		return query;
	}

	public String getQueryMinimal() {
		return QueryReadable.getQueryMinimal(query);
	}

	public void setTrainValues(int posMatchTrain, int negMatchTrain) {
		positiveMatchTrain = posMatchTrain;
		negativeMatchTrain = negMatchTrain;
	}

	public void setTestValues(int posMatchTest, int negMatchTest) {

		setPositiveMatchTest(posMatchTest);
		setNegativeMatchTest(negMatchTest);
	}

	public void setF1Train(final float f1) {
		f1train = f1;
	}

	public float getF1Train() {
		return f1train;
	}

	public void setF1Test(final float f1) {
		f1Test = f1;
	}

	public float getF1Test() {
		return f1Test;
	}

	public void setBEPTest(final float bep) {
		BEPTest = bep;
	}

	public float getBEPTest() {
		return BEPTest;
	}

	public void setNumberOfTerms(int numberOfTerms) {
		this.numberOfTerms = numberOfTerms;
	}

	public void setPositiveMatchTest(int positiveMatchTest) {
		this.positiveMatchTest = positiveMatchTest;
	}

	public int getPositiveMatchTest() {
		return positiveMatchTest;
	}

	public void setNegativeMatchTest(int negativeMatchTest) {
		this.negativeMatchTest = negativeMatchTest;
	}

	public int getNegativeMatchTest() {
		return negativeMatchTest;
	}

	public int getNumberOfTerms() {
		return numberOfTerms;
	}

	public String fitnessToStringForHumans() {
		return "F1train " + this.f1train;
	}

	// public void printFitnessForHumans(final EvolutionState state,
	// final int log, final int verbosity) {
	//
	// super.printFitnessForHumans(state, log, verbosity);
	// / super.printFitnessForHumans(state, 0, verbosity);
	// //
	// state.output.println(this.toString(state.generation), verbosity, log);
	// state.output.println(this.toString(state.generation), verbosity, 0);
	// }

	public String toString(int gen) {
		return "Gen: " + gen + " F1: " + f1train + " Positive Match: "
				+ positiveMatchTrain + " Negative Match: " + negativeMatchTrain
				+ " Total positive Docs: "
				+ IndexInfoStaticG.totalTrainDocsInCat
				// + " neutral Hit " + neutralHit
				+ '\n' + "QueryString: "
				+ query.toString(IndexInfoStaticG.FIELD_CONTENTS) + '\n';
	}

	public void setNeutralHits(int neutralHit) {
		this.neutralHit = neutralHit;

	}

	public int getNeutralHit() {

		return neutralHit;
	}
}
