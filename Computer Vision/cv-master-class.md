> 출처: [Computer Vision (컴퓨터 비전) : 마스터 클래스](https://www.udemy.com/course/best-computer-vision/)를 보고 정리한 내용입니다.

# Face Detection
### Plan
- Haarcascade classifier의 이론을 이해하고 OpenCV library를 이용하여 실행해보기
- HOG, Dlib library 사용하고 결과 비교하기
- CNN과 Dlib 사용해서 얼굴 감지 실행해보기
- webcam 사용해서 얼굴 감지하기
- 사전 제작된 감지기를 사용해서 배우는 파트임


### 내용 시작
- 이미지와 픽셀
- 캐스케이드 분류기
- HOG(Histograms of Oriented Gradients)
  - 변화를 감지하기 위해 미분(Derivative)을 사용한다.
    - 색의 변화가 적을 때, 미분값이 작다.
  - Gradient vector: 값이 증가하는 방향을 알려준다.
    - 이 벡터는 주변의 픽셀값을 고려해서 계산된다.
    - 색의 변화가 있으면 픽셀의 연결점이 생성되고 → 이를 통해 물체의 경계선이 그려짐.
    
    - Gradient Magnitude 행렬은 픽셀의 변화를 나타냄.
        - 색의 변화가 작으면 값이 작음.
    - 히스토그램을 사용해서 이미지에서 정보를 얻는다.
        - 위 두 행렬의 값을 연결해서 히스토그램을 이해해야 함.        
        - 이렇게 최종적으로 생성된 히스토그램을 비교해서 유사한지/아닌지를 찾는게 이 알고리즘의 기본 원리이다.

# 