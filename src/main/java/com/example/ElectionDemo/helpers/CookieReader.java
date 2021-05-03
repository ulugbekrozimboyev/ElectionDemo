package com.example.ElectionDemo.helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * Class which simplifies reading cookies from request.
 */
public class CookieReader {
    private final HttpServletRequest request;

    /**
     * The constructor.
     *
     * @param request request from which cookies will be read
     */
    public CookieReader(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Reads cookie by key from request.
     *
     * @param key the key of a cookie
     * @return returns cookie value
     */
    public Optional<String> readCookie(String key) {
        if (request.getCookies() == null) {
            return Optional.empty();
        }
        return Arrays.stream(request.getCookies())
                 .filter(c -> Objects.equals(key, c.getName()))
                 .map(Cookie::getValue)
                 .findAny();
    }
}
