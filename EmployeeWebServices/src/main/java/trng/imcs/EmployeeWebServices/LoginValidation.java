package trng.imcs.EmployeeWebServices;

import java.util.HashMap;

public class LoginValidation {
	

	public boolean ValidateCredentials(String user, String password,HashMap<String, String> loginMap){
		if(password.equals(loginMap.get(user)))
			return true;
		else
			return false;
	}

}
