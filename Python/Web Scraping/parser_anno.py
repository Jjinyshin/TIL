# parser_anno.py
# 출처: [나만의 웹 크롤러 만들기](https://beomi.github.io/gb-crawling/)
import requests
from bs4 import BeautifulSoup

# HTTP GET Request
req = requests.get('https://beomi.github.io/beomi.github.io_old/')

# HTML 소스 가져오기
html = req.text

# BeautifulSoup으로 html소스를 python객체로 변환하기
# 첫 인자는 html소스코드, 두 번째 인자는 어떤 parser를 이용할지 명시.
# 이 글에서는 Python 내장 html.parser를 이용했다.
soup = BeautifulSoup(html, 'html.parser')

# CSS Selector를 통해 html요소들을 찾아낸다.
# my_titles는 list형태로 가져와짐. -> 하나만 가져와도 리스트임을 주의!
my_titles = soup.select(
    'h3 > a'
    )

print(my_titles)

for title in my_titles:
    # print(title)
    # a tag안의 텍스트
    print(title.text)
    # Tag의 속성을 가져오기(ex: href속성)
    print(title.get('href'))

# select를 통해 요소들을 가져온 이후에는 각자가 생각하는 방식으로 python코드를 이용해 저장하면 된다.
