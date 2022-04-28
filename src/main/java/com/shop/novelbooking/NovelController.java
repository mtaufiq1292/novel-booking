package com.shop.novelbooking;

import java.nio.channels.NotYetBoundException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NovelController {

private final NovelRepository repository;

NovelController(NovelRepository repository) {
  this.repository = repository;
}


// Aggregate root
// tag::get-aggregate-root[]
@GetMapping("/novels")
List<Novel> all() {
  return repository.findAll();
}
// end::get-aggregate-root[]

@PostMapping("/novels")
Novel newNovel(@RequestBody Novel newNovel) {
  return repository.save(newNovel);
}

// Single item

@GetMapping("/novels/{id}")
Novel one(@PathVariable Long id) {
  
  return repository.findById(id)
    .orElseThrow(() -> new RuntimeException());
}

@PutMapping("/novels/{id}")
Novel replaceNovel(@RequestBody Novel newNovel, @PathVariable Long id) {
  
  return repository.findById(id)
    .map(employee -> {
      employee.setName(newNovel.getName());
      employee.setAuthor(newNovel.getAuthor());
      return repository.save(employee);
    })
    .orElseGet(() -> {
      newNovel.setId(id);
      return repository.save(newNovel);
    });
}

@DeleteMapping("/novels/{id}")
void deleteNovel(@PathVariable Long id) {
  repository.deleteById(id);
}
}
