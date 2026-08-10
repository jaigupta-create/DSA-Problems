class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(beginWord,1));
        Set<String> set=new HashSet();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            pair temp=q.poll();
            String word=temp.first;
            int steps=temp.second;

            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String replaceWord=new String(arr);
                    if(set.contains(replaceWord)){
                        q.offer(new pair(replaceWord,steps+1));
                        set.remove(replaceWord);
                    }
                }
            }
        }
        return 0;
    }
    class pair{
        String first;
        int second;
        pair(String f,int s){
            first=f;
            second=s;
        }
    }
}