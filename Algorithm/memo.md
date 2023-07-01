> 코드, 메모 출처: 이것이 코딩테스트다

- 기본 자료구조
  - 스택
    - 파이썬에서 스택 자료구조를 이용할 때에는 별도의 라이브러리를 이용할 필요가 없다.
    - 기본 리스트의 append(), pop()메서드를 사용하면 됨.
  - 큐
    - 파이썬에서 큐를 구현할 때에는 collections 모듈에서 제공하는 deque 자료구조를 활용한다.
      - deque는 스택&큐의 장점을 모두 채택한 것인데, 데이터를 넣고 빼는 속도가 리스트 자료형에 비해 효율적이고, queue 라이브러리를 이용하는 것보다 더 간단하다고 함.
      - 대부분의 코테에서는 collections 모듈같은 기본 라이브러리의 사용은 허용하므로 괜찮다.
- 파이썬 내장 자료구조인 리스트가 아니라 다른 자료구조를 쓰면 더 효율적이게 원소를 탐색할 수 있다.
- 알고리즘이 뭔가? 주어진 문제의 해결을 위해 어떤 자료구조와 어떤 연산방법을 선택할 것인지가 알고리즘을 디자인 하는 것.