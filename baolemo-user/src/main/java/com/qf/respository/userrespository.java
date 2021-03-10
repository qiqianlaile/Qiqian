package com.qf.respository;

import com.qf.pojo.user.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrespository extends JpaRepository<user,Integer> {

    user findByUsername(String username);

}
