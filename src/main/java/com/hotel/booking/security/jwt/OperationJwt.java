package com.hotel.booking.security.jwt;

import com.previo7.previo7s.dto.TokenDto;
import com.previo7.previo7s.model.User;

public interface OperationJwt {
    TokenDto generateTokenDto(User user);
}
