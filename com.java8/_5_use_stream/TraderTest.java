package _5_use_stream;

import com.sun.java.accessibility.util.Translator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TraderTest {

    static Trader raoul = new Trader("Raoul","Cambridge");
    static Trader mario = new Trader("Mario","Milan");
    static Trader alan = new Trader("Alan","Cambridge");
    static Trader brain = new Trader("Brain","Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brain,2011,300),
            new Transaction(raoul,2012,1000),
            new Transaction(raoul,2011,400),
            new Transaction(mario,2012,710),
            new Transaction(mario,2012,700),
            new Transaction(alan,2012,950)
    );

    public static void main(String[] args) {
        // 1 找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> q1 = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        q1.forEach(x-> System.out.println(x.getValue()));

        // 2 交易员都在哪些不同的城市工作过
        List<String> q2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        Set<String> q22 = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(q2);
        System.out.println(q22);

        // 3 查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> q3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> x.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(q3);

        // 4 返回所有交易员的名字字符串，按字母顺序排序
        List<String> q4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(q4);

        // 5 有没有交易员是在米兰工作的
        boolean q5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(x -> x.getCity().equalsIgnoreCase("milan"));
        System.out.println(q5);

        // 6 打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(p -> p.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum).ifPresent(System.out::println);
        // 7 所有交易中，最高的交易额是多少
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).ifPresent(System.out::println);
        // 8 找到交易额最小的交易
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).ifPresent(System.out::println);

    }
}
