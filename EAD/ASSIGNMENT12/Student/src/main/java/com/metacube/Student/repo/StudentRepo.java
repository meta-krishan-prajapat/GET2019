/*
 * Repository
 */
package com.metacube.Student.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.Student.model.Student;

/**
 * @author krishan
 * repository interface
 *
 */
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>
{

	/**
	 * @param key
	 * @return list of students
	 */
	public List<Student> findByfirstNameContainingIgnoreCase(String key);
}
