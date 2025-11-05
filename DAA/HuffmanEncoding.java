import java.util.PriorityQueue;

//Node Structure for Huffman Tree
class HuffmanNode{
    int freq;
    char ch;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }
}

//Comparator for PriorityQueue (min-heap)
class MyComparator implements java.util.Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.freq - y.freq;
    }
}

public class HuffmanEncoding {
    //Recursive function to print Huffman Codes
    public static void printCode(HuffmanNode root, String code){
        if(root == null) return;

        //If leaf node, print character and code
        if(root.left == null & root.right == null && Character.isLetter(root.ch)){
            System.out.println(root.ch + ": " + code);
            return;
        }

        printCode(root.left, code + "0");
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(n, new MyComparator());

        //Step 1 : Create leaf nodes for all characters
        for(int i = 0; i < n; i++){
            pq.add(new HuffmanNode(chars[i], freq[i]));
        }

        //Step 2 : Build Huffman Tree
        while(pq.size() > 1){
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();

            HuffmanNode sum = new HuffmanNode('-', x.freq + y.freq);
            sum.left = x;
            sum.right = y;

            pq.add(sum);
        }

        //Step 3: Print Huffman Codes
        HuffmanNode root = pq.peek();
        System.out.println("Huffman Codes:");
        printCode(root, "");
    }
}
