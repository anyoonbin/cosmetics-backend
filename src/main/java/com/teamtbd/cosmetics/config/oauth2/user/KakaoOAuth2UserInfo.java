package com.teamtbd.cosmetics.config.oauth2.user;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {
	private final Map<String, Object> kakaoAccount;
	private final Map<String, Object> profile;

	public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
		this.kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		this.profile = (Map<String, Object>) kakaoAccount.get("profile");
	}

	@Override
	public String getId() {
		return (String) kakaoAccount.get("id");
	}

	@Override
	public String getName() {
		return (String) profile.get("nickname");
	}

	@Override
	public String getEmail() {
		return (String) kakaoAccount.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String) profile.get("profile_image_url");
	}
}
