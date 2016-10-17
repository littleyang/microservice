//package com.micro.service.oauth.dao;
//
//import com.micro.service.oauth.model.user.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
///**
// * @description:
// * @author: yang.zhou
// * @version: 1.0.0
// * @since: 2016-10-14 1:16 PM
// */
//
//public interface UserRepository extends JpaRepository<User, String> {
//
//    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
//    User findByUsernameCaseInsensitive(@Param("username") String username);
//
//    @Query
//    User findByEmail(String email);
//
//    @Query
//    User findByEmailAndActivationKey(String email, String activationKey);
//
//    @Query
//    User findByEmailAndResetPasswordKey(String email, String resetPasswordKey);
//
//    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
//    User findByUsername(String username);
//
//    List<User> findUsersByUsername(String username);
//
//}