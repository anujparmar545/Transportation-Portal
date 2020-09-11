package com.anuj.services;

import javax.validation.Valid;

import com.anuj.response.CustomerResponse;
import com.anuj.response.TransporterResponse;

public interface LoginService {


	CustomerResponse loginCustomer(@Valid String username, @Valid String password);

	TransporterResponse loginTransporter(@Valid String username, @Valid String password);

	Boolean loginAdmin(@Valid String username, @Valid String password);

}
