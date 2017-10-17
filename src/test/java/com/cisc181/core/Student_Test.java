package com.cisc181.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static ArrayList<Semester> semesters = new ArrayList<Semester>();
	private static ArrayList<Section> sections = new ArrayList<Section>();
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	@BeforeClass
	public static void setup() throws PersonException {
		courses.clear();
		courses.add(new Course(UUID.randomUUID(), "Business", 100, eMajor.BUSINESS));
		courses.add(new Course(UUID.randomUUID(), "Chemistry", 100, eMajor.CHEM));
		courses.add(new Course(UUID.randomUUID(), "Physics", 100, eMajor.PHYSICS));
		
		semesters.clear();
		semesters.add(new Semester(UUID.randomUUID(), new Date(107, 9, 1), new Date(108, 1, 31)));
		semesters.add(new Semester(UUID.randomUUID(), new Date(107, 3, 1), new Date(107, 6, 30)));
		
		sections.clear();
		int roomID = 101;
		for(Course course : courses) {
			for(Semester semester : semesters) {
				sections.add(new Section(course.getCourseID(), semester.getSemesterID(), UUID.randomUUID(), roomID++));
			}
		}
		
		students.clear();
		students.add(new Student("Vicky", "Brook", "Carey", new Date(96, 10, 1), eMajor.BUSINESS, "", "(123)-456-7890", ""));
		students.add(new Student("Lyndon", "Hilary", "Regan", new Date(95, 10, 1), eMajor.BUSINESS, "", "(123)-456-7890", ""));
		students.add(new Student("Jonathan", "Hogan", "Waters", new Date(94, 10, 1), eMajor.CHEM, "", "(123)-456-7890", ""));
		students.add(new Student("Lynn", "Sharp", "Doyle", new Date(93, 10, 1), eMajor.CHEM, "", "(123)-456-7890", ""));
		students.add(new Student("York", "Dobbin", "Mill", new Date(92, 10, 1), eMajor.CHEM, "", "(123)-456-7890", ""));
		students.add(new Student("Bulwer", "Dana", "London", new Date(96, 10, 1), eMajor.BUSINESS, "", "(123)-456-7890", ""));
		students.add(new Student("Osborn", "Occam", "Augustine", new Date(95, 10, 1), eMajor.BUSINESS, "", "(123)-456-7890", ""));
		students.add(new Student("Penn", "Curme", "Daniell", new Date(94, 10, 1), eMajor.PHYSICS, "", "(123)-456-7890", ""));
		students.add(new Student("Virginia", "Edith", "Freeman", new Date(93, 10, 1), eMajor.PHYSICS, "", "(123)-456-7890", ""));
		students.add(new Student("Lucy", "Moore", " Addison", new Date(92, 10, 1), eMajor.PHYSICS, "", "(123)-456-7890", ""));
		
		
		int grade = 100;
		for(Student student : students) {
			if(student.getMajor().equals(eMajor.BUSINESS)) {
				Enrollment enrollment = new Enrollment(sections.get(0).getSectionID(), student.getStudentID());
				enrollment.SetGrade(grade--);
				enrollments.add(enrollment);
			}
			
			if(student.getMajor().equals(eMajor.CHEM)) {
				Enrollment enrollment = new Enrollment(sections.get(2).getSectionID(), student.getStudentID());
				enrollment.SetGrade(grade--);
				enrollments.add(enrollment);			}
			
			if(student.getMajor().equals(eMajor.PHYSICS)) {
				Enrollment enrollment = new Enrollment(sections.get(4).getSectionID(), student.getStudentID());
				enrollment.SetGrade(grade--);
				enrollments.add(enrollment);
			}
		}
	}

	@Test
	public void GPATest() {
		assertEquals(100, enrollments.get(0).getGrade(), 0.001);
		assertEquals(99, enrollments.get(1).getGrade(), 0.001);
		assertEquals(98, enrollments.get(2).getGrade(), 0.001);
		assertEquals(97, enrollments.get(3).getGrade(), 0.001);
		assertEquals(96, enrollments.get(4).getGrade(), 0.001);
		assertEquals(95, enrollments.get(5).getGrade(), 0.001);
		assertEquals(94, enrollments.get(6).getGrade(), 0.001);
		assertEquals(93, enrollments.get(7).getGrade(), 0.001);
		assertEquals(92, enrollments.get(8).getGrade(), 0.001);
		assertEquals(91, enrollments.get(9).getGrade(), 0.001);
	}
	
	@Test
	public void AverageGradeTest() {
		double sum = 0;
		for(Enrollment enrollment : enrollments) {
			sum += enrollment.getGrade();
		}
		double average = sum / enrollments.size();
		
		assertEquals(95.5, average, 0.0001);
	}
}