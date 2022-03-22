package com.example.fuck.repos;

import com.example.fuck.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")// позволяет добавить свой собственный JPQL запрос
// Фактически это как SQL, только запросы делаются не к таблицам, а к классам. Самый простой пример использования JPQL,
// это загрузка всех сущностей определённого типа
    public User findByUsername(String username);
}