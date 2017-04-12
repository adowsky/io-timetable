package com.out.io2.timetable.service.lecturer;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeacherRepository extends CrudRepository<TeacherDAO, Long> {
}
