package com.example.firstproject_2.repository;

import com.example.firstproject_2.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
