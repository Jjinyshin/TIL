# parser.py
import requests
from bs4 import BeautifulSoup as bs

# 로그인할 유저정보를 넣어주자 (모두 문자열)
LOGIN_INFO = {
    'userId': '사용자이름',
    'userPassword': '사용자패스워드'
}

# Session 생성, with 구문 안에서 유지
with requests.Session() as s:
    first_page = s.get('https://www.clien.net/service')
    html = first_page.text
    soup = bs(html, 'html.parser')
    csrf = soup.find('input', {'name':'_csrf'})
    print(csrf['value'])

    # (p.s.)Python3에서 두 dict를 합치는 방법은 {**dict1, **dict2} 으로 dict들을 unpacking하는 것입니다.
    LOGIN_INFO = {**LOGIN_INFO, **{'_csrf':csrf['value']}}
    print(LOGIN_INFO)

    # HTTP POST request: 로그인을 위해 POST url와 함께 전송될 data를 넣어주자.
    login_req = s.post('https://www.clien.net/service/login', data=LOGIN_INFO)
    # 어떤 결과가 나올까요?
    print(login_req.status_code)

    if login_req.status_code != 200:
        raise Exception('로그인이 되지 않았어요! 아이디와 비밀번호를 다시한번 확인해 주세요.')

    # -- 여기서부터는 로그인이 된 세션이 유지됩니다 --

    post_one = s.get('https://www.clien.net/service/board/rule/10707408')
    soup = bs(post_one.text, 'html.parser')
    title = soup.select('#div_content > div.post-title > div.title-subject > div')
    contents = soup.select('#div_content > div.post.box > div.post-content > div.post-article.fr-view')
    print(title)
    print(contents)