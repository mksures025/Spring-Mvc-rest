package com.te.loginpage.repository;

import com.te.loginpage.dto.LoginDTO;

public interface LoginRepository {

	boolean loginRepository(String username, String password);

}
