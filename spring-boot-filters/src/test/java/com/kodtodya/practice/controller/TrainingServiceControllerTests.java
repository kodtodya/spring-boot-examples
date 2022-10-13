package com.kodtodya.practice.controller;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.services.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainingServiceControllerTests {

    private final static String TRAINING_URI = "/training";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainingService trainingService;

    @Test
    public void insertTraining() throws Exception {
        // given
        Training training = new Training("kafka", 3, "java, jms");

        // insert training
        when(trainingService.storeTraining(training)).thenReturn(true);

        // validate
        this.mockMvc
                .perform(
                        post(TRAINING_URI).contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(mvcResult -> {
                    mvcResult.getResponse().equals(true);
                });
    }

    @Test
    public void retrieveTraining() throws Exception {

        // given
        Training training0 = new Training("kafka", 3, "java, jms");
        Training training1 = new Training("java", 1, "oops");
        Training training2 = new Training("spring", 2, "java, database");
        Training training3 = new Training("AWS", 15, "infra, rhel, os");
        Training training4 = new Training("openshift", 15, "rhel, infra, file-system");
        List<Training> trainingList = new ArrayList<Training>();
        trainingList.add(training0);
        trainingList.add(training1);
        trainingList.add(training2);
        trainingList.add(training3);
        trainingList.add(training4);

        // mock training service for retrieval method
        when(trainingService.retrieveTrainings()).thenReturn(trainingList);

        // invoke and validate
        this.mockMvc
                .perform(
                        get(TRAINING_URI).contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(mvcResult -> {
                    mvcResult.getResponse().equals(trainingList);
                });
    }
}