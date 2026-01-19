package com.News.service;

import com.News.pojo.Article;
import com.News.pojo.PageBean;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArticleService {

    void add(final Article article);

    PageBean<Article> list(final Integer pageNum,
                           final Integer pageSize,
                           final Integer categoryId,
                           final String state);

    Article findById(final Integer id);

    void update(final Article article);

    void delete(Integer id);
}
