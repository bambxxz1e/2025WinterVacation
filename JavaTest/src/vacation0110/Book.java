package vacation0110;

import java.util.*;

class Books {
	private String name, author, genre;

	public Books(String name, String author, String genre) {
		this.name = name;
		this.author = author;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "도서명 : " + name + "\n저자 : " + author + "\n장르 : " + genre;
	}
}

class BookSystem {
	private ArrayList<Books> manager;
	Scanner sc = new Scanner(System.in);

	public BookSystem() {
		manager = new ArrayList<>();
	}

	public void insertB(String name, String author, String genre) {
		for (Books books : manager) {
			if (books.getName().equals(name)) {
				System.out.println("이미 등록되었습니다.");
				return;
			}
		}
		manager.add(new Books(name, author, genre));
	}

	public void deleteB(String name) {
		for (int i = manager.size() - 1; i >= 0; i--) {
			if (manager.get(i).getName().equals(name)) {
				manager.remove(i);
				System.out.println("삭제 되었습니다.");
				return;
			}
		}
		System.out.println("도서를 찾을 수 없습니다.");
	}
	
	public void updateB(String name) {
		for (int i = manager.size() - 1; i >= 0; i--) {
			if (manager.get(i).getName().equals(name)) {
				System.out.println("새로운 정보 입력");
				System.out.print("새 도서명 : "); String n = sc.next();
				System.out.print("새 저자명 : "); String a = sc.next();
				System.out.print("새 장르 : "); String g = sc.next();
				manager.set(i, new Books(n, a, g));
				System.out.println("수정 되었습니다.");
				return;
			}
		}
		System.out.println("도서를 찾을 수 없습니다.");
	}

	public void selectOne(String name) {
		for (int i = 0; i < manager.size(); i++) {
			if (manager.get(i).getName().equals(name)) {
				System.out.println(manager.get(i).toString());
				break;
			}
		}
	}

	public void searchAll() {
		System.out.println("<도서 목록>");
		for (int i = 0; i < manager.size(); i++) {
			System.out.print((i + 1) + ". " + manager.get(i).getName() + "\n");
		}
	}
	
	public void checkB(String name) {
		for (int i = manager.size() - 1; i >= 0; i--) {
			if (manager.get(i).getName().equals(name)) {
				System.out.println("도서가 존재합니다.");
				return;
			}
		}
		System.out.println("도서를 찾을 수 없습니다.");
	}
}

public class Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BookSystem b = new BookSystem();

		while (true) {
			System.out.println("======== 도서 관리 프로그램 ========\n");
			System.out.println("1. 등록 / 2. 수정 / 3. 삭제 / 4. 검색 / 5. 목록 / 6. 도서 확인 / 7. 종료\n");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.print("도서명 입력 : "); String name = sc.next();
				System.out.print("저자명 입력 : "); String author = sc.next();
				System.out.print("장르 입력 : "); String genre = sc.next();
				b.insertB(name, author, genre);
				break;
			case 2:
				System.out.print("정보를 수정할 도서명 : ");
				name = sc.next();
				b.updateB(name);
				break;
			case 3:
				System.out.print("삭제할 도서명 : ");
				name = sc.next();
				b.deleteB(name);
				break;
			case 4:
				System.out.print("검색할 도서명 : ");
				name = sc.next();
				b.selectOne(name);
				break;
			case 5:
				b.searchAll();
				break;
			case 6:
				System.out.print("확인할 도서명 : ");
				name = sc.next();
				b.checkB(name);
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택하세요\n");
			}

			System.out.println();

		}
	}

}
