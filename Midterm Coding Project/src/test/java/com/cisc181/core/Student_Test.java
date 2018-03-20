package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static Date Date(int year, int month, int day) 
	{
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}

	private static ArrayList<Course> course = new ArrayList<Course>();
	private static ArrayList<Semester> semester = new ArrayList<Semester>();
	private static ArrayList<Section> section = new ArrayList<Section>();
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrollmentlist = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException {
		Course c1 = new Course(UUID.randomUUID(), "PROGRAMMING", 1, eMajor.COMPSI);
		Course c2 = new Course(UUID.randomUUID(), "NURSE", 2, eMajor.NURSING);
		Course c3 = new Course(UUID.randomUUID(), "PHYSIC", 3, eMajor.PHYSICS);
		course.addAll(Arrays.asList(c1, c2, c3));

		Semester fall = new Semester(UUID.randomUUID(), Date(2018, 8, 30), Date(2018, 12, 17));
		Semester spring = new Semester(UUID.randomUUID(), Date(2018, 2, 28), Date(2018, 5, 22));
		semester.addAll(Arrays.asList(fall, spring));

		ArrayList<Section> alist = new ArrayList<Section>();
		Section s1 = new Section(c1.getCourseID(), spring.getSemesterID(), 102, null);
		Section s2 = new Section(c2.getCourseID(), spring.getSemesterID(), 202, null);
		Section s3 = new Section(c3.getCourseID(), spring.getSemesterID(), 302, null);
		alist.addAll(Arrays.asList(s1, s2, s3));

		Section s4 = new Section(c1.getCourseID(), fall.getSemesterID(), 102, null);
		Section s5 = new Section(c2.getCourseID(), fall.getSemesterID(), 202, null);
		Section s6 = new Section(c3.getCourseID(), fall.getSemesterID(), 302, null);
		alist.addAll(Arrays.asList(s4, s5, s6));
		
		section.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6));

		Student st1 = new Student("A", "A1", "A2", Date(2011, 1, 1), eMajor.NURSING, "NEW YORK", "111-111-1111", "ACOM");
		Student st2 = new Student("B", "B1", "B2", Date(2012, 2, 2), eMajor.PHYSICS, "CHICAGO", "111-111-1112", "BCOM");
		Student st3 = new Student("C", "C1", "C2", Date(2013, 3, 3), eMajor.CHEM, "BUFFALO", "111-111-1113", "CCOM");
		Student st4 = new Student("D", "D1", "D2", Date(2014, 4, 4), eMajor.COMPSI, "DALLAS", "111-111-1114", "DCOM");
		Student st5 = new Student("E", "E1", "E2", Date(2015, 5, 5), eMajor.NURSING, "HOUSTON", "111-111-1115", "ECOM");
		Student st6 = new Student("F", "F1", "F2", Date(2016, 6, 6), eMajor.NURSING, "SEATLLE", "111-111-1116", "FCOM");
		Student st7 = new Student("G", "G1", "G2", Date(2017, 7, 7), eMajor.PHYSICS, "OAKLAND", "111-111-1117", "GCOM");
		Student st8 = new Student("H", "H1", "H2", Date(2017, 8, 8), eMajor.CHEM, "MIAMI", "111-111-1118", "HCOM");
		Student st9 = new Student("I", "I1", "I2", Date(2017, 9, 9), eMajor.CHEM, "SAN JOSE", "111-111-1119", "ICOM");
		Student st10 = new Student("J", "J1", "J2", Date(2017, 1, 1), eMajor.COMPSI, "SANTA CLARA", "1111-111-1110", "JCOM");
		
		students.addAll(Arrays.asList(st1, st2, st3, st4, st5, st6, st7, st8, st9, st10));

		for (Student student : students) {
			for (Section section : section) {
				enrollmentlist.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
		for (Enrollment enrollment : enrollmentlist) {
			if (enrollment.getStudentID() == students.get(1).getStudentID()) {
				enrollment.setGrade(55);
			} else if (enrollment.getStudentID() == students.get(2).getStudentID()) {
				enrollment.setGrade(99);
			} else if (enrollment.getStudentID() == students.get(3).getStudentID()) {
				enrollment.setGrade(100);
			} else if (enrollment.getStudentID() == students.get(4).getStudentID()) {
				enrollment.setGrade(88);
			} else if (enrollment.getStudentID() == students.get(5).getStudentID()) {
				enrollment.setGrade(60);
			} else if (enrollment.getStudentID() == students.get(6).getStudentID()) {
				enrollment.setGrade(77);
			} else if (enrollment.getStudentID() == students.get(7).getStudentID()) {
				enrollment.setGrade(54);
			} else if (enrollment.getStudentID() == students.get(8).getStudentID()) {
				enrollment.setGrade(58);
			} else if (enrollment.getStudentID() == students.get(9).getStudentID()) {
				enrollment.setGrade(66);
			} else if (enrollment.getStudentID() == students.get(0).getStudentID()) {
				enrollment.setGrade(64);
			}
		}
	}

	public double getGPA(UUID ID) {
		double GPA = 0.00;
		for (Enrollment enrollment : enrollmentlist) {
			if (enrollment.getStudentID() == ID) {
				if (enrollment.getGrade() >= 95) {
					GPA = 4.00;
				} else if (enrollment.getGrade() >= 90 && enrollment.getGrade() < 95) {
					GPA = 3.7;
				} else if (enrollment.getGrade() >= 87 && enrollment.getGrade() < 90) {
					GPA = 3.3;
				} else if (enrollment.getGrade() >= 83 && enrollment.getGrade() < 87) {
					GPA = 3.0;
				} else if (enrollment.getGrade() >= 80 && enrollment.getGrade() < 83) {
					GPA = 2.7;
				} else if (enrollment.getGrade() >= 77 && enrollment.getGrade() < 80) {
					GPA = 2.3;
				} else if (enrollment.getGrade() >= 73 && enrollment.getGrade() < 77) {
					GPA = 2.0;
				} else if (enrollment.getGrade() >= 70 && enrollment.getGrade() < 73) {
					GPA = 1.7;
				} else if (enrollment.getGrade() >= 67 && enrollment.getGrade() < 70) {
					GPA = 1.5;
				} else if (enrollment.getGrade() >= 63 && enrollment.getGrade() < 67) {
					GPA = 1.3;
				} else if (enrollment.getGrade() >= 60 && enrollment.getGrade() < 63) {
					GPA = 1.0;
				} else if (enrollment.getGrade() < 60) {
					GPA = 0.0;
				}
			}
		}

		return GPA;
	}

	@Test
	public void testStudentGPA() 
		{
		assertEquals(getGPA(enrollmentlist.get(1).getStudentID()), 0.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(2).getStudentID()), 4.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(3).getStudentID()), 4.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(4).getStudentID()), 3.4, 4.0);
		assertEquals(getGPA(enrollmentlist.get(5).getStudentID()), 1.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(6).getStudentID()), 2.3, 4.0);
		assertEquals(getGPA(enrollmentlist.get(7).getStudentID()), 2.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(8).getStudentID()), 0.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(9).getStudentID()), 0.0, 4.0);
		assertEquals(getGPA(enrollmentlist.get(0).getStudentID()), 1.3, 4.0);
			}
	@Test
	public void testCourseAverage() {
		double average = 84.6;
		double acual = (enrollmentlist.get(1).getGrade()
				+ enrollmentlist.get(2).getGrade() + enrollmentlist.get(3).getGrade()) / 3;
		assertEquals(average, acual, 100);

		double average2 = 74;
		double acual2 = (enrollmentlist.get(4).getGrade() + enrollmentlist.get(5).getGrade()) / 2;
		assertEquals(average2, acual2, 100);

		double average3 = 63.75;
		double acual3 = (enrollmentlist.get(6).getGrade() + enrollmentlist.get(7).getGrade()
				+ enrollmentlist.get(8).getGrade() + enrollmentlist.get(9).getGrade()) / 4;
		assertEquals(average3, acual3, 100);
	}
}