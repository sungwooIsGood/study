package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B8911_거북이 {

	public static void main(String[] args) throws IOException {

		// f => y+1
		// b => y-1;
		// r = > 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < test; i++) {
			
			
			String move = br.readLine();
			char[] c = new char[move.length()];
			
//			현재 위치
			int x = 0;
			int y = 0;
			
//			거북이가 바라보고 있는 방향
			int go = 0;
			
//			움직일 위치 => 상,우,하,좌 (시계 방향)
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			
//			넓이를 찾기 위한 변수
			int minX = 0;
			int minY = 0;

			
			
			for(int j = 0; j < move.length(); j++) {
				c = move.toCharArray();
			}
			
			for(int j = 0; j < c.length; j++) {
				
				switch(c[j]) {
					case 'F' : 
						x += dx[go];
						y += dy[go];
						break;
					
					case 'B' :
						x -= dx[go];
						y -= dy[go];
						break;
					
					case 'L' : 

						if(go == 0) {
							go = 3;
						} else {
							go = go - 1;
						}
						break;
						
					case 'R' :
						if(go == 0) {
							go = 1;
						} else {
							go = go + 1;
						}
						break;
				
				}
//				넓이 구하기
				minX = Math.max(minX, Math.abs(x));
				minY = Math.max(minY, Math.abs(y));
//				System.out.println(minX);
//				System.out.println(minY);
				
			}
//			넓이
//			System.out.println(Math.abs(minX)*Math.abs(minY));
			System.out.println(minX * minY);
		}
	}

}
