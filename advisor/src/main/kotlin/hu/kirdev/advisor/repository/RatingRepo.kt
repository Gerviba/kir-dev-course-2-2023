package hu.kirdev.advisor.repository

import hu.kirdev.advisor.model.RatingEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RatingRepo : CrudRepository<RatingEntity, Long> {

    fun findAllByUserId(userId: String): List<RatingEntity>

}