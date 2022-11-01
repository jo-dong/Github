/*
 * [concat]
 * 	: 배열 내의 컨텐츠들을 이어줄 때 사용
 * 
 * 	(syntax)
 *  : 문자열.concat(문자열)
 */

package stringexample;

public class Ex02 {

	public static void main(String[] args) {

		String[] str = {"one", "two", "three", "four"};
		String con = "";
		
		System.out.println(str[0] + str[1] + str[2] + str[3]);
		// 
		System.out.println(str[0].concat(str[1]).concat(str[2]).concat(str[3]));	
		// output : onetwothreefour
		
		// 향상된 for문
		for(String s : str) {
			con += s.concat(", ");
		 // con = con.concat(s).concat(", ");
		}
		System.out.print("con >> " + con);
	}

}
