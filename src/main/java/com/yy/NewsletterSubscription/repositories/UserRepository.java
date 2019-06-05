package com.yy.NewsletterSubscription.repositories;

import com.yy.NewsletterSubscription.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
