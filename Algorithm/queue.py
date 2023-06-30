from collections import deque

# deque 라이브러리 사용해서 큐 자료구조 구현
queue = deque()

# 사용 예시
queue.append(input("원소 추가: "))
queue.append(input("원소 추가: "))
queue.popleft()
queue.append(input("원소 추가: "))
queue.append(input("원소 추가: "))
queue.append(input("원소 추가: "))
queue.popleft()


print(queue)
queue.reverse()
print(queue)