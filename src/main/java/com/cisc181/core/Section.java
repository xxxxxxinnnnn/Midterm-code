package com.cisc181.core;

import java.util.UUID;

public class Section {
	private UUID COurseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(UUID cOurseID, UUID semesterID, UUID sectionID, int roomID) {
		COurseID = cOurseID;
		SemesterID = semesterID;
		SectionID = sectionID;
		RoomID = roomID;
	}

	public UUID getCOurseID() {
		return COurseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public int getRoomID() {
		return RoomID;
	}
	
	
}
