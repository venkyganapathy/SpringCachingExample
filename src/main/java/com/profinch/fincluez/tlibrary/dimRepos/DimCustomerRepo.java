package com.profinch.fincluez.tlibrary.dimRepos;

import com.profinch.fincluez.tlibrary.dimEntities.DimCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimCustomerRepo extends JpaRepository<DimCustomer, String> {
}
