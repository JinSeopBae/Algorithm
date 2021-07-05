package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberHobby {
    public void hobbys() {
        List<List<String>> persons = CsvUtils.readToList();
        Map<String, Integer> result = new HashMap<>();
        persons.remove(0);
        persons.stream()
                .flatMap(
                it -> Arrays.stream(it.get(1).split(":"))
                ).forEach(
                    hobby -> result.merge(hobby, 1, (oldValue, newValue)->++oldValue));

        result.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void main(String[] args) {
        MemberHobby memberHobby = new MemberHobby();
        memberHobby.hobbys();
    }
}
