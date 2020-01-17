package de.novatec.patc.chaosapp.web;

import de.novatec.patc.chaosapp.entity.Book;
import de.novatec.patc.chaosapp.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LibraryController.class)
class LibraryControllerTest {

    @Autowired
    MockMvc mock;

    @MockBean
    private LibraryService libraryService;

    @Test
    void getInventory_emptyInventory() throws Exception {

        String expected_json = "[{title: \"IT\", isbn: \"12345\", authors: \"Stephen King\", rented: false}]";

        when(libraryService.getInventory()).thenReturn(
                Arrays.asList(new Book("IT", "12345", "Stephen King", false))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/inventory")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{'title': 'IT', 'isbn': '12345', 'authors': 'Stephen King', 'rented': 'false'}]"))
                .andReturn();

        JSONAssert.assertEquals(expected_json, result.getResponse().getContentAsString(), JSONCompareMode.NON_EXTENSIBLE);
    }

}