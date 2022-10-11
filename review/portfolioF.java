import java.util.Scanner;
import java.util.Random;
public class portfolioF {

	public static void main(String[] args) {
		System.out.println("컴퓨터가 1~100 중 랜덤 숫자 하나를 정합니다. \n이 숫자를 맞춰주세요.");

        int count = 1;
        int num = (int) (Math.random() * 10) + 1;

        Scanner sc = new Scanner(System.in);

        int num_enter = 0;

        while (num != num_enter) {
            System.out.print("1~10 숫자 입력:");
            num_enter = sc.nextInt();
            if (num > num_enter) {
                System.out.println("컴퓨터의 숫자가 더 큽니다");
                count++;
            } else if (num < num_enter) {
                System.out.println("컴퓨터의 숫자가 더 작습니다");
                count++;
            }
        }
        System.out.println("정답입니다! " + count + "회 만에 맞췄어요.");
        sc.close();
		}
	}
