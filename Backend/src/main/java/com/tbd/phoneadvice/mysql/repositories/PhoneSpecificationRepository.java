package com.tbd.phoneadvice.mysql.repositories;

import com.tbd.phoneadvice.mysql.models.Phone;
import com.tbd.phoneadvice.mysql.models.PhoneSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneSpecificationRepository extends JpaRepository<PhoneSpecification, Long> {

    @Query("SELECT ps FROM PhoneSpecification ps WHERE ps.phone_specification_id.specification_id = ?1")
    List<PhoneSpecification> findPhoneSpecificationBySpecification_id(int specification_id);

/*    @Query("Select distinct distributor " +
            "from Distributor distributor" +
            "join d.towns town" +
            "join t.district district" +
            "where district.name = ?1")
   */
}
