## 🟢LEVEL 1

### SignInActivity

<img src="https://user-images.githubusercontent.com/37872134/136694713-a5870bc8-8285-4559-9250-2535db47dd5c.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694717-5b9ddcb7-f35b-481f-ac0e-21114f16204e.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694719-4d5f6ad8-c4c1-4195-b645-6a3b8c4a53d3.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694728-94831de3-aff2-460b-a259-18bf005a4389.png" width="270" height="570" />



- ##### 아이디 입력

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

  

- ##### 비밀번호 입력

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

    

- ##### 로그인 버튼

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



- ##### 회원가입 버튼

  ```kotlin
          binding.btnSignup.setOnClickListener{
              val intent = Intent(this, SignUpActivity::class.java)
              startActivity(intent)
          }
  ```

  - SignUpActivity를 호출하는 Intent를 생성하여, 회원가입 액티비티로 이동한다.
  
    



------



### SignUpActivity

<img src="https://user-images.githubusercontent.com/37872134/136694762-3d60017a-10eb-4b4d-baef-1325ea5f0b32.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694763-38ffd3e5-06f2-47bd-a5fb-cce0126694f8.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694765-8b68f2fd-f64f-440f-a4d1-0bd000ca7d0b.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694768-75fc4269-5bcf-4820-a6d6-37dd1d7bd058.png" width="270" height="570" />



- ##### 이름 입력

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

    

- ##### 아이디 입력

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

    

- ##### 비밀번호 입력

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

    

- ##### 회원가입 완료 버튼

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




---

### HomeActivity

<img src="https://user-images.githubusercontent.com/37872134/136694803-1d36865f-3c39-47cf-a06a-1bfe0dca1904.png" width="270" height="570" />



- ##### 프로필 사진

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

  - constraintDimensionRatio를 이용하여 가로세로 비율을 같게 설정하였다. 따라서 가로 길이만 설정하면 그에 맞게 세로길이가 변화하여 정사각형이 된다.



## 🟢LEVEL 2

