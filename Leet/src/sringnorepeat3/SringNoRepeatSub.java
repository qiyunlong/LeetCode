package sringnorepeat3;

import java.util.HashMap;

/**
 * Created by q on 2018/4/6.
 */
public class SringNoRepeatSub {
    public int lengthOfLongestSubstring(String s) {
        int rtn_length = 0;
        int index = 0;
        int oldIndex = 0;
        HashMap<String, Integer> indexOfChar = new HashMap<>(s.length());
        char[] charArrayS = s.toCharArray();

        for (char i : charArrayS) {
            if (!indexOfChar.containsKey(String.valueOf(i))) {
                indexOfChar.put(String.valueOf(i), Integer.valueOf(index));
            } else {
                oldIndex = indexOfChar.get(String.valueOf(i)).intValue();
                if (index - oldIndex > rtn_length) {
                    rtn_length = index - oldIndex;
                }

            }
            index++;
        }

        return rtn_length;
    }


}
