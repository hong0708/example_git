# 기존 목표
---
- DrawerLayout 구성 및 RecyclerView 추가
- RecyclerView 연결하고 mockup data 테스트
- 클릭리스너 작동하는지 테스트
- Api통신 해서 받아온 결과로 데이터 띄우기
- 아이템 클릭 시 해당 title에 맞는 페이지 띄우기

## 달성 목표
---
- DrawerLayout 구성 및 RecyclerView 추가
- RecyclerView 연결하고 mockup data 테스트
- 클릭리스너 작동하는지 테스트

## DrawerLayout 구성 및 RecyclerView 추가
---
기존의 Fragment 의 Lifecycle

![image](https://user-images.githubusercontent.com/22022393/129555771-23284c46-37c5-4a37-a757-11bf676e5971.png)

화면 회전 시 Fragment 의 Lifecycle

![image](https://user-images.githubusercontent.com/22022393/129555710-889bfdd7-5321-4697-b1b3-700c418311e9.png)


Fragment는 Actvitiy와 다르게 onDestroy 가 호출되지 않은 상태에서 onCreateView 가 여러 번 호출될 수 있습니다. 이로 인해 Fragment의 Lifecycle은 Destroy 되지 않은 상황에서 LiveData에 새로운 Observer가 등록되어 복수의 Observer가 호출되는 현상이 발생할 가능성이 있습니다.  

Fragment Lifecycle은 본 글의 처음에 언급한 Fragment의 생명 주기에 해당하는 내용입니다. 그리고, Fragment View Lifecycle은 문제의 Lifecycle 사용 패턴을 개선하기 위해서 도입된 Lifecycle입니다.  

Fragment는 Fragment View보다 긴 생명주기를 가지며, 일반적으로 UI를 업데이트용으로는 Fragment View Lifecycle 이 적절합니다. 그리고, Fragment View Lifecycle 도입으로 LiveData#observe에서 사용하는 Observer 중복 호출 문제도 해결할 수 있습니다. Fragment 사용 시 데이터 갱신에 대한 Lifecycle을 Fragment Lifecycle보다 Fragment View Lifecycle이 올바르다고 언급하고 있습니다.  

Fragment Lifecycle : Create ~ Destroy  
Fragment View Lifecycle : createView ~ destoryView  

기존 LiveData 사용에서 바뀌는 부분은 liveData를 observe 함수의 첫 번째 파라미터를 this에서 viewLifecycleOwner를 호출하도록 수정하면 됩니다.
