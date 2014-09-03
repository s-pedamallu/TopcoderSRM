package srm630.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by shashank on 8/21/14.
 *
 * This code is influenced from the solution posted in the SRM Match Editorials of www.topcoder.com
 */
public class Egalitarianism3Easy {
    private int[][] allDistances;
    private int currentNode;
    private boolean[] visited;

    public int maxCities(int numCities, int[] src, int[] dest, int[] len) {

        if (numCities<3) {
            return numCities;
        }
        String[] tree = buildTree(numCities,src,dest,len);
        computeAllDistances(tree);
        return computeMaxSubset(numCities);
    }

    // Build Adjacency List
    private String[] buildTree (int size, int[] src, int[] dest, int[] len) {
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

    // Perfrom DFS repetitively
    private void computeAllDistances(String[] tree) {
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

    // Perform DFS
    private void performDFS(int node, int cumulativeDistance, String[] tree) {
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

    // Compute the maximum subset of cities with equal mutual distances
    private int computeMaxSubset(int num) {
        int ans = 0; // keeps track of the end result

        // loop for all possible subsets
        for (int subsetId = 0; subsetId < (1<<num); subsetId++) {
            int dis = -1; // keeps track of current subset distance
            HashSet<Integer> subset = new HashSet<Integer>(); // keeps track of  cities in this subset
            boolean isSameDistance = true; // keeps track if all the distances in this subset are of same distance

            // loop through all of the valid portion of allDistances matrix (i.e., all elements above principal diagonal)
            for (int i=0; i < num; i++) {
                // to check if this particular subset takes i into consideration
                if ((subsetId & (1<<i)) > 0) {
                    subset.add(i);
                    for (int j=i+1; j<num; j++) {
                        // to check if this particular subset takes j into consideration
                        if ((subsetId & (1<<j)) > 0) {
                            subset.add(j);
                            if(dis==-1) {
                                dis = allDistances[i][j];
                            }
                            else if(allDistances[i][j] != dis) {
                                isSameDistance = false;
                            }
                        }
                    }
                }
            }

            if (isSameDistance) {
                ans = Math.max(ans, subset.size());
            }

        }
        return ans;
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