package Im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B8911_거북이 {
	
	// 시계방향 왼,상,우,하
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		// f => y+1
		// b => y-1;
		// r = > 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < test; i++) {
			
			// 넓이를 구하기 위한 변수, x축 최소-최대, y축 최소-최대
			int minX = 0;
			int minY = 0;
			int maxX = 0;
			int maxY = 0;
			
			int x = 0;
			int y = 0;
			
			// 회전
			int dir = 0;

			String s = br.readLine();
			
			for(int j = 0; j < s.length(); j++) {
				
				
				char c = s.charAt(j);
				
				switch(c) {
					
					case 'F' :
						x += dx[dir];
						y += dy[dir];
					break;
					
					case 'B' :
						x -= dx[dir];
						y -= dy[dir];
					break;
					
					case 'R' :
						if(dir == 3) {
							dir = 0;
						} else {
							dir++;
						}
					break;
					
					case 'L' : 
						if(dir == 0) {
							dir = 3;
						} else {
							dir--;
						}
					break;
						
				}
				
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
				
                
			}
			System.out.println((Math.abs(minX)+Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)));
			
		}
	}

}
