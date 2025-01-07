package vacation0107;
import java.util.*;

class NumberQA{
	private int randomNumber;
	private int numberOfTries;
	
	public NumberQA() {
		this.randomNumber = (int)((Math.random() * 100) + 1);
		this.numberOfTries = 0;
	}
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		boolean hasGuessedCorrectly = false;
		
		System.out.println("======= 숫자 맞추기 게임 =======");
		System.out.println("1부터 100 사이의 숫자를 맞춰 보세요.");
		System.out.println("===========================");
		
		while(!hasGuessedCorrectly) {
			System.out.print("숫자 입력 : ");
			int playerGuess = sc.nextInt();
			numberOfTries++;
			
			if(playerGuess < randomNumber) System.out.println("Up");
			else if(playerGuess > randomNumber) System.out.println("Down");
			else {
				hasGuessedCorrectly = true;
				System.out.println("정답");
				System.out.println("시도 횟수 : " + numberOfTries + "번");
			}
		}
	}
}

public class GuessingGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberQA game = new NumberQA();
		game.startGame();
	}

}
