package hu.kirdev.advisor.repository

import hu.kirdev.advisor.model.AccommodationEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccommodationRepo : CrudRepository<AccommodationEntity, Long> {
}