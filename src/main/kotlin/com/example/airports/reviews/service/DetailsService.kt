package com.example.airports.reviews.service

import com.example.airports.reviews.controllers.dto.ReviewResponse
import com.example.airports.reviews.controllers.mappers.toReviewResponse
import com.example.airports.reviews.domain.Review
import com.example.airports.reviews.repository.ReviewRepository
import com.example.airports.reviews.repository.specifications.ReviewSpecs
import org.springframework.stereotype.Service

@Service
class DetailsService(
	  private val reviewRepository: ReviewRepository
) {

	  fun getAllStats() = reviewRepository.getAllStats()

	  fun getAirportStats(airport: String) = reviewRepository.getAirportStats(airport)

	  fun getReviewsByAirport(airport: String) = reviewRepository.getAllByAirportNameOrderByDateDesc(airport)

	  fun addReviewToAirport(airport: String, request: Review): ReviewResponse =
			reviewRepository.saveAndFlush(request).toReviewResponse()

	  fun find(reviewSpecs: ReviewSpecs) = reviewRepository.findAll(reviewSpecs).map { it.toReviewResponse() }
}
