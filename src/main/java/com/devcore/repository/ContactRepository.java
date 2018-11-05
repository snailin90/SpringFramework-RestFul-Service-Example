package com.devcore.repository;

import com.devcore.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Snailin Inoa
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
