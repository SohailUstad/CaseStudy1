package SOHAIL_CoreJAVA_Rating.WithoutDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {

	Map<String, Integer> distributions = new HashMap<String, Integer>();

	public App() {
		this.distributions.put("test", 40);
		this.distributions.put("quiz", 20);
		this.distributions.put("lab", 10);
		this.distributions.put("project", 30);
	}

	public double getOverAllRating(String student, String subject, List<Assignment> assignment) {
		double rating = 0;

		rating = getScore(student, subject, "test", assignment) + getScore(student, subject, "quiz", assignment)
				+ getScore(student, subject, "lab", assignment) + getScore(student, subject, "project", assignment);

		return rating;
	}

	public double getScore(String student, String subject, String category, List<Assignment> assignment) {
		double score = 0;

		int total_assignments = 0;
		double total_points = 0;

		for (Assignment a : assignment) {
			if (a.getSubject().equals(subject)) {
				if (a.getStudentName().equals(student) && a.getAssignmentCategory()
						.substring(0, a.getAssignmentCategory().length() - 2).equals(category)) {
					total_assignments += 1;
					total_points += a.getPoints();
				}
			}
		}

		if (total_assignments == 0) {
			score = 0;
		} else {
			score = ((this.distributions.get(category) / total_assignments) * total_points) / 100;
		}

		return score;
	}

	public static void main(String[] args) {

		List<Assignment> Assignment = new ArrayList<Assignment>();
		Assignment.add(new Assignment(1, "Ananth", "Electro Fields", "test_1", "21-jul-16", 100));
		Assignment.add(new Assignment(2, "Bhagath", "Electro Fields", "test_1", "21-jul-16", 78));
		Assignment.add(new Assignment(3, "Chaya", "Electro Fields", "test_1", "21-jul-16", 68));
		Assignment.add(new Assignment(4, "Esharath", "Electro Fields", "test_1", "21-jul-16", 87));
		Assignment.add(new Assignment(5, "Bhagath", "Electro Fields", "quiz_1", "21-jul-16", 20));
		Assignment.add(new Assignment(6, "Chaya", "Electro Fields", "lab_1", "21-jul-16", 10));
		Assignment.add(new Assignment(7, "Ananth", "Electro Fields", "project_1", "21-jul-16", 100));
		Assignment.add(new Assignment(8, "Davanth", "Electro Fields", "project_1", "21-jul-16", 100));
		Assignment.add(new Assignment(9, "Bhagath", "Electro Fields", "quiz_2", "21-jul-16", 50));
		Assignment.add(new Assignment(10, "Ananth", "Electro Fields", "quiz_1", "21-jul-16", 100));
		Assignment.add(new Assignment(11, "Bhagath", "Electro Fields", "lab_1", "21-jul-16", 10));
		Assignment.add(new Assignment(12, "Chaya", "Electro Fields", "project_1", "21-jul-16", 100));
		Assignment.add(new Assignment(13, "Bhagath", "Electro Fields", "project_1", "21-jul-16", 100));
		Assignment.add(new Assignment(14, "Ananth", "Computing Techniques", "test_1", "21-jul-16", 86));
		Assignment.add(new Assignment(15, "Ananth", "Electro Fields", "quiz_2", "21-jul-16", 100));
		Assignment.add(new Assignment(16, "Bhagath", "Computing Techniques", "project_1", "21-jul-16", 100));
		Assignment.add(new Assignment(17, "Ananth", "Electro Fields", "lab_1", "21-jul-16", 100));
		Assignment.add(new Assignment(18, "Chaya", "Computing Techniques", "quiz_1", "21-jul-16", 20));
		Assignment.add(new Assignment(19, "Ananth", "Electro Fields", "test_2", "21-jul-16", 100));
		Assignment.add(new Assignment(20, "Chaya", "Electro Fields", "test_2", "21-jul-16", 92));

		App a = new App();

		Set<String> st = new HashSet<String>();
		for (Assignment aa : Assignment) {
			st.add(aa.getStudentName());
		}
		List<String> students = new ArrayList<String>();
		for (String s : st) {
			students.add(s);
		}

		Set<String> sub = new HashSet<String>();
		for (Assignment ab : Assignment) {
			sub.add(ab.getSubject());
		}
		List<String> subjects = new ArrayList<String>();
		for (String s : sub) {
			subjects.add(s);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to see ?");
		System.out.println("Enter 1 : to see rating by student name");
		System.out.println("Enter 2 : to see rating by subject name");

		String input1 = sc.nextLine();
		if (input1.equals("1")) {
			System.out.println("Enter student name : ");
			String input2 = sc.nextLine();
			if (!students.contains(input2)) {
				System.out.println("Invalid name");
			} else {
				for (String s : subjects) {
					System.out.print(s + "\t");
					System.out.println(
							a.getScore(input2, s, "test", Assignment) + "\t" + a.getScore(input2, s, "quiz", Assignment)
									+ "\t" + a.getScore(input2, s, "lab", Assignment) + "\t"
									+ a.getScore(input2, s, "project", Assignment)+"\t"+a.getOverAllRating(input2, s, Assignment));
				}
			}
		} else if (input1.equals("2")) {
			System.out.println("Enter subject");
			String input2 = sc.nextLine();
			if (!subjects.contains(input2)) {
				System.out.println("Invalid subject");
			} else {

				for (String n : students) {
					System.out.print(n + "\t");
					System.out.println(
							a.getScore(n, input2, "test", Assignment) + "\t" + a.getScore(n, input2, "quiz", Assignment)
									+ "\t" + a.getScore(n, input2, "lab", Assignment) + "\t"
									+ a.getScore(n, input2, "project", Assignment)+"\t"+a.getOverAllRating(n, input2, Assignment));
				}

			}
		}

		sc.close();
	}
}
