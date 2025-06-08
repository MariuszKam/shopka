package com.shopka.infrastracture.user;

import com.shopka.domain.user.Email;
import com.shopka.domain.user.User;
import com.shopka.domain.user.UserId;
import com.shopka.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final JpaUserEntityRepository jpaUserEntityRepository;

    private final UserMapper userMapper;

    @Override
    public Optional<User> findById(UserId id) {
        return jpaUserEntityRepository.findById(id.getValue()).map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return jpaUserEntityRepository.findByEmail(email.getValue()).map(userMapper::toUser);
    }

    @Override
    public void save(User user) {
        jpaUserEntityRepository.save(userMapper.toEntity(user));

    }
}
