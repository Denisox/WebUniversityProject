package com.example.web1.Services.ServiceImpl;

import com.example.web1.Entities.Author;
import com.example.web1.Repositories.AuthorRepository;
import com.example.web1.Services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthor(String fullName, boolean isAlive) {

        Author author = new Author();
        author.setFullName(fullName);
        author.setAlive(isAlive);
        authorRepository.save(author);
    }
}
