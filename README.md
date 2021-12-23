# Android-Hyeongki

![github_김형기_ver1-15](https://user-images.githubusercontent.com/70698151/135754182-8d3a8fc9-c7ad-46ee-b981-c8d7cb8c84e8.png)

## 목차

[:one: Week 1](#one-week-1)

[:two: Week 2](#two-week-2)

[:three: Week 3](#three-week-3)

[:four: Week 4](#four-week-4)

[:seven: Week 7](#seven-week-7)



## :one: Week 1



### 🟢 LEVEL 1

#### ◻SignInActivity

<img src="https://user-images.githubusercontent.com/37872134/136694713-a5870bc8-8285-4559-9250-2535db47dd5c.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694717-5b9ddcb7-f35b-481f-ac0e-21114f16204e.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694719-4d5f6ad8-c4c1-4195-b645-6a3b8c4a53d3.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694728-94831de3-aff2-460b-a259-18bf005a4389.png" width="270" height="570" />



- ###### 아이디 입력

  ```xml
      <EditText
          android:id="@+id/et_id"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="아이디를 입력해주세요"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_id"
          app:layout_constraintTop_toBottomOf="@+id/tv_id" />
  ```

  - 새로운 입력을 받을 수 있도록 text 속성은 비워놓고, hint 속성을 이용해 입력 장소를 설명해준다.
  - start(left)->tv_id, end(right)->parent, top->tv_id 로 제약을 설정하였다.
  - inputType을 기본값인 textPersonName으로 설정하여 입력된 값을 볼 수 있다.

  

- ###### 비밀번호 입력

  ```xml
  	<EditText
          android:id="@+id/et_pw"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="비밀번호를 입력해주세요"
          android:inputType="textPassword"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_pw"
          app:layout_constraintTop_toBottomOf="@+id/tv_pw" />
  ```

  - inputType을 textPassword로 설정하여 입력 값이 보이지 않도록 설정한다.

    

- ###### 로그인 버튼

  ```kotlin
          binding.btnSignin.setOnClickListener{
              val idInput = binding.etId.text
              val pwInput = binding.etPw.text
  
              if(idInput.isNotBlank() && pwInput.isNotBlank()){
                  Toast.makeText(this, "김형기님 환영합니다", Toast.LENGTH_SHORT).show()
                  val intent = Intent(this, HomeActivity::class.java)
                  startActivity(intent)
              }
              else
                  Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
          }
  ```

  - 뷰 바인딩을 통해 view에 입력된 값을 가져온다.
  - isNotBlank()를 통해 입력 값이 모두 비어있지 않으면 환영 메시지를 담은 Toast와 함께 HomeActivity로 이동한다.
    - isEmpty() : 공백문자도 비어있지 않다고 본다
    - isBlank() : 공백문자를 비어있다고 본다
    - 따라서, isNotBlank()를 사용하였기 때문에 공백문자로 이루어진 입력은 올바르지 않은 입력으로 판단한다
  - 만약 비어있는 입력값이 있다면 "로그인 실패" 메시지를 띄우고 메소드는 종료된다.
  - 로그인 성공 시 HomeActivity를 호출하는 Intent를 사용해 startActivity를 실행한다. 이 때 호출할 대상 컴포넌트가 분명히 명시되어 있기 때문에 이는 **명시적 인텐트**이다. 



- ###### 회원가입 버튼

  ```kotlin
          binding.btnSignup.setOnClickListener{
              val intent = Intent(this, SignUpActivity::class.java)
              startActivity(intent)
          }
  ```

  - SignUpActivity를 호출하는 Intent를 생성하여, 회원가입 액티비티로 이동한다.

    

#### ◻SignUpActivity

<img src="https://user-images.githubusercontent.com/37872134/136694762-3d60017a-10eb-4b4d-baef-1325ea5f0b32.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694763-38ffd3e5-06f2-47bd-a5fb-cce0126694f8.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694765-8b68f2fd-f64f-440f-a4d1-0bd000ca7d0b.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694768-75fc4269-5bcf-4820-a6d6-37dd1d7bd058.png" width="270" height="570" />



- ###### 이름 입력

  ```xml
  	<EditText
          android:id="@+id/et_name"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="이름을 입력해주세요"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_name"
          app:layout_constraintTop_toBottomOf="@+id/tv_name" />
  ```

  - inputType을 textPersonName으로 설정하여 입력값을 볼 수 있다.

    

- ###### 아이디 입력

  ```xml
      <EditText
          android:id="@+id/et_id"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="아이디를 입력해주세요"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_id"
          app:layout_constraintTop_toBottomOf="@+id/tv_id" />
  ```

  - 이름 입력과 동일하며, hint 속성을 통해 사용자에게 편의성을 제공한다.

    

- ###### 비밀번호 입력

  ```xml
      <EditText
          android:id="@+id/et_pw"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="비밀번호를 입력해주세요"
          android:inputType="textPassword"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_pw"
          app:layout_constraintTop_toBottomOf="@+id/tv_pw" />
  ```

  - inputType을 textPassword로 설정하여 입력값이 보이지 않도록 설정하였다.

    

- ###### 회원가입 완료 버튼

  ```kotlin
          binding.btnSignupSubmit.setOnClickListener{
              val nameInput = binding.etName.text
              val idInput = binding.etId.text
              val pwInput = binding.etPw.text
  
              if(nameInput.isNotBlank() && idInput.isNotBlank() && pwInput.isNotBlank()) {
                  Toast.makeText(this, "회원가입의 완료되었습니다", Toast.LENGTH_SHORT).show()
                  finish()
              }
              else
                  Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
          }
  ```

  - isNotBlank()를 통해 View의 입력값이 비어있지 않을 때 회원가입을 완료할 수 있도록 하였다.

  - 회원가입이 완료되면 메시지와 함께 SignUpActivity가 finish() 된다.

  - 이에 따라 **백스택**에 쌓여있는 SignInActivity로 돌아가게 된다.

    - 만약 Intent를 사용하여 다시 SignInActivity를 호출한다면 비정상적으로 백스택에 쌓이게 된다.



#### ◻HomeActivity

<img src="https://user-images.githubusercontent.com/37872134/136694803-1d36865f-3c39-47cf-a06a-1bfe0dca1904.png" width="270" height="570" />



- ###### 프로필 사진

  ```xml
      <ImageView
          android:id="@+id/iv_profile"
          android:layout_width="150dp"
          android:layout_height="0dp"
          android:layout_marginTop="20dp"
          app:layout_constraintDimensionRatio="1"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_title2"
          app:srcCompat="@drawable/profile_image" />
  ```

  - drawable에 이미지를 추가하여 표시하였다.

    - app:srcCompat

      롤리팝 이상의 버전에서 사용할 수 있으며, 벡터 드로어블을 지원

    - android:src

      이전 버전에서도 사용할 수 있음

    - **constraintDimensionRatio**를 이용하여 가로세로 비율을 같게 설정하였다. 따라서 가로 길이만 설정하면 그에 맞게 세로길이가 변화하여 정사각형이 된다.	




### 🟢 LEVEL 2

#### ◻GitHub 주소 이동

<img src="https://user-images.githubusercontent.com/37872134/136694803-1d36865f-3c39-47cf-a06a-1bfe0dca1904.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136701076-6037f257-20bd-4a50-89ff-750b6181433e.png" width="270" height="570" />



- ###### 깃허브 버튼

  ```kotlin
          binding.btnGithub.setOnClickListener{
              val intent = Intent(Intent.ACTION_VIEW)
              intent.data = Uri.parse(getString(R.string.github_address))
              startActivity(intent)
          }
  ```

  - 암시적 인텐트를 이용하여 URL을 실행하도록 하였다.



- ###### 명시적 인텐트 (Explicit Intent)

  - 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우
  - 특정 컴포넌트가 액티비티가 명확하게 실행된다

- ###### 암시적 인텐트 (Implicit Intent)

  - 인텐트의 호출할 대상이 달라질 수 있는 경우에 사용

  - 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아서 처리 결과를 보여주게 된다




#### ◻ScrollView

<img src="https://user-images.githubusercontent.com/37872134/136701100-6c0e406c-f30b-404d-ab91-f50165d94e19.png" width="270" height="570" />



- ###### 스크롤뷰를 이용한 자기소개

  ```xml
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="0dp"
          android:layout_marginTop="16dp"
          android:layout_marginBottom="16dp"
          app:layout_constraintBottom_toTopOf="@+id/btn_github"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_home_mbti">
  
          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="0dp"
              android:paddingHorizontal="50dp">
  
              <TextView
                  android:id="@+id/tv_home_introduction"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:gravity="center"
                  android:text="@string/introduction"
                  android:textColor="#000000"
                  android:textSize="16dp"
                  app:layout_constraintBottom_toBottomOf="parent"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toTopOf="parent" />
          </androidx.constraintlayout.widget.ConstraintLayout>
      </ScrollView>
  ```

  - 스크롤뷰 내부에 ConstraintLayout을 배치하고 그 안에 텍스트 뷰를 배치하여 수직으로 스크롤할 수 있도록 하였다.





## :two: Week 2



### 🟢 LEVEL 1

<img src="https://user-images.githubusercontent.com/37872134/138349204-03c0394c-1059-4ce2-8afe-e3a9c690cba3.gif"  width="270" height="570"/>



#### ◻PairData

```kotlin
class PairData (
    val name: String,
    val introduction: String
)
```

- 두 개의 String 값을 가지는 데이터 클래스이다.
- 팔로워 목록과 레포지토리 목록 모두 이름-설명의 형태이기 때문에 같은 데이터 클래스를 사용하도록 하였다.



#### ◻FollowerFragment

- 팔로워 목록을 보여주는 프래그먼트로, HomeActivity 화면의 일부를 구성한다.
- 리사이클뷰를 이용해 여러 팔로워의 리스트를 보여준다.



##### item_list_follower.xml 레이아웃

- ###### 리사이클 될 대상인 팔로워 한 명을 표시하는 뷰

  ```xml
      <TextView
          android:id="@+id/tv_repository_name"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:ems="6"
          android:textColor="#000000"
          android:textAlignment="center"
          android:textSize="14sp"
          android:textStyle="bold"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          tools:text="레포지토리 이름" />
  
      <TextView
          android:id="@+id/tv_repository_introduction"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="10dp"
          android:ellipsize="end"
          android:ems="8"
          android:maxLines="1"
          android:textAlignment="center"
          android:textColor="#000000"
          android:textSize="12sp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_repository_name"
          tools:text="일이삼사오육칠팔구십영일이삼사" />
  ```

  - 뷰의 background는 drawable에 정의한 둥근 모서리 직사각형 스타일을 사용하였다.



##### fragment_follower.xml 레이아웃

- ###### 팔로워 리스트를 담을 리사이클뷰

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager로 설정하여 팔로워 리스트를 수직으로 보이도록 하였다.
  - 각 팔로워 정보를 listitem을 설정하여 item_list_follower의 레이아웃으로 보이도록 하였다.



##### FollowerFragment.kt 코드

- ###### 프래그먼트 뷰바인딩 변수

  ```kotlin
      private var _binding: FragmentFollowerBinding? = null
      private val binding get() = _binding!!
  ```

  - _binding을 nullable 변수로 선언하고, null로 초기화하였다.
  - binding을 Not null로 단언하였다.

- ###### onCreateView(LayoutInflater, ViewGroup?, Bundle?)

  ```kotlin
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
  
          initAdapter()
  
          return binding.root
      }
  ```

  - layoutInflater를 이용해 프래그먼트의 view 객체를 만들고, 뷰 바인딩을 한다.
  - 뷰 어댑터 객체를 생성하고, 바인딩을 통해 어댑터를 적용하는 메소드인 initAdapter()를 호출한다. (아래 기술되어 있다.)

- ###### initAdapter()

  ```kotlin
      private fun initAdapter(){
          followerViewAdapter = FollowerViewAdapter()
  
          binding.rvFollower.adapter = followerViewAdapter
  
          followerViewAdapter.datalist.addAll(
              listOf(
                  PairData("김형기", "YB 29기 김형기"),
                  PairData("고틀린", "코틀린의 달인"),
                  PairData("김자바", "자바는 내 인생"),
                  PairData("이안드", "안드로이드 최고"),
                  PairData("박알고", "알고리즘 마스터")
              )
          )
          followerViewAdapter.notifyDataSetChanged()
      }
  ```

  - 뷰어댑터를 상속한 FollowerViewAdapter 객체를 생성한다.
  - 바인딩을 통해 리사이클뷰에 어댑터를 연결한다.
  - 뷰어댑터에 데이터를 추가시킨 후 데이터가 변경되었음을 알린다.

- ###### onDestroyView()

  ```kotlin
      override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
      }
  ```

  - 바인딩을 해제시켜서 메모리 누수를 방지한다.



##### FollowerViewAdapter.kt 코드

​	Adapter\<ViewHolder\>를 상속하여 리사이클뷰에 데이터를 연결하여 리스트를 만들 수 있도록 한다.

- ###### onCreateViewHolder(ViewGroup, Int)

  ```kotlin
      override fun onCreateViewHolder(
          parent: ViewGroup,
          viewType: Int
      ): RepositoryViewAdapter.RepositoryViewHolder {
          var binding = ItemListRepositoryBinding.inflate(
              LayoutInflater.from(parent.context), parent, false)
          return RepositoryViewHolder(binding)
      }
  ```

- ###### onBindViewHolder(ViewHolder, Int)

  ```kotlin
      override fun onBindViewHolder(
          holder: RepositoryViewAdapter.RepositoryViewHolder,
          position: Int
      ) {
          holder.onBind(dataList[position])
      }
  ```

- ###### getItemCount()

  ```kotlin
  	override fun getItemCount(): Int = dataList.size
  ```

- ###### nested class : RepositoryViewHolder

  ```kotlin
      class RepositoryViewHolder(private val binding: ItemListRepositoryBinding): RecyclerView.ViewHolder(binding.root){
          fun onBind(data: PairData){
              binding.tvRepositoryName.text = data.name
              binding.tvRepositoryIntroduction.text = data.introduction
          }
      }
  ```

  - 생성자에서 바인딩 객체를 받아서 부모 클래스인 뷰 홀더를 만들어낸다. onBind 메소드가 호출되면 전달된 데이터를 바인딩에 결합시킨다.



##### fragment_follower.xml 레이아웃

- ###### 팔로워 리스트를 담을 리사이클뷰

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager로 설정하여 팔로워 리스트를 수직으로 보이도록 하였다.
  - 각 팔로워 정보를 listitem을 설정하여 item_list_follower의 레이아웃으로 보이도록 하였다.





##### fragment_follower.xml 레이아웃

- ###### 팔로워 리스트를 담을 리사이클뷰

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_follower"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:padding="10dp"
          app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
          tools:itemCount="3"
          tools:listitem="@layout/item_list_follower"/>
  ```

  - LinearLayoutManager로 설정하여 팔로워 리스트를 수직으로 보이도록 하였다.
  - 각 팔로워 정보를 listitem을 설정하여 item_list_follower의 레이아웃으로 보이도록 하였다.



#### ◻RepositoryFragment

- 레포지토리 목록을 보여주는 프래그먼트로, 리사이클뷰로 구성되어 있다.

- 팔로워 프래그먼트와 구성이 유사하며, Grid 레이아웃이라는 차이점이 있다.

  

##### fragment_repository.xml 레이아웃

- ###### 레포지토리를 담는 리사이클 뷰

  ```xml
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/rv_repository"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:paddingVertical="10dp"
          app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
          app:spanCount="2"
          android:orientation="vertical"
          tools:listitem="@layout/item_list_repository"
          tools:itemCount="6"/>
  ```

  - 팔로워 목록과는 다르게 GridLayout으로 설정되어 있다.
  - spanCount를 2로 설정하여 한 줄에 2개의 리스트를 표시한다.



##### item_list_repository.xml 레이아웃

- ###### 레포지토리 설명 텍스트의 길이가 일정 이상 넘어가면 생략 표시(...)을 하도록 ellipsize 옵션을 설정하였다.

  ```xml
      <TextView
          android:id="@+id/tv_repository_introduction"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="10dp"
          android:ellipsize="end"
          android:ems="8"
          android:maxLines="1"
                ...
  ```

  



#### ◻HomeActivity

- 로그인 대상의 사진, 간단한 정보와 함께 팔로워, 레포지토리 목록을 보여주는 액티비티이다.

##### activity_home.xml 레이아웃

- ###### Fragment를 담을 컨테이너 뷰

  ```xml
      <androidx.fragment.app.FragmentContainerView
          android:id="@+id/home_fragment_container"
          android:layout_width="match_parent"
          android:layout_height="0dp"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/btn_follower"
          android:layout_marginTop="10dp" />
  ```

  - 팔로워 프래그먼트와 레포지토리 프래그먼트 뷰가 보여질 컨테이너이다.

  

- ###### 프래그먼트 교체 버튼

  ```xml
      <Button
          android:id="@+id/btn_follower"
          android:layout_width="135dp"
          android:layout_height="55dp"
          android:layout_marginLeft="45dp"
          android:layout_marginTop="10dp"
          android:background="@drawable/button_radius"
          android:paddingVertical="10dp"
          android:text="팔로워\n목록"
          android:textColor="#FFFFFF"
          android:textStyle="bold"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_introduce" />
  
      <Button
          android:id="@+id/btn_repository"
          android:layout_width="135dp"
          android:layout_height="55dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="45dp"
          android:background="@drawable/button_radius_orange"
          android:text="레포지토리\n목록"
          android:textColor="#FFFFFF"
          android:textStyle="bold"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_introduce" />
  ```

  - 각각 팔로워 프래그먼트와 레포지토리 프래그먼트로 교체시킬 버튼이다.
  - background 스타일은 둥근 모서리를 가진 사각형으로, drawable에 정의하였다.



##### HomeActivity.kt 코드

- ###### 프래그먼트 트랜잭션 초기화

  ```kotlin
      private fun initFragmentTransactionEvent(){
          val fragment1 = FollowerFragment()
          val fragment2 = RepositoryFragment()
  
          supportFragmentManager.beginTransaction().add(R.id.home_fragment_container, fragment1).commit()
  
          binding.btnFollower.setOnClickListener {
              supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment1).commit()
          }
          binding.btnRepository.setOnClickListener{
              supportFragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment2).commit()
          }
      }
  ```

  - supportFragmentManager의 beginTransaction() 메소드를 통해 트랜잭션을 시작한다.
  - fragment1를 트랜잭션에 추가하고 commit하여 FollowerFragment를 레이아웃에서 정의한 프래그먼트 컨테이너 뷰에 넣는다.
  - 각 버튼에 onClickListener를 설정하여 클릭하면 버튼에 해당하는 프래그먼트로 교체하는 트랜잭션을 생성하고, 커밋하게 만든다.





### 🟢 LEVEL 2

#### ◻DetailActivity에서 상세 설명

- ###### 아이템에 리스너 추가

  ```kotlin
  			binding.itemFollower.setOnClickListener { v:View ->
                  val intent = Intent(v.context, DetailActivity::class.java)
                  intent.putExtra("name", data.name)
                  v.context.startActivity(intent)
              }
  ```

  FollowerViewHolder 클래스에서 각 아이템들에 onClickListener를 추가한다.

  intent를 생성하고, 아이템이 가진 이름을 DetailActivity로 전달한다.



- ###### DetailActivity.kt에서 인텐트를 받아 처리하기

  ```kotlin
      private fun initMatchName(){
          name = intent.getStringExtra("name").toString()
  
          binding.tvDetailName.text = name
  
          when(name){
              "김형기"-> setDetail(R.drawable.profile_image, R.string.detail_khk)
              "고틀린"-> setDetail(R.drawable.img_kotlin, R.string.detail_kot)
              "김자바"-> setDetail(R.drawable.img_java, R.string.detail_jav)
              "이안드"-> setDetail(R.drawable.img_android, R.string.detail_and)
              "박알고"-> setDetail(R.drawable.img_algorithm, R.string.detail_alg)
          }
      }
      
      private fun setDetail(img_src: Int, detail_text: Int){
          binding.ivProfile.setImageResource(img_src)
          binding.tvDetailContent.text = getString(detail_text)
      }
  ```

  뷰홀더 클래스가 인텐트로 전달한 이름을 받아서 상세 설명에 필요한 정보로 변환한다.

  설명 텍스트는 string에 저장되어 있다.



#### ◻ItemDecoration으로 구분선 만들기

- ###### CustomDecoration 클래스 만들기

  ```kotlin
  class CustomDecoration(
      private val height: Float,
      private val padding: Float,
      @ColorInt
      private val color: Int
  ):RecyclerView.ItemDecoration() {
      private val paint = Paint()
  
      init{
          paint.color = color
      }
  
      override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
          val left = parent.paddingStart + padding
          val right = parent.width - parent.paddingEnd - padding
  
          for(i in 0 until parent.childCount){
              val child = parent.getChildAt(i)
              val params = child.layoutParams as RecyclerView.LayoutParams
  
              val top = (child.bottom + params.bottomMargin).toFloat()
              val bottom = top+height
  
              c.drawRect(left, top, right, bottom, paint)
          }
      }
  }
  ```

  

- ###### 바인딩을 통해 리사이클뷰에 적용시키기

  ```kotlin
          val decoration = CustomDecoration(1.0f, 0.5f, rgb(246,88,166))
          binding.rvFollower.addItemDecoration(decoration)
  ```

  

  #### ◻아이템 이동/삭제

- ###### ItemTouchHelperListener 인터페이스

  ```kotlin
  interface ItemTouchHelperListener {
      fun onItemMove(from_position: Int, to_position: Int):Boolean
      fun onItemSwipe(position: Int)
  }
  ```

- ###### ItemTouchHelperCallback 클래스

  ```kotlin
  class ItemTouchHelperCallback(val listener: ItemTouchHelperListener): ItemTouchHelper.Callback() {
      override fun getMovementFlags(
          recyclerView: RecyclerView,
          viewHolder: RecyclerView.ViewHolder
      ): Int {
          val drag_flags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
          val swipe_falgs = ItemTouchHelper.START or ItemTouchHelper.END
          return makeMovementFlags(drag_flags, swipe_falgs)
      }
  
      override fun isLongPressDragEnabled(): Boolean {
          return true
      }
  
      override fun onMove(
          recyclerView: RecyclerView,
          viewHolder: RecyclerView.ViewHolder,
          target: RecyclerView.ViewHolder
      ): Boolean {
          return listener.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
      }
  
      override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
          listener.onItemSwipe(viewHolder.adapterPosition)
      }
  }
  ```

  - ItemTouchHelper.Callback을 상속받아 구현한다.
  - isLongPressEnabled를 항상 true를 반환하도록 구현하여 드래그를 할 수 있도록 한다.
  - onMove나 onSwiped의 경우 프로퍼티의 앞의 인터페이스를 구현한 리스너가 처리한다.

- ###### FollowerViewAdapter에서 ItemTouchHelperListener 인터페이스 구현하기

  ```kotlin
  class FollowerViewAdapter: RecyclerView.Adapter<FollowerViewAdapter.FollowerViewHolder>(), ItemTouchHelperListener {
  ...
      override fun onItemMove(from_position: Int, to_position: Int): Boolean {
          val item = datalist[from_position]
          datalist.removeAt(from_position)
          datalist.add(to_position, item)
  
          notifyDataSetChanged()
          return true
      }
  
      override fun onItemSwipe(position: Int) {
          datalist.removeAt(position)
          notifyItemRemoved(position)
      }
  }
  ```

  ItemTouchHelperListener가 구현해야하는 메소드인 onItemMove와 onItemSwipe를 구현한다.

  move의 경우 데이터를 삭제하고 이동할 위치에 새로 추가한다.

- ###### RecyclerView에 Helper 붙이기

  ```kotlin
  ItemTouchHelper(ItemTouchHelperCallback(followerViewAdapter)).attachToRecyclerView(binding.rvFollower)
  ```

  - FollowerFragment에서 RecyclerView에 새로 생성한 Helper 객체를 붙인다.



[참고 : RecyclerView, ItemTouchHelper](https://everyshare.tistory.com/27)



### 🟢 LEVEL 3

- #### notifyDataSetChanged의 문제점

  notifyDataSetChanged는 화면에 보이는 전체 리스트를 갱신하기 때문에 비효율적이다.

  단순히 효율이 떨어지는 것뿐만 아니라 아이템을 이동하는 것을 구현했을 때 자연스럽게 교체되는 것이 아니라

  새로운 화면이 구성되는 것이 보이게 된다. (액티비티가 전환되는 것처럼)

  따라서, 아이템을 swipe할 때는 notifyItemRemoved(position)을 사용하고

  아이템을 이동할 때는 notifyItemMoved(from_position, to_position)을 사용하면 해결이 된다.

  

  또한, headerview를 사용하면서 notifyDataSetChanged를 호출하면 포커스가 사라지는 문제가 있다고 하는데, 이는 onBindViewHolder에서 0번 아이템일 때 포커스를 줄 뷰에 requestFocus를 호출하여 해결할 수 있다고 한다.





### 🟢 과제를 통해 성장한 내용

1. FragmentManager를 이용해 트랜잭션을 생성하고 커밋하여 프래그먼트를 추가/교체
2. Fragment에서의 뷰 바인딩
3. Intent를 사용해 Fragment에서 Activity 이동 및 데이터 전달
4. Data Class를 이용해 리스트를 구성하는 데이터 만들기
5. RecyclerView를 사용해 하나의 아이템 레이아웃을 반복해서 사용
6. ItemDecoration을 상속하여 CustomDecoration을 만들고, RecyclerView에 적용하기
7. ItemTouchHelper를 이용한 리스트 아이템 삭제와 이동







## :three: Week 3

<img src="https://user-images.githubusercontent.com/37872134/139559071-f67e707a-5849-44cf-a8bb-108675e8cace.gif"  width="180" height="320"/>



### 🟢 LEVEL 1

#### ◻ FontFamily - 폰트 추가 (noto sans kr)

- 폰트 import 하기

  1. font 디렉토리를 생성한다.

  2. import할 폰트를 디렉토리에 넣어준다.

  3. 디렉토리 내에서 리소스 파일을 생성하고 font-family를 작성한다.

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <font-family xmlns:android="http://schemas.android.com/apk/res/android"
         xmlns:app="http://schemas.android.com/apk/res-auto">
     
         <font
             android:font="@font/noto_sans_kr_regular"
             android:fontWeight="400"
             app:font="@font/noto_sans_kr_regular"
             app:fontWeight="400"
             />
                         ...
         <font
             android:font="@font/noto_sans_kr_bold"
             android:fontWeight="700"
             app:font="@font/noto_sans_kr_bold"
             app:fontWeight="700"
             />
                         ...
     </font-family>
     ```

     - font : 사용할 폰트를 지정한다.
     - fontWeight : 이를 통해 같은 폰트 내의 다른 스타일을 구별할 수 있다.
     - 안드로이드 8.0 미만에서 font family를 호환하기 위해서는 **app** 태그도 작성해야한다.

- fontFamily : 적용할 fontFamily를 선택한다.
- textfontWeight : fontWeight를 통해 fontFamily 내에서 구분되는 폰트를 이용한다. (ex thin, regular, bold, ..)
- textSize : 글자의 크기
- **includeFontPadding** : 폰트를 추가하면 자동으로 여백이 생기는 현상이 발생하기에 디자인을 적용하는데 불편함이 있다. 해당 속성을 false로 설정하면 여백을 없앨 수 있다. (또는 마이너스 padding을 통해 해결이 가능하다.)



#### ◻ 피그마 단위 변환

- px = dp * ( dpi / 160 )

- dp = px * ( 160 / dpi )

  160dpi (mdpi)로 제작된 디자인을 사용하기 때문에 px을 그대로 dp로 사용해도 된다.



#### ◻ 회원가입 버튼 만들기

- ##### 텍스트 밖의 여백 제거

  layout_width, layout_height를 wrap_content로 설정하여도 버튼 자체의 기본 여백이 있어서 디자인을 적용하기 불편하다. 이 때 아래의 값들을 0dp로 설정하면 정확하게 텍스트만 남은 버튼을 만들 수 있다.
  - android:minWidth
  - android:minHeight

- ##### textView와 Button을 하나의 레이아웃으로 묶기

  ```xml
      <androidx.constraintlayout.widget.ConstraintLayout
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="16dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/btn_signin">
  
          <TextView
              android:id="@+id/tv_no_account"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
  
              android:fontFamily="@font/noto_sans_kr"
              android:includeFontPadding="false"
              android:text="계정이 없으신가요?"
              android:textColor="@color/gray_3"
              android:textFontWeight="400"
              android:textSize="12sp"
              app:layout_constraintStart_toStartOf="parent"
              app:layout_constraintTop_toTopOf="parent" />
  
          <Button
              android:id="@+id/btn_signup"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_marginLeft="8dp"
              android:background="#00000000"
              android:minWidth="0dp"
              android:minHeight="0dp"
              
              android:fontFamily="@font/noto_sans_kr"
              android:includeFontPadding="false"
              android:text="회원가입"
              android:textColor="@color/gray_3"
              android:textFontWeight="700"
              android:textSize="12sp"
              
              app:layout_constraintStart_toEndOf="@+id/tv_no_account"
              app:layout_constraintTop_toTopOf="parent" />
      </androidx.constraintlayout.widget.ConstraintLayout>
  ```

  회원가입 버튼 디자인을 살펴보면, textView와 버튼은 8dp 떨어진 상태로 둘의 그룹이 parent 뷰를 상대로 가운데 정렬 되어있는 것을 확인할 수 있다.

  따라서 textView와 버튼을 하나의 ConstraintLayout으로 묶은 후 레이아웃에서 margin 등을 조정해 대칭을 맞춘다.



#### ◻ BottomNavigationView - 하단 메뉴(HomeActivity)

- ##### 아이콘 import

  피그마에서 svg형식으로 export한 아이콘을 **vector asset** 추가를 통해 xml로 변환시켜준다.

- ##### menu_home.xml

  네비게이션뷰의 디자인을 결정한다.

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <menu xmlns:android="http://schemas.android.com/apk/res/android">
      <item
          android:id="@+id/menu_profile"
          android:icon="@drawable/ic_profile"
          android:title="프로필"/>
      <item
          android:id="@+id/menu_home"
          android:icon="@drawable/ic_home"
          android:title="홈"/>
      <item
          android:id="@+id/menu_camera"
          android:icon="@drawable/ic_camera"
          android:title="카메라"/>
  </menu>
  ```

  

- ##### selector_bottom_navi.xml

  네비게이션뷰에서 아이템이 선택되었는지 여부에 따라 다른 색상을 적용시키기 위해서 selector를 사용한다.

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <selector xmlns:android="http://schemas.android.com/apk/res/android">
      <item android:color="#FA79B0" android:state_checked="true"/>
      <item android:color="#8F9090" android:state_checked="false"/>
  </selector>
  ```

  

- ##### 네비게이션뷰 추가

  HomeActivity에 뷰를 추가한다.

  ```xml
      <com.google.android.material.bottomnavigation.BottomNavigationView
          android:id="@+id/bnv_home"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:background="#FFFFFF"
  
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
  
          app:itemIconTint="@color/selector_bottom_navi"
          app:itemTextColor="@color/selector_bottom_navi"
          app:itemRippleColor="@color/main_pink"
  
          app:itemTextAppearanceActive="@style/MenuFont"
          app:itemTextAppearanceInactive="@style/MenuFont"
          app:menu="@menu/menu_home" />
  ```

  - itemIconTint : 아이템의 아이콘 색상

  - itemTextColor : 아이템의 텍스트(타이틀) 색상

  - itemRippleColor : 아이템 선택 시 퍼져나가는 물결 효과의 색상

  - itemTextAppearance : 아이템의 텍스트에 적용할 디자인

    style (themes.xml)에 다음처럼 MenuFont를 생성해준다.

    ```xml
        <style name="MenuFont" parent="android:Widget.TextView">
            <item name="android:fontFamily">@font/noto_sans_kr</item>
            <item name="android:fontWeight">500</item>
            <item name="android:textSize">10sp</item>
            <item name="android:layout_margin">6dp</item>
        </style>
    ```

    

- ##### 리스너 구현

  ```kotlin
          binding.bnvHome.setOnItemSelectedListener {
              when(it.itemId){
                  R.id.menu_profile -> binding.vpHome.currentItem = FIRST_FRAGMENT
                  R.id.menu_home -> binding.vpHome.currentItem = SECOND_FRAGMENT
                  else -> binding.vpHome.currentItem = THIRD_FRAGMENT
              }
              return@setOnItemSelectedListener true
          }
  ```

  

- ##### OnPageChangeCallBack

  ```kotlin
          binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
              override fun onPageSelected(position: Int) {
                  binding.bnvHome.menu.getItem(position).isChecked = true
              }
          })
  ```

  

  

#### ◻ HomeActivity - 프로필

- ##### 팔로워 목록 / 레포지토리 목록 버튼

  TabLayout을 이용하면 내부 버튼의 스타일을 커스텀하기 힘들고, 기존의 버튼을 이용하면 선택한 버튼에 색상을 변경하는 것이 어렵다.

  따라서 라디오버튼을 이용하였다.

  ```xml
      <RadioGroup
          android:id="@+id/rg_home"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="horizontal"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/cl_profile_background"
          >
  
          <RadioButton
              android:id="@+id/btn_follower"
              android:layout_width="0dp"
              android:layout_height="46dp"
              android:layout_marginVertical="11dp"
              android:layout_marginStart="11dp"
              android:layout_marginEnd="7dp"
              android:background="@drawable/button_radius"
              android:backgroundTint="@color/selector_botton_home_profile"
              android:button="@null"
              android:layout_weight="1"
              android:textAlignment="center"
              android:checked="true"
  
              android:fontFamily="@font/noto_sans_kr"
              android:includeFontPadding="false"
              android:paddingVertical="10dp"
              android:text="팔로워 목록"
              android:textColor="@color/selector_text_home_profile"
              android:textFontWeight="400"
              android:textSize="14sp"
  
              app:layout_constraintEnd_toStartOf="@+id/normv_empty"
              app:layout_constraintStart_toStartOf="parent"
              app:layout_constraintTop_toBottomOf="@+id/cl_profile_background" />
  
          <RadioButton
              android:id="@+id/btn_repository"
              android:layout_width="0dp"
              android:layout_height="46dp"
              android:layout_marginVertical="11dp"
              android:layout_marginRight="11dp"
              android:layout_marginLeft="7dp"
              android:background="@drawable/button_radius"
              android:backgroundTint="@color/selector_botton_home_profile"
              android:button="@null"
              android:layout_weight="1"
              android:textAlignment="center"
  
              android:fontFamily="@font/noto_sans_kr"
              android:includeFontPadding="false"
              android:text="레포지토리 목록"
              android:textColor="@color/selector_text_home_profile"
  
  
              android:textFontWeight="400"
              android:textSize="14sp"
              app:layout_constraintEnd_toEndOf="parent"
              app:layout_constraintStart_toEndOf="@+id/normv_empty"
              app:layout_constraintTop_toBottomOf="@+id/cl_profile_background" />
  
      </RadioGroup>
  ```

  기본으로 '팔로워 목록' 버튼이 checked 상태이며, 이는 버튼을 클릭할 때마다 자동으로 라디오 그룹이 관리한다. 또한 selector를 이용해서 checked 상태로 색을 적용한다.

  - 버튼 배경색

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <selector xmlns:android="http://schemas.android.com/apk/res/android">
      <item android:color="@color/orange" android:state_checked="true"/>
      <item android:color="@color/gray_6" android:state_checked="false"/>
  </selector>
  ```

  - 버튼 글자색

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <selector xmlns:android="http://schemas.android.com/apk/res/android">
      <item android:color="@color/white" android:state_checked="true"/>
      <item android:color="@color/gray_1" android:state_checked="false"/>
  </selector>
  ```



- ##### Glide를 이용한 둥근 이미지 만들기

  ```kotlin
          Glide.with(this)
              .load(getString(R.string.img_url_test))
              .circleCrop()
              .into(binding.ivProfile)
  ```

  Glide로 url의 이미지를 불러와서 circleCrop()으로 둥글게 만들 수 있다.







#### ◻ HomeActivity - 홈

TabLayout과 ViewPager2를 이용하였다.



- fragment_home2.xml

  ```
  <?xml version="1.0" encoding="utf-8"?>
  <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".HomeFragment2">
  
      <ImageView
          android:id="@+id/iv_title"
          android:layout_width="65dp"
          android:layout_height="65dp"
          android:layout_marginTop="40dp"
          android:src="@drawable/icon_github"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent" />
  
      <TextView
          android:id="@+id/tv_title"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginTop="11dp"
  
          android:text="GitHub"
          android:fontFamily="@font/noto_sans_kr"
          android:textFontWeight="700"
          android:textSize="20sp"
          android:textColor="@color/pink_power"
          android:includeFontPadding="false"
  
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/iv_title" />
  
      <com.google.android.material.tabs.TabLayout
          android:id="@+id/tl_home"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_marginTop="25dp"
          app:layout_constraintTop_toBottomOf="@+id/tv_title"
          app:tabTextAppearance="@style/GithubTabText"
          app:tabSelectedTextColor="@color/pink_power"
          app:tabIndicatorColor="@color/pink_power"
          app:tabIndicatorHeight="3dp"
          >
      </com.google.android.material.tabs.TabLayout>
  
      <org.sopt.androidassignment1.NestedScrollableHost
          android:layout_width="match_parent"
          android:layout_height="0dp"
          app:layout_constraintTop_toBottomOf="@+id/tl_home"
          app:layout_constraintBottom_toBottomOf="parent">
  
          <androidx.viewpager2.widget.ViewPager2
              android:id="@+id/vp_home"
              android:layout_width="match_parent"
              android:layout_height="match_parent"/>
  
      </org.sopt.androidassignment1.NestedScrollableHost>
  
  
  </androidx.constraintlayout.widget.ConstraintLayout>
  ```

  



- HomeFragment2.kt

  ```
  package org.sopt.androidassignment1
  
  import android.os.Bundle
  import androidx.fragment.app.Fragment
  import android.view.LayoutInflater
  import android.view.MotionEvent
  import android.view.View
  import android.view.ViewGroup
  import android.widget.Toast
  import androidx.viewpager2.widget.ViewPager2
  import com.google.android.material.tabs.TabLayoutMediator
  import org.sopt.androidassignment1.databinding.FragmentGithubFollowerBinding
  import org.sopt.androidassignment1.databinding.FragmentGithubFollowingBinding
  import org.sopt.androidassignment1.databinding.FragmentHome2Binding
  
  /* HomeActivity -> Fragment <Home> */
  class HomeFragment2 : Fragment() {
      private var _binding: FragmentHome2Binding? = null
      private val binding get() = _binding?: error("Binding not init")
      private lateinit var homeFragmentViewPagerAdapter: HomeFragmentViewPagerAdapter
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          _binding = FragmentHome2Binding.inflate(layoutInflater, container, false)
  
          initAdapter()
          initTabLayout()
  
          return binding.root
      }
  
      private fun initAdapter(){
          val fragmentList = listOf(GithubFollowerFragment(), GithubFollowingFragment())
  
          homeFragmentViewPagerAdapter = HomeFragmentViewPagerAdapter(this)
          homeFragmentViewPagerAdapter.fragments.addAll(fragmentList)
  
          binding.vpHome.adapter = homeFragmentViewPagerAdapter
  
      }
  
      private fun initTabLayout(){
          val tabLabel = listOf("팔로잉", "팔로워")
  
          TabLayoutMediator(binding.tlHome, binding.vpHome){ tab, position ->
              tab.text = tabLabel[position]
          }.attach()
      }
  
  
      override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
      }
  
  
  
  }
  
  ```



### 🟢 LEVEL 2

#### ◻ ViewPager2 중첩 스크롤 문제

requestDisallowInterceptTouchEvent를 사용해서 해결해보려고 했지만 어려웠다.

또한 ViewPager2는 final로 선언되어 있어서 커스텀할 수 없었다. 그래서 구글에서 지원한 NestedScrollableHost로  ViewPager를 감싸서 해결하였다.

- NestedScrollableHost

  ```kotlin
  package org.sopt.androidassignment1
  
  /*
   * Copyright 2019 The Android Open Source Project
   *
   * Licensed under the Apache License, Version 2.0 (the "License");
   * you may not use this file except in compliance with the License.
   * You may obtain a copy of the License at
   *
   *      http://www.apache.org/licenses/LICENSE-2.0
   *
   * Unless required by applicable law or agreed to in writing, software
   * distributed under the License is distributed on an "AS IS" BASIS,
   * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   * See the License for the specific language governing permissions and
   * limitations under the License.
   */
  
  import android.content.Context
  import android.util.AttributeSet
  import android.view.MotionEvent
  import android.view.View
  import android.view.ViewConfiguration
  import android.widget.FrameLayout
  import androidx.viewpager2.widget.ViewPager2
  import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
  import kotlin.math.absoluteValue
  import kotlin.math.sign
  
  /**
   * Layout to wrap a scrollable component inside a ViewPager2. Provided as a solution to the problem
   * where pages of ViewPager2 have nested scrollable elements that scroll in the same direction as
   * ViewPager2. The scrollable element needs to be the immediate and only child of this host layout.
   *
   * This solution has limitations when using multiple levels of nested scrollable elements
   * (e.g. a horizontal RecyclerView in a vertical RecyclerView in a horizontal ViewPager2).
   */
  class NestedScrollableHost : FrameLayout {
      constructor(context: Context) : super(context)
      constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  
      private var touchSlop = 0
      private var initialX = 0f
      private var initialY = 0f
      private val parentViewPager: ViewPager2?
          get() {
              var v: View? = parent as? View
              while (v != null && v !is ViewPager2) {
                  v = v.parent as? View
              }
              return v as? ViewPager2
          }
  
      private val child: View? get() = if (childCount > 0) getChildAt(0) else null
  
      init {
          touchSlop = ViewConfiguration.get(context).scaledTouchSlop
      }
  
      private fun canChildScroll(orientation: Int, delta: Float): Boolean {
          val direction = -delta.sign.toInt()
          return when (orientation) {
              0 -> child?.canScrollHorizontally(direction) ?: false
              1 -> child?.canScrollVertically(direction) ?: false
              else -> throw IllegalArgumentException()
          }
      }
  
      override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
          handleInterceptTouchEvent(e)
          return super.onInterceptTouchEvent(e)
      }
  
      private fun handleInterceptTouchEvent(e: MotionEvent) {
          val orientation = parentViewPager?.orientation ?: return
  
          // Early return if child can't scroll in same direction as parent
          if (!canChildScroll(orientation, -1f) && !canChildScroll(orientation, 1f)) {
              return
          }
  
          if (e.action == MotionEvent.ACTION_DOWN) {
              initialX = e.x
              initialY = e.y
              parent.requestDisallowInterceptTouchEvent(true)
          } else if (e.action == MotionEvent.ACTION_MOVE) {
              val dx = e.x - initialX
              val dy = e.y - initialY
              val isVpHorizontal = orientation == ORIENTATION_HORIZONTAL
  
              // assuming ViewPager2 touch-slop is 2x touch-slop of child
              val scaledDx = dx.absoluteValue * if (isVpHorizontal) .5f else 1f
              val scaledDy = dy.absoluteValue * if (isVpHorizontal) 1f else .5f
  
              if (scaledDx > touchSlop || scaledDy > touchSlop) {
                  if (isVpHorizontal == (scaledDy > scaledDx)) {
                      // Gesture is perpendicular, allow all parents to intercept
                      parent.requestDisallowInterceptTouchEvent(false)
                  } else {
                      // Gesture is parallel, query child if movement in that direction is possible
                      if (canChildScroll(orientation, if (isVpHorizontal) dx else dy)) {
                          // Child can scroll, disallow all parents to intercept
                          parent.requestDisallowInterceptTouchEvent(true)
                      } else {
                          // Child cannot scroll, allow all parents to intercept
                          parent.requestDisallowInterceptTouchEvent(false)
                      }
                  }
              }
          }
      }
  }
  ```

- fragment_home2.xml 에서 viewPager를 감싸기

  ```xml
      <org.sopt.androidassignment1.NestedScrollableHost
          android:layout_width="match_parent"
          android:layout_height="0dp"
          app:layout_constraintTop_toBottomOf="@+id/tl_home"
          app:layout_constraintBottom_toBottomOf="parent">
  
          <androidx.viewpager2.widget.ViewPager2
              android:id="@+id/vp_home"
              android:layout_width="match_parent"
              android:layout_height="match_parent"/>
  
      </org.sopt.androidassignment1.NestedScrollableHost>
  ```

  

  

#### ◻ 리사이클러뷰에 url을 이용해 서로 다른 이미지 띄우기

기존 name, introduction의 두 쌍으로 이루어진 data class에 uri도 포함시켰다.

- TripleData

  ```kotlin
  class TripleData (
      val name: String,
      val introduction: String,
      val imgUrl: String? = null
  )
  ```

ViewHolder의 onBind에서 Glide를 이용해 url에서 이미지를 불러와 원형으로 그리도록 하였다.

- FollowerViewAdapter.kt

  ```kotlin
      class FollowerViewHolder(private val binding: ItemListFollowerBinding): RecyclerView.ViewHolder(binding.root){
          fun onBind(data: TripleData){
              binding.tvFollowerName.text = data.name
              binding.tvFollowerIntroduction.text = data.introduction
  
              Glide.with(itemView)
                  .load(data.imgUrl)
                  .circleCrop()
                  .into(binding.ivFollower)
  
              binding.itemFollower.setOnClickListener { v:View ->
                  val intent = Intent(v.context, DetailActivity::class.java)
                  intent.putExtra("name", data.name)
                  v.context.startActivity(intent)
              }
  
          }
      }
  ```





### 🟢 LEVEL 3



#### ◻ 갤러리에서 받아온 이미지(uri)를 Glide로 화면에 띄우기

- fragment_home3.xml

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".HomeFragment3">
  
  
      <ImageView
          android:id="@+id/iv_attached"
          android:layout_width="200dp"
          android:layout_height="0dp"
          app:layout_constraintDimensionRatio="1"
          android:layout_marginTop="80dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent" />
  
      <TextView
          android:id="@+id/tv_plain"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="사진을 첨부해주세요"
          android:fontFamily="@font/noto_sans_kr"
          android:textFontWeight="500"
          android:textSize="20sp"
          android:includeFontPadding="false"
          android:textColor="@color/black"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/iv_attached"
          android:layout_marginTop="20dp"
          />
  
      <Button
          android:id="@+id/btn_attach_img"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layout_marginHorizontal="35dp"
          android:layout_marginTop="20dp"
          android:padding="10dp"
          android:background="@drawable/button_radius"
  
          android:text="첨부하기"
          android:fontFamily="@font/noto_sans_kr"
          android:textFontWeight="400"
          android:textColor="@color/white"
          android:includeFontPadding="false"
          android:textSize="16sp"
  
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@+id/tv_plain" />
  </androidx.constraintlayout.widget.ConstraintLayout>
  ```

  다음과 같이 이미지뷰와 버튼을 만든다.



- HomeFragment3.kt

  ```kotlin
  class HomeFragment3 : Fragment() {
      private var _binding: FragmentHome3Binding? = null
      private val binding get() = _binding!!
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          _binding = FragmentHome3Binding.inflate(layoutInflater, container, false)
  
          initListener()
  
          return binding.root
      }
  
      override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
          super.onActivityResult(requestCode, resultCode, data)
          if(requestCode == REQUEST_CODE){
              if(resultCode == -1){
                  Glide.with(requireContext()).load(data?.data).into(binding.ivAttached)
              }
          }
      }
  
      private fun initListener(){
          binding.btnAttachImg.setOnClickListener{
              val intent = Intent()
              intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
              intent.type = "image/*"
              intent.action = Intent.ACTION_GET_CONTENT
  
              startActivityForResult(intent, REQUEST_CODE)
          }
      }
  
      companion object{
          const val REQUEST_CODE = 1
      }
  
  }
  ```

  1. 버튼을 클릭하면 갤러리에 접근하는 intent를 생성하고, startActivityForResult를 호출하여 결과를 다시 받아올 수 있도록한다.

  2. 갤러리의 액티비티가 finish되면 onActivityResult 메소드가 실행되고, request code를 비교한 후 Glide를 통해 얻어온 값(uri)으로 이미지뷰를 그린다.



### 🟢 성장한 내용

1. 중첩 viewPager의 이벤트에 대해 관리하기 위해 뷰에서의 이벤트 흐름을 알게 되었다. (상위 뷰에서 하위 뷰로 dispatch)
2. Glide를 이용해 uri에 접근하여 이미지를 불러오고, 모양을 다듬는 방법을 알게 되었다.
3. Figma의 정보를 바탕으로 해상도에 맞게 적용할 수 있었다
4. NavigationBar, TabLayout 등을 커스텀하면서 xml의 사용에 대한 감을 익히게 되었다.
5. svg로 추출한 파일을 vector asset으로 추가해서 벡터 이미지로 사용하여 해상도 때문에 불편하지 않을 것 같다.
6. 그동안 fontWeight를 설정하면 때로는 특정 값에서는 bold가 되지만 특정 값에서는 아무 변화가 없는 이유가 궁금했는데, fontFamily에 대해서 알게 되었다.
7. 액티비티 간의 정보를 주고 받는 방법에 대해서 이해할 수 있었다.





## :four: Week 4

<img src="https://user-images.githubusercontent.com/37872134/141481007-280d8b6f-fca0-47b3-ae50-1e3557aaf658.gif"  width="180" height="320"/>



### 🟢 LEVEL 1

#### ◻ Postman으로 API 테스트



<img src="https://user-images.githubusercontent.com/37872134/141455132-3b9452a3-5010-46d0-8bad-60fa77190d9f.PNG" width="800" height="500"/>

/user/signup 경로에 POST하여 회원가입 API를 테스트한다.

<img src="https://user-images.githubusercontent.com/37872134/141455140-507ec5bb-3a54-42ca-a886-ab28c22b2bc9.PNG" width="800" height="500"/>

/user/login 경로에 POST하여 로그인 API를 테스트한다.



#### ◻ 로그인 구현

##### RequestLoginData

```kotlin
data class RequestLoginData(
    @SerializedName("email")
    val email : String,
    val password : String
)
```



##### ResponseLoginData

```kotlin
data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String
    )
}
```



##### LoginService

```kotlin
interface LoginService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>
}
```



##### ServiceCreator

```kotlin
object ServiceCreator {
    private const val BASE_URL_SOPT = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
    private const val BASE_URL_GITHUB = "https://api.github.com/"

    private val retrofitSopt : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL_SOPT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitGithub : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL_GITHUB)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService : LoginService = retrofitSopt.create(LoginService::class.java)
    val githubService: GithubService = retrofitGithub.create(GithubService::class.java)
}
```

ServiceCreator에는 LEVEL2에서 진행한 github service도 함께 다루고 있다.

data class를 이용해 Request나 Response로 오가는 JSON을 담을 데이터 형식을 정의하고, LoginService에서 HTTP 메소드 및 헤더, 파라미터, 바디 등 전달 방식을 결정한다.



##### LoginActivity

```kotlin
    private fun initNetWork(){
        val requestLoginData = RequestLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.loginService.postLogin(requestLoginData)

        call.enqueue(object: Callback<ResponseLoginData>{
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ){
              if(response.isSuccessful){
                  val data = response.body()?.data

                  Toast.makeText(this@LogInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                  startActivity(Intent(this@LogInActivity, HomeActivity::class.java))
              }else{
                  Toast.makeText(this@LogInActivity, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
              }

            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
```

Login 버튼 onclick 리스너에 initNetWork() 메소드를 넣어준다.

LoginService를 통해 Call을 생성하고, 비동기를 위해 queue에 넣는다.

POST에 대한 response가 HTTP OK이면 로그인 성공하며 다음 액티비티를 실행한다.



### 🟢 LEVEL 2

#### ◻ GitHub 팔로우 리스트



##### ResponseFollowerData

```kotlin
data class ResponseFollowerData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("html_url")
    val html_url: String,
)

```



##### ResponseGithubUserData

```kotlin
data class ResponseGIthubUserData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("html_url")
    val html_url: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("public_repos")
    val public_repos: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int
)
```



##### GithubService

```kotlin
interface GithubService {
    @Headers("Content-Type:application/json")
    @GET("users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    ) : Call<List<ResponseFollowerData>>

    @Headers("Content-Type:application/json")
    @GET("users/{login}")
    fun getUser(
        @Path("login") login: String
    ) : Call<ResponseGIthubUserData>
}
```



##### FollowerFragment

```kotlin
    private fun initFollowerList(){
        followerList.clear()
        val callFollowers: Call<List<ResponseFollowerData>> = ServiceCreator.githubService.getFollowers("gimangi")

        callFollowers.enqueue(object: Callback<List<ResponseFollowerData>>{
            override fun onResponse(
                call: Call<List<ResponseFollowerData>>,
                response: Response<List<ResponseFollowerData>>
            ) {
                if(response.isSuccessful){
                    val resbody = response.body()!!
                    for(i in resbody.indices){
                        val login = resbody[i].login
                        val imgUrl = resbody[i].avatar_url

                        // user bio (소개)를 불러오기 위한 call
                        ServiceCreator
                            .githubService
                            .getUser(login)
                            .enqueue(object: Callback<ResponseGIthubUserData>{
                                override fun onResponse(
                                    call: Call<ResponseGIthubUserData>,
                                    res: Response<ResponseGIthubUserData>
                                ) {

                                    if(res.isSuccessful){
                                        val newDat = TripleData(login, res.body()!!.bio, imgUrl)
                                        followerList.add(newDat)
                                    }
                                    else{
                                        Log.e("Network err", "response fail")
                                    }
                                }
                                override fun onFailure(
                                    call: Call<ResponseGIthubUserData>,
                                    t: Throwable
                                ) {
                                    Log.e("Network err", "error:$t")
                                }

                            })
                    }
                }
                else{
                    Toast.makeText(context, "팔로워 리스트를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseFollowerData>>, t: Throwable) {
                Log.e("Network err", "error:$t")
            }

        })


    }
```

FollowerFragment에 ViewAdapter로 list를 연결하기 전에 github API에서 불러온 데이터를 list에 삽입한다.

단, Github API 중 /users/{login}/followers를 사용했을 때 follower의 소개 멘트(bio)가 response로 없기 때문에,  팔로워의 {login}을 이용해 

/users/{login} API를 다시 한 번 호출해서 bio를 불러온다. 

참고로, Github API에는 요청 IP에서 일정 횟수 이상의 요청을 보내면 서비스해주지 않는다.

팔로워 API의 {login}은 나의 깃허브 아이디인 gimangi가 들어가서 다음과 같이 팔로워 목록을 보여준다.



<img src="https://user-images.githubusercontent.com/37872134/141484274-f37ad42f-0ff0-4e15-8696-676fa6a83c97.PNG" widht="250" height="400"/>









### 🟢 성장한 내용

- 서버 통신을 처리하기 위한 data 구조를 만드는 것을 알게 되었다.
- retrofit2를 이용하여 서버에 request를 보내고, response를 받는 방법에 대해 알게 되었다.
- GSON이라는 라이브러리를 이용하여 자바에서 JSON을 데이터로 바꿀 수 있다는 것을 알게 되었다.



## :seven: Week 7

<img src="https://user-images.githubusercontent.com/37872134/146587456-0acee3a1-336c-4763-ba13-983e0df34ef2.gif"  width="180" height="320"/>



### 🟢 LEVEL 1

#### ◻ 온보딩 화면 만들기

##### nav_welcome

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_welcome"
    app:startDestination="@id/onBoardFragment1">

    <fragment
        android:id="@+id/onBoardFragment1"
        android:name="org.sopt.androidassignment1.ui.onboard.OnBoardFragment1"
        android:label="fragment_on_board1"
        tools:layout="@layout/fragment_on_board1" >
        <action
            android:id="@+id/action_onBoardFragment1_to_onBoardFragment2"
            app:destination="@id/onBoardFragment2" />
    </fragment>
    <fragment
        android:id="@+id/onBoardFragment2"
        android:name="org.sopt.androidassignment1.ui.onboard.OnBoardFragment2"
        android:label="fragment_on_board2"
        tools:layout="@layout/fragment_on_board2" >
        <action
            android:id="@+id/action_onBoardFragment2_to_onBoardFragment3"
            app:destination="@id/onBoardFragment3" />
    </fragment>
    <fragment
        android:id="@+id/onBoardFragment3"
        android:name="org.sopt.androidassignment1.ui.onboard.OnBoardFragment3"
        android:label="fragment_on_board3"
        tools:layout="@layout/fragment_on_board3" />
</navigation>
```

navigaion component를 이용하여 fragment를 전환한다.



#### ◻ SharedPreferences 활용하여 자동로그인/자동로그인 해제 구현

##### SOPTSharedPrefereces

```kotlin
package org.sopt.androidassignment1.data

import android.content.Context

object SOPTSharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getAutoLogin(context: Context): Boolean = getPreference(context).getBoolean(AUTO_LOGIN, false)


    fun setAutoLogin(context: Context, value: Boolean) {
        getPreference(context).edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun removeAutoLogin(context: Context) {
        getPreference(context).edit()
            .remove(AUTO_LOGIN)
            .apply()
    }

    fun clearStorage(context: Context) {
        getPreference(context).edit()
            .clear()
            .apply()
    }

    private fun getPreference(context: Context) = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
}
```

SharedPreferences를 담당하는 싱글톤 객체를 생성하여 관리한다.



##### SettingActivity

```kotlin
package org.sopt.androidassignment1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.androidassignment1.data.SOPTSharedPreferences
import org.sopt.androidassignment1.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)

        initBtn()
        initListener()

        setContentView(binding.root)
    }

    private fun initBtn() {
        binding.cbtnAutoLogin.isChecked = SOPTSharedPreferences.getAutoLogin(this)
    }

    private fun initListener() {

        // 자동 로그인
        binding.cbtnAutoLogin.setOnClickListener {
            SOPTSharedPreferences.setAutoLogin(this, binding.cbtnAutoLogin.isChecked)
        }


    }
}
```

환경설정을 담당하는 액티비티에서 다음과 같이 SharedPreferences의 자동 로그인 값을 수정하고 불러온다.



##### LoginActivity

```kotlin
private fun checkAutoLogin() {
        if (SOPTSharedPreferences.getAutoLogin(this)) {
            shortToast("자동 로그인 되었습니다")
            startActivity(Intent(this@LogInActivity, HomeActivity::class.java))
            finish()
        }
    }
```

로그인 액티비티에서 자동 로그인 설정이 켜져있는 것을 확인하면 로그인을 거치지 않고 다음 액티비티를 실행한다.

현재 토큰을 이용한 로그인이 구현되지 않았기 때문에 임의로 로그인을 통과한 것이며, 로그인 성공 시 API로부터 토큰을 전달받으면 이를 저장해야 한다.

그리고 자동 로그인 실행 시에도 건너뛰는 것이 아니라, 저장된 토큰을 불러와서 API에 접근하는 방식으로 해야 한다. (현재는 API에서 토큰을 요구하지 않는다)



#### ◻ 패키징 방식

<img src="https://user-images.githubusercontent.com/37872134/146586975-aa51b500-76d3-4c8c-84ac-55f726d62e5b.png" widht="300" height="500"/>

- adapter
- config
- data
- model
- service
- ui
  - account
  - detail
  - home
  - onboard
- util



ui의 경우 연관 있는 단위로 한번 더 패키징하였다. (같은 그룹의 Fragment와 그 부모 액티비티 등)

이외에는 기능을 기준으로 패키징하였다. 



### 🟢 성장한 내용

- Fragment 간 전환할 때 간단한 기능임에도 코드의 가독성이 떨어졌었는데, Navigation Component를 사용하면 코드의 가독성뿐만 아니라 시각적으로도 정리해주기 때문에 매우 편리했다.
- 코틀린 확장 함수 개념을 공부했는데, 이를 활용해 Util 클래스를 만들어서 반복되는 코드를 줄일 수 있게 되었다. 자바를 사용하여 상속을 하게 된다면 원하지 않는 메소드들도 모두 구현해야 하지만, 확장 함수를 사용하면 단 한줄의 코드로 유용한 기능을 만들 수 있어서 놀라웠다.
- 데이터를 로컬 저장소에 저장할 수 있는 방법들에 대해 알게 되었는데, SharedPrefereces 외에도 다양한 방법들이 존재하는 것을 알게 되었다. 또한 SharedPreferences를 사용할 때에도 이를 관리하는 싱글톤 객체를 이용하면 가독성이나 유지보수 측면에서도 매우 좋았다. 앞으로 똑같은 기능을 구현하더라도 이렇게 좋은 구조를 만드는 것을 고민해야겠다고 생각했다.
