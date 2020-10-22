package search;

public class SeqSearch {

    private static int seqSearchMethod(int[] array, int expected) {
        
        int answer = 0;
        for(int seq : array) {
            if(seq == expected)
                return seq;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,11,13,15,17,19};
        System.out.println(seqSearchMethod(array, 14));

    }
}
