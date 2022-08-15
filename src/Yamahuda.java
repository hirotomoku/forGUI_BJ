import java.util.Collections;
import java.util.List;


public class Yamahuda {
	List <Integer> yamahuda;
	public static int flag;
	
	public static void shuffleDeck(List<Integer> deck) {
		for(int i = 1; i <= 52; i++) {
			deck.add(i);//リストに要素を加える
		}
//		for(var test: deck) {
//		System.out.println(test);
		Collections.shuffle(deck);
	}
	public static int drowDeck(List<Integer> deck, List<Integer> aman) {//deckから2枚カードを引いてその分deckから引くメソッド
		aman.add(deck.get(0));//deckの一要素目をプレイヤーorディーラーリストに加える
		deck.remove(deck.get(0));//上でどちらかのリストにいれたやつを削除する
		return deck.size();//残りのdeckの数を戻す。
	}
	
	public static String toSuit(int cardNumber) {//要素の値からマークを求める
		switch((cardNumber - 1)/13) {
		case 0:
			return "クラブ";
		case 1:
			return "ダイヤ";
		case 2:
			return "ハート";
		case 3:
			return "スペード";
		default:
			return "例外です";
		}
	}
	
	public static String toRank(int number) {//要素の値から手札の番号を求める
	    switch((number) % 13) {
	    case 1:
	        return "A";
	    case 11:
	        return "J";
	    case 12:
	        return "Q";
	    case 0:
	        return "K";
	    default:
	        String str = String.valueOf((number) % 13);
	        return str;
	    }
	}
	
	public static int[] toPoint(int number) {//ポイント換算
		int[] ace = { 1, 11 };
		int[] numbox = new int[2];
	    switch((number) % 13) {
	    case 1:
	    	if(flag == 0) {
	    		flag += 1;
	    		return ace;
	    	}else {
		    	numbox[0] = 1;
		    	numbox[1] = numbox[0];
		        return numbox;
	    	}
	        
	    case 11:
	    	numbox[0] = 10;
	    	numbox[1] = numbox[0];
	        return numbox;
	    case 12:
	    	numbox[0] = 10;
	    	numbox[1] = numbox[0];
	        return numbox;
	    case 0:
	    	numbox[0] = 10;
	    	numbox[1] = numbox[0];
	        return numbox;
	    default:
	    	numbox[0] = number % 13;
	    	numbox[1] = numbox[0];
	        return numbox;
	    }
	}
	
	public static String toDescription(int cardNumber) {//手札の番号と手札のマークを合わせるためのメソッド
	    String rank = toRank(cardNumber);
	    String suit = toSuit(cardNumber);
	 
	    return "【" + suit + ":"  + rank + "】";
	}
	
	public static int[] countPoint(List<Integer> aman) {//手札のポイント合算
//		int[] point = new int[2];
//		for(int yoso :aman) {
//		point[0] += (toPoint(yoso))[0];
//		point[1] += (toPoint(yoso))[1];
//		}
//		return point;
		
		int[] point = new int[2];
		int[] point0 = new int[2];
		
		for(int i = 0; i < aman.size();i++) {
//			point[0] += toPoint(aman.get(i))[0];
//			point[1] += toPoint(aman.get(i))[1];
			point0 = toPoint(aman.get(i));
//			System.out.println(point0[0]);
//			System.out.println(point0[1]);
			point[0] = point[0] + point0[0];
			point[1] = point[1] + point0[1];
				
		}
		
		return point;
	}
	
	public static String judgeResult(int a, int b) {
		if(a > 21 && b > 21) {
			return "引き分けです。";
		}else if(a > 21) {
			return "あなたの負けです。";
		}else if(b > 21) {
			return "あなたの勝ちです。";
		}else if(a > b) {
			return "あなたの勝ちです。";
		}else if (a < b) {
			return "あなたの負けです。";
		}else {
			return "引き分けです。";
		}
	}
	public static int selectElement(List<Integer> aman) {
		if(countPoint(aman)[1] > 21) {
			return countPoint(aman)[0];
		}else {
			return countPoint(aman)[1];
		}
	}
	public static void duelGame(List<Integer> deck, List<Integer> player, List<Integer> deeler) {
		
	}
	
}