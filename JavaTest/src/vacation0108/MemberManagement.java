package vacation0108;
import java.util.*;

class Member{
	private String name;
	private String gender;
	private int age;
	private String tel;
	private String home;
	
	public Member(String name, String gender, int age, String tel, String home) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.tel = tel;
		this.home = home;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "이름 : " + this.name + "\n성별 : " + this.gender + "\n나이 : " + this.age + "\n전화번호 : " + this.tel + "\n주소 : " + this.home;
	}
}

class ManagementSystem {
	private ArrayList<Member> manager;
	
	public ManagementSystem() {
		manager = new ArrayList<>();
	}
	
	// 회원 추가
	public void addMember(String name, String gender, int age, String tel, String home) {
		for (Member member : manager) {
			if (member.getName().equals(name)) {
				System.out.println("이미 등록되었습니다.");
				return;
			}
		}
		manager.add(new Member(name, gender, age, tel, home));
	}
	
	// 회원 내용 수정
	public void resetMember(String backname, String name, String gender, int age, String tel, String home) {
		for(int i = 0; i < manager.size(); i++) {
			if(manager.get(i).getName().equals(backname)) {
				manager.set(i, new Member(name, gender, age, tel, home));
				System.out.println("수정이 완료되었습니다.");
				return;
			}
		}
		System.out.println("회원을 찾을 수 없습니다.");
	}
	
	// 회원 삭제
	public void removeMember(String name) {
		for(int i = manager.size() - 1; i >= 0; i--) {
			if(manager.get(i).getName().equals(name)) {
				manager.remove(i);
				System.out.println("삭제 되었습니다.");
				break;
			}
		}
	}
	
	// 회원 검색
	public void searchMember(String name) {
		for(int i = 0; i < manager.size(); i++) {
			if(manager.get(i).getName().equals(name)) {
				System.out.println(manager.get(i).toString());
				break;
			}
		}
	}
	
	// 회원 목록
	public void showMember() {
		System.out.println("<회원 목록>");
		for(int i = 0; i < manager.size(); i++) {
			System.out.print((i + 1) + "번 회원 : " + manager.get(i).getName() + "\n");
		}
	}
}

public class MemberManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ManagementSystem m = new ManagementSystem();

		while (true) {
			System.out.println("======== 회원 관리 프로그램 ========\n");
			System.out.println("1. 등록 / 2. 수정 / 3. 삭제 / 4. 검색 / 5. 목록 / 6. 종료\n");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			String name;
			String gender;
			int age;
			String tel;
			String home;
			
			switch (menu) {
			case 1:
				System.out.print("이름 입력 : "); name = sc.next();
				System.out.print("성별 입력 : "); gender = sc.next();
				System.out.print("나이 입력 : "); age = sc.nextInt();
				System.out.print("전화번호 입력 : "); tel = sc.next();
				System.out.print("주소 입력 : "); home = sc.next();
				m.addMember(name, gender, age, tel, home);
				break;
			case 2:
				System.out.print("정보를 수정할 회원 이름 : ");
				String backname = sc.next();
				System.out.println("정보를 재입력해주세요");
				System.out.print("이름 입력 : "); name = sc.next();
				System.out.print("성별 입력 : "); gender = sc.next();
				System.out.print("나이 입력 : "); age = sc.nextInt();
				System.out.print("전화번호 입력 : "); tel = sc.next();
				System.out.print("주소 입력 : "); home = sc.next();
				m.resetMember(backname, name, gender, age, tel, home);
				break;
			case 3:
				System.out.print("삭제할 회원 이름 : ");
				name = sc.next();
				m.removeMember(name);
				break;
			case 4:
				System.out.print("검색할 회원 이름 : ");
				name = sc.next();
				m.searchMember(name);
				break;
			case 5:
				m.showMember();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택하세요\n");
			}
			
			System.out.println();
		}
	}

}
