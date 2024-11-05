package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
                                                                //primary ket is ID, which is an int.
public interface SkillRepository extends CrudRepository <Skill, Integer> {
}
