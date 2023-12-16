package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    OrderService orderService = new OrderService();

    Feedback feedback = new Feedback();

    List<Feedback> feedbacks = new ArrayList<>();

    public void createFeedback(String orderId, String feedbackId, String feedbacktext, String orderperson) {
        feedback.setFeedbackId(feedbackId);
        feedback.setOrderItem(orderService.getOneItem(orderId));
        feedback.setFeedbacktext(feedbacktext);
        feedback.setOrderPerson(orderperson);
        feedbacks.add(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

    public Feedback getOneFeedback(String feedbackId) {
        if (!feedbacks.isEmpty()) {
            for (Feedback feedback : feedbacks
            ) {
                if (feedback.getFeedbackId().equals(feedbackId)) {
                    return feedback;
                }
            }
        }
        return null;
    }

    public Feedback updateFeedback(String feedbackId,String feedbacktext){
        if (!feedbacks.isEmpty()) {
            for (Feedback feedback : feedbacks
            ) {
                if (feedback.getFeedbackId().equals(feedbackId)) {
                    feedback.setFeedbacktext(feedbacktext);
                    return feedback;
                }
            }
        }

        return null;
    }

    public void removeFeedback(String feedbackId) {
        if (!feedbacks.isEmpty()) {
            feedbacks.removeIf(feedback -> feedback.getFeedbackId().equals(feedbackId));
        }

    }
}