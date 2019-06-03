package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.DataSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSheetRepository extends JpaRepository<DataSheet, Long> {

}
