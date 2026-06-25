package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User2DTO;
import org.example.ch05.dto.User2DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 MyBatis API 호출 컴포넌트 선언
@Mapper
@Repository
public interface User2DAO {

    // 기본 CRUD 메서드
    public void insert(User2DTO dto);
    public User2DTO select(String userid);
    public List<User2DTO> selectAll();
    public void update(User2DTO dto);
    public void delete(String userid);
}