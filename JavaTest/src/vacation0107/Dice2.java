package vacation0107;

public class Dice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int one1 = (int)((Math.random() * 6) + 1);
			int two1 = (int)((Math.random() * 6) + 1);
			System.out.println("Player 1의 첫번째 주사위 : " + one1);
			System.out.println("Player 2의 첫번째 주사위 : " + two1);
			
			int one2 = (int)((Math.random() * 6) + 1);
			int two2 = (int)((Math.random() * 6) + 1);
			System.out.println("Player 1의 두번째 주사위 : " + one2);
			System.out.println("Player 2의 두번째 주사위 : " + two2);
			
			int sum1 = one1 + one2;
			int sum2 = two1 + two2;
			
			System.out.println();
			System.out.println("Player 1의 주사위의 합 : " + sum1);
			System.out.println("Player 2의 주사위의 합 : " + sum2);
			
			System.out.println();
			
			if(sum1 > 10 || sum2 > 10) {
				if(sum1 > 10 & sum2 <= 10) {
					System.out.println("Player 2가 이겼습니다.");
					break;
				}
				else if(sum1 <= 10 & sum2 > 10) {
					System.out.println("Player 1이 이겼습니다.");
					break;
				}
				else System.out.println("게임을 재시작 합니다.\n");
			}
			else {
				if(sum1 > sum2) {
					System.out.println("Player 1이 이겼습니다.");
					break;
				}
				else if(sum1 < sum2) {
					System.out.println("Player 2가 이겼습니다.");
					break;
				}
				else System.out.println("게임을 재시작 합니다.\n");
			}
		}
	}

}
