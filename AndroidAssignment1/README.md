# Android-Hyeongki

![github_김형기_ver1-15](https://user-images.githubusercontent.com/70698151/135754182-8d3a8fc9-c7ad-46ee-b981-c8d7cb8c84e8.png)

## 목차

[:one: Week 1](#one-week-1)

[:two: Week 2](#two-week-2)



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







