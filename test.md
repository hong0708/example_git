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
  ![image](https://user-images.githubusercontent.com/22022393/126152753-e0e50480-04d4-4ee2-bfcb-3d11ec40f4dd.png)


## RecyclerView 연결하고 mockup data 테스트
- 임의로 작성한 목업 데이터를 RecyclerView를 통해 출력
  ![image](https://user-images.githubusercontent.com/22022393/126155272-aae24a89-53d8-48c7-ba2c-ede5cae37ed1.png)

## 클릭리스너 작동하는지 테스트

- 목표는 해당 아이템 클릭 시 페이지가 업로드 되야하나 현재 클릭리스너 작동 확인만 로그로 출력
  ![image](https://user-images.githubusercontent.com/22022393/126155342-377bbde9-9061-4487-a799-b32cc7f74ae6.png)
  ![image](https://user-images.githubusercontent.com/22022393/126155761-0678f06a-a89c-434e-a20a-ee45ef55a708.png)

## 진행 중인 사항
- Api통신 해서 받아온 결과로 데이터 띄우기

## 추가적인 사항
- 해당 아이템을 클릭하면 페이지 업로드가 아닌 RecyclerView 아이템 하단에 해당 타이틀에 맞는 페이지들을 아이템으로 출력

  ## 특징 및 장단점
  - 퀵 정렬을 수행하기 전에는 pivot을 어떻게 설정할 것인지 미리 명시해야 한다.
  - 리스트를 분할하는 방법 중 가장 대표적인 방법은 호어 분할 방식(리스트에서 첫번째 데이터를 pivot으로 설정하는 방법)이다.
  - 퀵 정렬의 평균 시간 복잡도는 O(NlogN)이지만, 최악의 경우 O(N^2)이다.
  - 퀵 정렬은 데이터가 무작위로 입력되는 경우 빠르게 동작할 확률이 높다.(장점)
  - 이미 데이터가 정렬되어 있는 경우에는 매우 느리게 동작한다.(단점)

  ## 예시
  ---
    1. 리스트에서 첫 번째 데이터를 pivot으로 정한다.
    2. 왼쪽에서부터 pivot보다 큰 데이터를 찾는다.
    3. 오른쪽에서부터 pivot보다 작은 데이터를 찾는다.
    4. 2와 3의 데이터를 교환한다.
    5. 2와 3의 인덱스가 엇갈렸을 경우, 작은 데이터와 pivot값을 교환한다.


![Sample](QuickImg/Sample.jpeg)

  ### A파트

- Step1
    1. pivot: 5
    2. left: 7
    3. right: 4
    4. 2번과 3번의  데이터 교환


     #### Step1 결과
        5 4 9 0 3 1 6 2 7 8
- Step2
    1. pivot: 5
    2. left: 9
    3. right: 2
    4. 2번과 3번의  데이터 교환

     #### Step2 결과
        5 4 2 0 3 1 6 9 7 8

    - Step3(분할 완료)
    1. pivot: 5
    2. left: 6
    3. right: 1
    4. 2번과 3번이 엇갈렸으므로 작은데이터(right)와 pivot의 위치를 변경한다.

     #### Step3 결과
        1 4 2 0 3 5 6 9 7 8

        - '5'의 왼쪽에 있는 데이터는 모두 '5'보다 작다.
        - '5'의 오른쪽에 있는 데이터는 모두 '5'보다 크다.
     - pivot의 왼쪽에는 pivot보다 작은 값이, 오른쪽은 큰 값이 오도록 하는 작업을 분할(divide) 혹은 파티션(partition)이라고 한다.

### B파트
- 5를 기준으로 왼쪽에 있는 데이터를 A파트와 동일한 방법으로 정렬한다.
  ![sample2](QuickImg/sample2.jpeg)

### C파트
- 5를 기준으로 오른쪽에 있는 데이터를 A파트와 동일한 방법으로 정렬한다.
  ![sample3](QuickImg/sample3.jpeg)

## 결과
    0 1 2 3 4 5 6 7 8 9

## 코드(JS)
```javascript
let array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8];

quickSort(array, 0, array.length-1);
console.log(array.join(' '))

function quickSort(array, start, end){

    if(start >= end){ // 원소가 1개인 경우 종료
        return;
    }
    let pivot = start;
    let left = start+1;
    let right = end;

    while(left<=right){
        while(left<=end && array[left] <= array[pivot]){
            // pivot 기준 왼쪽은 pivot 보다 큰 수를 선택함.
            left += 1;
            }
        while(right>start && array[right] >= array[pivot]){
                // pivot 기준 오른쪽은 pivot보다 작은 수를 선택함
                right -=1;
        }

        if(left>right){
            // 엇갈렸다면, 작은 값과 pivot 값 교환
            [array[pivot], array[right]] = [array[right], array[pivot]];
        }
        else{
            // 그렇지 않다면, left와 right 값 교환
            [array[left], array[right]] = [array[right], array[left]]
        }

    }
    // 분할 이후 왼쪽 부분과 오른 쪽 부분 각각 정렬 수행
    quickSort(array, start, right-1);
    quickSort(array, right+1, end);

}

```
