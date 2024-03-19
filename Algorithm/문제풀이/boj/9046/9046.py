from collections import Counter


def find_most_freq_char(text):
    # 공백 문자 제외
    counts = Counter(c for c in text if c != ' ')

    most_common = counts.most_common(2)

    # 가장 빈번한 문자가 1개일 경우
    if len(most_common) == 1 or most_common[0][1] > most_common[1][1]:
        return most_common[0][0]
    # 가장 빈번한 문자가 여러 개일 경우
    else:
        return '?'


T = int(input())

for _ in range(T):
    text = input()
    print(find_most_freq_char(text))
