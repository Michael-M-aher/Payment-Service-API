package com.m_code.Fawry.Payment.services;

import com.m_code.Fawry.Auth.models.User;
import com.m_code.Fawry.Auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    UserRepository userRepository;

    public double getBalance(String username) {
        User user = userRepository.findByUsername(username).orElse(new User());
        return user.getBalance();
    }

    public void addBalance(String username, double balance) {
        User user = userRepository.findByUsername(username).orElse(new User());
        user.setBalance(user.getBalance() + balance);
        userRepository.save(user);
    }

    public boolean decreaseBalance(String username, double balance) {
        User user = userRepository.findByUsername(username).orElse(new User());
        if (user.getBalance() >= balance) {
            user.setBalance(user.getBalance() - balance);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
