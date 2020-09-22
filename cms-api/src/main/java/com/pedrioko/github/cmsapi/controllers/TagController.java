package com.pedrioko.github.cmsapi.controllers;

import com.pedrioko.github.cmsapi.domain.Tag;
import com.pedrioko.github.cmsapi.exceptions.TagNotFoundException;
import com.pedrioko.github.cmsapi.repositories.TagRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping("/tags")
    public List<Tag> all() {
        return tagRepository.findAll();
    }

    @PostMapping("/tags")
    public Tag newTag(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @GetMapping("/tags/{id}")
    public Tag one(@PathVariable Long id) {

        return tagRepository.findById(id)
                .orElseThrow(() -> new TagNotFoundException(id));
    }

    @PutMapping("/tags/{id}")
    public Tag updateEmployee(@RequestBody Tag tag, @PathVariable Long id) {

        return tagRepository.findById(id)
                .map(tag_old -> {
                    tag_old.setName(tag.getName());
                    return tagRepository.save(tag_old);
                })
                .orElseGet(() -> {
                    tag.setId(id);
                    return tagRepository.save(tag);
                });
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagRepository.deleteById(id);
    }
}
