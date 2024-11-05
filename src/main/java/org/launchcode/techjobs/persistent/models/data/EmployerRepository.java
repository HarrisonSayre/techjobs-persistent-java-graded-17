package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
                                                                    //primary ket is ID, which is an int.
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
