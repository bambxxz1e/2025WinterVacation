package vacation0108;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String name;
	private boolean isPresent;

	public Student(String name) {
		this.name = name;
		this.isPresent = false;
	}

	public String getName() {
		return name;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void markPresent() {
		this.isPresent = true;
	}

	public void markAbsent() {
		this.isPresent = false;
	}
}

class AttendanceManager {
	private ArrayList<Student> students;

	public AttendanceManager() {
		students = new ArrayList<>();
	}

	public void addStudent(String name) {
		for (Student student : students) { // Student 클래스의 student 객체 : ArrayList student 배열의 값
			if (student.getName().equals(name)) {
				System.out.println("이미 등록된 학생입니다.\n");
				return;
			}
		}
		students.add(new Student(name)); // ArrayList에 생성자 실행한거 넣어라
		System.out.println("학생이 추가되었습니다.\n");
	}

	public void showStudent() {
		System.out.println("<학생 목록>");

		for (int i = 0; i < students.size(); i++) {
			System.out.print((i + 1) + ". " + students.get(i).getName() + "\n");
			// students 리스트에 i번방에 있는 student 객체의 getName 호출
		}
		System.out.println();
	}

	public void checkStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				students.get(i).markPresent();
				System.out.println(name + " 출석 완료 되었습니다.\n");
			}
		}
	}

	public void showCheckStudent() {
		System.out.println("<출석 현황>");
		for (int i = 0; i < students.size(); i++) {
			System.out.print((i + 1) + ". " + students.get(i).getName() + " : ");
			if (students.get(i).isPresent() == true)
				System.out.print("출석\n");
			else
				System.out.print("결석\n");
		}
		System.out.println();
	}
}

public class AttendanceSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		AttendanceManager manager = new AttendanceManager();

		while (true) {
			System.out.println("======== 출석 관리 프로그램 ========\n");
			System.out.println("1. 등록 / 2. 목록 / 3. 출석체크 / 4. 출석현황 / 5. 종료\n");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			String name;
			switch (menu) {
			case 1:
				System.out.print("등록 학생 이름 : ");
				name = sc.next();
				manager.addStudent(name);
				break;
			case 2:
				manager.showStudent();
				break;
			case 3:
				System.out.print("출석 학생 이름 : ");
				name = sc.next();
				manager.checkStudent(name);
				break;
			case 4:
				manager.showCheckStudent();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택하세요\n");
			}
		}
	}

}
