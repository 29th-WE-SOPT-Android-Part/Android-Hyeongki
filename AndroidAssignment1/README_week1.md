## 1๏ธโฃWeek 1



### ๐ขLEVEL 1

#### โปSignInActivity

<img src="https://user-images.githubusercontent.com/37872134/136694713-a5870bc8-8285-4559-9250-2535db47dd5c.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694717-5b9ddcb7-f35b-481f-ac0e-21114f16204e.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694719-4d5f6ad8-c4c1-4195-b645-6a3b8c4a53d3.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694728-94831de3-aff2-460b-a259-18bf005a4389.png" width="270" height="570" />



- ###### ์์ด๋ ์๋ ฅ

  ```xml
      <EditText
          android:id="@+id/et_id"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_id"
          app:layout_constraintTop_toBottomOf="@+id/tv_id" />
  ```

  - ์๋ก์ด ์๋ ฅ์ ๋ฐ์ ์ ์๋๋ก text ์์ฑ์ ๋น์๋๊ณ , hint ์์ฑ์ ์ด์ฉํด ์๋ ฅ ์ฅ์๋ฅผ ์ค๋ชํด์ค๋ค.
  - start(left)->tv_id, end(right)->parent, top->tv_id ๋ก ์ ์ฝ์ ์ค์ ํ์๋ค.
  - inputType์ ๊ธฐ๋ณธ๊ฐ์ธ textPersonName์ผ๋ก ์ค์ ํ์ฌ ์๋ ฅ๋ ๊ฐ์ ๋ณผ ์ ์๋ค.

  

- ###### ๋น๋ฐ๋ฒํธ ์๋ ฅ

  ```xml
  	<EditText
          android:id="@+id/et_pw"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํด์ฃผ์ธ์"
          android:inputType="textPassword"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_pw"
          app:layout_constraintTop_toBottomOf="@+id/tv_pw" />
  ```

  - inputType์ textPassword๋ก ์ค์ ํ์ฌ ์๋ ฅ ๊ฐ์ด ๋ณด์ด์ง ์๋๋ก ์ค์ ํ๋ค.

    

- ###### ๋ก๊ทธ์ธ ๋ฒํผ

  ```kotlin
          binding.btnSignin.setOnClickListener{
              val idInput = binding.etId.text
              val pwInput = binding.etPw.text
  
              if(idInput.isNotBlank() && pwInput.isNotBlank()){
                  Toast.makeText(this, "๊นํ๊ธฐ๋ ํ์ํฉ๋๋ค", Toast.LENGTH_SHORT).show()
                  val intent = Intent(this, HomeActivity::class.java)
                  startActivity(intent)
              }
              else
                  Toast.makeText(this, "๋ก๊ทธ์ธ ์คํจ", Toast.LENGTH_SHORT).show()
          }
  ```
  - ๋ทฐ ๋ฐ์ธ๋ฉ์ ํตํด view์ ์๋ ฅ๋ ๊ฐ์ ๊ฐ์ ธ์จ๋ค.
  - isNotBlank()๋ฅผ ํตํด ์๋ ฅ ๊ฐ์ด ๋ชจ๋ ๋น์ด์์ง ์์ผ๋ฉด ํ์ ๋ฉ์์ง๋ฅผ ๋ด์ Toast์ ํจ๊ป HomeActivity๋ก ์ด๋ํ๋ค.
    - isEmpty() : ๊ณต๋ฐฑ๋ฌธ์๋ ๋น์ด์์ง ์๋ค๊ณ  ๋ณธ๋ค
    - isBlank() : ๊ณต๋ฐฑ๋ฌธ์๋ฅผ ๋น์ด์๋ค๊ณ  ๋ณธ๋ค
    - ๋ฐ๋ผ์, isNotBlank()๋ฅผ ์ฌ์ฉํ์๊ธฐ ๋๋ฌธ์ ๊ณต๋ฐฑ๋ฌธ์๋ก ์ด๋ฃจ์ด์ง ์๋ ฅ์ ์ฌ๋ฐ๋ฅด์ง ์์ ์๋ ฅ์ผ๋ก ํ๋จํ๋ค
  - ๋ง์ฝ ๋น์ด์๋ ์๋ ฅ๊ฐ์ด ์๋ค๋ฉด "๋ก๊ทธ์ธ ์คํจ" ๋ฉ์์ง๋ฅผ ๋์ฐ๊ณ  ๋ฉ์๋๋ ์ข๋ฃ๋๋ค.
  - ๋ก๊ทธ์ธ ์ฑ๊ณต ์ HomeActivity๋ฅผ ํธ์ถํ๋ Intent๋ฅผ ์ฌ์ฉํด startActivity๋ฅผ ์คํํ๋ค. ์ด ๋ ํธ์ถํ  ๋์ ์ปดํฌ๋ํธ๊ฐ ๋ถ๋ชํ ๋ช์๋์ด ์๊ธฐ ๋๋ฌธ์ ์ด๋ **๋ช์์  ์ธํํธ**์ด๋ค. 



- ###### ํ์๊ฐ์ ๋ฒํผ

  ```kotlin
          binding.btnSignup.setOnClickListener{
              val intent = Intent(this, SignUpActivity::class.java)
              startActivity(intent)
          }
  ```

  - SignUpActivity๋ฅผ ํธ์ถํ๋ Intent๋ฅผ ์์ฑํ์ฌ, ํ์๊ฐ์ ์กํฐ๋นํฐ๋ก ์ด๋ํ๋ค.
  
    



------



#### โปSignUpActivity

<img src="https://user-images.githubusercontent.com/37872134/136694762-3d60017a-10eb-4b4d-baef-1325ea5f0b32.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694763-38ffd3e5-06f2-47bd-a5fb-cce0126694f8.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694765-8b68f2fd-f64f-440f-a4d1-0bd000ca7d0b.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136694768-75fc4269-5bcf-4820-a6d6-37dd1d7bd058.png" width="270" height="570" />



- ###### ์ด๋ฆ ์๋ ฅ

  ```xml
  	<EditText
          android:id="@+id/et_name"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="์ด๋ฆ์ ์๋ ฅํด์ฃผ์ธ์"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_name"
          app:layout_constraintTop_toBottomOf="@+id/tv_name" />
  ```

  - inputType์ textPersonName์ผ๋ก ์ค์ ํ์ฌ ์๋ ฅ๊ฐ์ ๋ณผ ์ ์๋ค.

    

- ###### ์์ด๋ ์๋ ฅ

  ```xml
      <EditText
          android:id="@+id/et_id"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์"
          android:inputType="textPersonName"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_id"
          app:layout_constraintTop_toBottomOf="@+id/tv_id" />
  ```

  - ์ด๋ฆ ์๋ ฅ๊ณผ ๋์ผํ๋ฉฐ, hint ์์ฑ์ ํตํด ์ฌ์ฉ์์๊ฒ ํธ์์ฑ์ ์ ๊ณตํ๋ค.

    

- ###### ๋น๋ฐ๋ฒํธ ์๋ ฅ

  ```xml
      <EditText
          android:id="@+id/et_pw"
          android:layout_width="0dp"
          android:layout_height="60dp"
          android:layout_marginTop="10dp"
          android:layout_marginRight="20dp"
          android:background="@drawable/input_radius"
          android:ems="10"
          android:hint="๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํด์ฃผ์ธ์"
          android:inputType="textPassword"
          android:padding="15dp"
          android:textSize="15dp"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="@+id/tv_pw"
          app:layout_constraintTop_toBottomOf="@+id/tv_pw" />
  ```

  - inputType์ textPassword๋ก ์ค์ ํ์ฌ ์๋ ฅ๊ฐ์ด ๋ณด์ด์ง ์๋๋ก ์ค์ ํ์๋ค.

    

- ###### ํ์๊ฐ์ ์๋ฃ ๋ฒํผ

  ```kotlin
          binding.btnSignupSubmit.setOnClickListener{
              val nameInput = binding.etName.text
              val idInput = binding.etId.text
              val pwInput = binding.etPw.text
  
              if(nameInput.isNotBlank() && idInput.isNotBlank() && pwInput.isNotBlank()) {
                  Toast.makeText(this, "ํ์๊ฐ์์ ์๋ฃ๋์์ต๋๋ค", Toast.LENGTH_SHORT).show()
                  finish()
              }
              else
                  Toast.makeText(this, "์๋ ฅ๋์ง ์์ ์ ๋ณด๊ฐ ์์ต๋๋ค", Toast.LENGTH_SHORT).show()
          }
  ```

  - isNotBlank()๋ฅผ ํตํด View์ ์๋ ฅ๊ฐ์ด ๋น์ด์์ง ์์ ๋ ํ์๊ฐ์์ ์๋ฃํ  ์ ์๋๋ก ํ์๋ค.

  - ํ์๊ฐ์์ด ์๋ฃ๋๋ฉด ๋ฉ์์ง์ ํจ๊ป SignUpActivity๊ฐ finish() ๋๋ค.

  - ์ด์ ๋ฐ๋ผ **๋ฐฑ์คํ**์ ์์ฌ์๋ SignInActivity๋ก ๋์๊ฐ๊ฒ ๋๋ค.

    - ๋ง์ฝ Intent๋ฅผ ์ฌ์ฉํ์ฌ ๋ค์ SignInActivity๋ฅผ ํธ์ถํ๋ค๋ฉด ๋น์ ์์ ์ผ๋ก ๋ฐฑ์คํ์ ์์ด๊ฒ ๋๋ค.




---

#### โปHomeActivity

<img src="https://user-images.githubusercontent.com/37872134/136694803-1d36865f-3c39-47cf-a06a-1bfe0dca1904.png" width="270" height="570" />



- ###### ํ๋กํ ์ฌ์ง

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

  - drawable์ ์ด๋ฏธ์ง๋ฅผ ์ถ๊ฐํ์ฌ ํ์ํ์๋ค.

    - app:srcCompat

      ๋กค๋ฆฌํ ์ด์์ ๋ฒ์ ์์ ์ฌ์ฉํ  ์ ์์ผ๋ฉฐ, ๋ฒกํฐ ๋๋ก์ด๋ธ์ ์ง์

    - android:src

      ์ด์  ๋ฒ์ ์์๋ ์ฌ์ฉํ  ์ ์์
      
    - **constraintDimensionRatio**๋ฅผ ์ด์ฉํ์ฌ ๊ฐ๋ก์ธ๋ก ๋น์จ์ ๊ฐ๊ฒ ์ค์ ํ์๋ค. ๋ฐ๋ผ์ ๊ฐ๋ก ๊ธธ์ด๋ง ์ค์ ํ๋ฉด ๊ทธ์ ๋ง๊ฒ ์ธ๋ก๊ธธ์ด๊ฐ ๋ณํํ์ฌ ์ ์ฌ๊ฐํ์ด ๋๋ค.	




### ๐ขLEVEL 2

#### โปGitHub ์ฃผ์ ์ด๋

<img src="https://user-images.githubusercontent.com/37872134/136694803-1d36865f-3c39-47cf-a06a-1bfe0dca1904.png" width="270" height="570" /><img src="https://user-images.githubusercontent.com/37872134/136701076-6037f257-20bd-4a50-89ff-750b6181433e.png" width="270" height="570" />



- ###### ๊นํ๋ธ ๋ฒํผ

  ```kotlin
          binding.btnGithub.setOnClickListener{
              val intent = Intent(Intent.ACTION_VIEW)
              intent.data = Uri.parse(getString(R.string.github_address))
              startActivity(intent)
          }
  ```

  - ์์์  ์ธํํธ๋ฅผ ์ด์ฉํ์ฌ URL์ ์คํํ๋๋ก ํ์๋ค.



- ###### ๋ช์์  ์ธํํธ (Explicit Intent)

  - ์ธํํธ์ ํด๋์ค ๊ฐ์ฒด๋ ์ปดํฌ๋ํธ ์ด๋ฆ์ ์ง์ ํ์ฌ ํธ์ถํ  ๋์์ ํ์คํ ์ ์ ์๋ ๊ฒฝ์ฐ
  - ํน์  ์ปดํฌ๋ํธ๊ฐ ์กํฐ๋นํฐ๊ฐ ๋ชํํ๊ฒ ์คํ๋๋ค

- ###### ์์์  ์ธํํธ (Implicit Intent)

  - ์ธํํธ์ ํธ์ถํ  ๋์์ด ๋ฌ๋ผ์ง ์ ์๋ ๊ฒฝ์ฐ์ ์ฌ์ฉ

  - ์๋๋ก์ด๋ ์์คํ์ด ์ธํํธ๋ฅผ ์ด์ฉํด ์์ฒญํ ์ ๋ณด๋ฅผ ์ฒ๋ฆฌํ  ์ ์๋ ์ ์ ํ ์ปดํฌ๋ํธ๋ฅผ ์ฐพ์์ ์ฒ๋ฆฌ ๊ฒฐ๊ณผ๋ฅผ ๋ณด์ฌ์ฃผ๊ฒ ๋๋ค




#### โปScrollView

<img src="https://user-images.githubusercontent.com/37872134/136701100-6c0e406c-f30b-404d-ab91-f50165d94e19.png" width="270" height="570" />



- ###### ์คํฌ๋กค๋ทฐ๋ฅผ ์ด์ฉํ ์๊ธฐ์๊ฐ

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

  - ์คํฌ๋กค๋ทฐ ๋ด๋ถ์ ConstraintLayout์ ๋ฐฐ์นํ๊ณ  ๊ทธ ์์ ํ์คํธ ๋ทฐ๋ฅผ ๋ฐฐ์นํ์ฌ ์์ง์ผ๋ก ์คํฌ๋กคํ  ์ ์๋๋ก ํ์๋ค.