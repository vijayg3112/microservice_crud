package com.user.demo.Microservicecrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.demo.Microservicecrud.dto.AllUserInfoDTO;
import com.user.demo.Microservicecrud.entity.UserAccountdtls;
import com.user.demo.Microservicecrud.entity.Userdtls;
import com.user.demo.Microservicecrud.repository.UserAccountdtlsRepository;
import com.user.demo.Microservicecrud.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired

	UserRepository userrepository;

	@Autowired
	UserAccountdtlsRepository useraccdtlsrepository;

	@Override
	public boolean AddNewUserAccount(Userdtls userdetails) {

		Userdtls userdata = userrepository.save(userdetails);

		System.out.println("userdata" + userdata);
		if (userdata != null) {
			UserAccountdtls dtls = new UserAccountdtls();
			dtls.setUserId(userdata.getUserId());
			long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			dtls.setAccountNo(String.valueOf(number));
			dtls.setAccountType("Current");
			dtls.setAccountBalance(String.valueOf(number / 200000));
			UserAccountdtls accdtls = useraccdtlsrepository.save(dtls);
			return true;
		}

		return false;
	}

	@Override
	public Userdtls getUserInfo(String userId) {
		// TODO Auto-generated method stub

		Userdtls userdtls = null;
		Optional<Userdtls> findById = userrepository.findById(Long.parseLong(userId));
		System.out.println(findById);

		if (findById.isPresent()) {
			userdtls = findById.get();
		}

		return userdtls;
	}

	@Override
	public boolean updateUserDetailsById(String userId, Userdtls userdetails) {
		Optional<Userdtls> findById = userrepository.findById(Long.parseLong(userId));
		if (findById.isPresent()) {
			Userdtls userdtls = findById.get();
			userdetails.setUserId(userdtls.getUserId());
			Userdtls updateduser = userrepository.save(userdetails);
			return true;
		} else {
			return false;

		}

	}

	@Override
	public boolean deleteUserInfo(String userId) {
		Optional<Userdtls> findById = userrepository.findById(Long.parseLong(userId));
		if (findById.isPresent()) {
			userrepository.deleteById(Long.parseLong(userId));
			return true;
		}
		return false;
	}

	@Override
	public AllUserInfoDTO getallUserInfo() {

		int total_bal = 0;
		List<Userdtls> userdtls = userrepository.findAll();
		for (Userdtls user : userdtls) {
			long userId = user.getUserId();
			UserAccountdtls userAccountdtls = useraccdtlsrepository.findById(userId).get();

			total_bal = total_bal + Integer.parseInt(userAccountdtls.getAccountBalance());

		}

		AllUserInfoDTO dto = new AllUserInfoDTO();
		dto.setTotal_avl_balance(total_bal);
		dto.setUserInfolist(userdtls);
		return dto;
	}
}