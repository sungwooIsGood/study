package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1157_단어공부 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String s = br.readLine();

      s.toUpperCase();      // ZZA
      
      Map<Character,Integer> map = new HashMap<>();
      
      int count = 1;

      for(int i = 0; i < s.length(); i++) {

         if(!map.containsKey(s.charAt(i))) {
            
            map.put(s.charAt(i), count); // z : 1   
         
         } else {
            
            // map과 set은 자동으로 정렬된다. ex) 키값기준으로 c,b,a로 들어왔다면 a,b,c로 자동 정렬됨. 
            // 방법 1
//            map.get(s.charAt(i));
            // key값을 기준으로 value값 1씩 증가
//            map.put(s.charAt(i), map.get(s.charAt(i))+1);
            
            // 방법 2
            int cnt = map.get(s.charAt(i));
            cnt++;
            map.put(s.charAt(i), cnt);
            
            
         }
      }
      
      // map안에서 최대값,최소값 찾기
      // key를 리턴 => key값중에 큰 값을 찾는다.
      // Collections.max(map.keySet()) => z,z,a,a,a => z z가 a보다 크기때문에 z를 리턴
      
      // value를 리턴 => values중에 큰 값을 찾는다.
      // Collections.max(map.values()) => z,z,a,a,a => 3
      //System.out.println(Collections.max(map.values()));
      
      // 내림차순 정렬 Collections.sort() => List형태로 Map을 가져와야한다.
      List<Character> listKeySet = new ArrayList<>(map.keySet());      
      Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));

      // 인덱스[0]과 비교하여 최대값이 두개 이상이면 ?로 변환
      String max = "";

      for(Character key : listKeySet) {
         System.out.println("key : " + key + " , " + "value : " + map.get(key));
      }

      
//      for(int i = 1; i < map.size(); i++) {
//         if(Collections.max(map.values()) == map.get(s.charAt(i))) {
//            max = "?";
//         }
//      }
//      
//      if(max.equals("?")) {
//         System.out.println(max);
//      } else {
//         Collections.max(map.values());
//      }
   }

}