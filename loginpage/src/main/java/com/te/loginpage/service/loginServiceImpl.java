package com.te.loginpage.service;

import org.springframework.stereotype.Service;

import com.te.loginpage.dto.LoginDTO;

import com.te.loginpage.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class loginServiceImpl implements LoginService {

	private final LoginRepository logRepository;

	@Override
	public boolean login(LoginDTO loginDTO) {

		boolean login = logRepository.loginRepository(loginDTO.getUserName(), loginDTO.getPassword());

		return login;
	}

}
