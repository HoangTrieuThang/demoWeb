package company.repositories;

import org.springframework.data.repository.CrudRepository;

import company.entities.Company;

public interface CompanyRepo extends CrudRepository<Company, Long> {

}
