package srm630.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shashank on 8/21/14.
 */
public class Egalitarianism3Easy {
    private int[][] allDistances;
    private int currentNode;
    private boolean[] visited;

    public int maxCities(int numCities, int[] src, int[] dest, int[] len) {

        String[] tree = buildTree(numCities,src,dest,len);
        computeAllDistances(tree);
        return 0;
    }

    public String[] buildTree (int size, int[] src, int[] dest, int[] len) {
        String[] tree = new String[size];
        for (int i=0; i<size; i++) {
            tree[i]= new String();
        }
        for (int i=0; i<src.length; i++) {
            int a = src[i];
            int b = dest[i];
            tree[a-1]+=Integer.valueOf(b-1).toString()+"-"+len[i]+",";
            tree[b-1]+=Integer.valueOf(a-1).toString()+"-"+len[i]+",";
        }
        return tree;
    }

    public void computeAllDistances(String[] tree) {
        allDistances = new int[tree.length][tree.length];
        visited = new boolean[tree.length];
        for (int i=0; i<tree.length; i++){
            for (int j=0; j<visited.length; j++) {
                visited[j] = false;
            }
            currentNode = i;
            performDFS(i, 0, tree);
        }
    }

    public void performDFS(int node, int cumulativeDistance, String[] tree) {
        visited[node] = true;
        allDistances[currentNode][node] = cumulativeDistance;
        if(node!=currentNode) {
            allDistances[node][currentNode] = cumulativeDistance;
        }
        String[] neighbours = tree[node].split(",");
        for(int i=0; i<neighbours.length; i++) {
            String[] tmp = neighbours[i].split("-");
            int neighbourNode = Integer.parseInt(tmp[0]);
            int edgeLength = Integer.parseInt(tmp[1]);
            if(!visited[neighbourNode]) {
                performDFS(neighbourNode,cumulativeDistance+edgeLength,tree);
            }
        }
    }


    // For debugging
    public static void main(String[] args) throws IOException {
        Egalitarianism3Easy obj = new Egalitarianism3Easy();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of Cities: ");
        String input = br.readLine();
        int num = Integer.parseInt(input);
        int[] a = new int[num-1];
        int[] b = new int[num-1];
        int[] c = new int[num-1];
        System.out.println("Enter edge sources array: ");
        input = br.readLine();
        String[] tmp = input.split(",");
        for(int i=0; i<a.length; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println("Enter edge destinations array: ");
        input = br.readLine();
        tmp = input.split(",");
        for(int i=0; i<b.length; i++) {
            b[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println("Enter edge lengths array: ");
        input = br.readLine();
        tmp = input.split(",");
        for(int i=0; i<c.length; i++) {
            c[i] = Integer.parseInt(tmp[i]);
        }

        obj.maxCities(num,a,b,c);
    }

}