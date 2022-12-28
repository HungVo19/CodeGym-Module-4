package com.example.general_blog_manager.formatter;

import com.example.general_blog_manager.model.Tag;
import com.example.general_blog_manager.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class TagFormatter implements Formatter<Tag> {
    private ITagService tagService;

   @Autowired
   public TagFormatter(ITagService tagService) {
       this.tagService = tagService;
   }

    @Override
    public Tag parse(String text, Locale locale) throws ParseException {
        Optional<Tag> tag = tagService.findById(Long.parseLong(text));
        return tag.orElse(null);
    }

    @Override
    public String print(Tag object, Locale locale) {
        return null;
    }
}
