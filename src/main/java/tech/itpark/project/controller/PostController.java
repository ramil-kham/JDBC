package tech.itpark.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.project.dto.Post;
import tech.itpark.project.manager.PostManager;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
  private final PostManager manager;

  @GetMapping
  public List<Post> getAll() {
    return manager.getAll();
  }

  @PostMapping
  public void save(@RequestBody Post post) {
    manager.save(post);
  }
}
