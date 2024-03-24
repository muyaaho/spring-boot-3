package com.example.firstproject_2.repository;

import com.example.firstproject_2.entity.Member;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll();
}
