import java.util.*;

public class Test {
    private final int COLLECTION_MAXIMUM_LENGTH = 3;
    int strike = 0;
    int ball = 0;
    Set<Integer> computer;
    List<Integer> user;
    Random random;

    public Test() {
        computer = new HashSet<>();
        user = new ArrayList<>();
        random = new Random();
    }

    public static void main(String[] args) {
        Test test = new Test();

        // 컴퓨터 숫자 생성
        test.computerNumberCreate(test);
        System.out.println(Arrays.toString(test.computer.toArray()));
        Scanner scanner = new Scanner(System.in);

        // 유저 번호 입력
        test.userGame(test);
        System.out.println(Arrays.toString(test.user.toArray()));
        test.compare(test);
        System.out.println("스트라이크 : " + test.strike + " 볼 : " + test.ball);
        test.answer(test,scanner);

    }

    private void answer(Test test, Scanner scanner) {
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if(true) {
            System.out.println(ball+"볼");
            test.userGame(test);
        }
    }

    private void compare(Test test) {
        Iterator<Integer> userIter = test.user.iterator();
        for(Integer number : test.computer) {
            test.strikeBallCheck(number, userIter.next());
        }
    }

    private void userGame(Test test) {
        Scanner scanner = new Scanner(System.in);
        while(test.user.size() < test.COLLECTION_MAXIMUM_LENGTH)
            test.user.add(scanner.nextInt());
        scanner.close();
    }

    private void computerNumberCreate(Test test) {
        while(test.computer.size() < test.COLLECTION_MAXIMUM_LENGTH)
            test.randomNumberGenerate(test.random, test.computer);
    }

    private void randomNumberGenerate(Random random, Set<Integer> computer) {
            computer.add(random.nextInt(10)+1);
    }

    private void strikeBallCheck(Integer computer, Integer user) {
        if(computer.equals(user)) {
            this.strike += 1;
            return;
        }

        if(this.user.contains(computer)) {
            this.ball += 1;
        }
    }
}
