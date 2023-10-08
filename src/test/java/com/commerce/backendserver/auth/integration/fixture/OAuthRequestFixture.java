package com.commerce.backendserver.auth.integration.fixture;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;
import org.springframework.restdocs.restassured.RestDocumentationFilter;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashSet;
import java.util.Set;

import static com.commerce.backendserver.common.fixture.CommonRequestFixture.getRequest;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class OAuthRequestFixture {

    private static final String OAUTH_PATH = "/api/oauth/{provider}";
    private static final String LOGIN_PATH = "/login/oauth2/code/{provider}";

    public static ValidatableResponse 카카오_소셜로그인_페이지로_이동한다(
            final RequestSpecification spec,
            final Set<RestDocumentationFilter> documentations
    ) {
        return getOAuthRedirectRequest(spec, documentations, "kakao");
    }

    public static ValidatableResponse 구글_소셜로그인_페이지로_이동한다(
            final RequestSpecification spec,
            final Set<RestDocumentationFilter> documentations
    ) {
        return getOAuthRedirectRequest(spec, documentations, "google");
    }

    public static ValidatableResponse 구글_정보를_통해_로그인한다(
            final RequestSpecification spec
    ) {
        return getOAuthLoginRequest(spec, "google");
    }

    public static ValidatableResponse 카카오_정보를_통해_로그인한다(
            final RequestSpecification spec
    ) {
        return getOAuthLoginRequest(spec, "kakao");
    }

    private static ValidatableResponse getOAuthLoginRequest(RequestSpecification spec, String provider) {
        String path = UriComponentsBuilder
                .fromUriString(LOGIN_PATH)
                .queryParam("code", "code")
                .queryParam("state", "state")
                .toUriString().replace("%7B", "{").replace("%7D", "}");

        return getRequest(
                RestAssured.given(spec).log().all(),
                new HashSet<>(),
                path,
                provider
        );
    }

    private static ValidatableResponse getOAuthRedirectRequest(
            final RequestSpecification spec,
            final Set<RestDocumentationFilter> documentations,
            final String provider
    ) {
        return getRequest(
                RestAssured.given(spec),
                documentations,
                OAUTH_PATH,
                provider
        );
    }
}
