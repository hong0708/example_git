# Title
<!--Table of Contents-->
- First
    - 가나다
- Second
    - 라마바
- Third
    - 사아자
    - 차카타

<!-- 어떤 질문을 대답할 수 있어야 하는지-->
## You can answer
- 내 최애 디저트는?
- 부먹 vs 찍먹

<!--Contents-->

---
## First
### 가나다
```Kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.user = userViewModel

        userViewModel.height.observe(this, Observer {
            binding.textViewHeight.text = it.toString()
        })
    }
}
```

ViewModelProvider를 사용할 때 this를 넘겨주는 데 이는 owner를 의미

ViewModelStore를 누가 소유? -> this 즉, MainActivity가 소유

 ViewModelStore은?

ViewModelStore은 ViewModel 객체가 HashMap 구조로 저장되는 곳

즉, get() 안에 있는 'UserViewModel..'은 객체를 찾아오기 위한 Key값으로 쓰이는 것

![image](https://user-images.githubusercontent.com/22022393/128698881-00daa0cb-205a-4570-a1bd-e51c935ba200.png)
.

뷰 모델을 HashMap 구조로 저장하니까 get() 메서드에 Key값을 넣어준 거고.

(만약 Key에 해당하는 Value가 없으면 생성하고 가져온다. 그래서 처음 뷰 모델 객체를 처음 만드는데도 set 따위가 아니라 get을 쓰는 것)

저 ViewModelStore를 소유하고 있는 주체가 MainActivity라는 것을 알려줌

이를 통해 알 수 있는 2가지 사실

뷰 모델을 각각 다른 소유자가 생성하면 이는 별개의 메모리 공간을 사용하는 다른 객체가 됨  
하나의 액티비티를 소유자로 지정해 사용하면 같은 ViewModel을 공유할 수 있다. = 데이터 공유 가능  

AAC ViewModel은 싱글톤 패턴으로 구현되어 있는데, activity가 destroy 되거나, fragment가 detached 될 때까지 유지된다. 즉 하나의 lifecycle에 한해서만 유효한 싱글톤 객체다. 이 특징으로 인해

ViewModel을 서로 다른 Activity에서 선언하면 서로 다른 lifecycle을 따라가게 된다. 동일한 ViewModel 클래스여도 별개의 메모리 공간을 사용하는 객체가 된다.
하나의 액티비티 위에 올라간 프레그먼트들 안에서, 가장 lifecycle이 긴 Activity가 owner가 되도록 ViewModel을 선언하면 하나의 ViewModel을 공유하게 된다.


뷰 모델은 액티비티나 프래그먼트보다 긴 생명주기를 가지고 있다.  

만약 뷰 모델이 액티비티에 대한 참조를 가지고 있다고 했을 때 화면을 가로로 했다가 세로로 했다가 이 행동을 많이 반복한다면,

액티비티는 종료와 생성을 반복하겠지만 뷰 모델은 쭉 살아있기 때문에 이미 종료되어 사라진 액티비티의 참조를 그만큼 가지고 있을 것이다.  

쓸데없는 것이 메모리를 차지하고 있는 현상, 즉 Memory Leak이 발생하기 때문에 참조를 하면 안 된다는 것이다.  

단, applicationContext는 액티비티의 생명주기가 아닌 애플리케이션의 생명주기를 가지기 때문에 참조를 해도 괜찮다. 이 경우는 뷰 모델을 만들 때 ViewModel을 상속받는 것이 아니라 AndroidViewModel을 상속받으면 된다.



공유 방법  
공유할 ViewModel 정의  

```Kotlin
class MyViewModel : ViewModel() {
    // ...
}
```

Activity에서 선언하기

방법 1. Activity에선 owner로 자기 자신을 넘겨주면 된다.

```Kotlin
private lateinit var myViewModel: MyViewModel
// ...
// context를 사용 가능한 시점에서 초기화
myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
```

방법 2. androidx.activity 패키지에 정의된 함수를 사용할 수도 있다.

viewModel 초기화는 context를 사용 가능한 시점부터 가능하다. 때문에 viewModel을 프로퍼티로 선언할 땐 보통 지연 초기화를 하게 된다. viewModels()를 사용하면 lazy나 lateinit없이 간편하게 초기화를 할 수 있다.

```Kotlin
val myViewModel: MyViewModel by viewModels()
```

Fragment에서 선언하기

방법 1. activity 객체를 FragmentActivity나 ViewModelStoreOwner로 형변환 해서 넘겨주면 된다.

```Kotlin
// 동일한 표현
myViewModel = ViewModelProvider(activity as FragmentActivity)[MyViewModel::class.java]
myViewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MyViewModel::class.java]
```

방법 2. Fragment에 자체적으로 정의되어 있는 requireActivity()라는 메서드를 사용해도 된다.

```Kotlin
myViewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]
```


---
## Reference
- [Example Site1](www.google.com)
- [Example Site2](www.google.com)
