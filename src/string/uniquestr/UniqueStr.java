package string.uniquestr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * Created by Michael Allan on 2020/4/25.
 */
public class UniqueStr {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            boolean unique = isUnique(line);
            System.out.println(unique);
        }
    }

    /**
     * 使用BitSet判断一个字符串中的字符是否都是唯一的
     * @param input
     * @return
     */
    private static boolean isUnique(String input) {
        BitSet bitSet = new BitSet();
        byte[] bytes = input.getBytes();
        for (byte b : bytes) {
            if (bitSet.get(b)) {
                return false;
            }
            bitSet.set(b);
        }
        return true;
    }
}
