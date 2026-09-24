package org.ebank.ebankbackend.repositories;

import org.ebank.ebankbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
