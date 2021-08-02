# 기존 목표
---
- DrawerLayout 구성 및 RecyclerView 추가
- RecyclerView 연결하고 mockup data 테스트
- 클릭리스너 작동하는지 테스트
- Api통신 해서 받아온 결과로 데이터 띄우기
- 해당 아이템을 클릭하면 페이지 업로드가 아닌 RecyclerView 아이템 하단에 해당 타이틀에 맞는 페이지들을 아이템으로 출력

## 달성 목표

- Api통신 해서 받아온 결과로 데이터 띄우기
- slidingpanelayout으로 변경

---

## DrawerLayout에서 slidingpanelayout으로 변경
---

- slidingpanelayout의 예시
![image](https://user-images.githubusercontent.com/22022393/127854109-8a8417ad-3f51-4b4d-bc0c-1392a980ad05.png)


- 기존의 DrawerLayout
![image](https://user-images.githubusercontent.com/22022393/126155272-aae24a89-53d8-48c7-ba2c-ede5cae37ed1.png)

- 현재 수정된 상태
![image](https://user-images.githubusercontent.com/22022393/127854276-20a0f6a7-1d07-486b-a4e6-abea825f0994.png)

all 의 경우 받아온 결과가 나온 것을 확인 가능

- 최종 목표 이미지
![image](https://user-images.githubusercontent.com/22022393/127854461-da239bb0-3c2a-469c-86fd-c9fe7b3f3f4f.png)
![image](https://user-images.githubusercontent.com/22022393/127854550-1bb04e47-daac-45c4-9650-2162fcb9ca2e.png)
![image](https://user-images.githubusercontent.com/22022393/127854574-8c8702bc-f955-435f-85e0-5dc43a1dfa52.png)


## 진행 중인 사항
- 아이템 클릭 시 all 안에 있는 리스트 띄우기
- 목록 클릭 시 content 내용 변경
