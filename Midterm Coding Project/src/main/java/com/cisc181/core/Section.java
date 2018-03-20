package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Section{
	
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(UUID CourseID, UUID SemesterID, int RoomID,UUID SectionID) {
		this.SectionID = SectionID;
		this.RoomID = RoomID;
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

}
