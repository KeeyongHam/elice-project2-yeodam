# Yeodam
***

## 💬 프로젝트 소개
***
> **"여행을 담다"** 라는 뜻으로 전문 현지 가이드와 여행자를 직접 연결하는 맞춤형 플랫폼 입니다. 

### 기획의도

* 기존 패키지 여행의 획일화된 일정으로 개인 취향 반영의 어려움
* 현지 최신 정보, 효율적인 일정 구성의 어려움

### 기대효과
* 개인형 맞춤 일정 설계 가능
* 현지 가이드의 전문성 활용
* 소규모 / 개인 중심의 유연한 여행
* 자유롭고 효율적인 여행 경험 가능

## 🛠 기술스택
***

### 백엔드

<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src = "https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

### 프론트엔드

<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/JSS-F7DF1E?style=for-the-badge&logo=JSS&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">

## 🧩 ERD
***
<img src="/assets/erd.png">

## ⛓ 와이어프레임
***
<img src="/assets/wire-frame.png">

## 🔥 주요 기능


### 회원

|                      스프링 시큐리티                      | 가이드 관리                               |
|:--------------------------------------------------:|:-------------------------------------|
| <img src="/assets/user/security.png" width="750"/> | <img src="/assets/user/guide.png" width="750"/> |

* 스프링 시큐리티를 사용한 세션 기반 인증 및 인가
* 회원은 파트너 회원과 일반 회원으로 분리
* 파트너 회원
  * 소속 가이드 등록 및 수정, 삭제 
  * 상품등록 
* 일반 회원
  * 상품 검색 및 주문

### 상품

|                   상품 소개 정보 등록                   |                   상품 필수 정보 등록                   | 상품 이미지 정보 등록 | 상품 조회                                            |
|:-----------------------------------------------:|:-----------------------------------------------:|:--:|:-------------------------------------------------|
| <img src="/assets/item/add_1.png" width="750"/> | <img src="/assets/item/add_2.png" width="750"/> | <img src="/assets/item/add_3.png" width="750"/> | <img src="/assets/item/search.png" width="750"/> |

* 여행 상품 등록
  * 이미지를 포함한 상품 등록 시 커스텀 어노테이션을 통한 확장자, 파일 이름 내 특수문자 유효성 검사

* 여행 상품 조회
  * 기본 생성순 조회
  * 가격 오름차순/내림차순 조회
  * 평점 오름차순/내림차순 조회
  * 지역/기간/테마 별 조건 조회

* 여행 상품 수정
* 여행 상품 삭제

### 장바구니

|                      비로그인 장바구니                      | 로그인 후 장바구니                                     |
|:---------------------------------------------------:|:-----------------------------------------------|
| <img src="/assets/cart/anonymous.png" width="750"/> | <img src="/assets/cart/user.png" width="750"/> |

* 장바구니 상품 추가
  * 가이드 이름과 예약일 선택 시 반영되어 장바구니에 등록
  * 장바구니의 경우 비회원과 회원 모두 기능을 제공
    * 비회원 - 로컬스토리지에 저장
    * 회원 - DB 테이블에 저장
    * 로그인 시 로컬스토리지에 저장되어있는 값을 DB의 테이블에 추가

* 장바구니 상품 전체,개별 선택 조회가 가능
* 장바구니 상품 전체,개별 삭제가 가능

### 주문 및 결제

|                          주문 페이지                          | 결제 페이지 | 내역 확인                                                          |
|:--------------------------------------------------------:|:--:|:---------------------------------------------------------------|
| <img src="/assets/order_payment/order.png" width="750"/> | <img src="/assets/order_payment/payment.png" width="750"/> | <img src="/assets/order_payment/orderDetail.png" width="750"/> |

* 주문
  * 주문을 진행 시 상품의 수량을 차감하고 취소 시 다시 수량을 원복
* 결제 
  * 아이엠 포트 API를 사용하여 결제를 진행
* 조회 및 환불
  * 결제 내역 확인 및 사용전이라면 환불 가능

### 리뷰

|                       리뷰 작성                       |                     리뷰 내역 확인                     |
|:-------------------------------------------------:|:------------------------------------------------:|
| <img src="/assets/review/write.png" width="750"/> | <img src="/assets/review/list.png" width="750"/> |
* 리뷰 작성
  * 사용이 완료된 상품의 경우 0.5점 단위로 별점을 줄 수 있고, 사진 업로드 가능
* 리뷰 조회
  * 페이지네이션을 적용하여 10개 단위로 조회가 가능
  * 권한별 기능
    * 사용자 - 본인이 작성한 리뷰를 조회할 수 있다.
    * 파트너 - 해당 상품에 작성된 리뷰를 조회할 수 있다.
