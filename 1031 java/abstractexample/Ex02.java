// Error 위에 커서 올리고 Ctrl + 1 : Error 빠른 해결

package abstractexample;
import java.io.IOException;
import java.io.InputStream;

// InputStream 내에 있는 read() method가 abstract!
// InputStream을 부모로 두기 위해선 반드시 read() method를 Overriding 해야함.
class Test extends InputStream {

	@Override
	public int read() throws IOException {
		return 0;
	}
	
}

public class Ex02 {

	public static void main(String[] args) {

		
		
	}

}
