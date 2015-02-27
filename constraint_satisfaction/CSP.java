package constraint_satisfaction;

import java.util.List;

import constraint_satisfaction.CspJobPuzzle.Worker;

public abstract class CSP {

	public abstract void setupProblem();

	public abstract Job getUnassignedVariable();

	public abstract List<Worker> getDomainValues();

	public abstract boolean isConsistent();

	public abstract void printSolution();

	public abstract void assignJobToWorker(Job job, Worker people);

	public abstract void unassignJobForWorker(Job job);
}