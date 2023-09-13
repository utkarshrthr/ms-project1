package com.utkarshrthr.app.auth.service;

import com.utkarshrthr.app.auth.dto.AuthRequest;
import com.utkarshrthr.app.auth.dto.AuthResponse;

public interface LoginService {

    AuthResponse login(AuthRequest request);
}
