# Call by value and Call by reference
<!--Table of Contents-->
- Call by value(값에 의한 호출)
- Call by reference(참조에 의한 호출)

<!-- 어떤 질문을 대답할 수 있어야 하는지-->
## You can answer
- Call by value(값에 의한 호출)란?
- Call by reference(참조에 의한 호출)란?
<!--Contents-->

---

### Call by value(값에 의한 호출)

함수가 호출될 때 메모리 공간 안에서는 임시의 공간이 생성된다. 그리고 함수가 종료되면 해당공간은 사라진다.
함수 호출시 전달되는 변수의 값을 복사하여 함수의 인자로 전달한다.  
복사된 인자는 함수 안에서 지역적으로 사용하는 변수이다.  
JAVA의 경우 함수에 전달되는 인자의 데이터 타입에 따라서 (기본자료형 / 참조자료형 ) 함수 호출 방식이 달라짐  
기본 자료형 : call by value 로 동작 (int, short, long, float, double, char, boolean)  

![image](https://user-images.githubusercontent.com/22022393/141125505-fc74b781-1324-47f2-821f-9055e363027d.png)  

swap()에서 값만 받아와서 내부적으로 처리를 하고 아무 것도 넘기지를 않는다. 변수를 주소로 가져오거나 포인터로 통해서 가져온 것이 아니기 때문에, 새로운 변수를 만들어서 값을 대입해서 처리한 것이다. 이 경우 교체는 되지 않고 swap() 내부에서만 처리가 된다. 반환형이 없기에 사실상 위에서는 의미 없는 행동을 했다.  
만일 swap()이 아닌 다른 함수로 리턴 값을 넣었다면, 안정적으로 처리를 해서 결과를 도출해준다. 하지만 swap()의 경우 이런 방법으로 사용하면 잘못된 방법이다.  

### Call by value(값에 의한 호출) 장단점
장점 : 복사하여 처리하기 때문에 안전하다. 원래의 값이 보존이 된다.  
단점 : 복사를 하기 때문에 메모리가 사용량이 늘어난다.  

### Call by reference(참조에 의한 호출)

함수가 호출될 때, 메모리 공간 안에서는 함수를 위한 별도의 임시 공간이 생성된다. (함수 종료시 사라짐)  
call by reference 참조에 의한 호출방식은 함수 호출시 인자로 전달되는 변수의 레퍼런스를 전달한다. (해당 변수를 가르킨다.)   
함수 안에서 인자의 값이 변경되면, 함수 호출시에 있던 변수들도 값이 바뀐다.   
JAVA의 경우 함수에 전달되는 인자의 데이터 타입에 따라서 (기본자료형 / 참조자료형 ) 함수 호출 방식이 달라짐  
참조 자료형 : call by reference 로 동작 (Array, Class Instance)   

![image](https://user-images.githubusercontent.com/22022393/141125701-d9c8150c-1fc0-4f23-866a-929eb59d0a21.png)  

swap()에서 main()의 a, b 주소를 가져와서 처리를 했다. 직접 주소 가져와서 처리를 했기 때문에 swap()의 내부 처리로도 a, b가 교체가 되었다. 이렇게 보듯 단점으로는 주소나 포인터를 사용하면 직접 변수에 접근하기 때문에 리스크가 있다.  

### Call by reference(참조에 의한 호출) 장단점

장점 : 복사하지 않고 직접 참조를 하기에 빠르다.  
단점 : 직접 참조를 하기에 원래 값이 영향을 받는다.(리스크)  

---
### Call by value(값에 의한 호출) and Call by reference(참조에 의한 호출) 정리

- Call By Value  
인자로 받은 값을 복사하여 처리하는 방식  
Call By Value에 의해 넘어온 값을 증가시켜도 원래의 값이 보존된다.  
값을 복사하여 넘기기 때문에 메모리 사용량이 늘어난다.  

- Call By Reference  
인자로 받은 값의 주소를 참조하여 직접 값에 영향을 주는 방식  
값을 복사하지 않고 직접 참조하기 때문에 속도가 빠르다.  
원래의 값에 영향을 주는 리스크가 존재한다.  

---
## Reference
