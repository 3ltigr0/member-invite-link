# 회원 초대 링크 생성 기능 (SpringBoot)

제로베이스 백엔드 Pro 4기 미니 기술과제

- 현재 최소 기능만 최소 수준으로 구현.
- 리팩토링 등의 개선 및 기능 추가 예정.

[JAR 다운로드](https://github.com/3ltigr0/member-invite-link/blob/faec1b1b7953985b84ae350bc9bafd8afc0fe122/member-invite-link-0.0.1-SNAPSHOT.jar)

## API 명세

### 회원 초대 링크 생성

#### 엔드포인트
POST /api/invite

#### 요청 매개변수
- 'name' (페이로드): 회원의 이름 (문자열)
- 'email' (페이로드): 회원의 이메일 (문자열)
- 'phoneNumber' (페이로드): 회원의 전화번호 (문자열)

#### 응답
```json
{
    "inviteCode": "88693ba9-52ac-48c7-8ed9-ea0e6168584f"
}
```

### 초대 링크 수락

#### 엔드포인트
POST /api/accept-invite/{inviteCode}

#### 요청 매개변수
- 'inviteCode' (파라미터): 회원 초대 코드 (문자열)

#### 응답
- Status Code: 200 OK
