package study;

public class P스킬트리 {

	public static void main(String[] args) {
		
		String skill = "CBD";
		
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		// 어떻게든 CBD 순서를 유지해야한다.
		// CBD 중 어떠한 스킬도 빠트리면 안된다.
		// C는 필수로 있어야한다. 
		// 스킬트리 안에 스킬이 다 포함되었는지 확인하기.
		
		// skill_trees 인덱스 하나하나 확인하기
		int count = 0;
		for(int i = 0; i < skill_trees.length; i++) {
			
			// skill_trees를 배열 인덱스 번호로 끊어서 확인하기.
			String skill_tree = skill_trees[i];
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < skill_tree.length(); j++) {
				if(skill.contains(String.valueOf(skill_tree.charAt(j)))) {
					sb.append(String.valueOf(skill_tree.charAt(j)));
				}
			}
			
			for(int j = skill.length(); j > -1; j--) {
				String s = skill.substring(0,j);
				// cbd
				// cb
				// c
				if(s.equals(sb.toString())) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
