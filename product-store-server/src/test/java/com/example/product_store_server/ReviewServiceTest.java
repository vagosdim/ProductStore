package com.example.product_store_server;

import com.example.product_store_server.models.Review;
import com.example.product_store_server.repositories.ReviewRepository;
import com.example.product_store_server.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    private List<Review> reviewsList;

    @BeforeEach
    void init(){
        Review review1 = new Review(5, "Great product", null, null);
        Review review2 = new Review(1, "bad product", null, null);
        reviewsList=new ArrayList<Review>();

        Collections.addAll(reviewsList,review1,review2);

    }

    @Test
    void testFindAllReviews() {

        when(reviewRepository.findAll()).thenReturn(reviewsList);

        List<Review> result = reviewService.findAll();

        assertThat(result).isEqualTo(reviewsList);
    }

    @Test
    void testFindById() {
        Review review = reviewsList.getFirst();
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));


        Optional<Review> result = reviewService.findById(1L);

        assertThat(result).isEqualTo(Optional.of(review));
    }

    @Test
    void testSaveReview() {

        Review review = reviewsList.getFirst();
        when(reviewRepository.save(review)).thenReturn(review);

        Review result = reviewService.save(review);

        assertThat(result).isEqualTo(review);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(reviewRepository).deleteById(id);

        reviewService.deleteById(id);

        verify(reviewRepository, times(1)).deleteById(id);
    }
}
