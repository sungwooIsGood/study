package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018_체스판다시칠하기 {

	static char[][] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		// 체스판
		arr = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String ss = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = ss.charAt(j);
			}
		}
		
		int nowX = n-7;
		int nowY = m-7;
		
		// int의 최대값
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n-7; i++) {
			for(int j = 0; j < m-7; j++) {
				min = Math.min(min, find(i,j));
			}
		}
		System.out.println(min);
		
	}
	
	static int find(int x, int y) {
		
		int B = 0; // B부터 시작할 때 다시 칠해야 하는 정사각형 수
		int W = 0; // W부터 시작할 때 다시 칠해야 하는 정사각형 수
		
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if((i + j) % 2 == 0) {
					if(arr[i][j] == 'B') W++;
					else B++;
				}else { // (i + j) % 2 == 1)
					if(arr[i][j] == 'W') W++;
					else B++;
				}
			}
		}
		return Math.min(B,W);
	}
}
