package com.commerce.backendserver.newauth.domain;

import com.commerce.backendserver.newauth.domain.model.AuthToken;

public interface AuthTokenProvider {

	AuthToken generate(final Long memberId);

	Long getId(final String token);

	void validateToken(final String token);
}
