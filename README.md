# Babble
<img src="https://user-images.githubusercontent.com/74331913/115321397-ab9d4100-a1be-11eb-9273-3cf31d8617d5.jpg" width="600">

## 텍스트론 부족하고, 비디오는 과하며, 오디오는 적당하다.


### 1. 개요<br><br>

   가. 주제 선정 배경<br>
   - :computer:	독특한 SNS를 만들어보자는 의견이 나왔다.<br>
   - :loudspeaker:	요즘 대세인 Clubhouse처럼 음성 중심이되 Tiktok처럼 짧은! <br>
    			음성 SNS로 나의 일상과 감정을 공유하는 SNS는 세상에 아직 없다!<br>
   -  :microphone:	음성은 문자보다 정보전달에 우위를 점하고 있다. <br>
    			중국의 대세 SNS인 Wechat은 표의문자라는 한자의 특성 때문에 음성메세지가 활발하다.<br><br>
			
   나. 기획배경 & 시장
   <br>

   2-1) SNS 시장분석 <br>
	<img src="https://i.imgur.com/VhBBhMV.png" width="500"> <br>
	[출처 : 한국지능정보사회진흥원 Special Report 2021-1호]<br><br>
   - 코로나19 확산에 따라 비대면 인터렉션이 늘어나면서 영상기반 서비스의 이용 증가<br>
   - 재택근무로 온라인 화상회의가 늘면서, 사람들의 피로감 증가 (Zoom-Fatique, Zoombie)<br>
   - 영상 기반(시청각) 서비스 대비 간편한 오디오(청각) 기반 서비스의 인기<br>
   - 유튜브, 인스타그램 등 시청각 SNS 서비스는 포화 상태<br><br> 

   2-2) Clubhouse의 성장 <br>
	<img src="https://i.imgur.com/AESIjuj.png" width="500"> <br><br>
    :fire: 2021년 대세 SNS "Clubouse", 한 기사는 Club House의 흥행을 이렇게 분석했다. <br>
   - :lock_with_ink_pen: 폐쇄성 : 초대장이 있어야만 진입이 가능한 이 곳은 아무나 들어가지 못하기에 <br>
                 특별함을 느끼게 해주고 다른 사람들로 하여금 호기심을 유발한다.<br>
   - :sound: Audio SNS : 텍스트와 사진으로만 되어 있던 기존 SNS와는 달리 <br>
                 오디오를 기반으로 하여 사람들에게 흥미를 유발했다.<br>
   - :iphone: Multi Tasking : 동영상 시장이 엄청 커졌음에도 불구하고 <br>
                 계속해서 라디오 수요가 존재하는 이유는 다른 것을 하면서도 들을 수 있기 때문이다.<br> 
   - :pill: Covid-19 : 코로나19로 인해 사람들이 대면하지 못하면서 sns 수요가 더욱 늘어났고 <br>
                 컨퍼런스도 온라인으로 진행되었다.<br>
		 <br><br>

   2-3) 오디오 SNS 특징 <br>
	 <img src="https://i.imgur.com/idDIfFI.png" width="500"> <br>
   - 오디오 컨텐츠의 가장 큰 장점은 두가지 이상의 작업을 할 수 있는 것 (Multi-Tasking)<br>
   - 오디오는 Zoom-Fatique를 우회하면서 연락을 유지할 수 있는 간편한 방법<br>
   - 오디오의 즉각적이고 생생함이 핵심 경험임<br>
   - 기존 오디오북, 팟캐스트, 인터넷 라디오 등의 형태에서 사전녹음, 인터렉티브 등의 세분화된 서비스 모델 등장<br><br>

#### :clipboard:수많은 오디오 SNS들 중 기존의 SNS소통 형식의 오디오는 없는 것을 확인하였다.<br><br>
        
   다. 과제 목표, 작품 제작의도 및 컨셉<br>
   - :telephone_receiver: 30초의 짧은 음성 SNS <br>
   - :memo: 해시태그를 통한 감정 분석<br>
   - 짧은 시간에 많은 양의 정보 전달<br>
    
   
   라. 계획<br><br>
    1) 기존 SNS에 있는 기능들<br>
        
   | 트위터 리트윗 |  해시태그  |  이모티콘  |
   |------|------|------|
   | <img src="https://user-images.githubusercontent.com/74331913/115144691-ffa60980-a088-11eb-9a09-6689b0c72498.png" width="300"> | <img src="https://user-images.githubusercontent.com/74331913/115144689-fcab1900-a088-11eb-9c36-60e70f4dd706.png" width="300"> | <img src="https://user-images.githubusercontent.com/74331913/115328680-f6718580-a1cb-11eb-8d61-5288c9e26320.png" width="300">
	
   2) :family_man_woman_boy_boy:	 모든 소통은 오디오 (게시, 소개, 답글) <br>
    
   3) :wastebasket:	필터링<br>
         - 욕을 하거나 좋지 않은 언어를 사용시 필터링하여 '삐'소리로 처리<br>

   4) :bar_chart: 사용 언어를 통한 감정 분석<br><br>

    
  ### 2. 추진과정 및 방법<br><br>
    
  가. 주요 추진 과정 절차      <br>
            1) SQL table 구성<br>
![sqltable](https://user-images.githubusercontent.com/74331913/114953383-3b777e00-9e93-11eb-9bfc-1123a83b8eed.png)<br>
            2) SPRING Boot<br>
            3) VUE
## :movie_camera: Feature
| Loggin | Recoding |
|:------:|:------:|
| <img src = "https://i.imgur.com/aruZjjg.gif"> | <img src = "https://i.imgur.com/hEvvltQ.gif"> |
| 게시물 확인 | 댓글 |
| <img src = "https://i.imgur.com/r49RcBs.gif"> | <img src = "https://i.imgur.com/E3c9jV8.gif"> |
| 프로필 수정 |      |
| <img src = "https://i.imgur.com/3nvyT59.gif"> | |

<br>
            4) FLASK<br>

- app.py <br>

		def STT(): 사용자가 녹음한 음성파일을 Vue에서 전달받아 
			   서버에 저장한 후 음성분석 및 비속어 필터링된 음성을 반환
		
- googleSTT.py <br>
	 
		def total_api(file_dir, file_name): 
			- 서버 내 저장된 음성파일을 load후 아래의 기능들을 실행한 결과값을 반환
		def sample_recognize(file_dir, file_name): 
			- 음성파일을 Google STT API를 이용하여 반환받은 값들을 이용해 비속어 필터링(Text)
		def create_beep(duration): 
			- 문장 내 비속어 존재시 적용할 beep음 생성
		def saltlux_api(service_id, type_number, text): 
			- 감정, 감성분석 및 키워드 추출을 위하여 필요한 파라메터들을 JSON화
		def saltlux_api_post(params): 
			- 위의 코드에서 생성된 JSON은 Saltlux API 통신하기 위한 메서드


     5) ElasticSearch / Filebeat / Logstash / Kibana 를 활용한 로그 수집 및 분석 <br>

| 1. Logstash로 로그 수집 | 2. Kibana를 활용한 로그 검색 기능 |
|:-------:|:------:|
| <img src="https://user-images.githubusercontent.com/73862452/116015655-03332500-a675-11eb-99e2-9758f194eb26.png" width="450"> | <img src="https://user-images.githubusercontent.com/73862452/116015654-029a8e80-a675-11eb-9aa1-447ed3c8f489.png" width="450"> |
| Kibana를 활용한 사용 언어를 통한 나의 감정 상태 분석 | 사용 언어를 통한 나의 정서 상태 분석 |
| <img src="https://user-images.githubusercontent.com/73862452/116015657-03332500-a675-11eb-8813-494dc4c67d16.png" width="450"> |  <img src="https://user-images.githubusercontent.com/73862452/116015658-03cbbb80-a675-11eb-9fba-d46780511842.png" width="450"> |
| 내가 사용한 단어 빈도 분석 | 사용자 화면 구성 |
| <img src="https://user-images.githubusercontent.com/73862452/116015651-00d0cb00-a675-11eb-95e9-9956cb375764.png" width="450"> | <img src="https://user-images.githubusercontent.com/73862452/116015652-0201f800-a675-11eb-8b13-672d8e3c469a.png" width="450"> |<br><br>

      
   나. 방법 및 활용 프로그램<br>
![기술](https://user-images.githubusercontent.com/73862452/116014279-818cc880-a66f-11eb-9bba-f2547a92137c.png)<br>
+ badword_check : https://github.com/Nam-SW/badword_check
<br><br>


   다. 단계별 수행 내용 (기획, 제작, 테스트)<br>
          기획 : <br>
                1) PPT로 필요한 요구사항 도출<br>
                2) OVENAPP으로 PROTOTYPE 제작<br>
                3) ERD설계로 TABLE 구조 정립 <br>      
          제작 : <br>
   - ECLIPSE 와 VSCode로 제작<br>
![usedStack](https://user-images.githubusercontent.com/74331913/114958640-63201380-9e9e-11eb-847d-423690d0b5fc.png)      <br>
	테스트 : <br>
                - backend: Postman을 사용하여 test실행<br>
         
         
  
### 3. 결과

   가. 설치 및 실행<br>
       1) :open_file_folder: 설치 <br>
            git clone https://github.com/Final-Project-Playdata/Babble-MVC.git <br>
		    git clone https://github.com/Final-Project-Playdata/Babble-Webflux.git <br>
	        git clone https://github.com/Final-Project-Playdata/Babble-Frontend.git <br> 
		git clone https://github.com/Final-Project-Playdata/Babble-MVC.git <br>
		git clone https://github.com/Final-Project-Playdata/Babble-Flask.git <br><br>
       2) :floppy_disk: 테스트 실행<br>
             - Babble-Frontend 폴더에서<br>
            
	npm i
	npm run dev
		
   - Babble-MVC, Babble-Webflux 폴더에서 <br>
   	
	IDE에서 프로젝트 추가 후 각각 spring application 실행 
	
  - 구글 서비스 계정 생성 : https://cloud.google.com/iam/docs/creating-managing-service-account-keys?hl=ko 참조 
  
  - Babble-Flask 폴더에서
      
      	pip install requirements.txt
		 
        
   나. 기대효과<br>
   - 데이터가 중요해지고 있는 요즈음, 음성 데이터 샘플을 모을 수 있는 기반이다.<br>
   - 접근하기 어려운 정보인 감정 정보에 대한 데이터를 축적할 수 있다.<br> 
   - 해외에도 출시한다면 여러나라의 여러사람의 어투, 특성 등 방대한 양의 언어학적 가치를 지니고 있다.<br>
   - 외국어를 배우기에도 좋은 학습자료가 될 수 있다.<br><br>
   
   다. 추가 예정 기능 :construction:<br>
   - Spring Web Flux가 부분적으로 사용 되어있는 상태에서 전체 서비스를 Web Flux로 변환 (효율성)<br>
   - 추천서비스 : 녹음된 음성의 기분, 정서 등을 분석하여 관련된 음악, 행동 등 추천<br>
   - 자연소리, 어투 등 음성이 아닌 소리들도 분석 처리<br><br>
   
   라. 활용 계획 <br>
   -  페이스북이 운영하는 메신저인 whatsapp의 음성 메모는 인도에서 폭발적인 인기를 얻고 있다.<br>
   	|![indiaflag](https://user-images.githubusercontent.com/74331913/115198575-2c136180-a12d-11eb-967b-ded45aea9ad0.png)|
	![whatsapp](https://user-images.githubusercontent.com/74331913/115198956-a04e0500-a12d-11eb-9ba4-bdc30a84e015.png)|<br>
   -  중국의 메신저인 wechat의 음성메시지 기능은 압도적인 사용수치를 보여주고 있다. <br>
   -  중국에서는 "만리방화벽"(Great Firewall) 때문에 페이스북, 구글, 트위터, 페이스북이 안되는 상황이기 때문에     <br>
      중국 현지화 전략을 통해 진출할 수 있다면 중국내에서의 점유율을 빠르게 확보할 수 있을 것으로 예상된다.<br>
   	<br>
 	|![china flag](https://user-images.githubusercontent.com/74331913/115199246-f7ec7080-a12d-11eb-873f-0c03d774f83d.png)|
  	![wechat](https://user-images.githubusercontent.com/74331913/115198963-a17f3200-a12d-11eb-8db8-d935c3aa0af2.png)|<br>
   - 세계에서 가장인구가 많은 두 나라가 오디오 메시지를 주로 사용하는 나라들이다.<br>
   - 음성 메시지로 연락하는 것이 익숙한 나라를 공략한다면 더욱 빠르게 시장 점유를 할 수 있을 것으로 예상된다.<br>
	![상승그래프](https://user-images.githubusercontent.com/74331913/115319461-d7b6c300-a1ba-11eb-8cc6-f7966132a043.jpeg)<br>
	
	
	

