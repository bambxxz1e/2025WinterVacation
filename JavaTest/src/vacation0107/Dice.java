package vacation0107;
import java.util.*;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 이름을 입력하세요 : ");
		String username = sc.nextLine();
		System.out.println("");
		int score = 0;
		int life = 10;
		
		while(true) {
			if(score == 100) {
				System.out.println("게임에서 승리하였습니다. 게임 종료");
				break;
			}
			if(life == 0) {
				System.out.println("life가 모두 소진되었습니다. 게임 종료");
				break;
			}
			
			System.out.println("현재 score : " + score);
			System.out.println("현재 life : " + life);
			System.out.println("");
			int com = (int)((Math.random() * 6) + 1);
			int user = (int)((Math.random() * 6) + 1);
			
			System.out.println("컴퓨터의 주사위 : " + com);
			System.out.println(username + "님의 주사위 : " + user);
			
			if(com == user) System.out.println("비겼습니다.");
			else if(com > user) {
				System.out.println("컴퓨터가 이겼습니다.");
				life--;
			}
			else {
				System.out.println(username + "님이 이겼습니다.");
				score += 10;
			}
			
			System.out.println("");
			System.out.print("게임을 계속하시겠습니까? (예 : 1 / 아니오 : 2) >> ");
			int con = sc.nextInt();
			System.out.println("\n=========================================\n");
			
			if(con == 2) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}

}
