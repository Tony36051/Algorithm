package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M1713ReSpaceLcci {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new String[]{"aaysaayayaasyya","yyas","yayysaaayasasssy","yaasassssssayaassyaayaayaasssasysssaaayysaaasaysyaasaaaaaasayaayayysasaaaa","aya","sya","ysasasy","syaaaa","aaaas","ysa","a","aasyaaassyaayaayaasyayaa","ssaayayyssyaayyysyayaasaaa","aya","aaasaay","aaaa","ayyyayssaasasysaasaaayassasysaaayaassyysyaysaayyasayaaysyyaasasasaayyasasyaaaasysasy","aaasa","ysayssyasyyaaasyaaaayaaaaaaaaassaaa","aasayaaaayssayyaayaaaaayaaays","s"},
                        "asasayaayaassayyayyyyssyaassasaysaaysaayaaaaysyaaaa", 7),
                Arguments.of(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother", 7)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String[] dictionary, String sentence, int expect) {
        assertEquals(expect, respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {

        Trie root = new Trie();
        Arrays.stream(dictionary).forEach(t -> root.insert(t));
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1; // 假设：第i位字母与前面[0...i-1]未凑成单词
            int matchedLen = root.search(new StringBuilder(sentence.substring(0, i)).reverse().toString());
            if (matchedLen > 0) {
                dp[i] = Math.min(dp[i], dp[i - matchedLen]);
            }
        }
        return dp[sentence.length()];
    }
}

class Trie {
    private Trie[] next = new Trie[26];
    private boolean isEnd = false;

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie curNode = this;
        for (int i = word.length()-1; i >=0; i--) {
            char c = word.charAt(i);
            if (curNode.next[c - 'a'] == null) {
                curNode.next[c - 'a'] = new Trie();
            }
            curNode = curNode.next[c - 'a'];
        }
        curNode.isEnd = true;
    }

    public int search(String word) {
        int matchedLen = -1;
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            Trie childNode = curNode.next[word.charAt(i) - 'a'];
            if (childNode == null) {
                return matchedLen;
            }
            if (childNode.isEnd) {
                matchedLen = i + 1;
            }
            curNode = childNode;
        }
        return matchedLen;
    }
}