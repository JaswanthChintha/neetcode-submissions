

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];

        q.add(beginWord);
        int count = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                for (int i = 0; i < wordList.size(); i++) {

                    if (!visited[i] &&
                        isDifferentByOne(word, wordList.get(i))) {

                        q.add(wordList.get(i));
                        visited[i] = true;
                    }
                }
            }

            count++;
        }

        return 0;
    }

    // Checks whether exactly one character is different
    public boolean isDifferentByOne(String a, String b) {

        int diff = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}