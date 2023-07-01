from collections import deque

def bfs(graph, start, visited):
  queue = deque([start]) # deque 객체 파라미터로 iterable객체 넣어주기!
  # 현재 노드 방문 처리
  visited[start] = True
  # 큐가 empty가 될 때까지 반복
  while queue:
    v = queue.popleft()
    print(v, end=' ')
    for i in graph[v]:
      if not visited[i]:
        queue.append(i)
        visited[i] = True

def dfs(graph, v, visited):
  # 현재 노드 방문 처리
  visited[v] = True
  print(v, end=' ')
  # 현재 노드와 연결된 다른 노드를s 재귀적으로 방문
  for i in graph[v]:
    if not visited[i]:
      dfs(graph, i, visited)

# 인접 리스트 방식으로 각 노드가 연결된 정보 표현
graph = [
  [],
  [2,3,8],
  [1,7],
  [1,4,5],
  [3,5],
  [3,4],
  [7],
  [2,6,8],
  [1,7]
]

visited = [False] * 9

# 함수 호출
# dfs(graph, 1, visited
# bfs(graph, 1, visited)

# 일반적인 경우 dfs는 재귀함수로 구현되었므로 deque라이브러리를 사용해서 구현하는 bfs보다 수행 시간이 느리다.