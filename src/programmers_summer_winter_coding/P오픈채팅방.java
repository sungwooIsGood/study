package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P오픈채팅방 {

	public static void main(String[] args) {

		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        // record의 id값 넣기
        ArrayList<String> arr = new ArrayList<>();
        // id - 닉네임
		HashMap<String, String> map = new HashMap<>();
       
		for (int i = 0; i < record.length; i++) {
			String[] s = record[i].split(" ");
            
            if(s[0].equals("Enter")){
                map.put(s[1],s[2]);
                // 왜 아이디값 님이 들어왔습니다로 했냐면 map의 아이디값을 찾기 위해서
                arr.add(s[1]+"님이 들어왔습니다.");
            } else if(s[0].equals("Leave")){
                arr.add(s[1]+"님이 나갔습니다.");
            } else{
                map.put(s[1],s[2]);
            }
        }
       
        String[] answer = new String[arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            // 아이디값 분리 - int형으로 받기
        	int idx = arr.get(i).indexOf("님");
        	// int형 이용하여 id값 만들기
        	String id = arr.get(i).substring(0,idx);
        	// 들어왔습니다, 나갔습니다
        	String[] tmp = arr.get(i).split(" ");
        	answer[i] = map.get(id) + "님이 "+ tmp[1];
        }
        System.out.println(Arrays.toString(answer));
    }

}
