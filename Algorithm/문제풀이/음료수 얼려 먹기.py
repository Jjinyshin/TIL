# 출처: 이것이 취업을 위한 코딩테스트다 with 파이썬

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

# visited = [False] * n * m
visited = [[False] * 5 for _ in range(4)]

# 모든 노드 끝까지 탐색, dfs


def dfs(x, y):
    # 시작노드의 좌표받기
    print(x, y)
    global visited
    global graph
    # 그래프 밖에 접근하려 한다면
    if x <= -1 or x >= n or y <= -1 or y >= n:
        # print("False")
        return False
    if visited[x][y] == True or graph[x][y] == 1:
        # print("False")
        return False
    else:
        visited[x][y] = True
        # 상하좌우 모두 dfs호출 -> 아래 dfs함수들의 리턴값은 별도로 사용하지 않음. 연결된 모든 노드들에 방문처리를 수행하기만을 위한 코드이기 때문.
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        # print("True")
        return True


ice_cream_count = 0
for i in range(n):
    for j in range(m):
        # 0,0부터 모든 노드에서 dfs 수행
        if dfs(i, j) == True:
            ice_cream_count += 1

print(ice_cream_count)
