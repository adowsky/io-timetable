package com.out.io2.timetable.service.group;


import com.out.io2.timetable.service.model.Faculty;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MappingUtilsTest {

    @Test
    public void shouldReturnEmptyCollection() {
        //when
        List<Faculty> actual = MappingUtils.mapDaoToDomainModel(Collections.emptyList());

        //then
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldReturnSingleElement() {
        //given
        GroupDAO groupDAO = new GroupDAO(1L, "department", "faculty", "nr1", 3);

        //when
        List<Faculty> actual = MappingUtils.mapDaoToDomainModel(Collections.singletonList(groupDAO));

        //then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actual).hasSize(1);
            softly.assertThat(actual.get(0).getName()).isEqualTo("faculty");
            softly.assertThat(actual.get(0).getSemesters()).hasSize(1);
            softly.assertThat(actual.get(0).getSemesters().get(0).getSemester()).isEqualTo(3);
            softly.assertThat(actual.get(0).getSemesters().get(0).getGroups()).containsExactly("nr1");
        });
    }

}