package leetCode30Day;

public class BackspaceCompare9 {
	 

	public static void main(String[] args) {
		String str1 = "baa##c";
		String str2 = "#a#c";
		
		boolean ans = backspaceCompare(str1, str2);

		System.out.println(ans);
	}
	
	public static boolean backspaceCompare(String S, String T) {
		ReturnObj returnObj = null;
		char tempS, tempT;
		int indexS = S.length()-1;
		int indexT = T.length()-1;
		
		while(indexS > -1 || indexT > -1) {
			returnObj = getPreviousCharAndIndex(S, indexS);
			tempS = returnObj.character;
			indexS = returnObj.index - 1;
			
			returnObj = getPreviousCharAndIndex(T, indexT);
			tempT = returnObj.character;
			indexT = returnObj.index - 1;
			
			if(tempS != tempT) {
				return false;
			}else {
				continue;
			}
		}

		return true;
	}

	private static ReturnObj getPreviousCharAndIndex(String str, int index) {
		int readBackSpaceCnt = 0;
		char tempStr;
		while (index > -1) {
			tempStr = str.charAt(index);
			switch (tempStr) {
			case '#':
				index--;
				readBackSpaceCnt++;
				continue;
			default:
				if (readBackSpaceCnt != 0) {
					index--;
					readBackSpaceCnt--;
					continue;
				} else {
					return new ReturnObj(tempStr, index);
				}
			}
		}
		return new ReturnObj(' ', index);
		
	}

}

class ReturnObj {
	char character;
	int index;
	
	ReturnObj(char character, int index){
		this.character = character;
		this.index = index;
	}
}
