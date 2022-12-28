package com.example.general_blog_manager.service.impl;

import com.example.general_blog_manager.model.Tag;
import com.example.general_blog_manager.repository.ITagRepository;
import com.example.general_blog_manager.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService implements ITagService {
    @Autowired
    ITagRepository tagRepository;

    @Override
    public Page<Tag> findAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        if (tagRepository.findById(id).isPresent()) {
            return tagRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
