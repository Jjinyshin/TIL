### BeautifulSoup

- Requests는 정말 좋은 라이브러리이지만, html을 Python이 이해하는 객체 구조로 만들어주지는 못한다.
  - requests.get('url주소').text는 python의 문자열(str)객체를 반환할 뿐이기 때문에 정보를 추출하기가 어렵다.
- 따라서 BeautifulSoup을 이용함.
  - BeautifulSoup은 html 코드를 Python이 이해하는 객체 구조로 변환하는 Parsing을 맡고 있고, 이 라이브러리를 이용해 우리는 '의미있는' 정보를 추출해 낼 수 있다.
    > 출처: [나만의 웹 크롤러 만들기](https://beomi.github.io/gb-crawling/)
