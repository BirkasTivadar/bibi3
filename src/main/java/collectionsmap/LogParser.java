package collectionsmap;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {

    public static final String LOG_DELIMITER = "\n";
    public static final String ENTRY_DELIMITER = ":";
    public static final String DATE_DELIMITER = "-";
    public static final int SIZE = 3;
    public static final int POSITION_OF_DATE = 1;
    public static final int POSITION_OF_IP = 0;
    public static final int POSITION_OF_LOGIN = 2;


    public Map<String, List<Entry>> parseLog(String str) {
        Map<String, List<Entry>> result = new HashMap<>();
        String[] strArr = str.split(LOG_DELIMITER);
        for (String log : strArr) {
            Entry entry = getEntry(log);
            if (!result.containsKey(entry.getIpAddress())) {
                result.put(entry.getIpAddress(), new ArrayList<>());
            }
            result.get(entry.getIpAddress()).add(entry);
        }
        return result;
    }


    private Entry getEntry(String log) {
        String[] logArr = log.split(ENTRY_DELIMITER);
        if (logArr.length != SIZE) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        String[] dateArr = logArr[POSITION_OF_DATE].split(DATE_DELIMITER);
        if (dateArr.length != SIZE) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        return new Entry(logArr[POSITION_OF_IP], LocalDate.of(year, month, day), logArr[POSITION_OF_LOGIN]);
    }

}
