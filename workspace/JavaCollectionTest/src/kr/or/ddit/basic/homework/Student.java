package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

	private String id;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int total;
	private int rank;

	public Student(String id, String name, int korean, int english, int math) {
		super();
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return this.getKorean() + this.getEnglish() + this.getMath();
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s, korean=%s, english=%s, math=%s, total=%s], rank=%s]", id, name,
				korean, english, math, getTotal(), rank);
	}

	@Override
	public int compareTo(Student student1) {
		return getId().compareTo(student1.getId());
	}

}
