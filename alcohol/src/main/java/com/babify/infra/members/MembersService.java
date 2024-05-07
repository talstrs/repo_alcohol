package com.babify.infra.members;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MembersService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	MembersDao dao;
//	CodeGroupDao CodeGroupDao;
//	@Autowired 와 CodeGroupDao dao;의 이미는 아래와 같다
//	CodeGroupDao dao = new CodeGroupDao();

//	패턴 1
//	public List<CodeGroupDto> selectList(){
//		
//		List<CodeGroupDto> list = dao.selectList();
//		
//		return list;
//	}
// 	서비스는 논리 로직
//	패턴 2 리스트 호출
	public List<MembersDto> selectList(MembersVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public MembersDto selectOne(MembersDto dto) {
		return dao.selectOne(dto);
	}
	
// 로그인 객체 호출
	public MembersDto selectOneLoginCheck(MembersDto dto) {
		return dao.selectOneLoginCheck(dto);
	}

//  insert 서비스
	public int insert(MembersDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(MembersDto dto) {
		return dao.update(dto);
	}
	
// 유저 정보 업데이트
	public int updateUsr(MembersDto dto) {
		return dao.updateUsr(dto);
	}
	
// 유저 비밀번호 업데이트
	public int updateUsrPw(MembersDto dto) {
		return dao.updateUsrPw(dto);
	}
	
// 유저 비밀번호 셀렉문
	public MembersDto selectOnePw(MembersDto dto) {
		return dao.selectOnePw(dto);
	}
	
	
//  delete 업데이트 서비스
	public int updateDelete(MembersDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(MembersDto dto) {
		return dao.delete(dto);
	}
	
	public int selectOneCount(MembersVo vo) throws Exception{
		return dao.selectOneCount(vo);
	}
	
	// 페이징 처리 리스트
	public List<MembersDto> selectListWithPaging(MembersVo vo){
		return dao.selectListWithPaging(vo);
	}
	
	// 로그인 id 확인
	public MembersDto selectOneLogin(MembersDto dto) {
		return dao.selectOneLogin(dto);
	};
	
	// 회원등록
	public int kakaoinsert(MembersDto dto) {
		return dao.kakaoinsert(dto);
	};	
	
	// 카카오 회원 확인 서비스
	public MembersDto kakaoSelectOne(MembersDto dto) {
		return dao.kakaoSelectOne(dto);
	}
	
	// 토큰요청
		public String getAccessTokenFromKakao(String client_id, String code) throws IOException {
	        //------kakao POST 요청------
	        String reqURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id="+client_id+"&code="+code;
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line = "";
	        String result = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }

	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});

	        //System.out.println("Response Body : " + result);

	        String accessToken = (String) jsonMap.get("access_token");
	        //String refreshToken = (String) jsonMap.get("refresh_token");
	        //String scope = (String) jsonMap.get("scope");

	        return accessToken;
	    }
		
		// 사용자정보조회
		public MembersDto getUserInfo(String access_Token, MembersDto dto) throws IOException {
	        //------kakao GET 요청------
	        String reqURL = "https://kapi.kakao.com/v2/user/me";
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);

	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line = "";
	        String result = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }

	        System.out.println("Response Body : " + result);

	        // jackson objectmapper 객체 생성
	        ObjectMapper objectMapper = new ObjectMapper();
	        // JSON String -> Map
	        Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
	        });

	        //사용자 정보 추출
	        //Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
	        // 에러 무시 / 이후 확인 필요
	        @SuppressWarnings("unchecked")
			Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

//	        Long id       = (Long) jsonMap.get("id");
//	        String name   = kakao_account.get("name").toString();
	        String email  = kakao_account.get("email").toString();
//	        String gender = kakao_account.get("gender").toString();
//	        String phone  = kakao_account.get("phone_number").toString();
	        
	        /*
	        if(properties != null) {
	        	String nickname     = properties.get("nickname").toString();
	        	String profileImage = properties.get("profile_image").toString();  
	        	
	            dto.setNickname(nickname);
	            dto.setProfile_image(profileImage);        	
	        }
	        */

	        //userInfo에 넣기
//	        dto.setId(id);
//	        dto.setName(name);
	        dto.setEmail(email);
//	        dto.setPhone(phone);
	        
	        // 성별
//	        if(gender.equals("male")) {
//	        	dto.setGenderCd(null); // 남
//	        } else {
//	        	dto.setGenderCd(null); // 여
//	        }

	        return dto;
	    }	
	
	
}
