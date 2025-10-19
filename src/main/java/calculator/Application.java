package calculator;

<<<<<<< HEAD
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
=======
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = StringAdd.calculate(input);  // 클래스명 변경됨
        System.out.println("결과 : " + result);
    }
}

>>>>>>> f52a522 (입/출력 기능 구현)
