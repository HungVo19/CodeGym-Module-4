package com.example.blogmanager.repository;

import com.example.blogmanager.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @Autowired
//    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
//        TypedQuery<Blog> query = entityManager.createQuery("select  b from Blog where b.id=: id", Blog.class);
//        query.setParameter("id",id);
//        return query.getSingleResult();
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
//        if (blog.getId() != null) {
//            entityManager.merge(blog);
//        } else {
//
//            entityManager.persist(blog);
//        }
        TypedQuery<Blog> query = entityManager.createQuery("select * ")
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        entityManager.remove(blog);
    }
}
