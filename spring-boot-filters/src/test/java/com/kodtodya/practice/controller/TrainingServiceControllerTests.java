package com.kodtodya.practice.controller;

import com.kodtodya.practice.domain.Training;
import com.kodtodya.practice.services.TrainingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest
//@SpringBootTest
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
        BDDMockito.given(trainingService.storeTraining(training)).willReturn(true);
        // validate
        this.mockMvc
                .perform(MockMvcRequestBuilders.post(TRAINING_URI)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(mvcResult -> {mvcResult.getResponse().equals(true);});
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

        // insert training
        Mockito.when(trainingService.storeTraining(training0)).thenReturn(true);
        Mockito.when(trainingService.storeTraining(training1)).thenReturn(true);
        Mockito.when(trainingService.storeTraining(training2)).thenReturn(true);
        Mockito.when(trainingService.storeTraining(training3)).thenReturn(true);
        Mockito.when(trainingService.storeTraining(training4)).thenReturn(true);

        // validate
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(TRAINING_URI)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is(200))
                //.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)))
                .andExpect(mvcResult -> {mvcResult.getResponse().equals(trainingList);});
    }
}