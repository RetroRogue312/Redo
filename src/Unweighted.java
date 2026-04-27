
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Unweighted
{
    public List<Integer> BFS(int[][] graph, int start, int target)
    {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int[] pred = new int[graph.length];

        for (int i = 0; i < pred.length; i++)
        {
            pred[i] = -1;
        }
        q.add(start);
        visited[start] = true;


        while(!q.isEmpty())
        {
            int node = q.remove();

            for (int i = 0; i < graph.length; i++)
            {
                if (graph[node][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    pred[i] = node;
                    q.add(i);

                    if (i == target)
                    {
                        return getPath(pred, target);
                    }


                }
            }
        }
        return new ArrayList<>();
    }

    public List<Integer> getPath(int[] pred, int target)
    {
        List<Integer> path = new ArrayList<>();
        int current = target;
        while (current != -1)
        {
            path.add(0, current);
            current = pred[current];
        }
        return path;
    }

    public static void main(String[] args)
    {
        int[][] graph = {
                {0,1,0,0},
                {1,0,1,1},
                {1,0,0,0},
                {1,0,1,0}
        };
        Unweighted w = new Unweighted();
        System.out.println(w.BFS(graph,0,3));
    }
}
