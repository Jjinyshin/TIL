# boj 1012 유기농 배추 - dfs code

# 재귀함수 떄문에 런타임에러 -> sys.setrecursionlimit(10000) 재귀호출 제한 늘려주기
# 웬만하면 bfs로 풀기
# 음료수 얼려먹기와 동일한 유형
import sys
sys.setrecursionlimit(10000)


t = int(input())
result = []


def dfs(x, y):
    global visited
    # print(x, y)
    if x < 0 or y < 0 or x >= n or y >= m:
        return False
    elif visited[x][y] == 0 and graph[x][y] == 1:
        # 방문하지 않았다면
        visited[x][y] = 1
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y+1)
        dfs(x, y-1)
        return True
    return False


for _ in range(t):
    m, n, k = map(int, input().split())

    graph = [[0 for _ in range(m)] for _ in range(n)]
    visited = [[0 for _ in range(m)] for _ in range(n)]

    for i in range(k):
        y, x = map(int, input().split())
        graph[x][y] = 1

    count = 0
    # 모든 원소마다 dfs 호출
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                count += 1
    result.append(count)
print(*result, sep='\n')
