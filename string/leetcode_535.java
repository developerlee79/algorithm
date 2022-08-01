package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class leetcode_535 {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();

        String tinyURL = codec.encode(url);
        System.out.println(tinyURL);

        String fullURL = codec.decode(tinyURL);
        System.out.println(fullURL);
    }

    // Solution - Random API
    // Time Complexity : O(1)
    // Space Complexity : O(N)
    // Use java.util.Random api to make random 6 digits code.
    // Save the created code and the original URL to the map and search to the map when requested.
    public static class Codec {

        Map<String, String> encodeMap = new HashMap<>();

        protected final String tinyURL = "http://tinyurl.com/";

        public String encode(String longUrl) {
            String encodedString = getRandomCode();

            while (encodeMap.containsKey(encodedString)) {
                encodedString = getRandomCode();
            }

            encodeMap.put(encodedString, longUrl);

            return tinyURL + encodedString;
        }

        public String decode(String shortUrl) {
            return encodeMap.get(getFinalURLSeparator(shortUrl));
        }

        protected String getFinalURLSeparator(String url) {
            String[] splitURL = url.split("/");
            return splitURL[splitURL.length - 1];
        }

        protected String getRandomCode() {
            char[] codes = new char[6];

            for (int i = 0; i < codes.length; i++) {
                codes[i] = getRandomChar();

                if (codes[i] % 3 == 0) {
                    codes[i] = Character.toUpperCase(codes[i]);
                } else if (codes[i] % 4 == 0) {
                    codes[i] = Character.forDigit(getRandomInt(9), 10);
                }
            }

            return String.valueOf(codes);
        }

        protected char getRandomChar() {
            return (char) ((char) getRandomInt(26) + 'a');
        }

        protected int getRandomInt(int bound) {
            Random random = new Random();
            return random.nextInt(bound);
        }
    }

}
