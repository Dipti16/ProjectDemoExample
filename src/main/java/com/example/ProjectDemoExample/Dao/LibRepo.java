package com.example.ProjectDemoExample.Dao;

import com.example.ProjectDemoExample.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LibRepo extends JpaRepository<Library,Long> {
}
