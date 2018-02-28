package lab2;

import java.util.ArrayList;

public class StatisticsCalculator {

	private ArrayList<Integer> marks;
	private double avgScore = 0;

	public StatisticsCalculator() {
		this.marks = new ArrayList<Integer>();
	}

	public void addScore(int score) {
		marks.add(score);
		getAverage();
	}

	public double getAverage() {
		double totalMarks = 0;
		int numSubjects = 0;
		if (marks.size() != 0) {
			for (int mark : marks) {
				totalMarks += mark;
				numSubjects++;
			}
			avgScore =  totalMarks / numSubjects;
		}
		return avgScore;
	}

	public String getGrade() {
		if(avgScore == 0) {
			return "IC";
		} else if(avgScore < 50 && avgScore > 0) {
			return "F";
		} else if(avgScore >= 50 && avgScore < 65) {
			return "P";
		} else if(avgScore >= 65 && avgScore < 75) {
			return "CR";
		} else if(avgScore >= 75 && avgScore < 85) {
			return "D";
		} else {
			return "HD";
		}
	}

}
