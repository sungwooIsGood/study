package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class B2503_숫자야구 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 몇 번 물었는지
		int n = Integer.parseInt(br.readLine());
		ArrayList<BaseBallData> inputData = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			String number = s[0];
			int strike = Integer.parseInt(s[1]);
			int ball = Integer.parseInt(s[2]);
			
			inputData.add(new BaseBallData(number,strike,ball));
		}
		System.out.println(playBaseBall(inputData));

	}
	
	public static int playBaseBall(ArrayList<BaseBallData> inputData) {
		int answer = 0;
		
		// 1~9까지 서로 다른 숫자 3개
		for(int i = 123; i <= 987; i++) {
			
			if(hasSameOrContainsZero(i)) {
				continue;
			}
			
			int allCasePass = 0;
			
			// List 갯수만큼 돌린다.
			for(BaseBallData baseBallData : inputData) {
				
				// 민혁이가 부른 세개의 숫자
				String source = baseBallData.number;
				
				// for문으로 완탐한 숫자
				String target = String.valueOf(i);
				
				// strike 개수 확인
				int strike = countStrike(source,target);
				
				// ball 개수 확인
				int ball = countBall(source,target);
				
				// baseBallData와 일치하는지 확인
				if(strike == baseBallData.strike && ball == baseBallData.ball) {
					allCasePass++;
				} else {
					break;
				}
				
				if(allCasePass == inputData.size()) {
					answer++;
				}
			}
			
		}
		return answer;
		
	}
	
	// 스트라이크 개수 확인
	public static int countStrike(String source, String target) {
		int strike = 0;
		
		for(int i = 0; i < 3; i++) {
			if(source.charAt(i) == target.charAt(i)) {
				strike++;
			}
		}
		
		return strike;
	}
	
	// 볼 개수 확인
	public static int countBall(String source, String target) {
		int ball = 0;
		
		for(int i = 0; i < 3; i++) {
			// 숫자만 같은지 확인
			if(source.charAt(i) == target.charAt((i + 1) % 3) || source.charAt(i) == target.charAt((i + 2) % 3)) {
				ball++;
			}
		}
		return ball;
		
	}
	
	// 같은 숫자거나 0이 포함되면 true 반환
	public static boolean hasSameOrContainsZero(int i) {
		
		String sNumber = String.valueOf(i);
		
		// List 대신 Set으로 한 이유 중복허용이 안됨.
		Set<Character> chars = new HashSet<>();
		
		// set에서 122를 넣을 때 자동으로 1과 2만 들어가진다.
		for(int j = 0; j < sNumber.length(); j++) {
			chars.add(sNumber.charAt(j));
		}
		return chars.contains('0') || chars.size() != 3; // true
	}
	
	
	
	static class BaseBallData{
		String number;
        int strike;
        int ball;

        public BaseBallData(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
	}

}
