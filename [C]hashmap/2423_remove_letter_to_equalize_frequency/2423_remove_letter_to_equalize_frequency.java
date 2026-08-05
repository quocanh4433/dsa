

class RemoveLetterToEqualizeFrequency {
    /*
        time O(n)
        space O(26)
    */
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];

        for(char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            
            freq[i]--;
            if(isValid(freq)) return true;
            freq[i]++;
        }

        return false;
    }

    public boolean isValid (int[] freq) {
        int target = -1;

        for(int f : freq) {
            if(f == 0) continue;
            else if(target == -1) {
                target = f;
                continue;
            }
                
            if(f != target) return false;  

        }

        return true;
    }
}
