package app;

import model.CallBack;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CallBackGenerator {

    private final int length = 8;

    public List<CallBack> generateCallbacks(int amount) {
        List<CallBack> callBacks = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            CallBack callBack = new CallBack();
            callBack.setGUID(UUID.randomUUID().toString().toUpperCase());
            callBack.setOrigCallerNbr(generateNumber(length));
            callBack.setNext("ASAP");
            callBack.setQueuename(randomName());
            callBack.setStart(generateRandomTime());

            callBacks.add(callBack);
            //System.out.println(callBack.toString());
        }
        return callBacks;
    }
    private String generateRandomTime() {

        int hour = ThreadLocalRandom.current().nextInt(1, 24);
        int minute = ThreadLocalRandom.current().nextInt(1, 60);
        LocalDateTime dateTime = LocalDateTime.of(2020, 11, 14, hour, minute);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");

        return dateTime.format(formatter);


    }



    private String randomName() {
        List<String> names = Arrays.asList("AAAA", "BBBB", "CCCC", "Courier", "Express");
        int randomNum = ThreadLocalRandom.current().nextInt(1, names.size());
        return names.get(randomNum);
    }

    private String generateNumber(int length) {
        return RandomStringUtils.random(length, false, true);
    }
}
