package org.test.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by marc on 03/02/2017.
 */
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

    @RestResource(path = "by-twitter")
    Speaker findByTwitter(@Param("id") String twitter);

    Collection<Speaker> findByLastName (@Param("name") String lastName);
}
