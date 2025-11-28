package com.example.javagyakorlat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface messageRepo extends CrudRepository<message, Integer> {
}
