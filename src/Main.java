import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("ゲームを開始します\n");
		List <Integer> deck = new ArrayList<>();
		Yamahuda.shuffleDeck(deck);

		List <Integer> player = new ArrayList<>();//プレイヤーの空のデッキを作成
		for(int i = 0 ; i < 2; i++) {
		Yamahuda.drowDeck(deck,player);//deckからカードを2枚ドロー
		}
		
		List <Integer> deeler = new ArrayList<>();//ディーラーの空のデッキを作成
		for(int i = 0 ; i < 2; i++) {
		Yamahuda.drowDeck(deck,deeler);//deckからカードを2枚ドロー
		}
		
		System.out.println("あなたの手札");
		for(int i : player) {
			System.out.printf("%s", Yamahuda.toDescription(i));
		}
		System.out.println();
		System.out.println("---------------------------------");
		
	
		System.out.println("ディーラーの手札");
		System.out.printf("%s", Yamahuda.toDescription(deeler.get(0)));
		System.out.println("【■■■■】");
		System.out.println("---------------------------------\n");
		
		System.out.println("カードを引きますか？");
		System.out.println("1:Yes 2:No");
		Scanner sc = new Scanner(System.in);
		int yn = sc.nextInt();
		if(yn == 1) {
			while(yn == 1) {
				Yamahuda.drowDeck(deck,player);
				System.out.println("あなたの手札");
				for(int i : player) {
					System.out.printf("%s", Yamahuda.toDescription(i));
				}
				System.out.println();//↓ここチェック
				if(Yamahuda.countPoint(player)[0] > 21) {
					System.out.println("Burst!!");
					System.out.println("あなたの負けです。");
					System.out.println("ゲームを終了します。");
					System.exit(0);
				}
				System.out.println("もう一度カードを引きますか？");
				System.out.println("1:Yes 2:No");
				yn = sc.nextInt();
			}
			System.out.println("ディーラーの手札");
			System.out.printf("%s", Yamahuda.toDescription(deeler.get(0)));
			System.out.printf("%s\n", Yamahuda.toDescription(deeler.get(1)));
	

			int yososu = 1;//↓ここチェック
			int[] checkpoint = new int[2];
			checkpoint = Yamahuda.countPoint(deeler);
			System.out.println("ポイントは" + checkpoint[1]);
			while(checkpoint[1] <= 15) {//最大値が15以下の時はカードを引く
				Yamahuda.drowDeck(deck,deeler);
				System.out.println("ディーラーのドロー");
				System.out.printf("%s", Yamahuda.toDescription(deeler.get(0)));
				System.out.printf("%s", Yamahuda.toDescription(deeler.get(1)));
				System.out.printf("%s\n", Yamahuda.toDescription(deeler.get(++yososu)));
				if(Yamahuda.countPoint(deeler)[0] > 21) {
					System.out.println("Burst!!");
					System.out.println("あなたの勝ちです。");
					System.out.println("ゲームを終了します。");
					System.exit(0);
				}
				try {
				Thread.sleep(1000);//１秒待つ
				}catch(InterruptedException e) {
					 e.printStackTrace();
				}
				
			}//↓ここチェック
			System.out.println("〇ディーラーのポイントは" + Yamahuda.selectElement(deeler));
			System.out.println("●あなたのポイントは" + Yamahuda.selectElement(player));
			System.out.println(Yamahuda.judgeResult(Yamahuda.selectElement(player),Yamahuda.selectElement(deeler)));
			
			
			
			sc.close();
			System.exit(0);
		}else if (yn == 2) {
			System.out.println("ディーラーの手札");
			System.out.printf("%s", Yamahuda.toDescription(deeler.get(0)));
			System.out.printf("%s\n", Yamahuda.toDescription(deeler.get(1)));
	

			int yososu = 1;
//			int[] checkpoint = new int[2];
//			int[] checkpoint_p = new int[2];
//			checkpoint = Yamahuda.countPoint(deeler);
//			checkpoint_p = Yamahuda.countPoint(player);
//			System.out.println("ポイントは" + checkpoint[1]);
			while(Yamahuda.countPoint(deeler)[1] <= 15) {//合計が15以下の時はカードを引く || checkpoint[1] < checkpoint_p[1]
				System.out.println("ディーラーのドロー");
				for(int yoso: deeler) {
					System.out.printf("%s", Yamahuda.toDescription(yoso));
				}
				Yamahuda.drowDeck(deck,deeler);
				//checkpoint = Yamahuda.countPoint(deeler);
				try {
				Thread.sleep(1000);//１秒待つ
				}catch(InterruptedException e) {
					 e.printStackTrace();
				}
				System.out.printf("%s\n", Yamahuda.toDescription(deeler.get(++yososu)));
				if(Yamahuda.countPoint(deeler)[0] > 21) {
					System.out.println("Burst!!");
					System.out.println("あなたの勝ちです。");
					System.out.println("ゲームを終了します。");
					System.exit(0);
				}				
			}
			System.out.println("〇ディーラーのポイントは" + Yamahuda.selectElement(deeler));
			System.out.println("●あなたのポイントは" + Yamahuda.selectElement(player));
			System.out.println(Yamahuda.judgeResult(Yamahuda.selectElement(player),Yamahuda.selectElement(deeler)));
			
			sc.close();
			System.exit(0);
		}else {
			System.out.println("ゲームを終了します。");
			sc.close();
			System.exit(0);
		}
		sc.close();
	    
	}

}
