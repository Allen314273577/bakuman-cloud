package cn.bakuman.auth.component;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 *
 * JWT内容增强器
 * @Author 梦叶
 * @date 2021/11/30 14:59
 */
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     * token拓展
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        return null;
    }
}
