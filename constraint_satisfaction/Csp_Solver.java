package constraint_satisfaction;

import java.util.ArrayList;
import java.util.List;

import constraint_satisfaction.CspJobPuzzle.Value;
import constraint_satisfaction.CspZebraPuzzle.Variable;

public class Csp_Solver {

	static int iter = 1;

	// public boolean backTrack(CSP problem) {
	// System.out.println("\n" + iter++);
	//
	// Variable job = problem.getUnassignedVariable();
	// if (job == null) {
	// return true;
	// }
	// System.out.println("Considering Job:" + job.name + "\n");
	//
	// List<Value> availableWorkers = new ArrayList<Value>(
	// problem.getAvailableValues());
	// if (availableWorkers.size() <= 0)
	// System.out.println("No one available");
	// for (Value worker : availableWorkers) {
	// System.out.println("Available:" + worker.name);
	// }
	//
	// for (Value worker : availableWorkers) {
	// System.out.println("Considering Worker:" + worker.name);
	// problem.assignValueToVariable(job, worker);
	// if (problem.isConsistent() && backTrack(problem)) {
	// return true;
	// }
	// System.out.println("Not Consistent\n");
	// problem.unassignValueToVariable(job);
	// }
	// return false;
	// }

	public boolean backTrack(CspZebraPuzzle problem) {
		System.out.println("\n" + iter++);

		Variable var = problem.getUnassignedVariable();
		if (var == null) {
			return true;
		}
		System.out.println("Considering Var:" + problem.getVariableName(var)
				+ "\n");

		List<Integer> availableValues = new ArrayList<Integer>(
				problem.getAvailableValues(var));
		if (availableValues.size() <= 0)
			System.out.println("No one available");
		for (Integer worker : availableValues) {
			System.out.println("Available:" + worker);
		}

		for (Integer worker : availableValues) {
			System.out.println("Considering Value:" + worker);

			problem.assignValueToVariable(var, worker);
			if (problem.isConsistent() && backTrack(problem)) {
				return true;
			}
			problem.printSolution();
			System.out.println("Not Consistent\n");
			problem.unassignValueToVariable(var);
		}
		return false;
	}

	public static void main(String args[]) {
		Csp_Solver solver = new Csp_Solver();

		// CspJobPuzzle problem = new CspJobPuzzle();
		// problem.setupProblem();

		CspZebraPuzzle problem = new CspZebraPuzzle();
		problem.setupProblem();

		if (solver.backTrack(problem)) {
			problem.printSolution();
		} else {
			System.out.println("Done");
			problem.printSolution();
		}

	}
}
