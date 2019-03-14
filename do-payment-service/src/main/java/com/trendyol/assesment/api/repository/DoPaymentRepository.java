package com.trendyol.assesment.api.repository;

import com.trendyol.assesment.api.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Do Payment Repository.
 *
 * @author Mesut Dogan
 * @version 0.0.1
 */
@Repository
public interface DoPaymentRepository extends JpaRepository<Payment, Long> {
}
