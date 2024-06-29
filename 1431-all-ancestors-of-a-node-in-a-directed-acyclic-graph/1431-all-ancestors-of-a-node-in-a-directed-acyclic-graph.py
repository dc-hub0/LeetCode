from collections import defaultdict, deque

class Solution:
    def getAncestors(self, n, edges):
        graph = defaultdict(list)
        in_degree = [0] * n
        ancestors = [set() for _ in range(n)]

        for u, v in edges:
            graph[u].append(v)
            in_degree[v] += 1

        topo_order = []
        queue = deque([node for node in range(n) if in_degree[node] == 0])

        while queue:
            node = queue.popleft()
            topo_order.append(node)
            for neighbor in graph[node]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)
  
        for node in topo_order:
            for neighbor in graph[node]:
                ancestors[neighbor].update(ancestors[node])
                ancestors[neighbor].add(node)

        result = [sorted(list(ancestor_set)) for ancestor_set in ancestors]

        return result

n = 8
edges = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
solution = Solution()
print(solution.getAncestors(n, edges)) 
