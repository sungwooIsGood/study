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

      s = s.toUpperCase();   // ZZA
      
      Map<Character,Integer> map = new HashMap<>();
      
      // value값 하나씩 올려주는 역할
      int cnt = 0;
      
      for(int i = 0; i < s.length(); i++) {

         if(!map.containsKey(s.charAt(i))) {
            
            map.put(s.charAt(i), 1); // z : 1   
         
         } else {
            
            // map과 set은 자동으로 정렬된다. ex) 키값기준으로 c,b,a로 들어왔다면 a,b,c로 자동 정렬됨. 
            // 방법 1
//            map.get(s.charAt(i));
            // key값을 기준으로 value값 1씩 증가
//            map.put(s.charAt(i), map.get(s.charAt(i))+1);
            
            // 방법 2
            cnt = map.get(s.charAt(i));
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

      // map에 있는 최대값이 여러개인지 알 수 있는 역할
      int count = 0;
      char result = ' ';
      
//      for(Character key : listKeySet) {
//         System.out.println("key : " + key + " , " + "value : " + map.get(key));
//      }

      for(Character key : map.keySet()) {
    	  if(Collections.max(map.values()) == map.get(key)) {
              count++;
              result = key;

           }
      }

      if(count > 1) {
         System.out.println("?");
      } else {
         System.out.println(result);
      }
   }

}