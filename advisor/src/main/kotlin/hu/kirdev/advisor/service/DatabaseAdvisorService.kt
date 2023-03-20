package hu.kirdev.advisor.service

import hu.kirdev.advisor.model.AccommodationEntity
import hu.kirdev.advisor.model.RatingEntity
import hu.kirdev.advisor.repository.AccommodationRepo
import hu.kirdev.advisor.repository.RatingRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class DatabaseAdvisorService(
    private val accommodationRepo: AccommodationRepo,
    private val ratingRepo: RatingRepo
) : AdvisorService {

    override fun getAccommodations(): List<AccommodationEntity> {
        return accommodationRepo.findAll().toList()
    }

    override fun getAccommodation(id: Long): Optional<AccommodationEntity> {
        return accommodationRepo.findById(id)
    }

    override fun createAccommodation(accommodation: AccommodationEntity) {
        accommodationRepo.save(accommodation)
    }

    override fun createRating(accommodationId: Long, rating: RatingEntity) {
        getAccommodation(accommodationId)
            .ifPresent { accommodation ->
                rating.accommodation = accommodation
                ratingRepo.save(rating)
                accommodationRepo.save(accommodation)
            }
    }

    override fun getRatingByUserId(userId: String): List<RatingEntity> {
        return ratingRepo.findAllByUserId(userId)
    }

}